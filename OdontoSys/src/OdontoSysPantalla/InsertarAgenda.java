/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysPantalla;

import OdontoSysControlador.AgendaControlador;
import OdontoSysModelo.Agenda;
import OdontoSysModelo.Doctor;
import OdontoSysModelo.Paciente;
import OdontoSysModelo.Servicio;
import OdontoSysPantalla.ConsultarAgenda;
import OdontoSysPantallaAuxiliares.BuscarServicio;
import OdontoSysPantallaAuxiliares.ObtenerDoctor;
import OdontoSysPantallaAuxiliares.ObtenerPaciente;
import OdontoSysUtil.Configuraciones;
import OdontoSysVista.AgendaVista;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class InsertarAgenda extends javax.swing.JFrame {

    
    
    //Variables Globales
    Paciente pac = new Paciente();
    Doctor doc = new Doctor();
    Agenda nuevo = null;
    Servicio mot = null;
    int idAgenda = 0;
    
    /**
     *
     */
    public InsertarAgenda() {
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
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPaciente = new javax.swing.JTextField();
        jToggleButtonBuscarPaciente = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldMotivo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldDoctor = new javax.swing.JTextField();
        jToggleButtonBuscarDoctor = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jFormattedTextFieldHora = new javax.swing.JFormattedTextField();
        jComboBoxEstado = new javax.swing.JComboBox();
        jToggleButtonBuscarServicio = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("Agenda");

        jDateChooserFecha.setPreferredSize(new java.awt.Dimension(87, 23));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Fecha");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Hora:");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Paciente:");

        jTextFieldPaciente.setEditable(false);
        jTextFieldPaciente.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTextFieldPaciente.setPreferredSize(new java.awt.Dimension(150, 23));

        jToggleButtonBuscarPaciente.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jToggleButtonBuscarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/buscar.png"))); // NOI18N
        jToggleButtonBuscarPaciente.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jToggleButtonBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonBuscarPacienteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Motivo:");

        jTextFieldMotivo.setEditable(false);
        jTextFieldMotivo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Doctor:");

        jTextFieldDoctor.setEditable(false);
        jTextFieldDoctor.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTextFieldDoctor.setPreferredSize(new java.awt.Dimension(150, 23));

        jToggleButtonBuscarDoctor.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jToggleButtonBuscarDoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/buscar.png"))); // NOI18N
        jToggleButtonBuscarDoctor.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jToggleButtonBuscarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonBuscarDoctorActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("Estado:");

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/eliminar.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/ingresar.png"))); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        try {
            jFormattedTextFieldHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldHora.setPreferredSize(new java.awt.Dimension(6, 23));

        jComboBoxEstado.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pendiente", "Cancelado", "Realizado" }));
        jComboBoxEstado.setEnabled(false);

        jToggleButtonBuscarServicio.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jToggleButtonBuscarServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/buscar.png"))); // NOI18N
        jToggleButtonBuscarServicio.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jToggleButtonBuscarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonBuscarServicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(jButtonAceptar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jFormattedTextFieldHora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButtonBuscarPaciente))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldDoctor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addComponent(jTextFieldMotivo, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jToggleButtonBuscarDoctor)
                                    .addComponent(jToggleButtonBuscarServicio)))
                            .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jFormattedTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButtonBuscarPaciente)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jToggleButtonBuscarServicio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButtonBuscarDoctor))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonBuscarPacienteActionPerformed
        ObtenerPaciente jDialog= new ObtenerPaciente(null, true);
        jDialog.setVisible(true);
        pac= jDialog.getReturnStatus();
                if(pac != null){
                    String paciente = pac.getNombres() +" "+ pac.getApellidos();
                   jTextFieldPaciente.setText(paciente);
                }
    }//GEN-LAST:event_jToggleButtonBuscarPacienteActionPerformed

    private void jToggleButtonBuscarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonBuscarDoctorActionPerformed
        ObtenerDoctor jDialog= new ObtenerDoctor(null, true);
        jDialog.setVisible(true);
        
        doc = jDialog.getReturnStatus();
                if(doc != null){
                   String doctor = doc.getNombre() +" "+ doc.getApellido();
                   jTextFieldDoctor.setText(doctor);
                }
    }//GEN-LAST:event_jToggleButtonBuscarDoctorActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        obtenerDatos();
        if(idAgenda > 0){
            String reporte="C:\\Users\\user\\Google Drive\\UNA\\Odontosys2017\\OdontoSys\\src\\Reportes\\agenda";
            
            Map parametros = new HashMap();
            parametros.put("idAgenda", idAgenda);
        
            Configuraciones.imprimirReporteHB(reporte, parametros);
        
            ConsultarAgenda jFrame= new ConsultarAgenda();
            jFrame.setVisible(true); //Abre Form
            this.setVisible(false);  //Cierra Form Actual
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        limpiar();
        ConsultarAgenda jFrame= new ConsultarAgenda();
        jFrame.setVisible(true); //Abre Form Agenda
        this.setVisible(false);  //Cierra Form Actual
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jToggleButtonBuscarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonBuscarServicioActionPerformed
        BuscarServicio jDialog= new BuscarServicio(null, true);
        jDialog.setVisible(true);
        
        mot = jDialog.getReturnStatus();
        if(mot != null){
            String motivo = mot.getDescripcion();
            jTextFieldMotivo.setText(motivo);
        }
    }//GEN-LAST:event_jToggleButtonBuscarServicioActionPerformed

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
            java.util.logging.Logger.getLogger(InsertarAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertarAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertarAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertarAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertarAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JComboBox jComboBoxEstado;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JFormattedTextField jFormattedTextFieldHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextFieldDoctor;
    private javax.swing.JTextField jTextFieldMotivo;
    private javax.swing.JTextField jTextFieldPaciente;
    private javax.swing.JToggleButton jToggleButtonBuscarDoctor;
    private javax.swing.JToggleButton jToggleButtonBuscarPaciente;
    private javax.swing.JToggleButton jToggleButtonBuscarServicio;
    // End of variables declaration//GEN-END:variables

    private void obtenerDatos() {
        nuevo = new Agenda();
        nuevo.setFecha(jDateChooserFecha.getDate());
        nuevo.setHora(jFormattedTextFieldHora.getText());
        nuevo.setPaciente(pac);
        nuevo.setServicio(mot);
        nuevo.setDoctor(doc);
        nuevo.setEstado(String.valueOf(jComboBoxEstado.getSelectedItem()));
        int i = AgendaVista.validarAgenda(nuevo);
        if(i == 0){            //registro validado correctamente
            int a = AgendaControlador.InsertarCita(nuevo);
            if(a > 0){
                idAgenda = a;
                JOptionPane.showMessageDialog(rootPane, "Cita Agendada", "Insertar Cita", WIDTH);
            }else{                
                JOptionPane.showMessageDialog(rootPane, "No se pudo insertar cita", "Insertar Cita", WIDTH);
            }
        }
    }

    private void limpiar() {
        jDateChooserFecha.setDate(null);
        jFormattedTextFieldHora.setText("");
        jTextFieldPaciente.setText("");
        jTextFieldMotivo.setText("");
        jTextFieldDoctor.setText("");
        jComboBoxEstado.setSelectedIndex(-1);
    }
}
