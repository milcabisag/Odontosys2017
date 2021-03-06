    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysPantallaAuxiliares;

import OdontoSysControlador.AgendaControlador;
import OdontoSysModelo.Agenda;
import OdontoSysModelo.Doctor;
import OdontoSysModelo.OrdenServicio;
import OdontoSysModelo.Paciente;
import OdontoSysPantalla.ConsultarAgenda;
import OdontoSysVista.AgendaVista;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class DetalleAgenda extends javax.swing.JFrame {

    /**
     * Creates new form DetalleAgenda
     */
    public DetalleAgenda() {
        initComponents();
        buscarAgenda();
        deshabilitarcampos();
        jButtonGuardar.setVisible(false);
        jButtonBuscarDoctor.setVisible(false);
        jButtonBuscarPaciente.setVisible(false);
        
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
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldDoctor = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldPaciente = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldMotivo = new javax.swing.JTextField();
        jComboBoxEstado = new javax.swing.JComboBox();
        jButtonModificar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jFormattedTextFieldHHora = new javax.swing.JFormattedTextField();
        jButtonBuscarDoctor = new javax.swing.JButton();
        jButtonBuscarPaciente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("Detalle Agenda");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Fecha:");

        jDateChooserFecha.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserFecha.setForeground(new java.awt.Color(255, 255, 255));
        jDateChooserFecha.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jDateChooserFecha.setPreferredSize(new java.awt.Dimension(87, 25));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Hora:");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Paciente:");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Motivo: ");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Doctor:");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("Teléfono:");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("Email:");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("Estado:");

        jTextFieldDoctor.setEditable(false);
        jTextFieldDoctor.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldDoctor.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jTextFieldTelefono.setEditable(false);
        jTextFieldTelefono.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldTelefono.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jTextFieldPaciente.setEditable(false);
        jTextFieldPaciente.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPaciente.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jTextFieldEmail.setEditable(false);
        jTextFieldEmail.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldEmail.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jTextFieldMotivo.setEditable(false);
        jTextFieldMotivo.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldMotivo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jComboBoxEstado.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jComboBoxEstado.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pendiente", "Cancelado", "Realizado" }));

        jButtonModificar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/modificar.png"))); // NOI18N
        jButtonModificar.setText("Modificar");
        jButtonModificar.setRolloverEnabled(false);
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/eliminar.png"))); // NOI18N
        jButtonCancelar.setText("Volver");
        jButtonCancelar.setRolloverEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonGuardar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/ingresar.png"))); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setRolloverEnabled(false);
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jFormattedTextFieldHHora.setEditable(false);
        jFormattedTextFieldHHora.setBackground(new java.awt.Color(255, 255, 255));
        try {
            jFormattedTextFieldHHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButtonBuscarDoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/buscar.png"))); // NOI18N
        jButtonBuscarDoctor.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonBuscarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarDoctorActionPerformed(evt);
            }
        });

        jButtonBuscarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/buscar.png"))); // NOI18N
        jButtonBuscarPaciente.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 223, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(200, 200, 200))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldMotivo, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jDateChooserFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextFieldHHora)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscarDoctor)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel9))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscarPaciente))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jFormattedTextFieldHHora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscarDoctor)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addComponent(jButtonBuscarPaciente))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonGuardar))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        ConsultarAgenda jFrame = new ConsultarAgenda();
        jFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        jButtonModificar.setVisible(false);
        jButtonGuardar.setVisible(true);
        
        jDateChooserFecha.setEnabled(true);
        jFormattedTextFieldHHora.setEditable(true);
        jTextFieldMotivo.setEditable(true);
        jComboBoxEstado.setEnabled(true);
        
        jButtonBuscarDoctor.setVisible(true);
        jButtonBuscarPaciente.setVisible(true);
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        modificarDatos();
        deshabilitarcampos();
        jButtonGuardar.setVisible(false);
        jButtonModificar.setVisible(true);
        jButtonBuscarDoctor.setVisible(false);
        jButtonBuscarPaciente.setVisible(false);
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonBuscarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarDoctorActionPerformed
        doc = new Doctor();
        
        ObtenerDoctor jDialog= new ObtenerDoctor(null, true);
        jDialog.setVisible(true);
        
        doc = jDialog.getReturnStatus();
                if(doc != null){
                   String doctor = doc.getNombre() +" "+ doc.getApellido();
                   jTextFieldDoctor.setText(doctor);
                }
                else{
                    doc = agenda.getDoctor();
                }
    }//GEN-LAST:event_jButtonBuscarDoctorActionPerformed

    private void jButtonBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPacienteActionPerformed
        Paciente npac = new Paciente();
        
        ObtenerPaciente jDialog = new ObtenerPaciente(null, true);
        jDialog.setVisible(true);
        
        npac = jDialog.getReturnStatus();
        if(npac != null){   // Cargar nuevo paciente
            jTextFieldPaciente.setText(npac.getNombres() + " " + npac.getApellidos());
            jTextFieldTelefono.setText(npac.getTelLb() + "  " + npac.getTelCel());
            jTextFieldEmail.setText(npac.getEmail());
        }
        else{   // En caso de cancelado, dejar el paciente anterior
            npac = agenda.getPaciente();
        }
        
    }//GEN-LAST:event_jButtonBuscarPacienteActionPerformed

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
            java.util.logging.Logger.getLogger(DetalleAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleAgenda().setVisible(true);
            }
        });
        
    }
    
    //Variables Globales
    public static int idAgenda;
    Agenda agenda;
    Doctor doc;
    Paciente npac;
    Agenda modificar;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarDoctor;
    private javax.swing.JButton jButtonBuscarPaciente;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JComboBox jComboBoxEstado;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JFormattedTextField jFormattedTextFieldHHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldDoctor;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldMotivo;
    private javax.swing.JTextField jTextFieldPaciente;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables

    private void modificarDatos() {
        modificar = new Agenda();
        modificar = agenda;
        modificar.setFecha(jDateChooserFecha.getDate());
        modificar.setHora(jFormattedTextFieldHHora.getText());
        modificar.setEstado(String.valueOf(jComboBoxEstado.getSelectedItem()));
        modificar.setDoctor(doc);
        modificar.setPaciente(npac);
        
        if(modificar.getEstado().compareTo("Realizado") == 0){
            ObtenerOrdenServicio.idPaciente = npac.getIdPaciente();
            ObtenerOrdenServicio jDialog = new ObtenerOrdenServicio(null, true);
            jDialog.setVisible(true);
            
            OrdenServicio orden = jDialog.getReturnStatus();
            if(orden != null){
                modificar.setOrdenServicio(orden);
                modificarTodo(modificar);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Favor Ingrese la orden de servicio correspondiente a la cita", "Realizar Cita", WIDTH);
                jComboBoxEstado.setSelectedIndex(0);
            }            
        }else{
            if(modificar.getEstado().compareTo("Cancelado") == 0){                
                int i = AgendaControlador.CancelarCita(agenda);
                if(i == 0){            //registro insertado correctamente
                    JOptionPane.showMessageDialog(rootPane, "Cita Modificada", "Modificar Cita", WIDTH);
                    jButtonCancelar.doClick();
                }else{               //no insertado
                    JOptionPane.showMessageDialog(rootPane, "No se pudo Modificar Cita", "Modificar Cita", WIDTH);
                }            
            }else{
                modificarTodo(modificar);
            }
        }
    }

    private void modificarTodo(Agenda modificar) {
        int validar = AgendaVista.validarAgenda(modificar);
            if(validar == 0){
                int i = AgendaControlador.UpDateAgenda(modificar);
                if(i > 0){            //registro insertado correctamente
                    JOptionPane.showMessageDialog(rootPane, "Cita Modificada", "Modificar Cita", WIDTH);
                }else{               //no insertado
                    JOptionPane.showMessageDialog(rootPane, "No se pudo Modificar Cita", "Modificar Cita", WIDTH);
                }
            }
    }

    private void buscarAgenda() {
        agenda = new Agenda();
        agenda = AgendaControlador.BuscarAgenda(idAgenda);
        jDateChooserFecha.setDate(agenda.getFecha());
        jFormattedTextFieldHHora.setText(agenda.getHora());
        jTextFieldPaciente.setText(agenda.getPaciente().getNombres() +" "+ agenda.getPaciente().getApellidos());
        jTextFieldMotivo.setText(agenda.getServicio().getDescripcion());
        jTextFieldDoctor.setText(agenda.getDoctor().getNombre() +" "+ agenda.getDoctor().getApellido());
        jTextFieldTelefono.setText(agenda.getPaciente().getTelLb() +"   "+ agenda.getPaciente().getTelCel());
        jTextFieldEmail.setText(agenda.getPaciente().getEmail()); 
        if(agenda.getEstado() == "Cancelado"){
            jComboBoxEstado.setSelectedItem("Cancelado");
        }
        else{
            jComboBoxEstado.setSelectedItem("Pendiente");
        }
        doc = agenda.getDoctor();
        npac = agenda.getPaciente();
    }

    private void deshabilitarcampos() {
        jDateChooserFecha.setEnabled(false);
        jFormattedTextFieldHHora.setEditable(false);
        jTextFieldPaciente.setEditable(false);
        jTextFieldMotivo.setEditable(false);
        jTextFieldDoctor.setEditable(false);
        jTextFieldTelefono.setEditable(false);
        jTextFieldEmail.setEditable(false);
        jComboBoxEstado.setEnabled(false);
    }
}
