/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uoc.tdp.pac4.client.estadisticas;

import edu.uoc.tdp.pac4.beans.Actividad;
import edu.uoc.tdp.pac4.beans.Grupo;
import edu.uoc.tdp.pac4.beans.Matricula;
import edu.uoc.tdp.pac4.beans.Usuario;
import edu.uoc.tdp.pac4.remote.Estadisticas;
import edu.uoc.tdp.pac4.remote.GestAcademica;
import edu.uoc.tdp.pac4.util.LanguageUtils;
import java.awt.Frame;
import java.rmi.RemoteException;
import java.util.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author eSupport Netbeans
 */
public class PnlListadoProfesor extends javax.swing.JDialog {

   private Estadisticas manager;
   private LanguageUtils language;
   private ArrayList<Actividad> actividades;
   private ArrayList<Matricula> matriculas;
   private Usuario usr;
   private Date data;
   private int opcion;
    /**
     * Creates new form PnlListadoProfesor
     */
    public PnlListadoProfesor(java.awt.Frame parent, boolean modal,Estadisticas manager, LanguageUtils language, Usuario usr, Date data, ArrayList<Actividad> actividades, int opcion) {
        super(parent, modal);
        initComponents();
        this.usr=usr;  
        this.manager = manager;
        this.language = language;
        this.opcion=opcion;
        this.data=data;
        this.actividades=actividades;
        //carga todos los textos
        btnExport.setText(language.getProperty("form.common.export"));
        btnCerrar.setText(language.getProperty("form.common.close"));
        lblFecha.setText(language.getProperty("estadisticas.form.fechaInicio"));
        if(data!=null){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        fechaLabel.setText(df.format(data));
      }
        
        
        listMatriculas(opcion);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFecha = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        grdTable = new javax.swing.JTable();
        btnExport = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        fechaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblFecha.setText("Fecha de inicio:");

        grdTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(grdTable);

        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/report.png"))); // NOI18N
        btnExport.setText("Exportar");

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/arrow-curve-180.png"))); // NOI18N
        btnCerrar.setText("Volver");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnExport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(fechaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExport)
                    .addComponent(btnCerrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

       /**
    * Rellena la tabla de grupos.
    */
   private void listMatriculas(int op)
   {
      
      // Rellena la tabla
      ArrayList<String> header2 = new ArrayList<String>();   // cabecera
      header2.add(language.getProperty("estadisticas.table.alumno.actividad"));
      header2.add(language.getProperty("estadisticas.table.alumno.fInicio"));
      header2.add(language.getProperty("estadisticas.table.alumno.fFinal"));
      if(op==0)header2.add(language.getProperty("estadisticas.table.profesor.nombreAlumno"));
      header2.add(language.getProperty("estadisticas.table.alumno.asisRequerida"));
      header2.add(language.getProperty("estadisticas.table.alumno.asisCumplida"));
      header2.add(language.getProperty("estadisticas.table.alumno.asistenciatotal"));
      header2.add(language.getProperty("estadisticas.table.alumno.status"));
      if(op==0)this.setTitle(language.getProperty("estadisticas.form.title.alumnos"));        
      else this.setTitle(language.getProperty("estadisticas.form.title.actividades"));
      String[][] gridData;
      List<String> row;

      try 
      {
         if(op==0){
          matriculas= manager.consultarAlumnosProfesor(usr.getId(), data,actividades);
            gridData = new String[matriculas.size()][8];
         }
         else{
         matriculas= manager.consultarEstCursProfesor(usr.getId(), data,actividades);
            gridData = new String[matriculas.size()][7];
         }
         
         int i = 0;
         float total;
         float stat;
         float cos=0;
         
         DecimalFormat formato = new DecimalFormat("0");
         SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

         
         for (Matricula matricula : matriculas)
         {
             cos=matricula.getAsis()+matricula.getNoAsis();
             total=matricula.getAsis()/cos;
             total=total*100;
             stat=total-matricula.getAsisRequerida();
             float diff = Math.abs(matricula.getFechaFinal().getTime() - matricula.getFechaInicio().getTime());
             diff = diff / 1000 / 86400;
             
            gridData[i][0] = matricula.getActividadNombre();
            gridData[i][1] = df.format(matricula.getFechaInicio()).toString();
            gridData[i][2] = df.format(matricula.getFechaFinal()).toString();
            
            if(op==0){
            gridData[i][3] = matricula.getUsuarioNombre();
            gridData[i][4] = matricula.getAsisRequerida() + "%";
            gridData[i][5] = formato.format(total) + "%";
            gridData[i][6] = formato.format(((float)matricula.getAsis()/diff)*100) + "%";
            gridData[i][7] = formato.format(stat) + "%";
            }
            else{
       
            gridData[i][3] = matricula.getAsisRequerida() + "%";
            gridData[i][4] = formato.format(total) + "%";
            gridData[i][5] = formato.format(((float)matricula.getAsis()/diff)*100) + "%";
            gridData[i][6] = formato.format(stat) + "%";
            }
            i++;
         }
         //hace que la tabla no se pueda editar
         grdTable.setModel(new DefaultTableModel(gridData, header2.toArray()){ 
                     @Override 
                     public boolean isCellEditable(int row, int column)
                    { return false; } 
                    });
      } 
      catch (SQLException ex)
      {
         JOptionPane.showMessageDialog(null, 
                                       language.getProperty("err.sql") + "\n" + language.getProperty("err.detail") + ":\n\n" + ex.getMessage(), 
                                       language.getProperty("app.title"), 
                                       JOptionPane.ERROR_MESSAGE);
         
      }
      catch (RemoteException ex)
      {
         JOptionPane.showMessageDialog(null, 
                                       language.getProperty("err.rmi") + "\n" + language.getProperty("err.detail") + ":\n\n" + ex.getMessage(), 
                                       language.getProperty("app.title"), 
                                       JOptionPane.ERROR_MESSAGE);

      }
      catch (Exception ex) 
      {
         JOptionPane.showMessageDialog(null, 
                                       language.getProperty("err.generic") + "\n" + language.getProperty("err.detail") + ":\n\n" + ex.getMessage(), 
                                       language.getProperty("app.title"), 
                                       JOptionPane.ERROR_MESSAGE);
  
      }
   }
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnExport;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JTable grdTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFecha;
    // End of variables declaration//GEN-END:variables
}
