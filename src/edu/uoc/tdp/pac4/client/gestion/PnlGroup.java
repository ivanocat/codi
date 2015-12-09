package edu.uoc.tdp.pac4.client.gestion;

import edu.uoc.tdp.pac4.beans.Aula;
import edu.uoc.tdp.pac4.beans.Actividad;
import edu.uoc.tdp.pac4.beans.Grupo;
import edu.uoc.tdp.pac4.beans.IdentifiableObject;
import edu.uoc.tdp.pac4.beans.Profesor;
import edu.uoc.tdp.pac4.exceptions.GroupAlreadyExistsException;
import edu.uoc.tdp.pac4.exceptions.NotAvailableProfessorException;
import edu.uoc.tdp.pac4.remote.GestAcademica;
import edu.uoc.tdp.pac4.util.LanguageUtils;
import edu.uoc.tdp.pac4.util.NumericUtils;
import edu.uoc.tdp.pac4.util.StringUtils;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import edu.uoc.tdp.pac4.eAcademiaEU;

/**
 * Formulario de edición de grupo.
 * <br /><br />
 * NOTA: El formulario está preparado para permitir editar un grupo sin asignarle AULA
 *       y PROFESOR. No obstante, el diseño de la BBDD obliga, por las claves foráneas,
 *       a que estos datos estén informados. De momento se han comentado los controles
 *       y obliga a pedir estos datos. Si se modifica la estructura de la BBDD, el
 *       formulario está preparado para permitir crear grupos sin PROFESOR ni AULA.
 * 
 * @author eSupport Netbeans
 */
public class PnlGroup extends javax.swing.JDialog 
{
   private GestAcademica manager;
   private LanguageUtils language;
   private Grupo group;
   private int groupId;
   private List<Actividad> actividades;
   private List<Aula> aulas;
   private List<Profesor> profesores;
   
   /**
    * Creates new form PnlGroup
    */
   public PnlGroup(java.awt.Frame parent, boolean modal, GestAcademica manager, LanguageUtils language) 
   {
      super(parent, modal);
      initComponents();
      
      this.manager = manager;
      this.language = language;
      this.groupId = 0;
      this.group = null;
        
      setLanguage();
      fillLists();
   }
   
   /**
    * Crea el panel para editar un objeto.
    */
   public PnlGroup(java.awt.Frame parent, boolean modal, GestAcademica manager, LanguageUtils language, int groupId) 
   {
      super(parent, modal);
      initComponents();
      
      this.manager = manager;
      this.language = language;
      this.groupId = groupId;
      this.group = null;
        
      setLanguage();
      fillLists();
      fillGroupData(groupId);
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdoGroupTurno = new javax.swing.ButtonGroup();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        cboActividad = new javax.swing.JComboBox();
        lblProfesor = new javax.swing.JLabel();
        cboProfesor = new javax.swing.JComboBox();
        cboAula = new javax.swing.JComboBox();
        lblAula = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rdbManana = new javax.swing.JRadioButton();
        rdbTarde = new javax.swing.JRadioButton();
        btnAccept = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblDateIni = new javax.swing.JLabel();
        lblDateEnd = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        txtMaxAlumnos = new javax.swing.JTextField();
        lblMaxAlumnos = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        lblActividad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar grupo");
        setResizable(false);

        lblName.setText("Nombre");

        cboActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboActividadActionPerformed(evt);
            }
        });

        lblProfesor.setText("Profesor");

        lblAula.setText("Aula");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        rdoGroupTurno.add(rdbManana);
        rdbManana.setSelected(true);
        rdbManana.setText("Mañana");

        rdoGroupTurno.add(rdbTarde);
        rdbTarde.setText("Tarde");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbManana)
                    .addComponent(rdbTarde))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdbManana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbTarde)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAccept.setText("Aceptar");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblDateIni.setText("Fecha de inicio:");

        lblDateEnd.setText("Fecha de finalización:");

        lblFechaFin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFechaFin.setText("- seleccione una actividad -");

        lblFechaInicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFechaInicio.setText("- seleccione una actividad -");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDateEnd)
                    .addComponent(lblDateIni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaInicio)
                    .addComponent(lblFechaFin))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDateIni)
                    .addComponent(lblFechaInicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDateEnd)
                    .addComponent(lblFechaFin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtMaxAlumnos.setText("20");

        lblMaxAlumnos.setText("Máximo alumnos");

        lblTurno.setText("Turno");

        lblActividad.setText("Actividad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAccept)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblActividad))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboActividad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTurno)
                        .addGap(54, 54, 54)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblProfesor)
                                .addComponent(lblAula, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(lblMaxAlumnos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboProfesor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboAula, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMaxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblActividad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProfesor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaxAlumnos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTurno)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAccept))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed

      // Comprueba la validez de los datos proporcionados
      if (StringUtils.isNullOrEmptyTrim(txtName.getText()))
      {
         JOptionPane.showMessageDialog(null,
                                       language.getProperty(eAcademiaEU.FORM_PNLGROUP_WARN_NOMBRE),
                                       language.getProperty(eAcademiaEU.APP_TITLE),
                                       JOptionPane.WARNING_MESSAGE);
         return;
      }
      else if (cboActividad.getSelectedIndex() < 0)
      {
         JOptionPane.showMessageDialog(null,
                                       language.getProperty(eAcademiaEU.FORM_PNLGROUP_WARN_ACTIVIDAD),
                                       language.getProperty(eAcademiaEU.APP_TITLE),
                                       JOptionPane.WARNING_MESSAGE);
         return;
      }
      else if (cboProfesor.getSelectedIndex() < 0) // && this.groupId > 0)
      {
         JOptionPane.showMessageDialog(null,
                                       language.getProperty(eAcademiaEU.FORM_PNLGROUP_WARN_PROFESOR),
                                       language.getProperty(eAcademiaEU.APP_TITLE),
                                       JOptionPane.WARNING_MESSAGE);
         return;
      }
      else if (cboAula.getSelectedIndex() < 0) // && this.groupId > 0)
      {
         JOptionPane.showMessageDialog(null, 
                                       language.getProperty(eAcademiaEU.FORM_PNLGROUP_WARN_AULA),
                                       language.getProperty(eAcademiaEU.APP_TITLE),
                                       JOptionPane.WARNING_MESSAGE);
         return;
      }
      else if (!NumericUtils.isInteger(txtMaxAlumnos.getText()))
      {
         JOptionPane.showMessageDialog(null,
                                       language.getProperty(eAcademiaEU.FORM_PNLGROUP_WARN_MAXALUMNOS),
                                       language.getProperty(eAcademiaEU.APP_TITLE),
                                       JOptionPane.WARNING_MESSAGE);
         return;
      }

      // Recoge datos del formulario
      group = new Grupo();
      group.setId(this.groupId);
      group.setNombre(txtName.getText());
      group.setMaxAlumnos(Integer.parseInt(txtMaxAlumnos.getText()));
      group.setFechaInicioActividad(((Actividad) cboActividad.getSelectedItem()).getDataInici());
      group.setFechaFinActividad(((Actividad) cboActividad.getSelectedItem()).getDataFi());
      group.setTurno((rdbManana.isSelected() ? Grupo.TURNO_MANANA : Grupo.TURNO_TARDE));
      group.setIdActividad(((Actividad) cboActividad.getSelectedItem()).getId());
      if (cboAula.getSelectedIndex() >= 0)
      {
         group.setIdAula(((Aula) cboAula.getSelectedItem()).getId());
      }
      else
      {
         group.setIdAula(0);
      }
      if (cboProfesor.getSelectedIndex() >= 0)
      {
         group.setIdProfesor(((Profesor) cboProfesor.getSelectedItem()).getId());
      }
      else
      {
         group.setIdProfesor(0);
      }

      // Realiza la acción apropiada según el modo actual del formulario
      try
      {
         if (this.groupId <= 0)
         {
            // Inicialmente el grupo tiene tantas plazas libres cono alumnos puede tener el grupo
            group.setPlazasDisponibles(Integer.parseInt(txtMaxAlumnos.getText()));
            
            manager.addGrupo(group);
         }
         else
         {
            manager.updateGrupo(group);
         }

         // Cierra el formulario
         this.dispose();
      }
      catch (GroupAlreadyExistsException ex)
      {
         JOptionPane.showMessageDialog(null,
                                       language.getProperty(eAcademiaEU.ERROR_GROUPALREADYEXISTS),
                                       language.getProperty(eAcademiaEU.APP_TITLE),
                                       JOptionPane.ERROR_MESSAGE);
      }
      catch (NotAvailableProfessorException ex)
      {
         JOptionPane.showMessageDialog(null,
                                       language.getProperty(eAcademiaEU.ERROR_NOTAVAILABLEPROFESSOR),
                                       language.getProperty(eAcademiaEU.APP_TITLE),
                                       JOptionPane.ERROR_MESSAGE);
      }
      catch (Exception ex)
      {
         JOptionPane.showMessageDialog(null, 
                                       language.getProperty(eAcademiaEU.ERROR_GENERIC) + "\n" + language.getProperty(eAcademiaEU.ERROR_DETAILS) + ":\n\n" + ex.getMessage(), 
                                       language.getProperty(eAcademiaEU.APP_TITLE), 
                                       JOptionPane.ERROR_MESSAGE);
         
         // Registra el error en un archivo de LOG
         // Logger.getLogger(FrmResourcesRequest.class.getName()).log(Level.SEVERE, null, ex);
      }
   }//GEN-LAST:event_btnAcceptActionPerformed

   private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

      // Cierra el formulario
      this.dispose();
   }//GEN-LAST:event_btnCancelarActionPerformed

   private void cboActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboActividadActionPerformed
      
      // Actualiza las fechas de inicio y fin de la actividad
      if (cboActividad.getSelectedIndex() < 0)
      {
         lblFechaInicio.setText(language.getProperty(eAcademiaEU.FORM_PNLGROUP_SELECTACTIVIDAD));
         lblFechaFin.setText(language.getProperty(eAcademiaEU.FORM_PNLGROUP_SELECTACTIVIDAD));
      }
      else
      {
         SimpleDateFormat sdf = new SimpleDateFormat(language.getProperty(eAcademiaEU.FORMAT_SHORTDATE));
         lblFechaInicio.setText(sdf.format(actividades.get(cboActividad.getSelectedIndex()).getDataInici()));
         lblFechaFin.setText(sdf.format(actividades.get(cboActividad.getSelectedIndex()).getDataFi()));
      }
      
   }//GEN-LAST:event_cboActividadActionPerformed
 
   /**
    * Internacionaliza el idioma del formulario.
    */
   private void setLanguage()
   {
      this.setTitle(language.getProperty(eAcademiaEU.FORM_PNLGROUP_TITLE));
      lblName.setText(language.getProperty(eAcademiaEU.FORM_PNLGROUP_NOMBRE));
      lblActividad.setText(language.getProperty(eAcademiaEU.FORM_PNLGROUP_ACTIVIDAD));
      lblDateIni.setText(language.getProperty(eAcademiaEU.FORM_PNLGROUP_FECHAINI));
      lblFechaInicio.setText(language.getProperty(eAcademiaEU.FORM_PNLGROUP_SELECTACTIVIDAD));
      lblDateEnd.setText(language.getProperty(eAcademiaEU.FORM_PNLGROUP_FECHAFIN));
      lblFechaFin.setText(language.getProperty(eAcademiaEU.FORM_PNLGROUP_SELECTACTIVIDAD));
      lblProfesor.setText(language.getProperty(eAcademiaEU.FORM_PNLGROUP_PROFESOR));
      lblAula.setText(language.getProperty(eAcademiaEU.FORM_PNLGROUP_AULA));
      lblMaxAlumnos.setText(language.getProperty(eAcademiaEU.FORM_PNLGROUP_MAXALUMNOS));
      lblTurno.setText(language.getProperty(eAcademiaEU.FORM_PNLGROUP_TURNO));
      rdbManana.setText(language.getProperty(eAcademiaEU.FORM_PNLGROUP_MANANA));
      rdbTarde.setText(language.getProperty(eAcademiaEU.FORM_PNLGROUP_TARDE));
      btnAccept.setText(language.getProperty(eAcademiaEU.FORM_COMMON_ACCEPT));
      btnCancelar.setText(language.getProperty(eAcademiaEU.FORM_COMMON_CANCEL));
   }
   
   /**
    * Rellena el formulario con la información de un determinado grupo.
    */
   private void fillGroupData(int id)
   {
      SimpleDateFormat sdf = new SimpleDateFormat(language.getProperty(eAcademiaEU.FORMAT_SHORTDATE));
      
      try 
      {
         // Rellena la lista de actividades
         this.group = manager.getGrupo(id);
         
         txtName.setText(group.getNombre());
         txtMaxAlumnos.setText("" + group.getMaxAlumnos());
         lblFechaInicio.setText(sdf.format(group.getFechaInicioActividad()));
         lblFechaFin.setText(sdf.format(group.getFechaFinActividad()));
         rdbManana.setSelected(group.getTurno() == Grupo.TURNO_MANANA);
         rdbTarde.setSelected(group.getTurno() == Grupo.TURNO_TARDE);
         
         cboActividad.setSelectedItem(IdentifiableObject.getObjectFromList(actividades.toArray(), manager.getActividad(group.getIdActividad()).getId()));
         cboActividad.setEnabled(false);

         if (group.getIdProfesor() > 0)
         {
            cboProfesor.setSelectedItem(IdentifiableObject.getObjectFromList(profesores.toArray(), manager.getProfesor(group.getIdProfesor()).getId()));
         }
         if (group.getIdAula() > 0)
         {
            cboAula.setSelectedItem(IdentifiableObject.getObjectFromList(aulas.toArray(), manager.getAula(group.getIdAula()).getId()));
         }

      } 
      catch (Exception ex)
      {
         JOptionPane.showMessageDialog(null, 
                                       language.getProperty(eAcademiaEU.ERROR_GENERIC) + "\n" + language.getProperty(eAcademiaEU.ERROR_DETAILS) + ":\n\n" + ex.getMessage(), 
                                       language.getProperty(eAcademiaEU.APP_TITLE), 
                                       JOptionPane.ERROR_MESSAGE);
         
         // Registra el error en un archivo de LOG
         // Logger.getLogger(FrmResourcesRequest.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
   
   /**
    * Rellena las listas del formulario.
    */
   private void fillLists()
   {
      try 
      {
         actividades = manager.getActividades();
         cboActividad.removeAll();
         cboActividad.setModel(new DefaultComboBoxModel(actividades.toArray()));
         cboActividad.setSelectedIndex(-1);
         
         aulas = manager.getAulas();
         cboAula.removeAll();
         cboAula.setModel(new DefaultComboBoxModel(aulas.toArray()));
         cboAula.setSelectedIndex(-1);
         
         profesores = manager.getProfesores();
         cboProfesor.removeAll();
         cboProfesor.setModel(new DefaultComboBoxModel(profesores.toArray()));
         cboProfesor.setSelectedIndex(-1);
      }
      catch (Exception ex) 
      {
         JOptionPane.showMessageDialog(null, 
                                       language.getProperty(eAcademiaEU.ERROR_GENERIC) + "\n" + language.getProperty(eAcademiaEU.ERROR_DETAILS) + ":\n\n" + ex.getMessage(), 
                                       language.getProperty(eAcademiaEU.APP_TITLE), 
                                       JOptionPane.ERROR_MESSAGE);
         
         // Registra el error en un archivo de LOG
         // Logger.getLogger(FrmResourcesRequest.class.getName()).log(Level.SEVERE, null, ex);
         
         // Bloquea el botón de Aceptar pues no sabemos a priori como ha quedado el formulario
         btnAccept.setEnabled(false);
      }
   }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cboActividad;
    private javax.swing.JComboBox cboAula;
    private javax.swing.JComboBox cboProfesor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblActividad;
    private javax.swing.JLabel lblAula;
    private javax.swing.JLabel lblDateEnd;
    private javax.swing.JLabel lblDateIni;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblMaxAlumnos;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblProfesor;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JRadioButton rdbManana;
    private javax.swing.JRadioButton rdbTarde;
    private javax.swing.ButtonGroup rdoGroupTurno;
    private javax.swing.JTextField txtMaxAlumnos;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
