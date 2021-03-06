package edu.uoc.tdp.pac4.client.mantenimiento;

import edu.uoc.tdp.pac4.beans.Usuario;
import edu.uoc.tdp.pac4.remote.Mantenimiento;
import edu.uoc.tdp.pac4.util.LanguageUtils;
import edu.uoc.tdp.pac4.util.FieldLimit;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author eSupport Netbeans
 */
public class PnlMantenimientoUsuarioGestor extends javax.swing.JDialog 
{
    private Mantenimiento manager;
    private LanguageUtils language;

    private String ActionType;
    private Boolean reactivate = false;
    private java.util.HashMap RolesDesc;
    private java.util.HashMap doubleDescription = new java.util.HashMap();
   
    private Date now                    = new Date();
    private Usuario user                = null;
    private ArrayList<Usuario> oldusers = null;
    SimpleDateFormat df                 = new SimpleDateFormat("dd/MM/yyyy");
    private int userID;
   
    private String ALUMNO_CODE = "rol.alumno";
    private int LOGIN_LENGTH   = 20;
    private int NAME_LENGTH    = 30;
    private int NIF_LENGTH     = 9;
    private int TELF_LENGTH    = 9;
    private int MAIL_LENGTH    = 30;
    private int SURN_LENGTH    = 29;
    
   
    /**
      * Creates new form PnlGroupGestor
      */
    public PnlMantenimientoUsuarioGestor(java.awt.Frame parent, boolean modal, Mantenimiento manager, LanguageUtils language, String ActionType, int userID) 
    {
        super(parent, modal);
        initComponents();
      
        setLocationRelativeTo(null);

        this.manager    = manager;
        this.language   = language;
        this.ActionType = ActionType;
        this.userID     = userID;
      
        addaptToPreferences();

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
        fldLogin = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        lblPwd = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblDNI = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblSn1 = new javax.swing.JLabel();
        lblSn2 = new javax.swing.JLabel();
        lblTlf = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        fldPwd = new javax.swing.JTextField();
        fldDate = new javax.swing.JTextField();
        fldDNI = new javax.swing.JTextField();
        fldName = new javax.swing.JTextField();
        fldSn1 = new javax.swing.JTextField();
        fldSn2 = new javax.swing.JTextField();
        fldTlf = new javax.swing.JTextField();
        fldMail = new javax.swing.JTextField();
        cbxType = new javax.swing.JComboBox();
        cmdAccept = new javax.swing.JButton();
        cmdNIFsearch = new javax.swing.JButton();
        cmdNIFclear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setRollover(true);

        cmdClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/arrow-curve-180.png"))); // NOI18N
        cmdClose.setText("Cerrar");
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        lblLogin.setText("login");

        lblPwd.setText("contraseña");

        lblDate.setText("fecha alta");

        lblDNI.setText("DNI");

        lblName.setText("nombre");

        lblSn1.setText("1º Apellido");

        lblSn2.setText("2º Apellido");

        lblTlf.setText("telefono");

        lblMail.setText("e-mail");

        lblType.setText("tipologia");

        cmdAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ok_st_obj.gif"))); // NOI18N
        cmdAccept.setText("Acceptar");
        cmdAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAcceptActionPerformed(evt);
            }
        });

        cmdNIFsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh_002_16.gif"))); // NOI18N
        cmdNIFsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNIFsearchActionPerformed(evt);
            }
        });

        cmdNIFclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/eraser.png"))); // NOI18N
        cmdNIFclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNIFclearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogin)
                            .addComponent(lblDate)
                            .addComponent(lblPwd)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDNI)
                                .addGap(18, 18, 18)
                                .addComponent(cmdNIFsearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdNIFclear))
                            .addComponent(lblName)
                            .addComponent(lblSn1)
                            .addComponent(lblSn2)
                            .addComponent(lblTlf)
                            .addComponent(lblMail)
                            .addComponent(lblType))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fldLogin)
                            .addComponent(fldPwd)
                            .addComponent(fldDate)
                            .addComponent(fldDNI)
                            .addComponent(fldName)
                            .addComponent(fldSn1)
                            .addComponent(fldSn2)
                            .addComponent(fldTlf)
                            .addComponent(fldMail)
                            .addComponent(cbxType, 0, 166, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(100, Short.MAX_VALUE)
                        .addComponent(cmdAccept)
                        .addGap(45, 45, 45)
                        .addComponent(cmdClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPwd)
                    .addComponent(fldPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(fldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDNI)
                                .addComponent(fldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmdNIFclear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(fldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSn1)
                            .addComponent(fldSn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSn2)
                            .addComponent(fldSn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTlf)
                            .addComponent(fldTlf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMail)
                            .addComponent(fldMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblType)
                            .addComponent(cbxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdClose)
                            .addComponent(cmdAccept)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdNIFsearch)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   /**
    * Genera el {@link javax.swing.JComboBox} que permite escoger entre los distintos roles disponibles.
    * Captura los roles directamente desde la base de datos. Si no pudiera significa que algo no está
    * bien en las conexiones. Si es así emite eror y cierra el dialogo
    */
    private void initComboBox() {
        /*
         * Intentamos capturar los posibles roles definidos por la base de datos para añadirlos
         * al combobox. Si no se puede, no podremos abrir este panel, pues algo pasa con la connexión
         * a la DB o al rmi.
         */
        try {
            this.RolesDesc      = manager.getRolesByDesc();
            java.util.Set roles = this.RolesDesc.entrySet(); //Creamos diccionario de roles

            String[] possibleRoles  = new String[roles.size()];
            java.util.Iterator iter = roles.iterator();
            
            while (iter.hasNext()) {
                java.util.Map.Entry role = (java.util.Map.Entry)iter.next();
                
                doubleDescription.put(language.getProperty(role.getKey().toString()),
                                        role.getKey().toString());
                
                Integer rolID            = new Integer(role.getValue().toString());
                possibleRoles[rolID -1] = language.getProperty(role.getKey().toString());
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
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, 
                                          language.getProperty("err.rmi") + "\n" + language.getProperty("err.detail") + ":\n\n" + ex.getMessage(), 
                                          language.getProperty("app.title"), 
                                          JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }
   
    private boolean allDataFilled() {
        /*
         * Tanto para añadir  un usuario deberemos tener toda la información.
         * Para modificarlo, toda excepto el password, que es opcional
         * Esta función se encarga de asegurarse de que así sea.
         */
        if (fldLogin.getText().isEmpty() || fldLogin.getText().equals("")) {return false;}
        if (fldDNI.getText().isEmpty()   || fldDNI.getText().equals(""))   {return false;}
        if (fldName.getText().isEmpty()  || fldName.getText().equals(""))  {return false;}
        if (fldSn1.getText().isEmpty()   || fldSn1.getText().equals(""))   {return false;}
        if (fldSn2.getText().isEmpty()   || fldSn2.getText().equals(""))   {return false;}
        
        if (this.ActionType.equalsIgnoreCase("Add") && !this.reactivate) {
            if (fldPwd.getText().isEmpty() || fldPwd.getText().equals("")) {return false;}
        }
        
        return true;
    }
    private void setLabelsLanguage() {
        /*
         * Definimos el texto de las labels del panel en función del idioma seleccionado
         */
        lblLogin.setText(language.getProperty("mantenimiento.usermain.login"));
        lblPwd.setText  (language.getProperty("mantenimiento.usermain.pswd"));
        lblDate.setText (language.getProperty("mantenimiento.usermain.date"));
        lblDNI.setText  (language.getProperty("mantenimiento.usermain.DNI"));
        lblName.setText (language.getProperty("mantenimiento.usermain.name"));
        lblSn1.setText  (language.getProperty("mantenimiento.usermain.surname1"));
        lblSn2.setText  (language.getProperty("mantenimiento.usermain.surname2"));
        lblTlf.setText  (language.getProperty("mantenimiento.usermain.telf"));
        lblMail.setText ("e-mail");
        lblType.setText (language.getProperty("mantenimiento.usermain.tipo"));
       
        if (this.ActionType.equalsIgnoreCase("Add")) {
            this.cmdAccept.setText(language.getProperty("mantenimiento.usermain.newUser"));
        }
        else if (this.ActionType.equalsIgnoreCase("Edit")){
            this.cmdAccept.setText(language.getProperty("mantenimiento.usermain.modUser"));
        }
        this.cmdClose.setText(language.getProperty("mantenimiento.usermain.back"));
    }
   
    private void addaptToPreferences() {
        /*
         * El mismo panel se usa para añadir/modificar usuarios, hay que adaptar ciertas características
         * en función de qué se solicite
         */
        this.initComboBox();
        this.setLabelsLanguage();
       
        // Set longitud campos
        this.fldLogin.setDocument(new FieldLimit(LOGIN_LENGTH));
        this.fldDNI.setDocument  (new FieldLimit(NIF_LENGTH));
        this.fldName.setDocument (new FieldLimit(NAME_LENGTH));
        this.fldSn1.setDocument  (new FieldLimit(SURN_LENGTH));
        this.fldSn2.setDocument  (new FieldLimit(SURN_LENGTH));
        this.fldTlf.setDocument  (new FieldLimit(TELF_LENGTH));
        this.fldMail.setDocument (new FieldLimit(MAIL_LENGTH));
        
        
        // Cambios Vinculados al tipo de llamada
        if (this.ActionType.equalsIgnoreCase("Add")) {
            this.addaptToAddUser();
        } else if (this.ActionType.equalsIgnoreCase("Edit")) {
            this.addaptToEditUser();
        } else if (this.ActionType.equalsIgnoreCase("Explore")) {
            this.addaptToExploreUser();
        }
        
    }
   
    private void addaptToAddUser(){
        
        this.setTitle(language.getProperty("mantenimiento.main.title") + ". " + 
                      language.getProperty("mantenimiento.main.user")   + ". " +
                      language.getProperty("mantenimiento.usermain.newUser"));
       
       /*
        * Cuando vamos a añadir un nuevo usuario los parametros (excepto Fecha de Registro)
        * se inicializan en blanco
        * 
        * El usuario de creación por defecto es Alumno, que debería ser el más abundante
        */
       fldLogin.setText    ("");
       fldPwd.setText      ("");
       fldDate.setText     (df.format(this.now));
       fldDate.setEditable (false);
       fldDNI.setText      ("");
       fldName.setText     ("");
       fldSn1.setText      ("");
       fldSn2.setText      ("");
       fldTlf.setText      ("");
       fldMail.setText     ("");
            
       cbxType.setSelectedIndex(new Integer(this.RolesDesc.get(this.ALUMNO_CODE).toString()) - 1);
            
       this.cmdAccept.setText(language.getProperty("mantenimiento.usermain.newUser"));
       
       try {
            this.oldusers = manager.getUsuariosInactivos();
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
    }
   
    private void addaptToEditUser(){
        
        this.setTitle(language.getProperty("mantenimiento.main.title") + ". " + 
                      language.getProperty("mantenimiento.main.user")   + ". " +
                      language.getProperty("mantenimiento.usermain.modUser"));
       
       /*
        * Cuando vamos a modificar un usuario, inicializamos los formularios con los valores
        * que tiene el usuario
        */
        try {
            this.user = manager.getUsuario(this.userID);
            // NO mostramos el password
            this.user.setPwd("");
            
            fldLogin.setText    (user.getLogin());
            fldPwd.setText      (user.getPwd());
            fldDate.setText     (df.format(user.getFechaAlta()));
            fldDate.setEditable (false);
            fldDNI.setText      (user.getNif());
            fldName.setText     (user.getNombre());
            fldSn1.setText      (user.getPrimerApellido());
            fldSn2.setText      (user.getSegundoApellido());
            fldTlf.setText      (user.getTelf());
            fldMail.setText     (user.getEmail());
            
            cbxType.setSelectedIndex(user.getIdRol() - 1);
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
           
        this.cmdAccept.setText(language.getProperty("mantenimiento.usermain.modUser")); 
        
        this.cmdNIFsearch.setVisible(false);
        this.cmdNIFclear.setVisible(false);
    }
    
    private void addaptToExploreUser() {
        this.addaptToEditUser();
        fldLogin.setEditable(false);
        fldPwd.setEditable  (false);
        fldDate.setEditable (false);
        fldDNI.setEditable  (false);
        fldName.setEditable (false);
        fldSn1.setEditable  (false);
        fldSn2.setEditable  (false);
        fldTlf.setEditable  (false);
        fldTlf.setEditable  (false);
        this.cmdAccept.setVisible(false);
    }
   
   private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed

    /*
     * Cerramos el formulario
     */
    this.dispose();

   }//GEN-LAST:event_cmdCloseActionPerformed

    private void cmdAddUserAction() {
        /*
         * Gestión de Añadir Nuevo Usuario
         * Creamos una instancia Usuario con toda la info recibida y luego la pasamos al manager
         * para que la incluya en la BD
         * 
         * Si añadimos correctamente se cierra el panel
         */
        try {
            if (this.reactivate) {

                JOptionPane.showMessageDialog(null, language.getProperty("mantenimiento.msg.add.olduse"),
                                              language.getProperty("app.title"), JOptionPane.INFORMATION_MESSAGE);
                manager.undeleteUsuario(this.userID);
                return;
            }

            Usuario usuario = new Usuario();
            
            usuario.setLogin     (this.fldLogin.getText());
            usuario.setPwd       (this.fldPwd.getText());
            usuario.setFechaAlta (this.now);
            usuario.setNif       (this.fldDNI.getText());
            usuario.setNombre    (this.fldName.getText());
            usuario.setApellidos (this.fldSn1.getText(), this.fldSn2.getText());
            usuario.setTelf      (this.fldTlf.getText());
            usuario.setEmail     (this.fldMail.getText());
            usuario.setIdRol     (new Integer(this.RolesDesc.get(this.doubleDescription.get(this.cbxType.getSelectedItem().toString()).toString()).toString()));
            
            Boolean reallyNotUpdate = true;
            for (Usuario oldusuario : this.oldusers) {
                if (oldusuario.getNif().equalsIgnoreCase(usuario.getNif())) {
                    reallyNotUpdate = false;
                    break;
                }
            }
            if (!reallyNotUpdate) {
                this.cmdNIFsearchActionPerformed(null);
                JOptionPane.showMessageDialog(null, language.getProperty("mantenimiento.ask.add.olduser"),
                                              language.getProperty("app.title"), JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
                    
            if (manager.addUsuario(usuario)) {
                JOptionPane.showMessageDialog(null, language.getProperty("mantenimiento.msg.add.user"),
                                              language.getProperty("app.title"), JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
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
    }
    
    private void cmdModUserAction() {
        /*
         * Gestión de odificar Usuario
         * Creamos una instancia Usuario con toda la info recibida y luego la pasamos al manager
         * para que la actualize la BD (no se accede al UserID)
         * 
         * Para la modificacion solicitaremos confirmación
         * 
         * Si modificamos correctamente se cierra el panel
         */
        try {
            
            Usuario usuario = new Usuario();
            
            usuario.setId        (this.userID);
            usuario.setLogin     (this.fldLogin.getText());
            usuario.setPwd       (this.fldPwd.getText());
            usuario.setFechaAlta (this.user.getFechaAlta());
            usuario.setNif       (this.fldDNI.getText());
            usuario.setNombre    (this.fldName.getText());
            usuario.setApellidos (this.fldSn1.getText(), this.fldSn2.getText());
            usuario.setTelf      (this.fldTlf.getText());
            usuario.setEmail     (this.fldMail.getText());
            usuario.setIdRol     (new Integer(this.RolesDesc.get(this.doubleDescription.get(this.cbxType.getSelectedItem().toString()).toString()).toString()));
            
            usuario.setActivo    (this.user.isActivo());
            
            if (this.user.getFechaInactividad() != null) {
                usuario.setFechaInactividad (this.user.getFechaInactividad());
            }
            else {
                usuario.setFechaInactividad (this.user.getFechaAlta());
            }
            
            
            Object[] options = {language.getProperty("opt.si"), language.getProperty("opt.no")};//NOi18
            int reply = JOptionPane.showOptionDialog(this, language.getProperty("mantenimiento.msg.confirm"), 
                                                     language.getProperty("app.title"), JOptionPane.YES_NO_OPTION, 
                                                     JOptionPane.QUESTION_MESSAGE, null, options, now);
            if (reply == 0) {
                if (manager.updateUsuario(usuario)) {
                    JOptionPane.showMessageDialog(null, language.getProperty("mantenimiento.msg.modif"),
                                                  language.getProperty("app.title"), JOptionPane.INFORMATION_MESSAGE);
                }
            }
            this.dispose();
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
    }
    
    private void cmdAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAcceptActionPerformed
        /*
         * Las acciones sólo se llevaran a cabo si tenemos TODOS los campos llenos
         */
        if (!this.allDataFilled()) {
            JOptionPane.showMessageDialog(null, 
                                          language.getProperty("mantenimiento.err.fields"), 
                                          language.getProperty("app.title"), 
                                          JOptionPane.ERROR_MESSAGE);
        } else {
            if (this.ActionType.equalsIgnoreCase("Add")) {
                this.cmdAddUserAction();
            }
            else if (this.ActionType.equalsIgnoreCase("Edit")) {
                this.cmdModUserAction();
            }
        }
    }//GEN-LAST:event_cmdAcceptActionPerformed

    private void cmdNIFsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNIFsearchActionPerformed
        // TODO add your handling code here:
        if (!this.fldDNI.getText().equals("")) {
            for (Usuario usuario : this.oldusers) {
                if (usuario.getNif().equalsIgnoreCase(this.fldDNI.getText())) {
                    fldLogin.setText    (usuario.getLogin());
                    fldLogin.setEditable(false);
                    fldPwd.setText      ("");
                    fldPwd.setEditable  (false);
                    fldDate.setText     (df.format(usuario.getFechaAlta()));
                    fldDate.setEditable (false);
                    fldDNI.setText      (usuario.getNif());
                    fldDNI.setEditable  (false);
                    fldName.setText     (usuario.getNombre());
                    fldName.setEditable (false);
                    fldSn1.setText      (usuario.getPrimerApellido());
                    fldSn1.setEditable  (false);
                    fldSn2.setText      (usuario.getSegundoApellido());
                    fldSn2.setEditable  (false);
                    fldTlf.setText      (usuario.getTelf());
                    fldTlf.setEditable  (false);
                    fldMail.setText     (usuario.getEmail());
                    fldTlf.setEditable  (false);
            
                    cbxType.setSelectedIndex(usuario.getIdRol() - 1);
                    
                    this.userID = usuario.getId();
                    
                    this.reactivate = true;
                    break;
                }
            }
        }
    }//GEN-LAST:event_cmdNIFsearchActionPerformed

    private void cmdNIFclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNIFclearActionPerformed
       
       fldLogin.setText    ("");
       fldLogin.setEditable(true);
       fldPwd.setText      ("");
       fldPwd.setEditable  (true);
       fldDate.setText     (df.format(this.now));
       fldDate.setEditable (false);
       fldDNI.setText      ("");
       fldDNI.setEditable  (true);
       fldName.setText     ("");
       fldName.setEditable (true);
       fldSn1.setText      ("");
       fldSn1.setEditable  (true);
       fldSn2.setText      ("");
       fldSn2.setEditable  (true);
       fldTlf.setText      ("");
       fldTlf.setEditable  (true);
       fldMail.setText     ("");
       fldTlf.setEditable  (true);
            
       cbxType.setSelectedIndex(new Integer(this.RolesDesc.get(this.ALUMNO_CODE).toString()) - 1);
       
       this.userID = 0;
       this.reactivate = false;
        
    }//GEN-LAST:event_cmdNIFclearActionPerformed
   
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxType;
    private javax.swing.JButton cmdAccept;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdNIFclear;
    private javax.swing.JButton cmdNIFsearch;
    private javax.swing.JTextField fldDNI;
    private javax.swing.JTextField fldDate;
    private javax.swing.JTextField fldLogin;
    private javax.swing.JTextField fldMail;
    private javax.swing.JTextField fldName;
    private javax.swing.JTextField fldPwd;
    private javax.swing.JTextField fldSn1;
    private javax.swing.JTextField fldSn2;
    private javax.swing.JTextField fldTlf;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPwd;
    private javax.swing.JLabel lblSn1;
    private javax.swing.JLabel lblSn2;
    private javax.swing.JLabel lblTlf;
    private javax.swing.JLabel lblType;
    // End of variables declaration//GEN-END:variables
}
