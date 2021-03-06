package edu.uoc.tdp.pac4.client.mantenimiento;

import edu.uoc.tdp.pac4.beans.Actividad;
import edu.uoc.tdp.pac4.remote.Mantenimiento;
import edu.uoc.tdp.pac4.util.LanguageUtils;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eSupport Netbeans
 */
public class PnlMantenimientoActividades extends javax.swing.JDialog {

    private Mantenimiento manager;
    private LanguageUtils language;
    private ArrayList<Actividad> actividades;

    private boolean dofilter = false;

    /**
     * Creates new form PnlGroupGestor
     */
    public PnlMantenimientoActividades(java.awt.Frame parent, boolean modal, Mantenimiento manager, LanguageUtils language) {

        super(parent, modal);
        this.language = language;
        this.manager = manager;

        initComponents();

        setLocationRelativeTo(null);

        addaptToPreferences();

        listData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        cmdClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        fldasistencia = new javax.swing.JTextField();
        lblassistencia = new javax.swing.JLabel();
        cmdFilter = new javax.swing.JButton();
        cmdClearFilter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setRollover(true);

        cmdClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/arrow-curve-180.png"))); // NOI18N
        cmdClose.setText("Cerrar");
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        tblData.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblData);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/projection-screen--plus.png"))); // NOI18N
        btnAdd.setText("Nuevo");
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/projection-screen--pencil.png"))); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.setFocusable(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/projection-screen--minus.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.setFocusable(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblassistencia.setText("Asistencia Mínima");

        cmdFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh_002_16.gif"))); // NOI18N
        cmdFilter.setText("Filtrar");
        cmdFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdFilterActionPerformed(evt);
            }
        });

        cmdClearFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/eraser.png"))); // NOI18N
        cmdClearFilter.setText("Limpiar Filtro");
        cmdClearFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdClearFilterActionPerformed(evt);
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
                        .addComponent(btnAdd)
                        .addGap(0, 0, 0)
                        .addComponent(btnEdit)
                        .addGap(0, 0, 0)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmdClose, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblassistencia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fldasistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdClearFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAdd)
                        .addComponent(btnEdit)
                        .addComponent(btnDelete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fldasistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblassistencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdFilter)
                    .addComponent(cmdClearFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addaptToPreferences() {

        this.setTitle(language.getProperty("mantenimiento.main.title") + ". "
                + language.getProperty("mantenimiento.main.curse"));

        this.setLabelsLanguage();

        this.fldasistencia.setText("");
    }

    private void setLabelsLanguage() {
        this.btnAdd.setText(language.getProperty("mantenimiento.usermain.newUser"));
        this.btnEdit.setText(language.getProperty("mantenimiento.usermain.modUser"));
        this.btnDelete.setText(language.getProperty("mantenimiento.usermain.delUser"));
        this.cmdClose.setText(language.getProperty("mantenimiento.usermain.back"));
        this.lblassistencia.setText(language.getProperty("mantenimiento.actividadesmain.minasistencia"));
        this.cmdFilter.setText(language.getProperty("mantenimiento.usermain.dofilter"));
        this.cmdClearFilter.setText(language.getProperty("mantenimiento.usermain.clearfilter"));
    }

   private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

       PnlMantenimientoActividadGestor form = new PnlMantenimientoActividadGestor(this, true, manager, language, "Add", 0);
       form.setLocationRelativeTo(null);
       form.setVisible(true);

       listData();
   }//GEN-LAST:event_btnAddActionPerformed

   private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

       if (tblData.getSelectedRow() < 0) {
           JOptionPane.showMessageDialog(null,
                   language.getProperty("mantenimiento.msg.sele.actividad"),
                   language.getProperty("app.title"),
                   JOptionPane.WARNING_MESSAGE);
           return;
       }

       // Obtiene el ID del grupo a editar
       Actividad actividad = actividades.get(tblData.getSelectedRow());

       PnlMantenimientoActividadGestor form = new PnlMantenimientoActividadGestor(null, true, manager, language, "Edit", actividad.getId());
       form.setLocationRelativeTo(null);
       form.setVisible(true);

       listData();

   }//GEN-LAST:event_btnEditActionPerformed

   private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed

       // Cierra el formulario
       this.dispose();

   }//GEN-LAST:event_cmdCloseActionPerformed

   private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

       if (tblData.getSelectedRow() < 0) {
           JOptionPane.showMessageDialog(null,
                   language.getProperty("mantenimiento.msg.sele.actividad"),
                   language.getProperty("app.title"),
                   JOptionPane.WARNING_MESSAGE);
           return;
       }

       Actividad actividad = actividades.get(tblData.getSelectedRow());

       Object[] options = {"Si", "No"};//NOi18
       int reply = JOptionPane.showOptionDialog(this, "quiere borrar actividad " + actividad.getTitol(), language.getProperty("app.title"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, actividad);
       if (reply == 0) {
           try {

               manager.deleteActividad(actividad.getId());

           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,
                       language.getProperty("err.sql") + "\n" + language.getProperty("err.detail") + ":\n\n" + ex.getMessage(),
                       language.getProperty("app.title"),
                       JOptionPane.ERROR_MESSAGE);
           } catch (Exception ex) {
               JOptionPane.showMessageDialog(null,
                       language.getProperty("err.generic") + "\n" + language.getProperty("err.detail") + ":\n\n" + ex.getMessage(),
                       language.getProperty("app.title"),
                       JOptionPane.ERROR_MESSAGE);
           }

           listData();
       }
   }//GEN-LAST:event_btnDeleteActionPerformed

    private void cmdFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdFilterActionPerformed
        // TODO add your handling code here:
        if (!this.fldasistencia.getText().equals("")) {
            this.dofilter = true;
            listData();
        }
    }//GEN-LAST:event_cmdFilterActionPerformed

    private void cmdClearFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdClearFilterActionPerformed
        // TODO add your handling code here:
        this.fldasistencia.setText("");
        this.dofilter = false;
        listData();
    }//GEN-LAST:event_cmdClearFilterActionPerformed

    /**
     * Rellena la tabla de usuarios.
     */
    private void listFullActividadesData() throws SQLException, RemoteException, Exception {
        ArrayList<String> header = new ArrayList<String>();   // cabecera

        header.add(language.getProperty("mantenimiento.usermain.universidad"));
        header.add(language.getProperty("mantenimiento.usermain.tipo"));
        header.add(language.getProperty("mantenimiento.usermain.name"));        
        header.add(language.getProperty("mantenimiento.actividad.cambios"));

        String[][] gridData;

        actividades = manager.getActividades();
        gridData = new String[actividades.size()][4];

        int i = 0;
        for (Actividad actividad : actividades) {
            gridData[i][0] = getDescUniversidad(Math.toIntExact(actividad.getUniversitatId()));
            gridData[i][1] = getDescTipus(actividad.getTipus());
            gridData[i][2] = actividad.getTitol();
            gridData[i][3] = "" + actividad.getMinimPercentatge();
            i++;
        }

        //Modificamos la tabla para que no sea editable
        this.tblData.setModel(new DefaultTableModel(gridData, header.toArray()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }

    private void listFilteredActividadesData() throws SQLException, RemoteException, Exception {
        ArrayList<String> header = new ArrayList<String>();   // cabecera

        header.add(language.getProperty("mantenimiento.usermain.universidad"));
        header.add(language.getProperty("mantenimiento.usermain.tipo"));
        header.add(language.getProperty("mantenimiento.usermain.name"));        
        header.add(language.getProperty("mantenimiento.actividad.cambios"));

        String[][] gridData;

        actividades = manager.getActividades();
        gridData = new String[actividades.size()][4];

        int i = 0;
        for (Actividad actividad : actividades) {
            if (new Integer(this.fldasistencia.getText()) <= actividad.getMinimPercentatge()) {
                gridData[i][0] = getDescUniversidad(Math.toIntExact(actividad.getUniversitatId()));
                gridData[i][1] = getDescTipus(actividad.getTipus());
                gridData[i][2] = actividad.getTitol();
                gridData[i][3] = "" + actividad.getMinimPercentatge();
                i++;
            }
        }

        this.tblData.setModel(new javax.swing.table.DefaultTableModel(gridData, header.toArray()));
    }
    
    private String getDescTipus(int tipusId) {
    
        switch (tipusId) {
            case Actividad.ACTIVIDAD_TIPO_CONGRESO_ID:
                return Actividad.getTipoActividadName(Actividad.ACTIVIDAD_TIPO_CONGRESO_ID, language);
            case Actividad.ACTIVIDAD_TIPO_JORNADA_ID:
                return Actividad.getTipoActividadName(Actividad.ACTIVIDAD_TIPO_JORNADA_ID, language);
            case Actividad.ACTIVIDAD_TIPO_MASTER_ID:
                return Actividad.getTipoActividadName(Actividad.ACTIVIDAD_TIPO_MASTER_ID, language);
            case Actividad.ACTIVIDAD_TIPO_CONFERENCIA_ID:
                return Actividad.getTipoActividadName(Actividad.ACTIVIDAD_TIPO_CONFERENCIA_ID, language);
            default:
                return "(-)";
        }
        
    }
    
    private String getDescUniversidad(int universidadId) {
        
        switch (universidadId) {
            case Actividad.ACTIVIDAD_UNIVERSIDAD_UOC_ID:
                return Actividad.getUniversidadName(Actividad.ACTIVIDAD_UNIVERSIDAD_UOC_ID, language);
            case Actividad.ACTIVIDAD_UNIVERSIDAD_UAB_ID:
                return Actividad.getUniversidadName(Actividad.ACTIVIDAD_UNIVERSIDAD_UAB_ID, language);
            case Actividad.ACTIVIDAD_UNIVERSIDAD_UPC_ID:
                return Actividad.getUniversidadName(Actividad.ACTIVIDAD_UNIVERSIDAD_UPC_ID, language);
            case Actividad.ACTIVIDAD_UNIVERSIDAD_UPF_ID:
                return Actividad.getUniversidadName(Actividad.ACTIVIDAD_UNIVERSIDAD_UPC_ID, language);
            default:
                return "(-)";
        }
        
    }

    private void listData() {
        try {
            if (!this.dofilter) {
                this.listFullActividadesData();
            } else {
                this.listFilteredActividadesData();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    language.getProperty("err.sql") + "\n" + language.getProperty("err.detail") + ":\n\n" + ex.getMessage(),
                    language.getProperty("app.title"),
                    JOptionPane.ERROR_MESSAGE);

            // Registra el error en un archivo de LOG
            // Logger.getLogger(FrmResourcesRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null,
                    language.getProperty("err.rmi") + "\n" + language.getProperty("err.detail") + ":\n\n" + ex.getMessage(),
                    language.getProperty("app.title"),
                    JOptionPane.ERROR_MESSAGE);

            // Registra el error en un archivo de LOG
            // Logger.getLogger(FrmResourcesRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    language.getProperty("err.generic") + "\n" + language.getProperty("err.detail") + ":\n\n" + ex.getMessage(),
                    language.getProperty("app.title"),
                    JOptionPane.ERROR_MESSAGE);

            // Registra el error en un archivo de LOG
            // Logger.getLogger(FrmResourcesRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton cmdClearFilter;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdFilter;
    private javax.swing.JTextField fldasistencia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblassistencia;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables
}
