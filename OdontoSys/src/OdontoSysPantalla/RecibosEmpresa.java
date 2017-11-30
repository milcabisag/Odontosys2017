/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysPantalla;

import OdontoSysControlador.FacturaControlador;
import OdontoSysControlador.NumberToLetterConverter;
import OdontoSysControlador.RecibosControlador;
import OdontoSysModelo.DetalleReciboemp;
import OdontoSysModelo.Empresa;
import OdontoSysModelo.FacturaEmpresa;
import OdontoSysModelo.MovimientoEmpresa;
import OdontoSysModelo.ReciboEmpresa;
import OdontoSysModelo.Usuario;
import OdontoSysPantallaAuxiliares.ObtenerEmpresa;
import OdontoSysPantallaAuxiliares.ObtenerFacEmpPendiente;
import OdontoSysUtil.NewHibernateUtil;
import OdontoSysVista.ReciboVista;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author user
 */
public class RecibosEmpresa extends javax.swing.JFrame {

    //Variables Globales
    ReciboEmpresa reciboActual = null;
    public static Empresa empActual = null;
    public static FacturaEmpresa facActual = null;
    ArrayList<DetalleReciboemp> detalle = new ArrayList();   //Guarda el detalle de las formas de pago del recibo actual
    public static Usuario user;
    int monto = 0;                  //Calcula la suma de los montos de las formas de pago
    int saldo = 0;
    
    DefaultTableModel tabla = new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {            
                return false;            
        }};
    DecimalFormat formateador = new DecimalFormat("###,###");
    
    
   
    public RecibosEmpresa() {
        initComponents();
        inicializarTabla();
        jButtonBorrarSeleccion1.setVisible(false);
        obtenerHoy();
        
        if(empActual != null){
            jTextFieldEmpresa.setText(empActual.getNombre());
            jButtonBuscarEmpresa.setVisible(false);
        }
        if(facActual != null){
            jTextFieldFactura.setText(facActual.getIdfacturaEmpresa().toString());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldEmpresa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldMontoLetras = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldFactura = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonBuscarEmpresa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFormPago = new javax.swing.JTable();
        jButtonFormaPago = new javax.swing.JButton();
        jLabelFecha = new javax.swing.JLabel();
        jButtonBorrarSeleccion1 = new javax.swing.JButton();
        jButtonBuscarFactura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("RECIBO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Fecha");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Recibimos de");

        jTextFieldEmpresa.setEditable(false);
        jTextFieldEmpresa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmpresaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("La suma de Guaraníes");

        jTextFieldMontoLetras.setEditable(false);
        jTextFieldMontoLetras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("En concepto de pago por Factura Nro");

        jTextFieldFactura.setEditable(false);
        jTextFieldFactura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Firma");

        jButtonGuardar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/guardar.png"))); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/eliminar.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonBuscarEmpresa.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonBuscarEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/buscar.png"))); // NOI18N
        jButtonBuscarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarEmpresaActionPerformed(evt);
            }
        });

        jScrollPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jScrollPane1FocusGained(evt);
            }
        });

        jTableFormPago.setModel(tabla);
        jTableFormPago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTableFormPagoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTableFormPagoFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFormPago);

        jButtonFormaPago.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonFormaPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/agregar.png"))); // NOI18N
        jButtonFormaPago.setText("Añadir Forma de Pago");
        jButtonFormaPago.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonFormaPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFormaPagoActionPerformed(evt);
            }
        });

        jLabelFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButtonBorrarSeleccion1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonBorrarSeleccion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/borrar.png"))); // NOI18N
        jButtonBorrarSeleccion1.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonBorrarSeleccion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarSeleccion1ActionPerformed(evt);
            }
        });

        jButtonBuscarFactura.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonBuscarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/buscar.png"))); // NOI18N
        jButtonBuscarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButtonGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(jButtonBuscarEmpresa))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jButtonFormaPago)
                                                .addComponent(jButtonBorrarSeleccion1)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1)
                                            .addComponent(jTextFieldMontoLetras, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(255, 255, 255)
                                            .addComponent(jTextFieldFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButtonBuscarFactura))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextFieldEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonBuscarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonBuscarFactura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldMontoLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonFormaPago)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonBorrarSeleccion1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCancelar)
                        .addComponent(jButtonGuardar)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmpresaActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
         Session sesion;
         sesion = NewHibernateUtil.getSessionFactory().openSession();
         Transaction tx = sesion.beginTransaction();
         sesion.getTransaction().begin();          
         
        reciboActual = new ReciboEmpresa();
        reciboActual.setFecha(new Date());
        reciboActual.setMonto(monto);
        reciboActual.setEmpresa(empActual);
        reciboActual.setFacturaEmpresa(facActual);
        reciboActual.setUsuario(user);
        MovimientoEmpresa mov = null;
        detalle = ReciboVista.validarReciboEmpresa(reciboActual, detalle);
        if(detalle != null){            //registro insertado correctamente  
            reciboActual = RecibosControlador.InsertarReciboEmpresa(reciboActual, sesion);
            if(reciboActual.getFacturaEmpresa().getTipo().compareTo("Contado") != 0){
                mov = new MovimientoEmpresa();
                mov = RecibosControlador.insertarMovimientoEmpresa(reciboActual, sesion);
            }
            for(DetalleReciboemp d : detalle){
                d.setReciboEmpresa(reciboActual);
                RecibosControlador.InsertarDetalleEmpresa(d, mov, user, sesion);
            }
            JOptionPane.showMessageDialog(rootPane, "Registro insertado correctamente", "Insertar Recibo", WIDTH);
            facActual.setSaldo(facActual.getSaldo() - reciboActual.getMonto());
            FacturaControlador.ModificarSaldoEmpresa(facActual, sesion);
            facActual = null;
            empActual = null;
            user = null;
            this.setVisible(false);
        }else{            //no insertado
            JOptionPane.showMessageDialog(rootPane, "No se pudo Insertar Recibo", "Insertar Recibo", WIDTH);      
        }
        
        //tx.commit();
        sesion.getTransaction().commit();            
        sesion.close();
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonBuscarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarEmpresaActionPerformed
        ObtenerEmpresa jDialog = new ObtenerEmpresa(null, true); 
        jDialog.setVisible(true);
        empActual = jDialog.getReturnStatus();
                if(empActual != null){
                    jTextFieldEmpresa.setText(empActual.getNombre());
                }
               
    }//GEN-LAST:event_jButtonBuscarEmpresaActionPerformed

    private void jButtonFormaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFormaPagoActionPerformed
        Object[] fila = new Object[2];        
        fila[0] = JOptionPane.showInputDialog(null, "Seleccione una forma de pago", "Forma de Pago", JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Efectivo", "Tarjeta Crédito", "Tarjeta Débito", "Cheque"}, 0);
        boolean bandera;
        do{
           try{
                fila[1] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese monto pagado", "Monto", JOptionPane.QUESTION_MESSAGE));
                bandera = true;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Sólo se permiten números" , "Monto" , JOptionPane.QUESTION_MESSAGE );
                bandera = false;
            }
        }while(!bandera);
        
        
        if(fila[0] != null && fila[1] != null){
            tabla.addRow(fila);
            jTableFormPago.setValueAt(formateador.format(fila[1]), tabla.getRowCount()-1, 1);
            DetalleReciboemp d = new DetalleReciboemp();
            d.setFormaPago(fila[0].toString());
            d.setMonto(Integer.parseInt(fila[1].toString()));
            d.setIddetalleReciboEmp(null);
            d.setReciboEmpresa(null);
            detalle.add(d);
            monto = Integer.parseInt(fila[1].toString())+ monto;
            jTextFieldMontoLetras.setText(NumberToLetterConverter.convertNumberToLetter(monto));
        }
    }//GEN-LAST:event_jButtonFormaPagoActionPerformed

    private void jButtonBorrarSeleccion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarSeleccion1ActionPerformed
        int f = jTableFormPago.getSelectedRow();
        int mont = Integer.parseInt(jTableFormPago.getValueAt(f, 1).toString().replace(".", ""));
        monto = monto - mont;
        jTextFieldMontoLetras.setText(NumberToLetterConverter.convertNumberToLetter(monto));
        tabla.removeRow(f);
        detalle.remove(f);
        jButtonBorrarSeleccion1.setVisible(false);
    }//GEN-LAST:event_jButtonBorrarSeleccion1ActionPerformed

    private void jScrollPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jScrollPane1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1FocusGained

    private void jTableFormPagoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableFormPagoFocusGained
        int fila = jTableFormPago.rowAtPoint(evt.getComponent().getLocation());
         if (fila > -1){        //El foco tiene una fila
             jButtonBorrarSeleccion1.setVisible(true);
         }else{
             jButtonBorrarSeleccion1.setVisible(false);
         }
    }//GEN-LAST:event_jTableFormPagoFocusGained

    private void jTableFormPagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableFormPagoFocusLost
        jButtonBorrarSeleccion1.setVisible(false);
    }//GEN-LAST:event_jTableFormPagoFocusLost

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        jButtonBorrarSeleccion1.setVisible(false);
    }//GEN-LAST:event_formMouseClicked

    private void jButtonBuscarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarFacturaActionPerformed
        ObtenerFacEmpPendiente.emp = empActual;
        ObtenerFacEmpPendiente jDialog = new ObtenerFacEmpPendiente(null, true);
        jDialog.setVisible(true);
        facActual = new FacturaEmpresa();
        facActual = jDialog.getReturnStatus();
                if(facActual != null){
                   jTextFieldFactura.setText("001-001-00"+facActual.getTalonario().getNroFactura());
                   saldo = facActual.getSaldo();
                }
    }//GEN-LAST:event_jButtonBuscarFacturaActionPerformed

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
            java.util.logging.Logger.getLogger(RecibosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecibosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecibosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecibosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecibosEmpresa().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBorrarSeleccion1;
    private javax.swing.JButton jButtonBuscarEmpresa;
    private javax.swing.JButton jButtonBuscarFactura;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonFormaPago;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFormPago;
    private javax.swing.JTextField jTextFieldEmpresa;
    private javax.swing.JTextField jTextFieldFactura;
    private javax.swing.JTextField jTextFieldMontoLetras;
    // End of variables declaration//GEN-END:variables

    private void inicializarTabla() {
        tabla.addColumn("Forma de Pago");
        tabla.addColumn("Monto");
        
    }

    private void obtenerHoy() {
        Date fecha = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String fec = f.format(fecha);
        jLabelFecha.setText(fec);
    }
    
    
}
