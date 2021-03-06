package edu.uoc.tdp.pac4.client.conexion;

import edu.uoc.tdp.pac4.beans.Actividad;
import edu.uoc.tdp.pac4.beans.Grupo;
import edu.uoc.tdp.pac4.beans.Matricula;
import edu.uoc.tdp.pac4.beans.Usuario;
import edu.uoc.tdp.pac4.exceptions.ApplicationAlreadyExistsException;
import edu.uoc.tdp.pac4.remote.Conexion;
import edu.uoc.tdp.pac4.util.ComboItem;
import edu.uoc.tdp.pac4.util.LanguageUtils;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;

/**
 *
 * @author Javabeginers
 */
public class PnlSolicitaMatricula extends javax.swing.JDialog 
{
   private Conexion manager;
   private LanguageUtils language;
   private ArrayList<Grupo> grupos;
   private Usuario alumno;

   /**
    * Creates new form PnlSolicitaMatricula
    */
   public PnlSolicitaMatricula(java.awt.Frame parent, boolean modal, Conexion manager, LanguageUtils language, Usuario alumno) 
   {
      super(parent, modal);
      this.manager = manager;
      this.language = language;
      this.alumno = alumno;  
      initComponents();
      setLocationRelativeTo(null);
      pnlFilter.setVisible(false);            
      fillForm();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tlbarMatriculas = new javax.swing.JToolBar();
        cmdAdd = new javax.swing.JButton();
        jSprtMatriculas = new javax.swing.JToolBar.Separator();
        cmbBibliografia = new javax.swing.JButton();
        cmbPlanDocente = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        cmdFilter = new javax.swing.JToggleButton();
        cmdClose = new javax.swing.JButton();
        scrlPnCursos = new javax.swing.JScrollPane();
        tblGrupos = new javax.swing.JTable();
        pnlFilter = new javax.swing.JPanel();
        lblTurno = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();
        cboCurso = new javax.swing.JComboBox();
        cmdSetFilter = new javax.swing.JButton();
        lblFechaInicio = new javax.swing.JLabel();
        lblFechaFinalizacion = new javax.swing.JLabel();
        cboTurno = new javax.swing.JComboBox();
        cmdFilterDelete = new javax.swing.JButton();
        spnFechaFin = new javax.swing.JSpinner();
        spnFechaInicio = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(language.getProperty("cnxmatricula.solicitudmatricula.formname"));
        setName("frmMatriculas"); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 500));

        tlbarMatriculas.setRollover(true);

        cmdAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/book--plus.png"))); // NOI18N
        cmdAdd.setText(language.getProperty("cnxmatricula.solicitudmatricula.solicitar"));
        cmdAdd.setFocusable(false);
        cmdAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });
        tlbarMatriculas.add(cmdAdd);
        tlbarMatriculas.add(jSprtMatriculas);

        cmbBibliografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/book-open-text.png"))); // NOI18N
        cmbBibliografia.setText(language.getProperty("cnxmatricula.solicitudmatricula.bibliografia"));
        cmbBibliografia.setFocusable(false);
        cmbBibliografia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmbBibliografia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmbBibliografia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBibliografiaActionPerformed(evt);
            }
        });
        tlbarMatriculas.add(cmbBibliografia);

        cmbPlanDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/books-stack.png"))); // NOI18N
        cmbPlanDocente.setText(language.getProperty("cnxmatricula.solicitudmatricula.plandocente"));
        cmbPlanDocente.setFocusable(false);
        cmbPlanDocente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmbPlanDocente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmbPlanDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPlanDocenteActionPerformed(evt);
            }
        });
        tlbarMatriculas.add(cmbPlanDocente);
        tlbarMatriculas.add(jSeparator1);

        cmdFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/funnel.png"))); // NOI18N
        cmdFilter.setText(language.getProperty("cnxmatricula.solicitudmatricula.filtrar"));
        cmdFilter.setFocusable(false);
        cmdFilter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdFilter.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmdFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdFilterActionPerformed(evt);
            }
        });
        tlbarMatriculas.add(cmdFilter);

        cmdClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/arrow-curve-180.png"))); // NOI18N
        cmdClose.setText(language.getProperty("cnxmatricula.solicitudmatricula.cerrar"));
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        tblGrupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrlPnCursos.setViewportView(tblGrupos);

        pnlFilter.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTurno.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTurno.setText(language.getProperty("cnxmatricula.solicitudmatricula.turno"));

        lblCurso.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCurso.setText(language.getProperty("cnxmatricula.solicitudmatricula.curso"));

        cmdSetFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/funnel--plus.png"))); // NOI18N
        cmdSetFilter.setText(language.getProperty("cnxmatricula.solicitudmatricula.aplicar"));
        cmdSetFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSetFilterActionPerformed(evt);
            }
        });

        lblFechaInicio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFechaInicio.setText(language.getProperty("cnxmatricula.solicitudmatricula.fechainicio"));

        lblFechaFinalizacion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFechaFinalizacion.setText(language.getProperty("cnxmatricula.solicitudmatricula.fechafin"));

        cmdFilterDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/eraser.png"))); // NOI18N
        cmdFilterDelete.setText(language.getProperty("cnxmatricula.solicitudmatricula.limpiar"));
        cmdFilterDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdFilterDeleteActionPerformed(evt);
            }
        });

        spnFechaFin.setModel(new javax.swing.SpinnerDateModel());
        spnFechaFin.setEditor(new javax.swing.JSpinner.DateEditor(spnFechaFin, "dd/MM/yyyy"));

        spnFechaInicio.setModel(new javax.swing.SpinnerDateModel());
        spnFechaInicio.setEditor(new javax.swing.JSpinner.DateEditor(spnFechaInicio, "dd/MM/yyyy"));

        javax.swing.GroupLayout pnlFilterLayout = new javax.swing.GroupLayout(pnlFilter);
        pnlFilter.setLayout(pnlFilterLayout);
        pnlFilterLayout.setHorizontalGroup(
            pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTurno)
                    .addComponent(lblCurso, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFilterLayout.createSequentialGroup()
                        .addComponent(cboCurso, 0, 462, Short.MAX_VALUE)
                        .addGap(27, 27, 27))
                    .addGroup(pnlFilterLayout.createSequentialGroup()
                        .addComponent(cboTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFilterLayout.createSequentialGroup()
                        .addComponent(lblFechaFinalizacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFilterLayout.createSequentialGroup()
                        .addComponent(lblFechaInicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdSetFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdFilterDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlFilterLayout.setVerticalGroup(
            pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFilterLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCurso)))
                    .addGroup(pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdFilterDelete)
                        .addComponent(spnFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFechaInicio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spnFechaFin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFechaFinalizacion)
                        .addComponent(lblTurno)
                        .addComponent(cboTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdSetFilter)))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tlbarMatriculas, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cmdClose))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrlPnCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnlFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tlbarMatriculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(pnlFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrlPnCursos, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdClose)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   /**
    * Añade una solicitud de matrícula
    * @param evt 
    */
   private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
    
        if (tblGrupos.getSelectedRow() < 0) {
                   
            JOptionPane.showMessageDialog(null,
                                          language.getProperty("cnxmatricula.solicitudmatricula.warncurso"),
                                          language.getProperty("app.title"),
                                          JOptionPane.WARNING_MESSAGE);
         return;
        }
                
        // Obtiene el curso seleccionado, para obtener sus datos
        Grupo grupo = grupos.get(tblGrupos.getSelectedRow()); 
        
        //Función que verifica aspectos de la solicitud antes de permitir su inserción
        if(!verificaMatricula(grupo))
            return;
            
        // Genera un objeto matrícula para su inserción en la base de datos
        Matricula matricula = new Matricula();        
        // Inserta datos en matrícula
        matricula.setUsuarioId(alumno.getId());        
        matricula.setGrupoId(grupo.getId());
        matricula.setactividadId(grupo.getIdActividad());
        matricula.setEstado(Matricula.MATRICULA_ESTADO_PENDIENTE);
        try 
        {
            manager.addMatricula(matricula);            
            JOptionPane.showMessageDialog(null,
                                          language.getProperty("cnxmatricula.solicitudmatricula.infosolicitud"), 
                                          language.getProperty("app.title"),
                                          JOptionPane.INFORMATION_MESSAGE);
            
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null,
                                          "ERROR SQL: " + ex.getMessage(),
                                          language.getProperty("app.title"),
                                          JOptionPane.ERROR_MESSAGE);
        }
        catch (ApplicationAlreadyExistsException ex)
        {            
            JOptionPane.showMessageDialog(null,
                                          language.getProperty("cnxmatricula.solicitudmatricula.errorsolicitud"), 
                                          language.getProperty("app.title"),
                                          JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,
                                          "ERROR: " + ex.getMessage(),
                                          language.getProperty("app.title"),
                                          JOptionPane.ERROR_MESSAGE);
        }
        fillForm();
    
   }//GEN-LAST:event_cmdAddActionPerformed

   private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed

      // Cierra el formulario
      this.dispose();

   }//GEN-LAST:event_cmdCloseActionPerformed

    private void cmbPlanDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPlanDocenteActionPerformed
     
        if (tblGrupos.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null,
                                          language.getProperty("cnxmatricula.solicitudmatricula.warncurso"),
                                          language.getProperty("app.title"),
                                          JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtiene el curso seleccionado, para poder obetener el plan docente
        Grupo grupo = grupos.get(tblGrupos.getSelectedRow());      
        PnlMuestraPlanDocente form = new PnlMuestraPlanDocente(this, true, language, grupo);
        form.setLocationRelativeTo(null);
        form.setVisible(true);      
      
    }//GEN-LAST:event_cmbPlanDocenteActionPerformed

    private void cmbBibliografiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBibliografiaActionPerformed
        
      if (tblGrupos.getSelectedRow() < 0)
      {
         JOptionPane.showMessageDialog(null,
                                       language.getProperty("cnxmatricula.solicitudmatricula.warncurso"),
                                       language.getProperty("app.title"),
                                       JOptionPane.WARNING_MESSAGE);
         return;
      }
      
      Grupo grupo = grupos.get(tblGrupos.getSelectedRow());
      PnlMuestraBibliografia form = new PnlMuestraBibliografia(this, true, language, grupo);
      form.setLocationRelativeTo(null);
      form.setVisible(true);
    }//GEN-LAST:event_cmbBibliografiaActionPerformed

    private void cmdSetFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSetFilterActionPerformed

        int idCurso = (cboCurso.getSelectedIndex() >= 0 ? ((Actividad)cboCurso.getSelectedItem()).getId() : -1);
        int idTurno = (cboTurno.getSelectedIndex() >= 0 ? ((ComboItem)cboTurno.getSelectedItem()).getId() : -1);

        fillForm(idCurso, idTurno, (Date) spnFechaInicio.getValue(), (Date) spnFechaFin.getValue());
    }//GEN-LAST:event_cmdSetFilterActionPerformed

    private void cmdFilterDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdFilterDeleteActionPerformed

        //Limpiar filtros y recargar tabla
        fillFilterPanel();
        fillForm();

    }//GEN-LAST:event_cmdFilterDeleteActionPerformed

    private void cmdFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdFilterActionPerformed
      
      pnlFilter.setVisible(cmdFilter.isSelected());
      
      // Si se oculta el filtro, se regenera la lista completa
      if (!pnlFilter.isVisible())
      {
         fillForm();
      }
      else
      {
         fillFilterPanel();
      }
    }//GEN-LAST:event_cmdFilterActionPerformed

  
  /**
    * Rellena el panel de filtros.
    */
   private void fillFilterPanel() 
   {
      try 
      {
         //Formateo del Spinner de fecha (formato de fecha y no editable con teclado)
	spnFechaInicio.setEditor(new JSpinner.DateEditor(spnFechaInicio, "dd/MM/yyyy"));
	JFormattedTextField ftf = getTextField(spnFechaInicio);
	((DateFormatter) ftf.getFormatter()).setAllowsInvalid(false);	
        ftf.setEditable(false);        
        spnFechaFin.setEditor(new JSpinner.DateEditor(spnFechaFin, "dd/MM/yyyy"));
        ftf = getTextField(spnFechaFin);
	((DateFormatter) ftf.getFormatter()).setAllowsInvalid(false);	
        ftf.setEditable(false);
        
         // Rellena la lista de cursos
         cboCurso.removeAll();
         cboCurso.setModel(new DefaultComboBoxModel(manager.getActividades().toArray()));
         cboCurso.setSelectedIndex(-1);

         // Rellena el combo de filtros
         ArrayList<ComboItem> turnos = new ArrayList<ComboItem>();
         turnos.add(new ComboItem(Grupo.getTurnoName(Grupo.TURNO_MANANA, language), Grupo.TURNO_MANANA));
         turnos.add(new ComboItem(Grupo.getTurnoName(Grupo.TURNO_TARDE, language), Grupo.TURNO_TARDE));
         cboTurno.removeAll();
         cboTurno.setModel(new DefaultComboBoxModel(turnos.toArray()));
         cboTurno.setSelectedIndex(-1);                  
      } 
      catch (Exception ex) 
      {
         JOptionPane.showMessageDialog(null, 
                                       language.getProperty("err.filter"),
                                       language.getProperty("app.title"), 
                                       JOptionPane.ERROR_MESSAGE);
      }
   }
   
   /**
    * Confecciona el listado completo.
    */
   private void fillForm()
   {
      //Por defecto, solo muestra los cursos cuya fecha de comienzo sea posterior a la actual 
      fillForm(-1, -1, new Date(), null);
   }
   
   /**
    * Confecciona el listado filtrado.
    */
   private void fillForm(int idCurso, int idTurno, Date fechaInicio, Date fechaFin)
   {
      SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                         
      // Rellena la tabla
      ArrayList<String> header = new ArrayList<String>();   // cabecera
      header.add(language.getProperty("cnxmatricula.solicitudmatricula.tableheadercurso"));
      header.add(language.getProperty("cnxmatricula.solicitudmatricula.tableheaderprofesor"));
      header.add(language.getProperty("cnxmatricula.solicitudmatricula.tableheaderaula"));
      header.add(language.getProperty("cnxmatricula.solicitudmatricula.tableheaderturno"));
      header.add(language.getProperty("cnxmatricula.solicitudmatricula.tableheaderfechainicio"));
      header.add(language.getProperty("cnxmatricula.solicitudmatricula.tableheaderfechafin"));
      header.add(language.getProperty("cnxmatricula.solicitudmatricula.tableheaderplazas"));
      header.add(language.getProperty("cnxmatricula.solicitudmatricula.tableheaderplazasdisponibles"));
      header.add(language.getProperty("cnxmatricula.solicitudmatricula.tableheaderasistenciarequerida"));
      
      String[][] gridData;
      ArrayList<String> row;

      try 
      {
         grupos = manager.getGrupos(idCurso, idTurno, fechaInicio, fechaFin);
         gridData = new String[grupos.size()][9];
         int i = 0;
         for (Grupo grupo : grupos)
         {
            gridData[i][0] = grupo.getNombreActividad();
            gridData[i][1] = grupo.getNombreProfesor();
            gridData[i][2] = grupo.getNombreAula();
            gridData[i][3] = (grupo.getTurno() == Grupo.TURNO_MANANA ? "Mañana" : "Tarde");
            gridData[i][4] = (grupo.getFechaFinActividad() == null ? "?" : df.format(grupo.getFechaInicioActividad()));
            gridData[i][5] = (grupo.getFechaFinActividad() == null ? "?" : df.format(grupo.getFechaFinActividad()));
            gridData[i][6] = String.valueOf(grupo.getMaxAlumnos());
            gridData[i][7] = String.valueOf(grupo.getPlazasDisponibles());
            gridData[i][8] = String.valueOf(grupo.getMinimoAsistenciaActividad()) + "%";
            i++;
         }
         
         //Modificamos la tabla para que no sea editable
         tblGrupos.setModel(new DefaultTableModel(gridData, header.toArray()) {
               @Override
               public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });         
         
      } 
      catch (SQLException ex)
      {
         JOptionPane.showMessageDialog(null, 
                                       language.getProperty("err.sql") + "\n" + language.getProperty("err.detail") + ":\n\n" + ex.getMessage(), 
                                       language.getProperty("app.title"), 
                                       JOptionPane.ERROR_MESSAGE);
         
         // Registra el error en un archivo de LOG
         // Logger.getLogger(FrmResourcesRequest.class.getName()).log(Level.SEVERE, null, ex);
      }
      catch (RemoteException ex)
      {
         JOptionPane.showMessageDialog(null, 
                                       language.getProperty("err.rmi") + "\n" + language.getProperty("err.detail") + ":\n\n" + ex.getMessage(), 
                                       language.getProperty("app.title"), 
                                       JOptionPane.ERROR_MESSAGE);
         
         // Registra el error en un archivo de LOG
         // Logger.getLogger(FrmResourcesRequest.class.getName()).log(Level.SEVERE, null, ex);
      }
      catch (Exception ex) 
      {
         JOptionPane.showMessageDialog(null, 
                                       language.getProperty("err.generic") + "\n" + language.getProperty("err.detail") + ":\n\n" + ex.getMessage(), 
                                       language.getProperty("app.title"), 
                                       JOptionPane.ERROR_MESSAGE);
         
         // Registra el error en un archivo de LOG
         // Logger.getLogger(FrmResourcesRequest.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
   
   /**
    * Método para formatear la fecha de un componente spinner
    * @param spinner
    * @return JFormattedTextField
    */
   private JFormattedTextField getTextField(JSpinner spinner) {
        
        JComponent editor = spinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            return ((JSpinner.DefaultEditor)editor).getTextField();
	    } 
        else 
        {
	        System.err.println(language.getProperty("err.jeditor")
	                           + spinner.getEditor().getClass()
	                           + " no es descendiente de DefaultEditor");
	        return null;
        }
    }
   
   /**
    * Método que verifica los datos de inserción de una nueva solicitud de @link Matricula
    * @param grupo
    * @return true | false según se pueda inserta la matrícula o no
    */
   private boolean verificaMatricula(Grupo grupo)
   {       
               
        // Si no quedan plazas disponibles, se impide la solicitud
        if (grupo.getPlazasDisponibles() == 0) {
                        
            JOptionPane.showMessageDialog(null,
                                          language.getProperty("cnxmatricula.solicitudmatricula.errorplazas"),
                                          language.getProperty("app.title"),
                                          JOptionPane.ERROR_MESSAGE);
            return false;
        }
                
        // Si el curso ha ya comenzado, se impide la solicitud. Para pruebas, se permite
        //realizar la solicitud el mismo día que empieza el curso.
        if (grupo.getFechaInicioActividad().before(new Date()))
        {
                        
            JOptionPane.showMessageDialog(null,
                                          language.getProperty("cnxmatricula.solicitudmatricula.errorcursocomenzado"),
                                          language.getProperty("app.title"),
                                          JOptionPane.ERROR_MESSAGE);
            return false;
        }
   
        return true;
   }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboCurso;
    private javax.swing.JComboBox cboTurno;
    private javax.swing.JButton cmbBibliografia;
    private javax.swing.JButton cmbPlanDocente;
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdClose;
    private javax.swing.JToggleButton cmdFilter;
    private javax.swing.JButton cmdFilterDelete;
    private javax.swing.JButton cmdSetFilter;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSprtMatriculas;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblFechaFinalizacion;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JPanel pnlFilter;
    private javax.swing.JScrollPane scrlPnCursos;
    private javax.swing.JSpinner spnFechaFin;
    private javax.swing.JSpinner spnFechaInicio;
    private javax.swing.JTable tblGrupos;
    private javax.swing.JToolBar tlbarMatriculas;
    // End of variables declaration//GEN-END:variables
}
