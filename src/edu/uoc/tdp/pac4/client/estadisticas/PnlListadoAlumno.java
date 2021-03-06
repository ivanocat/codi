/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uoc.tdp.pac4.client.estadisticas;

import edu.uoc.tdp.pac4.beans.Grupo;
import edu.uoc.tdp.pac4.beans.Matricula;
import edu.uoc.tdp.pac4.beans.Usuario;
import edu.uoc.tdp.pac4.remote.Estadisticas;
import edu.uoc.tdp.pac4.remote.GestAcademica;
import edu.uoc.tdp.pac4.util.LanguageUtils;
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
public class PnlListadoAlumno extends javax.swing.JDialog {

   private Estadisticas manager;
   private LanguageUtils language;
   private List<Matricula> matriculas;
   private Usuario usr;
   private int op;
   private Date data;
    /**
     * Creates new form PnlListadoAlumno
     */
    public PnlListadoAlumno(java.awt.Frame parent, boolean modal,Estadisticas manager, LanguageUtils language, Usuario usr, int opcio, Date data) {
      
      super(parent, modal);
      initComponents();
      
      this.usr=usr;  
      this.manager = manager;
      this.language = language;
      this.op=opcio;
      this.data=data;
      //cargar textos tabla 
      btnExport.setText(language.getProperty("form.common.export"));
      btnCerrar.setText(language.getProperty("form.common.close"));
      lblFecha.setText(language.getProperty("estadisticas.form.fechaInicio"));
      this.setTitle(language.getProperty("estadisticas.form.estAlumno"));                
      
      //si en el campro de data tiene texto hace un parse de data
      if(data!=null){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        fechaLabel.setText(df.format(data));
      }
      listMatriculas();
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnExport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(fechaLabel))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnExport))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    private void listMatriculas()
   {
      
      // Rellena la tabla
      ArrayList<String> header = new ArrayList<String>();   // cabecera
      header.add(language.getProperty("estadisticas.table.alumno.actividad"));
      header.add(language.getProperty("estadisticas.table.alumno.fInicio"));
      header.add(language.getProperty("estadisticas.table.alumno.fFinal"));
      header.add(language.getProperty("estadisticas.table.alumno.asisRequerida"));
      header.add(language.getProperty("estadisticas.table.alumno.asisCumplida"));
      header.add(language.getProperty("estadisticas.table.alumno.asistenciatotal"));
      header.add(language.getProperty("estadisticas.table.alumno.status"));
      
      String[][] gridData;
      List<String> row;

      try 
      {
         matriculas= manager.consultarActividadesAlumno(usr.getId(), op, data);
         gridData = new String[matriculas.size()][7];
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
             //float totalActividad = ((float)matricula.getAsis()/diff)*100;
        
            gridData[i][0] = matricula.getActividadNombre();
            gridData[i][1] = df.format(matricula.getFechaInicio()).toString();
            gridData[i][2] = df.format(matricula.getFechaFinal()).toString();
            gridData[i][3] = matricula.getAsisRequerida() + "%";
            gridData[i][4] = formato.format(total) + "%";
            gridData[i][5] = formato.format(((float)matricula.getAsis()/diff)*100) + "%";
            gridData[i][6] = formato.format(stat) + "%";
            i++;
         }
         //Modificamos la tabla para que no sea editable
         grdTable.setModel(new DefaultTableModel(gridData, header.toArray()){ 
                     @Override public boolean isCellEditable(int row, int column)
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnExport;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JTable grdTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFecha;
    // End of variables declaration//GEN-END:variables
}
