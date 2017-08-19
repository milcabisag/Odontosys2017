/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysPantalla;

import OdontoSysControlador.NotaControlador;
import OdontoSysModelo.DetalleNotaEmp;
import OdontoSysModelo.Empresa;
import OdontoSysModelo.FacturaEmpresa;
import OdontoSysModelo.NotaCreditoEmpresa;
import OdontoSysModelo.Usuario;
import OdontoSysPantallaAuxiliares.ObtenerEmpresa;
import OdontoSysPantallaAuxiliares.ObtenerFacturasEmpresa;
import OdontoSysUtil.Configuraciones;
import OdontoSysUtil.NewHibernateUtil;
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
public class NotasCreditosEmpresa extends javax.swing.JFrame {

    /**
     * Creates new form NotasCreditos
     */
    public NotasCreditosEmpresa() {
        initComponents();
        inicializarTodo();
        if(empActual != null){
            jTextFieldEmpresa.setText(empActual.getNombre());
            jButtonBuscarFactura.setVisible(true);
        }else{
            jButtonBuscarFactura.setVisible(false);
            
        }
        jButtonBorrarSeleccion.setVisible(false);
        
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
        jTextFieldEmpresa = new javax.swing.JTextField();
        jButtonBuscarEmpresa = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldFactura = new javax.swing.JTextField();
        jButtonBuscarFactura = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDescripcion = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldIVA = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jButtonInsertarMotivo = new javax.swing.JButton();
        jButtonBorrarSeleccion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("Nota de Crédito");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Empresa");

        jTextFieldEmpresa.setEditable(false);

        jButtonBuscarEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/buscar.png"))); // NOI18N
        jButtonBuscarEmpresa.setMargin(new java.awt.Insets(2, 7, 2, 7));
        jButtonBuscarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarEmpresaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Fecha");

        jLabelFecha.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Modificando a Factura N°");

        jTextFieldFactura.setEditable(false);

        jButtonBuscarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/buscar.png"))); // NOI18N
        jButtonBuscarFactura.setMargin(new java.awt.Insets(2, 7, 2, 7));
        jButtonBuscarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarFacturaActionPerformed(evt);
            }
        });

        jTableDescripcion.setModel(tabla);
        jTableDescripcion.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTableDescripcionComponentAdded(evt);
            }
        });
        jTableDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTableDescripcionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTableDescripcionFocusLost(evt);
            }
        });
        jTableDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTableDescripcionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDescripcion);

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("IVA");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Total");

        jButtonCancelar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/eliminar.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonAceptar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/ingresar.png"))); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonInsertarMotivo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonInsertarMotivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/agregar.png"))); // NOI18N
        jButtonInsertarMotivo.setText("Insertar Motivo");
        jButtonInsertarMotivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarMotivoActionPerformed(evt);
            }
        });

        jButtonBorrarSeleccion.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonBorrarSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/borrar.png"))); // NOI18N
        jButtonBorrarSeleccion.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonBorrarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarSeleccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextFieldEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButtonBuscarEmpresa)
                                            .addGap(37, 37, 37)
                                            .addComponent(jLabel3))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextFieldFactura)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonBuscarFactura)))
                                .addComponent(jButtonInsertarMotivo))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAceptar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonCancelar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jButtonBorrarSeleccion)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonBuscarFactura)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonBuscarEmpresa)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jButtonInsertarMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButtonBorrarSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableDescripcionComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTableDescripcionComponentAdded

    }//GEN-LAST:event_jTableDescripcionComponentAdded

    private void jTableDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableDescripcionKeyTyped
                
    }//GEN-LAST:event_jTableDescripcionKeyTyped

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        Session sesion;
        sesion = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.getTransaction().begin(); 
        
        if(jTableDescripcion.getRowCount() == 0 || jTableDescripcion.getValueAt(0, 0) == null || jTableDescripcion.getValueAt(0, 1).toString().trim().compareTo("") == 0){
            JOptionPane.showMessageDialog(null, "Ingrese al menos un motivo", "Validez de Campo", WIDTH);
        }
        if(facActual == null){
            JOptionPane.showMessageDialog(rootPane, "Ingrese factura", "Validez de Campo", WIDTH);
        }else if(empActual == null){
            JOptionPane.showMessageDialog(rootPane, "Ingrese Paciente", "Validez de Campo", WIDTH);
        }else{
                NotaCreditoEmpresa nuevo = new NotaCreditoEmpresa();
                nuevo.setFacturaEmpresa(facActual);
                nuevo.setFecha(new Date());
                nuevo.setEmpresa(empActual);
                nuevo.setTotal(Integer.parseInt(jTextFieldTotal.getText().replace(".", "")));
                nuevo.setUsuario(userActual);
                boolean v = false;
                if(facActual.getTipo().compareTo("Crédito") == 0 && facActual.getEstado().compareTo("Pendiente") == 0){    //Si la factura es crédito, afecta su saldo
                    if(nuevo.getFacturaEmpresa().getSaldo() >= nuevo.getTotal()){   //Si el total es menor o igual al saldo de la factura
                        nuevo = NotaControlador.insertarNotaEmpresa(nuevo, sesion);
                        insertarDetalle(nuevo, sesion);
                        v = NotaControlador.actualizarSaldoFacEmpresa(nuevo, sesion);          //Actualiza el saldo de la factura crédito
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Monto no puede ser mayor al saldo de la factura: "+formateador.format(facActual.getSaldo()), "Nota Crédito", WIDTH);
                    }
                }else{                                                  //Factura contado
                    nuevo = NotaControlador.insertarNotaEmpresa(nuevo, sesion);
                    insertarDetalle(nuevo, sesion);
                    v = true;
                }
                if(v){
                    JOptionPane.showMessageDialog(rootPane, "Nota insertada", "Nota Crédito", WIDTH);
                    limpiar();
                }else{
                    JOptionPane.showMessageDialog(rootPane, "No se pudo insertar nota", "Nota Crédito", WIDTH);
                }
            }
        
        sesion.getTransaction().commit();            
        sesion.close();
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonBuscarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarEmpresaActionPerformed
        ObtenerEmpresa jDialog = new ObtenerEmpresa(null, true);
        jDialog.setVisible(true);        
        empActual = jDialog.getReturnStatus();
        if(empActual != null){
            jTextFieldEmpresa.setText(empActual.getNombre());
            jButtonBuscarFactura.setVisible(true);
        }
    }//GEN-LAST:event_jButtonBuscarEmpresaActionPerformed

    private void jButtonBuscarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarFacturaActionPerformed
        ObtenerFacturasEmpresa.emp = empActual;
        ObtenerFacturasEmpresa jDialog = new ObtenerFacturasEmpresa(null, true);
        jDialog.setVisible(true);
        facActual = jDialog.getReturnStatus();
        if(facActual != null){
            jTextFieldFactura.setText(facActual.getNroFactura().toString());
        }
    }//GEN-LAST:event_jButtonBuscarFacturaActionPerformed

    private void jButtonInsertarMotivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarMotivoActionPerformed
        Object[] fila = new Object[2];        
        fila[0] = JOptionPane.showInputDialog(null, "Ingrese el motivo de la nota", "Motivo", JOptionPane.QUESTION_MESSAGE);
        boolean bandera;
        do{
            try{
                fila[1] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese monto", "Monto", JOptionPane.QUESTION_MESSAGE));
                bandera = true;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Sólo se permiten números" , "Monto" , JOptionPane.QUESTION_MESSAGE );
                bandera = false;
            }
        }while(!bandera);        
        
        if(fila[0] != null && fila[1] != null){
            tabla.addRow(fila);  
            jTableDescripcion.setValueAt(formateador.format(fila[1]), tabla.getRowCount()-1, 1);
            DetalleNotaEmp d = new DetalleNotaEmp();
            d.setDescripcion(fila[0].toString());
            d.setMonto(Integer.parseInt(fila[1].toString()));
            detalle.add(d);
            monto = Integer.parseInt(fila[1].toString())+ monto;
            jTextFieldTotal.setText(String.valueOf(formateador.format(monto)));
            jTextFieldIVA.setText(String.valueOf(formateador.format(monto/11)));
        }
    }//GEN-LAST:event_jButtonInsertarMotivoActionPerformed

    private void jButtonBorrarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarSeleccionActionPerformed
        int f = jTableDescripcion.getSelectedRow();
        int mont = Integer.parseInt(jTableDescripcion.getValueAt(f, 1).toString().replace(".", ""));
        monto = monto - mont;
        jTextFieldTotal.setText(String.valueOf(monto));
        jTextFieldIVA.setText(String.valueOf(monto/11));
        tabla.removeRow(f);
        detalle.remove(f);
        jButtonBorrarSeleccion.setVisible(false);

    }//GEN-LAST:event_jButtonBorrarSeleccionActionPerformed

    private void jTableDescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableDescripcionFocusGained
        int fila = jTableDescripcion.rowAtPoint(evt.getComponent().getLocation());
         if (fila > -1){        //El foco tiene una fila
             jButtonBorrarSeleccion.setVisible(true);
         }else{
             jButtonBorrarSeleccion.setVisible(false);
         }
    }//GEN-LAST:event_jTableDescripcionFocusGained

    private void jTableDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableDescripcionFocusLost
        jButtonBorrarSeleccion.setVisible(false);
    }//GEN-LAST:event_jTableDescripcionFocusLost

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        jButtonBorrarSeleccion.setVisible(false);
    }//GEN-LAST:event_formMouseClicked

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
            java.util.logging.Logger.getLogger(NotasCreditosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotasCreditosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotasCreditosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotasCreditosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotasCreditosEmpresa().setVisible(true);
            }
        });
    }
    //Variables
    DefaultTableModel tabla = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
    public static Empresa empActual = null;
    FacturaEmpresa facActual = null;
    int monto = 0;
    public static Usuario userActual;
    ArrayList<DetalleNotaEmp> detalle = new ArrayList();
    DecimalFormat formateador = new DecimalFormat("###,###");

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonBorrarSeleccion;
    private javax.swing.JButton jButtonBuscarEmpresa;
    private javax.swing.JButton jButtonBuscarFactura;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonInsertarMotivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDescripcion;
    private javax.swing.JTextField jTextFieldEmpresa;
    private javax.swing.JTextField jTextFieldFactura;
    private javax.swing.JTextField jTextFieldIVA;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables

    private void inicializarTodo() {
        tabla.addColumn("Descripción o motivo de la modificación");
        tabla.addColumn("Monto");
        
        Date fecha = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String fec = f.format(fecha);
        jLabelFecha.setText(fec);
        
        if(empActual != null){          //Si es llamado desde otro Frame que no sea inicio
            jButtonBuscarEmpresa.setVisible(false);
        }
        if(facActual != null){          //Si es llamado desde otro Frame que no sea inicio
            jButtonBuscarFactura.setVisible(false);
        }
    }

    private void limpiar() {
        jTextFieldFactura.setText("");
        jTextFieldIVA.setText("");
        jTextFieldEmpresa.setText("");
        jTextFieldTotal.setText("");
        Configuraciones.limpiarModelo(tabla);
    }

    private void insertarDetalle(NotaCreditoEmpresa nuevo, Session sesion) {
        detalle = new ArrayList();
        int f = jTableDescripcion.getRowCount();
        for(int x=0;x<f;x++){
            DetalleNotaEmp n = new DetalleNotaEmp();
            n.setDescripcion(jTableDescripcion.getValueAt(x, 0).toString());
            n.setMonto(Integer.parseInt(jTableDescripcion.getValueAt(x, 1).toString().replace(".", "")));
            n.setNotaCreditoEmpresa(nuevo);
            detalle.add(n);
        }
        boolean v = NotaControlador.insertarDetalleNotaEmpresa(detalle, sesion);
        if(v==false){
            JOptionPane.showMessageDialog(null, "No se pudo insertar detalle de nota", "Detalle de Nota", WIDTH);
        }
    }
}
