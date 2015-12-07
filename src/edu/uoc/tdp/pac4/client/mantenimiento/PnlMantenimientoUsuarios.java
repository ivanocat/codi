package edu.uoc.tdp.pac4.client.mantenimiento;

import edu.uoc.tdp.pac4.beans.Usuario;
import edu.uoc.tdp.pac4.remote.Mantenimiento;
import edu.uoc.tdp.pac4.util.LanguageUtils;
import edu.uoc.tdp.pac4.exceptions.NoRolesException;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JavaBeginers
 */
public class PnlMantenimientoUsuarios extends javax.swing.JDialog 
{
    private Mantenimiento      manager;
    private LanguageUtils      language;
    private ArrayList<Usuario> usuarios;

    private java.util.HashMap RolesDesc;
    private java.util.HashMap RolesID             = new java.util.HashMap();
    private java.util.HashMap VariableDescriptors = new java.util.HashMap();
    
    private boolean dofilter   = false;
    
    private Usuario activeUser;
    
   
    /**
     * Creates new form PnlGroupGestor
     */
    public PnlMantenimientoUsuarios(java.awt.Frame parent, boolean modal, Mantenimiento manager, LanguageUtils language, Usuario activeUser) {
        super(parent, modal);
            
        this.language       = language;
        this.activeUser     = activeUser;
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
        cbxType = new javax.swing.JComboBox();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        fldname = new javax.swing.JTextField();
        lblname = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        fldsurname = new javax.swing.JTextField();
        lblsurname = new javax.swing.JLabel();
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

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user--plus.png"))); // NOI18N
        btnAdd.setText("Nuevo");
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user--pencil.png"))); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.setFocusable(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user--minus.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.setFocusable(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblname.setText("Nombre");

        lblRol.setText("Tipologia");

        lblsurname.setText("Apellidos");

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

        btnExplore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user--exclamation.png"))); // NOI18N
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
                        .addGap(20, 20, 20)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cmdClose))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxType, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblname)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fldname, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblsurname, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fldsurname, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(btnDelete)
                        .addComponent(btnExplore)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblname)
                    .addComponent(lblRol)
                    .addComponent(fldsurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblsurname))
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
       
       this.setTitle(language.getProperty("mantenimiento.main.title") + ". " + 
                     language.getProperty("mantenimiento.main.user"));
       
       this.initComboBox();
       this.setLabelsLanguage();

       this.fldname.setText("");
       this.fldsurname.setText("");
   }
   
   private void initComboBox() {
        /*
         * Intentamos capturar los posibles roles definidos por la base de datos para añadirlos
         * al combobox. Si no se puede, no podremos abrir este panel, pues algo pasa con la connexión
         * a la DB o al rmi.
         */
        try {
            this.RolesDesc = manager.getRolesByDesc();
            
            java.util.Set roles = this.RolesDesc.entrySet();

            String[] possibleRoles = new String[roles.size()+1];
            possibleRoles[0] = language.getProperty("rol.all");
            java.util.Iterator iter  = roles.iterator();
            while (iter.hasNext()) {
                java.util.Map.Entry role = (java.util.Map.Entry)iter.next();
                Integer rolID = new Integer(role.getValue().toString());
                RolesID.put(role.getValue(), role.getKey());
                VariableDescriptors.put(language.getProperty(role.getKey().toString()),
                                        role.getKey().toString());
                possibleRoles[rolID] = language.getProperty(role.getKey().toString());
            }
            cbxType.setModel(new javax.swing.DefaultComboBoxModel(possibleRoles));
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                                          language.getProperty("err.sql") + "\n" + language.getProperty("err.detail") + ":\n\n" + ex.getMessage(), 
                                          language.getProperty("app.title"), 
                                          JOptionPane.ERROR_MESSAGE);
         this.dispose();
        }
        catch (NoRolesException ex) {
            JOptionPane.showMessageDialog(null, 
                                          language.getProperty("err.sql") + "\n" + language.getProperty("mantenimiento.err.norole") + ":\n\n" + ex.getMessage(), 
                                          language.getProperty("app.title"), 
                                          JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception ex) {
         JOptionPane.showMessageDialog(null, 
                                       language.getProperty("err.rmi") + "\n" + language.getProperty("err.detail") + ":\n\n" + ex.getMessage(), 
                                       language.getProperty("app.title"), 
                                       JOptionPane.ERROR_MESSAGE);
         this.dispose();
        }
    }
    
    private void setLabelsLanguage() {
        this.btnAdd.setText         (language.getProperty("mantenimiento.usermain.newUser"));
        this.btnEdit.setText        (language.getProperty("mantenimiento.usermain.modUser"));
        this.btnDelete.setText      (language.getProperty("mantenimiento.usermain.delUser"));
        this.btnExplore.setText     (language.getProperty("mantenimiento.usermain.explore"));
        this.cmdClose.setText       (language.getProperty("mantenimiento.usermain.back"));
        this.lblRol.setText         (language.getProperty("mantenimiento.usermain.tipo"));
        this.lblname.setText        (language.getProperty("mantenimiento.usermain.name"));
        this.lblsurname.setText     (language.getProperty("mantenimiento.usermain.surname"));
        this.cmdFilter.setText      (language.getProperty("mantenimiento.usermain.dofilter"));
        this.cmdClearFilter.setText (language.getProperty("mantenimiento.usermain.clearfilter"));
    }
   
   private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       
           PnlMantenimientoUsuarioGestor form = new PnlMantenimientoUsuarioGestor(null, true ,manager, language, "Add", 0);
           form.setLocationRelativeTo(null);
           form.setVisible(true);


       listData();
   }//GEN-LAST:event_btnAddActionPerformed

   private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

      if (tblData.getSelectedRow() < 0)
      {
         JOptionPane.showMessageDialog(null,
                                       language.getProperty("mantenimiento.msg.sele.usuario"),
                                       language.getProperty("app.title"),
                                       JOptionPane.WARNING_MESSAGE);
         return;
      }

      // Obtiene el ID del grupo a editar
      Usuario usuario = usuarios.get(tblData.getSelectedRow());

      PnlMantenimientoUsuarioGestor form = new PnlMantenimientoUsuarioGestor(null, true, manager, language, "Edit", usuario.getId());
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
                                       language.getProperty("mantenimiento.msg.sele.usuario"),
                                       language.getProperty("app.title"),
                                       JOptionPane.WARNING_MESSAGE);
         return;
      }
      
      Usuario usuario = usuarios.get(tblData.getSelectedRow());
      
      if (usuario.getId() == this.activeUser.getId()) {
          JOptionPane.showMessageDialog(null,
                                       language.getProperty("mantenimiento.err.deown"),
                                       language.getProperty("app.title"),
                                       JOptionPane.WARNING_MESSAGE);
         return;
      }
      
      Object[] options = {language.getProperty("opt.si"), language.getProperty("opt.no")};
      int reply = JOptionPane.showOptionDialog(this, language.getProperty("mantenimientomsg.dele.usuario"), 
                                               language.getProperty("app.title"), JOptionPane.YES_NO_OPTION, 
                                               JOptionPane.QUESTION_MESSAGE, null, options, usuario);
      if (reply == 0) {
        try {
            int grupos_profesor = manager.checkGruposUsuario(usuario.getId());
            if (grupos_profesor == 0) {
                if (manager.deleteUsuario(usuario.getId())) {
                    manager.liberarMatriculasUsuario(usuario.getId());
                }
            }
            else {
                JOptionPane.showMessageDialog(null,
                                              language.getProperty("mantenimiento.err.link.usuario"),
                                              language.getProperty("app.title"),
                                              JOptionPane.WARNING_MESSAGE);
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
                                          language.getProperty("err.generic") + "\n" + language.getProperty("err.detail") + ":\n\n" + ex.getMessage(), 
                                          language.getProperty("app.title"), 
                                          JOptionPane.ERROR_MESSAGE);
      }
      
      listData();
      }
   }//GEN-LAST:event_btnDeleteActionPerformed

    private void cmdFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdFilterActionPerformed
        // TODO add your handling code here:
        if (!this.cbxType.getSelectedItem().toString().equals(language.getProperty("rol.all")) ||
            !this.fldname.getText().equals("") || !this.fldsurname.getText().equals("")) {
            this.dofilter = true;
            listData();
        }
    }//GEN-LAST:event_cmdFilterActionPerformed

    private void cmdClearFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdClearFilterActionPerformed
        // TODO add your handling code here:
        this.cbxType.setSelectedIndex(0);
        this.fldname.setText("");
        this.fldsurname.setText("");
        this.dofilter = false;
        listData();
    }//GEN-LAST:event_cmdClearFilterActionPerformed

    private void btnExploreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExploreActionPerformed
        // TODO add your handling code here:
        if (tblData.getSelectedRow() < 0)
      {
         JOptionPane.showMessageDialog(null,
                                       language.getProperty("mantenimiento.msg.sele.usuario"),
                                       language.getProperty("app.title"),
                                       JOptionPane.WARNING_MESSAGE);
         return;
      }

      // Obtiene el ID del grupo a editar
      Usuario usuario = usuarios.get(tblData.getSelectedRow());

      PnlMantenimientoUsuarioGestor form = new PnlMantenimientoUsuarioGestor(null, true, manager, language, "Explore", usuario.getId());
      form.setLocationRelativeTo(null);
      form.setVisible(true);
    }//GEN-LAST:event_btnExploreActionPerformed

   
   /**
    * Rellena la tabla de usuarios.
    */
    private void listFullUsersData() throws SQLException, RemoteException, Exception {
        ArrayList<String> header = new ArrayList<String>();   // cabecera
      
        header.add(language.getProperty("mantenimiento.usermain.login"));
        header.add(language.getProperty("mantenimiento.usermain.DNI"));
        header.add(language.getProperty("mantenimiento.usermain.name"));
        header.add(language.getProperty("mantenimiento.usermain.surname"));
        header.add(language.getProperty("mantenimiento.usermain.tipo"));
        
        String[][] gridData;
        
        usuarios = manager.getUsuarios();
        gridData = new String[usuarios.size()][5];
        
        int i = 0;
        for (Usuario usuario : usuarios) {
            gridData[i][0] = usuario.getLogin();
            gridData[i][1] = usuario.getNif();
            gridData[i][2] = usuario.getNombre();
            gridData[i][3] = usuario.getApellidos();
            gridData[i][4] = language.getProperty(this.RolesID.get(usuario.getIdRol()).toString());
            i++;
        }
        
        this.tblData.setModel(new javax.swing.table.DefaultTableModel(gridData, header.toArray())
            {@Override public boolean isCellEditable(int row, int column)
                { return false; } 
            });
    }
    
    private void listFilteredUsersData() throws SQLException, RemoteException, Exception {
        ArrayList<String> header = new ArrayList<String>();   // cabecera
      
        header.add(language.getProperty("mantenimiento.usermain.login"));
        header.add(language.getProperty("mantenimiento.usermain.DNI"));
        header.add(language.getProperty("mantenimiento.usermain.name"));
        header.add(language.getProperty("mantenimiento.usermain.surname"));
        header.add(language.getProperty("mantenimiento.usermain.tipo"));
      
        String[][] gridData;
        
        String rolDescriptor = "";
        if (!this.cbxType.getSelectedItem().toString().equals(language.getProperty("rol.all"))) {
            System.err.print(VariableDescriptors.get(this.cbxType.getSelectedItem().toString()).toString());
            usuarios = manager.getUsuariosByRolDesc(VariableDescriptors.get(this.cbxType.getSelectedItem().toString()).toString());
        }
        else {
            usuarios = manager.getUsuarios();
        }
        gridData = new String[usuarios.size()][5];
        
        int i = 0;
        for (Usuario usuario : usuarios) {
            System.err.print(this.fldsurname.getText() + "\n");
            System.err.print(usuario.getPrimerApellido() + "\n");
            if ((this.fldname.getText().equals("")    || this.fldname.getText().equalsIgnoreCase(usuario.getNombre())) &&
                (this.fldsurname.getText().equals("") || this.fldsurname.getText().equalsIgnoreCase(usuario.getPrimerApellido())
                                                      || this.fldsurname.getText().equalsIgnoreCase(usuario.getSegundoApellido()))) {
                gridData[i][0] = usuario.getLogin();
                gridData[i][1] = usuario.getNif();
                gridData[i][2] = usuario.getNombre();
                gridData[i][3] = usuario.getApellidos();
                gridData[i][4] = language.getProperty(this.RolesID.get(usuario.getIdRol()).toString());
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
              this.listFullUsersData();
          }
          else {
              this.listFilteredUsersData();
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
    private javax.swing.JComboBox cbxType;
    private javax.swing.JButton cmdClearFilter;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdFilter;
    private javax.swing.JTextField fldname;
    private javax.swing.JTextField fldsurname;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblsurname;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables
}
