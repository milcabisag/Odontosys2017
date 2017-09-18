/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysPantallaAuxiliares;

import OdontoSysModelo.Hallazgo;
import OdontoSysUtil.Configuraciones;
import OdontoSysVista.HallazgoVista;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tito
 */
public class BuscarHallazgo extends javax.swing.JDialog {

    private static Hallazgo elHallazgo = null;
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    
    /**
     * Creates new form BuscarHallazgo
     * @param parent desde dondde se llama este componente
     * @param modal si se puede tocar parent mientras esta ventana este activa.
     */
    public BuscarHallazgo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        cargarModelo( false, "" );
        initComponents();
        this.setLocationRelativeTo(null);
        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doClose(null);
            }
        });
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public Hallazgo getReturnStatus() {
        return elHallazgo;
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
        jLabel1 = new javax.swing.JLabel();
        nombreBuscado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHallazgos = new javax.swing.JTable();

        setTitle("BuscarHallazgo");
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

        jLabel1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel1.setText("Nombre Hallazgo:");

        nombreBuscado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreBuscadoActionPerformed(evt);
            }
        });
        nombreBuscado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mientrasBusca(evt);
            }
        });

        jTableHallazgos.setModel(modeloTabla);
        jScrollPane1.setViewportView(jTableHallazgos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nombreBuscado))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreBuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
      
        int fila = jTableHallazgos.getSelectedRow();
        
        if (fila > -1) {
            Integer id = Integer.parseInt((String)modeloTabla.getValueAt(fila, 0));
            String nombreHallazgo = (String)modeloTabla.getValueAt(fila, 1);            
            String simboloHallazgo = (String)modeloTabla.getValueAt(fila, 2);
            
            elHallazgo = new Hallazgo();           
            elHallazgo.setIdhallazgo(id);
            elHallazgo.setNombre(nombreHallazgo);
            elHallazgo.setSimbolol(simboloHallazgo);
            
            doClose(elHallazgo);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Seleccione un Hallazgo", "BuacarHallazgo", WIDTH);        
        }
               
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(null);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(null);
    }//GEN-LAST:event_closeDialog

    private void nombreBuscadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreBuscadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreBuscadoActionPerformed

    private void mientrasBusca(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mientrasBusca
        cargarModelo(true, nombreBuscado.getText());// TODO add your handling code here:
    }//GEN-LAST:event_mientrasBusca
    
    private void doClose(Hallazgo HallazgoSelected) {
        elHallazgo = HallazgoSelected;
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
            java.util.logging.Logger.getLogger(BuscarHallazgo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarHallazgo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarHallazgo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarHallazgo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                BuscarHallazgo dialog = new BuscarHallazgo(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableHallazgos;
    private javax.swing.JTextField nombreBuscado;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

    private void cargarModelo(boolean cargar, String nombre) {
        if(cargar){
        modeloTabla = Configuraciones.limpiarModelo(modeloTabla);
        ArrayList<Hallazgo> losHallazgos = HallazgoVista.BuscarPorNombre(nombre);
            for( Hallazgo hallazgo: losHallazgos ){
                String[] rowData = new String[3];
                rowData[0] = String.valueOf(hallazgo.getIdhallazgo());
                rowData[1] = hallazgo.getNombre();
                rowData[2] = hallazgo.getSimbolol();
                modeloTabla.addRow(rowData);
            }        
        }else{            
            modeloTabla.addColumn("IdHallazgo");
            modeloTabla.addColumn("NombreHallazgo");
            ArrayList<Hallazgo> losHallazgos = HallazgoVista.BuscarPorNombre(nombre);
            for( Hallazgo hallazgo: losHallazgos ){
                String[] rowData = new String[3];
                rowData[0] = String.valueOf(hallazgo.getIdhallazgo());
                rowData[1] = hallazgo.getNombre();
                modeloTabla.addRow(rowData);
            } 
        }
    }

    
}
