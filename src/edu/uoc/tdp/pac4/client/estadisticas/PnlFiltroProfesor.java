/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uoc.tdp.pac4.client.estadisticas;

import edu.uoc.tdp.pac4.beans.Curso;
import edu.uoc.tdp.pac4.beans.Usuario;
import edu.uoc.tdp.pac4.exceptions.eAssistenciaException;
import edu.uoc.tdp.pac4.remote.Estadisticas;
import edu.uoc.tdp.pac4.util.LanguageUtils;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
/**
 *
 * @author eSupport Netbeans
 */
public class PnlFiltroProfesor extends javax.swing.JDialog {

   private Estadisticas manager;
   private LanguageUtils language;
   private Usuario usuario;
   private java.awt.Frame parent;
   DefaultListModel modelo ;
   DefaultListModel modelo2 ;
   ArrayList<Curso> listaCurso;
    /**
     * Creates new form PnlFiltroProfesor
     */
    public PnlFiltroProfesor(java.awt.Frame parent, boolean modal,Estadisticas manager, LanguageUtils language, Usuario usr) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.manager = manager;
        this.language = language;
        this.usuario=usr;
        this.parent=parent;
        //Cargar textos
        
        btnAceptar.setText(language.getProperty("estadisticas.profesor.btn.alumnos"));
        btnCurso.setText(language.getProperty("estadisticas.profesor.btn.curso"));
        btnCancelar.setText(language.getProperty("form.common.close"));
        lblFecha.setText(language.getProperty("estadisticas.form.fechaInicio"));
        lblSelCursos.setText(language.getProperty("estadisticas.form.selCursos"));
        opSelCursos.setText(language.getProperty("estadisticas.form.opFiltrarCursos"));
        this.setTitle(language.getProperty("estadisticas.form.estProfesor"));
        
        int prova=usuario.getId();
        opcionesCursos.add(opTodosCursos);
        opcionesCursos.add(opSelCursos);
        opTodosCursos.setSelected(true);
        
        
        
        //modelos para la jList
        modelo = new DefaultListModel();
        modelo2 = new DefaultListModel();

        //obtiene una lista con todos los cursos de un profesor
    try {    
        
        listaCurso = manager.consultarCursosProfesor(usuario.getLogin());
        cargarLista(listCursos, listaCurso);
        
        } catch (RemoteException e) {
            
            Logger.getLogger(PnlFiltroProfesor.class.getName()).log(Level.SEVERE, null, e);
            
        } catch (Exception e) {
            //Logger.getLogger(PnlFiltroProfesor.class.getName()).log(Level.SEVERE, null, e);
            Logger.getLogger(PnlFiltroProfesor.class.getName()).log(Level.SEVERE, null, "Error al cargar la lista");
        
        }
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opcionesMostrar = new javax.swing.ButtonGroup();
        opcionesCursos = new javax.swing.ButtonGroup();
        lblFecha = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        opTodosCursos = new javax.swing.JRadioButton();
        opSelCursos = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        lblSelCursos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCursos = new javax.swing.JList();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnCurso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblFecha.setText("Fecha de inicio:");

        opTodosCursos.setText("Todos los cursos");
        opTodosCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opTodosCursosActionPerformed(evt);
            }
        });

        opSelCursos.setText("Filtrar por curso");
        opSelCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opSelCursosActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblSelCursos.setText("Seleccionar curso/os");

        listCursos.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(listCursos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSelCursos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSelCursos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/users.png"))); // NOI18N
        btnAceptar.setText("Estadísticas alumnos");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/arrow-curve-180.png"))); // NOI18N
        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/books-stack.png"))); // NOI18N
        btnCurso.setText("Estadísticas curso/os");
        btnCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(opTodosCursos)
                            .addComponent(opSelCursos))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCurso))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFecha)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(opTodosCursos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(opSelCursos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCurso)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(27, 27, 27))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opTodosCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opTodosCursosActionPerformed
        // TODO add your handling code here:

        
        if(opSelCursos.isSelected()){

            listCursos.setModel(modelo);
            listCursos.setBackground(new java.awt.Color(255, 255, 255));
        }
        else {listCursos.setModel(modelo2);
            listCursos.setBackground(new java.awt.Color(204, 204, 204));
        }
    }//GEN-LAST:event_opTodosCursosActionPerformed

    private void opSelCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opSelCursosActionPerformed
        // TODO add your handling code here:

        if(opTodosCursos.isSelected()){
            listCursos.setModel(modelo2);
            listCursos.setBackground(new java.awt.Color(204, 204, 204));
        }
        else {listCursos.setModel(modelo);
            listCursos.setBackground(new java.awt.Color(255, 255, 255));

        }
    }//GEN-LAST:event_opSelCursosActionPerformed

    
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:

        llamarAcciones(0);

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursoActionPerformed
        // TODO add your handling code here:
        
        llamarAcciones(1);
        
    }//GEN-LAST:event_btnCursoActionPerformed

        /*
     * Carga la lista que se le envía por parámetro en el combo del parámetro
     */
    
    
    private void llamarAcciones(int opcion){
        
        
        ArrayList<Curso> listaCursoSel = null;
        Curso curso;
        //PnlListadoAlumno pn = new PnlListadoAlumno(, true);
       
        Object s[];

        //Cargar a una ArrayList los cursos seleccionados
        try{
            if(opSelCursos.isSelected()){
                if(listCursos.getSelectedValue()==null){

                    JOptionPane.showMessageDialog(null,
                        language.getProperty("err.curso.noselect"),
                        language.getProperty("app.title"),
                        JOptionPane.WARNING_MESSAGE);
                    return;

                }
                else{
                    listaCursoSel = new ArrayList<Curso>();
                    s=listCursos.getSelectedValues();
                    for(int i =0 ; i< s.length; i++)
                    {
                        String prova=s[i].toString();

                        curso = new Curso();
                        curso.setNombre(prova);
                        listaCursoSel.add(curso);
                    }

                }
            }

            Date data = null;
            String txt = txtData.getText();
            if(txt.equals(""))
            {
                data=null;
            }
            else
            {

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                data = formato.parse(txt);
            }
         //manda todos los datos de filtrado a PnlListadoProfesor
            PnlListadoProfesor form = new PnlListadoProfesor(parent, true, manager, language, usuario ,data, listaCursoSel, opcion);
            form.setLocationRelativeTo(null);
            form.setVisible(true);

        }catch (ParseException ex) {
            JOptionPane.showMessageDialog(null,
                language.getProperty("err.formatoData"),
                language.getProperty("app.title"),
                JOptionPane.ERROR_MESSAGE);
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
    
    
    private void cargarLista(JList listas, ArrayList lista) {
        //mota la lisa a partir de una ArrayList
        String item;
        for (Object obj : lista) {
            if (obj instanceof Curso) {
                item = ((Curso) obj).getNombre();
                modelo.addElement(item);
            } 
        }
    }
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCurso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblSelCursos;
    private javax.swing.JList listCursos;
    private javax.swing.JRadioButton opSelCursos;
    private javax.swing.JRadioButton opTodosCursos;
    private javax.swing.ButtonGroup opcionesCursos;
    private javax.swing.ButtonGroup opcionesMostrar;
    private javax.swing.JTextField txtData;
    // End of variables declaration//GEN-END:variables
}
