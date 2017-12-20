/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysPantallaAuxiliares;

import OdontoSysModelo.Diente;
import OdontoSysModelo.Odontograma;
import OdontoSysModelo.Servicio;
import OdontoSysModelo.Tratamiento;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author Tito
 */
public class InsertarTratamiento extends javax.swing.JDialog {

    private static Tratamiento elTratamiento = null;
    public static Diente elDiente = null;
    public static Servicio elServicio = null;
    public static Odontograma elOdontograma=null;
    
    public InsertarTratamiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doClose(elTratamiento);
            }
        });
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public Tratamiento getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jButtonBuscarDiente = new javax.swing.JButton();
        labelBuscarDiente = new java.awt.Label();
        jTextFieldDiente = new javax.swing.JTextField();
        jButtonBuscarServicio = new javax.swing.JButton();
        jTextFieldServicio = new javax.swing.JTextField();
        labelBuscarDiente1 = new java.awt.Label();
        label1 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaEspecificacion = new javax.swing.JTextArea();
        labelNomenclaturaDiente = new java.awt.Label();
        labelPrecioServicio = new java.awt.Label();

        setTitle("Registrar Tratamiento");
        setPreferredSize(new java.awt.Dimension(550, 320));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/ingresar.png"))); // NOI18N
        okButton.setText("Aceptar");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/eliminar.png"))); // NOI18N
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jButtonBuscarDiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/buscar.png"))); // NOI18N
        jButtonBuscarDiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarDienteActionPerformed(evt);
            }
        });

        labelBuscarDiente.setAlignment(java.awt.Label.RIGHT);
        labelBuscarDiente.setBackground(new java.awt.Color(239, 239, 239));
        labelBuscarDiente.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        labelBuscarDiente.setText("Diente");

        jTextFieldDiente.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jButtonBuscarServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/buscar.png"))); // NOI18N
        jButtonBuscarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarServicioActionPerformed(evt);
            }
        });

        jTextFieldServicio.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        labelBuscarDiente1.setAlignment(java.awt.Label.RIGHT);
        labelBuscarDiente1.setBackground(new java.awt.Color(239, 239, 239));
        labelBuscarDiente1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        labelBuscarDiente1.setText("Servicio");

        label1.setAlignment(java.awt.Label.RIGHT);
        label1.setBackground(new java.awt.Color(239, 239, 239));
        label1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        label1.setText("Especificación");

        jTextAreaEspecificacion.setColumns(20);
        jTextAreaEspecificacion.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTextAreaEspecificacion.setRows(5);
        jScrollPane1.setViewportView(jTextAreaEspecificacion);

        labelNomenclaturaDiente.setAlignment(java.awt.Label.RIGHT);
        labelNomenclaturaDiente.setBackground(new java.awt.Color(239, 239, 239));
        labelNomenclaturaDiente.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        labelNomenclaturaDiente.setText("Nomenclatura");

        labelPrecioServicio.setAlignment(java.awt.Label.RIGHT);
        labelPrecioServicio.setBackground(new java.awt.Color(239, 239, 239));
        labelPrecioServicio.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        labelPrecioServicio.setText("Precio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addGap(262, 262, 262)
                        .addComponent(okButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBuscarDiente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelBuscarDiente1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldDiente, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNomenclaturaDiente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelPrecioServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonBuscarDiente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonBuscarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBuscarDiente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDiente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNomenclaturaDiente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBuscarDiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPrecioServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonBuscarDiente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonBuscarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);
        jTextFieldDiente.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if(elDiente!=null && elServicio!=null){
            String especificacion = jTextAreaEspecificacion.getText().trim();
            
            elTratamiento = new Tratamiento();
            elTratamiento.setDiente(elDiente);
            elTratamiento.setServicio(elServicio);
            elTratamiento.setOdontograma(null);
            elTratamiento.setEspecificacion(especificacion);
            
            doClose(elTratamiento);
        }else if(elDiente!=null && elServicio!=null){
            
            String especificacion = jTextAreaEspecificacion.getText().trim();
                        
            elTratamiento = new Tratamiento();
            elTratamiento.setDiente(elDiente);
            elTratamiento.setServicio(elServicio);
            elTratamiento.setEspecificacion(especificacion);
            
            doClose(elTratamiento);
        
        }else{
            System.out.println("mensage de datos incompletos");
            doClose(elTratamiento);
        }       
        
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(null);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(elTratamiento);
    }//GEN-LAST:event_closeDialog

    private void jButtonBuscarDienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarDienteActionPerformed
        // TODO add your handling code here:
        BuscarDiente fmrBuscarDiente = new BuscarDiente(null, true);
        fmrBuscarDiente.setVisible(true);
        elDiente = null;
        elDiente = fmrBuscarDiente.getReturnStatus();
        
        if(elDiente != null){
            jTextFieldDiente.setText(elDiente.getNombre());
            labelNomenclaturaDiente.setText(labelNomenclaturaDiente.getText()+" "+elDiente.getNomenclatura());
        }
        
    }//GEN-LAST:event_jButtonBuscarDienteActionPerformed

    private void jButtonBuscarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarServicioActionPerformed
        // TODO add your handling code here:
        BuscarServicio fmrBuscadorServicio = new BuscarServicio(null, true);
        fmrBuscadorServicio.setVisible(true);
        elServicio = null;
        elServicio = fmrBuscadorServicio.getReturnStatus();
        
        if(elServicio != null){
            jTextFieldServicio.setText(elServicio.getDescripcion());
            labelPrecioServicio.setText("Precio: "+formateador.format(elServicio.getPrecio()));
        }
    }//GEN-LAST:event_jButtonBuscarServicioActionPerformed
    
    private void doClose(Tratamiento retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InsertarTratamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertarTratamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertarTratamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertarTratamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                InsertarTratamiento dialog = new InsertarTratamiento(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    //Variables
    DecimalFormat formateador = new DecimalFormat("###,###");
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton jButtonBuscarDiente;
    private javax.swing.JButton jButtonBuscarServicio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaEspecificacion;
    private javax.swing.JTextField jTextFieldDiente;
    private javax.swing.JTextField jTextFieldServicio;
    private java.awt.Label label1;
    private java.awt.Label labelBuscarDiente;
    private java.awt.Label labelBuscarDiente1;
    private java.awt.Label labelNomenclaturaDiente;
    private java.awt.Label labelPrecioServicio;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

    private Tratamiento returnStatus = null;
}
