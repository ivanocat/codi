package edu.uoc.tdp.pac4.dao;

import edu.uoc.tdp.pac4.beans.Curso;
import edu.uoc.tdp.pac4.beans.Grupo;
import edu.uoc.tdp.pac4.beans.Matricula;
import edu.uoc.tdp.pac4.beans.Usuario;
import edu.uoc.tdp.pac4.exceptions.ApplicationAlreadyExistsException;
import edu.uoc.tdp.pac4.util.LanguageUtils;
import edu.uoc.tdp.pac4.util.StringUtils;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Implementa el gestor de matriculas del centro.
 * 
 * @author eSupport Netbeans
 */
public class GestorMatricula extends GestorDisco
{
   private Connection conn = null;
   private LanguageUtils txt = null;
   
   /**
    * Constructor de la clase.
    */
   public GestorMatricula(Connection conn) 
   {
      this.conn = conn;
   }
   
   //===========================================
   // Propiedades
   //===========================================
   
   /**
    * Devuelve la conexión a base de datos.
    */
   @Override
   public Connection getConnection() 
   {
      return conn;
   }
   
   //===========================================
   // Métodos
   //===========================================
   
   /**
    * Obtiene una matricula.
    * 
    * @param id Identificador único de la matricula.
    * @return Una instancia de {@link Grupo} que contiene los datos del matricula solicitado.
    * 
    * @throws SQLException
    * @throws Exception 
    */
   public Matricula get(int id) throws SQLException, Exception
   {
      String sql;
      Matricula matricula = null;
      
      sql = "SELECT matriculas.*, curso.fecha_inicio As fechaInicio, curso.fecha_finalizacion As fechaFin, " +
            "       grupo.nombre As grupoNombre, curso.nombre As cursoNombre, usuario.nombre As usrNombre, " +
            "       usuario.apellidos As usrApellidos, usuario.nif as usrNif " +
            "FROM   matriculas, usuario, grupo, curso " +
            "WHERE  matriculas.usuarioid = usuario.id And " +
                   "matriculas.grupoid = grupo.grupoid And " + 
                   "grupo.idcurso = curso.id And " + 
                   "matriculaid = " + id;
      
      try 
      {
         ResultSet rs = executeSql(sql);
         if (rs.next()) 
         {
            matricula = new Matricula();
            getMatriculaValues(matricula, rs);
         }
      } 
      catch (SQLException ex) 
      {
         throw ex;
      } 
      catch (Exception ex) 
      {
         throw ex;
      }
      
      return matricula;
   }
   
   /**
    * Agrega un nuevo matricula al centro.
    * 
    * @param matricula Una instancia de {@link Grupo} que contiene los datos del matricula.
    * 
    * @throws SQLException
    * @throws Exception 
    */
   public void add(Matricula matricula) throws SQLException, Exception
   {
      String sql;
      SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");

         // Comprueba que no exista otra matricula para el mismo grupo y turno
         sql = "SELECT Count(*) As nItems " +
               "FROM matriculas " +
               "WHERE matriculas.usuarioid = " + matricula.getUsuarioId() + " And " +
               "      matriculas.cursoid = " + matricula.getCursoId()     + " And " +
               "      matriculas.grupoid = " + matricula.getGrupoId() ;
         
         if (executeScalar(sql) > 0)
         {
            throw new ApplicationAlreadyExistsException();
         }                  
      
      try 
      {
         // Agrega la petición (peticionid = 1, alta)
         sql = "INSERT INTO matriculas (peticionid, cursoid, grupoid, estadoid, usuarioid, fechaalta) " +
               "VALUES " +
               "(1, "                               +
               "  " + matricula.getCursoId() + ", " +  
               "  " + matricula.getGrupoId() + ", " +
               "  " + matricula.getEstado() + ", " +
               "  " + matricula.getUsuarioId() + ", " +
               "      current_timestamp)";
         
         execute(sql);
      } 
      catch (SQLException ex) 
      {
         throw ex;
      }
      catch (Exception ex) 
      {
         throw ex;
      }
   }
   
   /**
    * Actualiza los datos de una matricula.<br />
    * Si la matrícula estaba aceptada se actualizan las plazas libres del grupo.
    * 
    * @param matricula Una instancia de {@link Grupo} que contiene los datos actualizados del matricula.
    * 
    * @throws SQLException
    * @throws Exception 
    */
   public void update(Matricula matricula) throws SQLException, Exception
   {
      String sql;
      SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
      
      try 
      {
         // Si la matricula previmanet estaba aceptada en otro grupo debe anular esa plaza
         liberarPlazaEnGroup(matricula);
         
         // Agrega la petición
         sql = "UPDATE matriculas " +
               "SET cursoid           = " + matricula.getCursoId() + ", " +
                   "grupoid           = " + matricula.getGrupoId() + ", " +
                   "estadoid          = " + matricula.getEstado() + ", " +
                   "usuarioid         = " + matricula.getUsuarioId() + ", " +
                   "fechamodificacion =     current_timestamp " +
               "WHERE matriculaid = " + matricula.getId();

         execute(sql);
      } 
      catch (SQLException ex) 
      {
         throw ex;
      }
      catch (Exception ex) 
      {
         throw ex;
      }
   }
   
   /**
    * Acepta un matricula para un alumno y grupo.<br />
    * Si la matrícula ya estaba aceptada se actualizan las plazas libres del grupo.
    * 
    * @param matricula Una instancia de {@link Grupo} que contiene los datos actualizados del matricula.
    * 
    * @throws SQLException
    * @throws Exception 
    */
   public void accept(Matricula matricula) throws SQLException, Exception
   {
      String sql;
      SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");

      // Actualiz ala instancia
      matricula.setEstado(Matricula.MATRICULA_ESTADO_ACEPTADA);

      try 
      {
         // Si la matricula previmanet estaba aceptada en otro grupo debe anular esa plaza
         liberarPlazaEnGroup(matricula);

         // Formaliza la petición
         sql = "UPDATE matriculas " +
               "SET    estadoid          = " + Matricula.MATRICULA_ESTADO_ACEPTADA + ", " +
               "       grupoid           = " + matricula.getGrupoId() + ", " +
               "       fechamodificacion =     current_timestamp " +
               "WHERE  matriculaid       = " + matricula.getId();
         execute(sql);
         
         // Resta una plaza libre al grupo
         sql = "UPDATE grupo " +
               "SET    plazasdisponibles = plazasdisponibles - 1 " +
               "WHERE  grupoid           = " + matricula.getGrupoId();
         execute(sql);
      } 
      catch (SQLException ex) 
      {
         throw ex;
      }
      catch (Exception ex) 
      {
         throw ex;
      }
   }
   
   /**
    * Elimina un matricula.
    * 
    * @param id Identificador del matricula a eliminar.
    * 
    * @throws SQLException
    * @throws Exception 
    */
   public void delete(int id) throws SQLException, Exception
   {
      String sql;
      
      try 
      {
         // PATCH xxxxx: No elimina ninguna matrícula, sólo la marca como anulada
         // Elimina la matricula
         /*sql = "DELETE FROM matriculas " +
               "WHERE matriculaid = " + id;*/

         // Marca la matrícula como anulada
         sql = "UPDATE matriculas " +
               "SET estadoid = " + Matricula.MATRICULA_ESTADO_ANULADA +
               "WHERE matriculaid = " + id;  
         
         execute(sql);
      } 
      catch (SQLException ex) 
      {
         throw ex;
      }
      catch (Exception ex) 
      {
         throw ex;
      }
   }
   
   /**
    * Obtiene una lista completa de los grupos del centro.
    * 
    * @return Una lista de instancia de {@link Curso}.
    * 
    * @throws SQLException
    * @throws Exception 
    */
   public ArrayList<Matricula> getMatriculas() throws SQLException, Exception
   {
      Matricula matricula;
      String sql;
      ArrayList<Matricula> list = new ArrayList<Matricula>();
      
      sql = "SELECT   matriculas.*, curso.fecha_inicio As fechaInicio, curso.fecha_finalizacion As fechaFin, " +
            "         grupo.nombre As grupoNombre, curso.nombre As cursoNombre, usuario.nombre As usrNombre, " +
            "         usuario.apellidos As usrApellidos, usuario.nif as usrNif " +
            "FROM     matriculas, usuario, grupo, curso " +
            "WHERE    matriculas.usuarioid = usuario.id And " +
                     "matriculas.grupoid = grupo.grupoid And " + 
                     "grupo.idcurso = curso.id " + 
            "ORDER BY usrApellidos, usrNombre";

      try
      {
         ResultSet rs = executeSql(sql);
         while (rs.next()) 
         {
            matricula = new Matricula();
            getMatriculaValues(matricula, rs);
            list.add(matricula);
         }
      }
      catch (SQLException ex) 
      {
         throw ex;
      } 
      catch (Exception ex) 
      {
         throw ex;
      }
      
      return list;
   }
   
   /**
    * Obtiene una lista completa de los grupos del centro.
    * 
    * @param name Una cadena que contiene parte del nombre y/o apellidos para filtrar.
    * @param nif Una cadena que contiene parte del nif para filtrar.
    * @param estado Un estado para filtrar o -1 para ignorar el filtro.
    * @return Una lista de instancia de {@link Curso}.
    * 
    * @throws SQLException
    * @throws RemoteException
    * @throws Exception 
    */
   public ArrayList<Matricula> getMatriculas(String name, String nif, int estado, Date fechainicio, Date fechafin) throws SQLException, Exception, RemoteException
   {
      Matricula matricula;
      String sql;
      ArrayList<Matricula> list = new ArrayList<Matricula>();
      
      // Formatea los parámetros proporcionados
      name = StringUtils.formatToSql(name.trim().toLowerCase());
      nif = StringUtils.formatToSql(nif.trim().toLowerCase());
      
      // Genera la senténcia SQL de selección de matriculas
      sql = "SELECT   matriculas.*, curso.fecha_inicio As fechaInicio, curso.fecha_finalizacion As fechaFin, " +
            "         grupo.nombre As grupoNombre, curso.nombre As cursoNombre, usuario.nombre As usrNombre, " +
            "         usuario.apellidos As usrApellidos, usuario.nif as usrNif " +
            "FROM     matriculas, usuario, grupo, curso " +
            "WHERE    matriculas.usuarioid = usuario.id And " +
                     "matriculas.grupoid = grupo.grupoid And " + 
                     "grupo.idcurso = curso.id ";

      // Aplica los filtros especificados como parámetro
      if (!name.equals(""))
      {
         sql += " And ";
         sql += "(lower(textcat(textcat(usuario.nombre, ' '), usuario.apellidos)) Like '%" + name + "%' Or ";
         sql += " lower(textcat(textcat(usuario.apellidos, ', '), usuario.nombre)) Like '%" + name + "%' Or ";
         sql += " lower(usuario.nombre) Like '%" + name + "%' Or ";
         sql += " lower(usuario.apellidos) Like '%" + name + "%') ";
      }
      if (!nif.equals(""))
      {
         sql += " And ";
         sql += "(lower(usuario.nif) Like '%" + nif + "%') ";
      }   
      if (estado >= Matricula.MATRICULA_ESTADO_BAJA && estado <= Matricula.MATRICULA_ESTADO_ANULADA)
      {
         sql += " And ";
         sql += "(matriculas.estadoid = " + estado + ") ";
      }
      if(fechainicio != null && fechafin != null)          
      {
         sql += " And ";
         sql += "(curso.fecha_inicio >= '" + fechainicio + "') ";
         sql += " And ";
         sql += "(curso.fecha_finalizacion <= '" + fechafin + "') ";
      }
              
      // Genera la secuencia de ordenación de los resultados
      sql += "ORDER BY usrApellidos, usrNombre";

      try
      {
         ResultSet rs = executeSql(sql);
         while (rs.next()) 
         {
            matricula = new Matricula();
            getMatriculaValues(matricula, rs);
            list.add(matricula);
         }
      }
      catch (SQLException ex) 
      {
         throw ex;
      } 
      catch (Exception ex) 
      {
         throw ex;
      }
      
      return list;
   }
   
   /**
    * Obtiene una lista completa de los Cursos de un alumno.
    *
    * @param id Identificador del Alumno que se quiere mostrar cursos.
    * @param op Opción escogida de tipo de cursos a mostrar
    * @param inici Fecha de inicio de la busqueda
    * @return Una lista de instancia de {@link Matricula}.
    * 
    * @throws SQLException
    * @throws Exception 
    */
    public ArrayList<Matricula> getMatriculasAlumno(int idAlumno, int op, java.util.Date inici) throws SQLException, Exception
   {
      Matricula matricula;
      String sql;
      ArrayList<Matricula> list = new ArrayList<Matricula>();
      SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
      Date hoy = new Date(System.currentTimeMillis());
      
         sql= "select curso.nombre, " + 
              "curso.minasistencia, " + 
              "curso.fecha_inicio, " +
              "curso.fecha_finalizacion, " +
              "sum(asistencia.totalasisten)as totalasisten, " +
              "sum(asistencia.totalnoasisten) as totalnoasisten " +
              "FROM matriculas, usuario, grupo, curso, asistencia, asistenciaalumno " + 
              "where matriculas.usuarioid = usuario.id " +
              "And matriculas.grupoid = grupo.grupoid " +
              "AND grupo.idcurso = curso.id " +
              "AND asistenciaalumno.alumnoid = usuario.id " +
              "AND asistenciaalumno.asistid = asistencia.asistid " +
              "AND asistencia.grupoid = grupo.grupoid " +
              "And usuario.id=" + idAlumno;
      
      if(inici!=null){
          sql=sql+" And curso.fecha_inicio >= '" + df.format(new java.sql.Date(inici.getTime())) + "'";
      }
         
      
         if(op==1){
          sql=sql+" And curso.fecha_finalizacion <= '" + hoy + "'";
          
      }
      
      if(op==2){
          
          sql=sql+" And curso.fecha_finalizacion > '" + hoy + "'";
          
      }
      
      sql=sql+" group by curso.nombre,curso.minasistencia,curso.fecha_inicio,curso.fecha_finalizacion";
     
      try
      {
         ResultSet rs = executeSql(sql);
         while (rs.next()) 
         {
            matricula = new Matricula();
            matricula.setCursoNombre(rs.getString("nombre"));
            matricula.setFechaInicio(rs.getDate("fecha_inicio"));
            matricula.setFechaFinal(rs.getDate("fecha_finalizacion"));
            matricula.setAsis(rs.getInt("totalasisten"));
            matricula.setNoAsis(rs.getInt("totalnoasisten"));
            matricula.setAsisRequerida(rs.getInt("minasistencia"));
            

            list.add(matricula);
         }
      }
      catch (SQLException ex) 
      {
         throw ex;
      } 
      catch (Exception ex) 
      {
         throw ex;
      }
      
      return list;
   }
 
   /**
    * Obtiene una lista completa de los alumnos de un profesor con su asistencia
    * @param id codigo identificador del profesor
    * @param inici fecha de inicio
    * @param cursos listado de cursos seleccionados
    * @return Una lista de instancia de {@link Matricula}.
    * @throws SQLException
    * @throws Exception 
    */ 
   public ArrayList<Matricula> getAlumnosProfesor(int id, java.util.Date inici, ArrayList<Curso> cursos) throws SQLException, Exception
   {
      Matricula matricula;
      String sql;
      ArrayList<Matricula> list = new ArrayList<Matricula>();
      SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
      Date hoy = new Date(System.currentTimeMillis());
         sql= "select curso.nombre As nombreCurso, " + 
              "curso.minasistencia, " + 
              "curso.fecha_inicio, " +
              "curso.fecha_finalizacion, " +
              "(usuario.apellidos ||', '|| usuario.nombre) as nombreUsuario, " +  
              "sum(asistencia.totalasisten)as totalasisten, " +
              "sum(asistencia.totalnoasisten) as totalnoasisten " +
              "FROM matriculas, usuario, grupo, curso, asistencia, asistenciaalumno " + 
              "where matriculas.usuarioid = usuario.id " +
              "And matriculas.grupoid = grupo.grupoid " +
              "AND grupo.idcurso = curso.id " +
              "AND asistenciaalumno.alumnoid = usuario.id " +
              "AND asistenciaalumno.asistid = asistencia.asistid " +
              "AND asistencia.grupoid = grupo.grupoid " +
              "And grupo.idprofesor=" + id;
      
      if(inici!=null){
          sql=sql+" And curso.fecha_inicio >= '" + df.format(new java.sql.Date(inici.getTime())) + "'";
      }
         
      
      if(cursos!=null)
      {
          sql=sql+" And (";
          for( int i = 0 ; i < cursos.size() ; i++ ){
                
          sql = sql + " curso.nombre = '" + cursos.get( i ).getNombre() + "'";
           
            if (i == cursos.size() - 1) 
            {
               sql = sql + " )";
            }
            else 
            {
               sql = sql + " OR ";
            }
         }
      }
      
      sql=sql+"group by nombreUsuario,curso.nombre,curso.minasistencia,curso.fecha_inicio,curso.fecha_finalizacion order by nombreCurso";
      
     Usuario usr=new Usuario();
      try
      {
         ResultSet rs = executeSql(sql);
         while (rs.next()) 
         {
            matricula = new Matricula();
            usr.setApellidos(rs.getString("nombreUsuario"));
            matricula.setCursoNombre(rs.getString("nombreCurso"));
            matricula.setFechaInicio(rs.getDate("fecha_inicio"));
            matricula.setFechaFinal(rs.getDate("fecha_finalizacion"));
            matricula.setAsis(rs.getInt("totalasisten"));
            matricula.setNoAsis(rs.getInt("totalnoasisten"));
            matricula.setAsisRequerida(rs.getInt("minasistencia"));
            matricula.setUsuarioNombre(usr.getApellidos());

            list.add(matricula);
         }
      }
      catch (SQLException ex) 
      {
         throw ex;
      } 
      catch (Exception ex) 
      {
         throw ex;
      }
      
      return list;
   }
    
   /**
    * Obtiene una lista completa de la asistencia de los cursos que imparte clase un profesor
    * @param id codigo identificador del profesor
    * @param inici fecha de inicio
    * @param cursos listado de cursos seleccionados
    * @return Una lista de instancia de {@link Matricula}.
    * @throws SQLException
    * @throws Exception 
    */
   public ArrayList<Matricula> getAsistenciaCursos(int id, java.util.Date inici, ArrayList<Curso> cursos) throws SQLException, Exception
   {
      Matricula matricula;
      String sql;
      ArrayList<Matricula> list = new ArrayList<Matricula>();
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      Date hoy = new Date(System.currentTimeMillis());
      
      sql = "select curso.nombre As nombreCurso, " + 
                "curso.minasistencia, " +
                "curso.fecha_inicio, " +
                "curso.fecha_finalizacion, " + 
                "sum(asistencia.totalasisten) as asistenciatotal, " +
                "sum(asistencia.totalnoasisten) as absencia " +
                "FROM matriculas, usuario, grupo, curso, asistencia, asistenciaalumno " +
                "where matriculas.usuarioid = usuario.id " +
                "And matriculas.grupoid = grupo.grupoid " +
                "AND grupo.idcurso = curso.id " +
                "AND asistenciaalumno.alumnoid = usuario.id " +
                "AND asistenciaalumno.asistid = asistencia.asistid " +
                "AND asistencia.grupoid = grupo.grupoid " +
                "And grupo.idprofesor=" + id;
      
      if (inici!=null)
      {
          sql = sql + " And curso.fecha_inicio >= '" + df.format(new Date(inici.getTime())) + "'";
      }
      
      if (cursos!=null)
      {
         sql = sql + " And (";
         for (int i = 0; i < cursos.size() ; i++ )
         {
            sql = sql + " curso.nombre = '" + cursos.get( i ).getNombre() + "'";

            if (i==cursos.size()-1) 
            {
               sql = sql +  " ) ";
            }
            else
            {
               sql = sql + " OR ";
            }
         }
      }
      
      sql=sql+" group by nombreCurso,curso.minasistencia,curso.fecha_inicio,curso.fecha_finalizacion " +
              "order by nombreCurso";
      try
      {
         ResultSet rs = executeSql(sql);
         while (rs.next()) 
         {
            matricula = new Matricula();
            matricula.setCursoNombre(rs.getString("nombreCurso"));
            matricula.setFechaInicio(rs.getDate("fecha_inicio"));
            matricula.setFechaFinal(rs.getDate("fecha_finalizacion"));
            matricula.setAsis(rs.getInt("asistenciatotal"));
            matricula.setNoAsis(rs.getInt("absencia"));
            matricula.setAsisRequerida(rs.getInt("minasistencia"));

            list.add(matricula);
         }
      }
      catch (SQLException ex) 
      {
         throw ex;
      } 
      catch (Exception ex) 
      {
         throw ex;
      }
      
      return list;
   }
    
   
   /**
    * Obtiene una lista completa de la asistencia media de los profesores
    * @param inici fecha de inicio
    * @param cursos listado de cursos seleccionados
    * @return Una lista de instancia de {@link Matricula}.
    * @throws SQLException
    * @throws Exception 
    */
   public ArrayList<Matricula> getAsistenciaProfesores(java.util.Date inici, ArrayList<Curso> cursos) throws SQLException, Exception
   {
      Matricula matricula;
      String sql;
      ArrayList<Matricula> list = new ArrayList<Matricula>();
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      Date hoy = new Date(System.currentTimeMillis());
      
      sql = "select sum(asistencia.totalasisten) as asistenciatotal, " + 
                "sum(asistencia.totalnoasisten) as absencia, " +
                "(usuario.apellidos ||', '|| usuario.nombre) as nombreUsuario " +
                "FROM curso, asistencia, asistenciaalumno, grupo inner join usuario on usuario.id = grupo.idprofesor " + 
                "where grupo.idcurso = curso.id  " +
                "AND asistenciaalumno.asistid = asistencia.asistid " +
                "AND asistencia.grupoid = grupo.grupoid ";
      
      if (inici!=null)
      {
          sql = sql + " And curso.fecha_inicio >= '" + df.format(new Date(inici.getTime())) + "'";
      }
      
      if (cursos!=null)
      {
         sql = sql + " And (";
         for (int i = 0; i < cursos.size() ; i++ )
         {
            sql = sql + " curso.nombre = '" + cursos.get( i ).getNombre() + "'";

            if (i==cursos.size()-1) 
            {
               sql = sql +  " ) ";
            }
            else
            {
               sql = sql + " OR ";
            }
         }
      }
      
      sql=sql+" group by nombreUsuario " +
              "order by nombreUsuario";
     
     Usuario usr=new Usuario();
      try
      {
         ResultSet rs = executeSql(sql);
         while (rs.next()) 
         {
            usr.setApellidos(rs.getString("nombreUsuario"));
            matricula = new Matricula();
            matricula.setUsuarioNombre(usr.getApellidos());
            matricula.setAsis(rs.getInt("asistenciatotal"));
            matricula.setNoAsis(rs.getInt("absencia"));
            list.add(matricula);
         }
      }
      catch (SQLException ex) 
      {
         throw ex;
      } 
      catch (Exception ex) 
      {
         throw ex;
      }
      
      return list;
   }
   
   
     /**
    * Obtiene una lista completa de la asistencia de los cursos que imparte el centro
    * @param inici fecha de inicio
    * @param cursos listado de cursos seleccionados
    * @return Una lista de instancia de {@link Matricula}.
    * @throws SQLException
    * @throws Exception 
    */
   public ArrayList<Matricula> getAsistenciaCursoCentro(java.util.Date inici, ArrayList<Curso> cursos) throws SQLException, Exception
   {
      Matricula matricula;
      String sql;
      ArrayList<Matricula> list = new ArrayList<Matricula>();
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      Date hoy = new Date(System.currentTimeMillis());
      
      sql = "select curso.minasistencia, " + 
                "sum(asistencia.totalasisten) as totalAsis, " +
                "sum(asistencia.totalnoasisten) as totalAbsencia, " +
                "curso.nombre as nombreCurso, " + 
                "(usuario.apellidos ||', '|| usuario.nombre) as nombreUsuario  " +
                "FROM curso, asistencia, asistenciaalumno, grupo inner join usuario on usuario.id = grupo.idprofesor " +
                "where grupo.idcurso = curso.id "+
                "AND asistenciaalumno.asistid = asistencia.asistid "+
                "AND asistencia.grupoid = grupo.grupoid ";
      
      if (inici!=null)
      {
          sql = sql + " And curso.fecha_inicio >= '" + df.format(new Date(inici.getTime())) + "'";
      }
      
      if (cursos!=null)
      {
         sql = sql + " And (";
         for (int i = 0; i < cursos.size() ; i++ )
         {
            sql = sql + " curso.nombre = '" + cursos.get( i ).getNombre() + "'";

            if (i==cursos.size()-1) 
            {
               sql = sql +  " ) ";
            }
            else
            {
               sql = sql + " OR ";
            }
         }
      }
      
      sql=sql+" group by curso.nombre,nombreUsuario,curso.minasistencia " +
              "order by curso.nombre";
     
     Usuario usr=new Usuario();
      try
      {
         ResultSet rs = executeSql(sql);
         while (rs.next()) 
         {
            
            usr.setApellidos(rs.getString("nombreUsuario"));
            matricula = new Matricula();
            matricula.setCursoNombre(rs.getString("nombreCurso"));
            matricula.setUsuarioNombre(usr.getApellidos());
            matricula.setAsis(rs.getInt("totalAsis"));
            matricula.setNoAsis(rs.getInt("totalAbsencia"));
            list.add(matricula);
         }
      }
      catch (SQLException ex) 
      {
         throw ex;
      } 
      catch (Exception ex) 
      {
         throw ex;
      }
      
      return list;
   }
    
   
    /**
    * Obtiene una lista completa de cursos i grupos de loa alumnos
    * @param inici fecha de inicio
    * @param nif nif del alumno
    * @return Una lista de instancia de {@link Matricula}.
    * @throws SQLException
    * @throws Exception 
    */
   public ArrayList<Matricula> getCursosGruposAlumnos(java.util.Date inici, String nif) throws SQLException, Exception
   {
      Matricula matricula;
      String sql;
      ArrayList<Matricula> list = new ArrayList<Matricula>();
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      Date hoy = new Date(System.currentTimeMillis());
      
      sql = "select usuario.id as usuarioId, " +
                "usuario.nif as nif, " + 
                "matriculas.matriculaid as matriculaId, " +
                "grupo.turno as turno, " +
                "(usuario.apellidos ||', '|| usuario.nombre) as nombreUsuario, " +
                "curso.nombre as nombreCurso, " +
                "grupo.nombre as nombregrupo, " + 
                "curso.fecha_inicio,  " +
                "curso.fecha_finalizacion " +
                "from usuario,curso,grupo,matriculas " +
                "where grupo.idcurso=curso.id " +
                "AND matriculas.usuarioid=usuario.id " +
                "AND matriculas.grupoid=grupo.grupoid " +
                "AND matriculas.usuarioid=usuario.id ";

      if (nif != null) 
      {
         sql = sql + "AND usuario.nif='" + nif + "'";
      }
      if (inici != null) 
      {
         sql = sql + " And curso.fecha_inicio >= '" + df.format(new Date(inici.getTime())) + "'";
      }

     Usuario usr=new Usuario();
      try
      {
         ResultSet rs = executeSql(sql);
         while (rs.next()) 
         {
            
            usr.setApellidos(rs.getString("nombreUsuario"));
            matricula = new Matricula();
            matricula.setUsuarioId(rs.getInt("usuarioId"));
            matricula.setIdMatricula(rs.getInt("matriculaId"));
            matricula.setTurno(rs.getInt("turno"));
            matricula.setFechaInicio(rs.getDate("fecha_inicio"));
            matricula.setFechaFinal(rs.getDate("fecha_finalizacion"));
            matricula.setCursoNombre(rs.getString("nombreCurso"));
            matricula.setGrupoNombre(rs.getString("nombregrupo"));
            matricula.setUsuarioNif(rs.getString("nif"));
            matricula.setUsuarioNombre(usr.getApellidos());
            list.add(matricula);
         }
      }
      catch (SQLException ex) 
      {
         throw ex;
      } 
      catch (Exception ex) 
      {
         throw ex;
      }
      
      return list;
   }
   
   
   /**
    * Obtiene una lista completa de asistencia por horas.
    * 
    * @param inici hora de inicio
    * @param fi hora fin
    * @return Una lista de instancia de {@link Matricula}.
    * 
    * @throws SQLException
    * @throws Exception 
    */
   public ArrayList<Matricula> getAsistenciaHoras (java.sql.Time inici, java.sql.Time fi) throws SQLException, Exception
   {
      Matricula matricula;
      String sql;
      ArrayList<Matricula> list = new ArrayList<Matricula>();
      
      sql = "select horainicio, horafin, " +
                "sum(totalasisten) as asisten, " + 
                "sum(totalnoasisten) as noasisten " +
                "from asistencia ";
                
      
      if(inici!=null)sql=sql+"where horainicio>='"+ inici +"'";
      if (fi!=null)sql = sql + " And horainicio <= '" + fi + "'";
      sql=sql+" group by horainicio, horafin";
 
      try
      {
         ResultSet rs = executeSql(sql);
         while (rs.next()) 
         {
            matricula = new Matricula();
            matricula.setHoraInicio(rs.getTime("horainicio"));
            matricula.setAsis(rs.getInt("asisten"));
            matricula.setNoAsis(rs.getInt("noasisten"));
            list.add(matricula);
         }
      }
      catch (SQLException ex) 
      {
         throw ex;
      } 
      catch (Exception ex) 
      {
         throw ex;
      }
      
      return list;
   }
    
    
   //===========================================
   // Private members
   //===========================================
   
   /**
    * Lee la información de un grupo desde una fila de un {@linl ResultSet}.
    * 
    * @param matricula
    * @param rs
    * 
    * @throws SQLException 
    */
   private void getMatriculaValues(Matricula matricula, ResultSet rs) throws SQLException
   {
      matricula.setId(rs.getInt("matriculaid"));
      matricula.setCursoId(rs.getInt("cursoid"));
      matricula.setGrupoId(rs.getInt("grupoid"));
      matricula.setEstado(rs.getInt("estadoid"));
      matricula.setUsuarioId(rs.getInt("usuarioid"));
      matricula.setFechaModificacion(rs.getDate("fechamodificacion"));
      matricula.setFechaAlta(rs.getDate("fechaalta"));
            
      // Propiedades de sólo lectura (para listados)
      matricula.setGrupoNombre(rs.getString("grupoNombre"));
      matricula.setCursoNombre(rs.getString("cursoNombre"));
      matricula.setUsuarioNombre(rs.getString("usrApellidos") + ", " + rs.getString("usrNombre"));
      matricula.setUsuarioNif(rs.getString("usrNif"));
      matricula.setFechaInicio(rs.getDate("fechainicio"));
      matricula.setFechaFinal(rs.getDate("fechafin"));
   }
   
   /**
    * Si la matricula previmanet estaba aceptada en otro grupo, libera la plaza en el grupo antiguo.
    * 
    * @param id Identificador de la matrícula original (antes de ninguna modificación).
    * 
    * @throws SQLException
    * @throws Exception 
    */
   private void liberarPlazaEnGroup(Matricula matricula) throws SQLException, Exception
   {
      String sql;
      Matricula oldreg;

      try 
      {
         oldreg = this.get(matricula.getId());
         if (oldreg.getEstado() == Matricula.MATRICULA_ESTADO_ACEPTADA && matricula.getGrupoId() != oldreg.getGrupoId())
         {
            sql = "UPDATE grupo " +
                  "SET    plazasdisponibles = plazasdisponibles + 1 " +
                  "WHERE  grupoid           = " + oldreg.getGrupoId();
            execute(sql);
         }
      } 
      catch (SQLException ex) 
      {
         throw ex;
      }
      catch (Exception ex) 
      {
         throw ex;
      }
   }
}
