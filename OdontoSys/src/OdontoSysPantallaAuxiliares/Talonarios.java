/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysPantallaAuxiliares;

import OdontoSysControlador.TalonarioControlador;
import OdontoSysModelo.Talonario;
import static java.awt.image.ImageObserver.WIDTH;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Talonarios extends javax.swing.JFrame {

    /**
     * Variables
     */
    Talonario tal = null;
    ArrayList<Talonario> listaf = new ArrayList();
    
    public Talonarios() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldTal = new javax.swing.JTextField();
        jTextFieldCanF = new javax.swing.JTextField();
        jTextFieldNroI = new javax.swing.JTextField();
        jTextFieldTim = new javax.swing.JTextField();
        jButtonGua = new javax.swing.JButton();
        jButtonCan = new javax.swing.JButton();
        jDateFecI = new com.toedter.calendar.JDateChooser();
        jDateFecF = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(420, 520));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("Datos de Factura");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Cantidad de talonarios nuevos");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Número de factura inicial");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Timbrado");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Fecha inicio vigencia");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Fecha fin vigencia");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("Cantidad de facturas por talonario");

        jTextFieldTal.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTextFieldTal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTalActionPerformed(evt);
            }
        });
        jTextFieldTal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloNumerosKeyTyped(evt);
            }
        });

        jTextFieldCanF.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTextFieldCanF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCanFActionPerformed(evt);
            }
        });
        jTextFieldCanF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloNumerosKeyTyped(evt);
            }
        });

        jTextFieldNroI.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTextFieldNroI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNroIActionPerformed(evt);
            }
        });
        jTextFieldNroI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloNumerosKeyTyped(evt);
            }
        });

        jTextFieldTim.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTextFieldTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTimActionPerformed(evt);
            }
        });
        jTextFieldTim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloNumerosKeyTyped(evt);
            }
        });

        jButtonGua.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonGua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/guardar.png"))); // NOI18N
        jButtonGua.setText("Guardar");
        jButtonGua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuaActionPerformed(evt);
            }
        });

        jButtonCan.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonCan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/eliminar.png"))); // NOI18N
        jButtonCan.setText("Cancelar");
        jButtonCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jButtonCan)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonGua))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel8)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldTal, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                .addComponent(jTextFieldCanF, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                .addComponent(jTextFieldNroI, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                .addComponent(jTextFieldTim, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                .addComponent(jDateFecI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateFecF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCanF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNroI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTim, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateFecI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateFecF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTalActionPerformed

    private void jTextFieldCanFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCanFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCanFActionPerformed

    private void jTextFieldNroIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNroIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNroIActionPerformed

    private void jTextFieldTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTimActionPerformed

    private void soloNumerosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_soloNumerosKeyTyped
       char c = evt.getKeyChar();
        int i = c;
        if( (c < '0' || c > '9') && (i != 8 && i != 9 && i != 13) ){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Este campo sólo admite numeros", "Validez de Campo", WIDTH);
        }
    }//GEN-LAST:event_soloNumerosKeyTyped

    private void jButtonGuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuaActionPerformed
        boolean v = validar();
        if(v){
            calcular();
            v = TalonarioControlador.Guardar(listaf);
            if(v){
                JOptionPane.showMessageDialog(rootPane, "Guardado exitosamente", "", WIDTH);
            }else{
                JOptionPane.showMessageDialog(rootPane, "No se pudo guardar", "Talonario", WIDTH);
            }
        }
        limpiar();
        dispose();
    }//GEN-LAST:event_jButtonGuaActionPerformed

    private void jButtonCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCanActionPerformed
        limpiar();
        dispose();
    }//GEN-LAST:event_jButtonCanActionPerformed

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
            java.util.logging.Logger.getLogger(Talonarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Talonarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Talonarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Talonarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Talonarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCan;
    private javax.swing.JButton jButtonGua;
    private com.toedter.calendar.JDateChooser jDateFecF;
    private com.toedter.calendar.JDateChooser jDateFecI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextFieldCanF;
    private javax.swing.JTextField jTextFieldNroI;
    private javax.swing.JTextField jTextFieldTal;
    private javax.swing.JTextField jTextFieldTim;
    // End of variables declaration//GEN-END:variables

    private boolean validar() {
        
        boolean v = false;
        tal = new Talonario();
        tal.setTimbrado(parseInt(jTextFieldTim.getText()));
        tal.setIniVigencia(jDateFecI.getDate());
        tal.setFinVigencia(jDateFecF.getDate());
        int c = parseInt(jTextFieldTal.getText());
        
        if(c <= 0 || c > 50){
            JOptionPane.showMessageDialog(rootPane, "La cantidad de talonarios debe estar entre 1 y 50", "Talonario", WIDTH);
        }else{
            v = true;
        }
        return v;
    
    }
    
    private void limpiar(){
        jTextFieldCanF.setText("");
        jTextFieldNroI.setText("");
        jTextFieldTal.setText("");
        jTextFieldTim.setText("");
        jDateFecF.setDate(null);
        jDateFecI.setDate(null);
        tal = null;
    }

    private void calcular() {
    
         int canTal = parseInt(jTextFieldTal.getText());
         int nro = parseInt(jTextFieldNroI.getText());        //Número de factura inicial
         int canFac = parseInt(jTextFieldCanF.getText());
         int n = 0;
            
            for(int x=1; x<=canTal; x++){       //Desde 1 hasta cantidad de Talonarios
                for(int a=0; a<canFac; a++){   //Desde 1 hasta cantidad de Facturas de un talonario
                    Talonario t = new Talonario();
                    t.setTimbrado(parseInt(jTextFieldTim.getText()));
                    t.setIniVigencia(jDateFecI.getDate());
                    t.setFinVigencia(jDateFecF.getDate());
                    t.setEstado("Libre");
                    t.setNroTalonario(x);
                    t.setNroFactura("0"+nro);
                    nro++;
                    listaf.add(t);
                }
            }
    }
    
}
