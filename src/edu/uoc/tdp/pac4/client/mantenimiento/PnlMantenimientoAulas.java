package edu.uoc.tdp.pac4.client.mantenimiento;

import edu.uoc.tdp.pac4.client.gestion.*;
import edu.uoc.tdp.pac4.beans.Aula;
import edu.uoc.tdp.pac4.exceptions.GroupNotEmptyException;
import edu.uoc.tdp.pac4.remote.Mantenimiento;
import edu.uoc.tdp.pac4.util.LanguageUtils;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author eSupport Netbeans
 */
public class PnlMantenimientoAulas extends javax.swing.JDialog 
{
    private Mantenimiento manager;
    private LanguageUtils language;
    private ArrayList<Aula> aulas;
    
    private boolean dofilter = false;
    
   
    /**
     * Creates new form PnlGroupGestor
     */
    public PnlMantenimientoAulas(java.awt.Frame parent, boolean modal, Mantenimiento manager, LanguageUtils language) {
        super(parent, modal);
            
        this.language       = language;
        this.manager        = manager;
        
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
        fldcapacity = new javax.swing.JTextField();
        lblcapacity = new javax.swing.JLabel();
        cmdFilter = new javax.swing.JButton();
        cmdClearFilter = new javax.swing.JButton();
        btnExplore = new javax.swing.JButton();

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

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sofa--plus.png"))); // NOI18N
        btnAdd.setText("Nuevo");
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sofa--pencil.png"))); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.setFocusable(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sofa--minus.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.setFocusable(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblcapacity.setText("Capacidad Mínima");

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

        btnExplore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sofa--exclamation.png"))); // NOI18N
        btnExplore.setText("Explorar");
        btnExplore.setFocusable(false);
        btnExplore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExplore.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExplore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExploreActionPerformed(evt);
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
                        .addGap(18, 18, 18)
                        .addComponent(btnExplore)
                        .addGap(95, 95, 95)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmdClose, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblcapacity)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fldcapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                        .addComponent(btnDelete))
                    .addComponent(btnExplore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fldcapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcapacity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdFilter)
                    .addComponent(cmdClearFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdClose)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


   
   private void addaptToPreferences() {
       
       this.setTitle(language.getProperty("mantenimiento.main.title") + ". " + 
                     language.getProperty("mantenimiento.main.aula"));
       
       this.setLabelsLanguage();

       this.fldcapacity.setText("");
   }
       
    private void setLabelsLanguage() {
        this.btnAdd.setText         (language.getProperty("mantenimiento.usermain.newUser"));
        this.btnEdit.setText        (language.getProperty("mantenimiento.usermain.modUser"));
        this.btnDelete.setText      (language.getProperty("mantenimiento.usermain.delUser"));
        this.cmdClose.setText       (language.getProperty("mantenimiento.usermain.back"));
        this.lblcapacity.setText    (language.getProperty("mantenimiento.aulasmain.mincapacidad"));
        this.cmdFilter.setText      (language.getProperty("mantenimiento.usermain.dofilter"));
        this.cmdClearFilter.setText (language.getProperty("mantenimiento.usermain.clearfilter"));
        this.btnExplore.setText     (language.getProperty("mantenimiento.usermain.explore"));
    }
   
   private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       
           PnlMantenimientoAulaGestor form = new PnlMantenimientoAulaGestor(null, true ,manager, language, "Add", 0);
           form.setLocationRelativeTo(null);
           form.setVisible(true);

       listData();
   }//GEN-LAST:event_btnAddActionPerformed

   private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

      if (tblData.getSelectedRow() < 0)
      {
         JOptionPane.showMessageDialog(null,
                                       language.getProperty("mantenimiento.msg.sele.aula"),
                                       language.getProperty("app.title"),
                                       JOptionPane.WARNING_MESSAGE);
         return;
      }

      // Obtiene el ID del grupo a editar
      Aula aula = aulas.get(tblData.getSelectedRow());

      PnlMantenimientoAulaGestor form = new PnlMantenimientoAulaGestor(null, true, manager, language, "Edit", aula.getId());
      form.setLocationRelativeTo(null);
      form.setVisible(true);

      listData();

   }//GEN-LAST:event_btnEditActionPerformed

   private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed

      // Cierra el formulario
      this.dispose();

   }//GEN-LAST:event_cmdCloseActionPerformed

   private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
      
      if (tblData.getSelectedRow() < 0)
      {
         JOptionPane.showMessageDialog(null,
                                       language.getProperty("mantenimiento.msg.sele.aula"),
                                       language.getProperty("app.title"),
                                       JOptionPane.WARNING_MESSAGE);
         return;
      }
      
      Aula aula = aulas.get(tblData.getSelectedRow());
      
      
      
      Object[] options = {language.getProperty("opt.si"), language.getProperty("opt.no")};
      int reply = JOptionPane.showOptionDialog(this, language.getProperty("mantenimientomsg.dele.aula"),
                                               language.getProperty("app.title"), JOptionPane.YES_NO_OPTION, 
                                               JOptionPane.QUESTION_MESSAGE, null, options, aula);
      if (reply == 0) {
      try {
          int grupos_aula = manager.checkGruposAula(aula.getId());
          if (grupos_aula == 0) {
            if (manager.deleteAula(aula.getId())) {
                manager.liberarRecursosAula(aula.getId());
            }
          }
          else {
              JOptionPane.showMessageDialog(null, 
                                          language.getProperty("mantenimiento.err.link.aula"), 
                                          language.getProperty("app.title"), 
                                          JOptionPane.ERROR_MESSAGE);
          }
      }
      catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                                          language.getProperty("err.sql") + "\n" + language.getProperty("err.detail") + ":\n\n" + ex.getMessage(), 
                                          language.getProperty("app.title"), 
                                          JOptionPane.ERROR_MESSAGE);
      }
      catch (Exception ex) {
            JOptionPane.showMessageDialog(null, 
                                          language.getProperty("err.rmi") + "\n" + language.getProperty("err.detail") + ":\n\n" + ex.getMessage(), 
                                          language.getProperty("app.title"), 
                                          JOptionPane.ERROR_MESSAGE);
      }
      
      listData();
      }
   }//GEN-LAST:event_btnDeleteActionPerformed

    private void cmdFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdFilterActionPerformed
        
        if (!this.fldcapacity.getText().equals("")) {
            this.dofilter = true;
            listData();
        }
    }//GEN-LAST:event_cmdFilterActionPerformed

    private void cmdClearFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdClearFilterActionPerformed
        // TODO add your handling code here:
        this.fldcapacity.setText("");
        this.dofilter = false;
        listData();
    }//GEN-LAST:event_cmdClearFilterActionPerformed

    private void btnExploreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExploreActionPerformed
        // TODO add your handling code here:
      if (tblData.getSelectedRow() < 0)
      {
         JOptionPane.showMessageDialog(null,
                                       language.getProperty("mantenimiento.msg.sele.aula"),
                                       language.getProperty("app.title"),
                                       JOptionPane.WARNING_MESSAGE);
         return;
      }

      // Obtiene el ID del grupo a editar
      Aula aula = aulas.get(tblData.getSelectedRow());

      PnlMantenimientoAulaGestor form = new PnlMantenimientoAulaGestor(null, true, manager, language, "Explore", aula.getId());
      form.setLocationRelativeTo(null);
      form.setVisible(true);
    }//GEN-LAST:event_btnExploreActionPerformed

   
   /**
    * Rellena la tabla de usuarios.
    */
    private void listFullAulasData() throws SQLException, RemoteException, Exception {
        ArrayList<String> header = new ArrayList<String>();   // cabecera
      
        header.add(language.getProperty("mantenimiento.usermain.name"));
        header.add(language.getProperty("mantenimiento.aulasmain.capacidad"));
        header.add(language.getProperty("mantenimiento.aulasmain.localizacion"));

        
        String[][] gridData;
        
        aulas = manager.getAulas();
        
        gridData = new String[aulas.size()][3];
        
        int i = 0;
        for (Aula aula : aulas) {
            gridData[i][0] = aula.getNombre();
            gridData[i][1] = "" + aula.getCapacidad();
            gridData[i][2] = aula.getLocalizacion();
            i++;
        }
        
        this.tblData.setModel(new javax.swing.table.DefaultTableModel(gridData, header.toArray())
            {@Override public boolean isCellEditable(int row, int column)
                { return false; } 
            });
    }
    
    private void listFilteredAulasData() throws SQLException, RemoteException, Exception {
        ArrayList<String> header = new ArrayList<String>();   // cabecera
      
        header.add(language.getProperty("mantenimiento.usermain.name"));
        header.add(language.getProperty("mantenimiento.aulasmain.capacidad"));
        header.add(language.getProperty("mantenimiento.aulasmain.localizacion"));
      
        String[][] gridData;
        
        aulas = manager.getAulas();
        
        gridData = new String[aulas.size()][3];
        
        int i = 0;
        for (Aula aula : aulas) {
            if (new Integer(this.fldcapacity.getText()) <= aula.getCapacidad()) {
                gridData[i][0] = aula.getNombre();
                gridData[i][1] = "" + aula.getCapacidad();
                gridData[i][2] = aula.getLocalizacion();
                i++;
            }
        }
        
        this.tblData.setModel(new javax.swing.table.DefaultTableModel(gridData, header.toArray())
            {@Override public boolean isCellEditable(int row, int column)
                { return false; } 
            });
    }
    
   private void listData()
   {
      try {
          if (!this.dofilter) {
              this.listFullAulasData();
          }
          else {
              this.listFilteredAulasData();
          }
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
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExplore;
    private javax.swing.JButton cmdClearFilter;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdFilter;
    private javax.swing.JTextField fldcapacity;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblcapacity;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables
}
