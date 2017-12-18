/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysPantallaAuxiliares;

import OdontoSysControlador.ConvenioControlador;
import OdontoSysModelo.ConvPaciente;
import OdontoSysModelo.Convenio;
import OdontoSysModelo.Empresa;
import OdontoSysModelo.Paciente;
import OdontoSysModelo.Usuario;
import OdontoSysPantalla.Convenios;
import OdontoSysPantalla.Pacientes;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author user
 */
public class DetalleConvenio extends javax.swing.JFrame {

    
    //Variables
    public static String llamado = null;
    Convenio ce = null;
    public static Empresa empresaActual = null;
    public static Paciente pacActual = null;
    public static ConvPaciente conv = null;
    public static Usuario user = null;
    public static Session sesion = null;
    
    
    
    public DetalleConvenio() {
        initComponents();
        if(llamado.compareTo("consulta") == 0){      //Llamado desde frame consultar convenios
           mostrarConvenio();
            
        }else if(llamado.compareTo("insertar") == 0){                          //Llamado a insertar
            jButtonModificar.setVisible(false);
            jButtonEliminar.setVisible(false);
            jButtonBuscarConvenio.setVisible(false);
            if(pacActual != null){             // Insertar convenio desde paciente
                jTextFieldPaciente.setText(pacActual.getNombres()+" "+pacActual.getApellidos());
                jButtonBuscarPaciente.setVisible(false);
            }else if(empresaActual != null){       // Insertar convenio desde empresa
                jTextFieldEmpresa.setText(empresaActual.getNombre());
                jButtonBuscarEmpresa.setVisible(false);
            }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldEmpresa = new javax.swing.JTextField();
        jTextFieldPaciente = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonBuscarEmpresa = new javax.swing.JButton();
        jButtonBuscarPaciente = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabelConv = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonBuscarConvenio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaObs = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("Convenios entre Pacientes y Empresas");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Empresa");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("Paciente");

        jTextFieldEmpresa.setEditable(false);
        jTextFieldEmpresa.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jTextFieldPaciente.setEditable(false);
        jTextFieldPaciente.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jButtonCancelar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/eliminar.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonGuardar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/guardar.png"))); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonModificar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/modificar.png"))); // NOI18N
        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonBuscarEmpresa.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonBuscarEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/buscar.png"))); // NOI18N
        jButtonBuscarEmpresa.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonBuscarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarEmpresaActionPerformed(evt);
            }
        });

        jButtonBuscarPaciente.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonBuscarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/buscar.png"))); // NOI18N
        jButtonBuscarPaciente.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarPacienteActionPerformed(evt);
            }
        });

        jButtonEliminar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/borrar.png"))); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setText("Nombre del Convenio");

        jLabelConv.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelConv.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.black));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Observación");

        jButtonBuscarConvenio.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonBuscarConvenio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/convenio.png"))); // NOI18N
        jButtonBuscarConvenio.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonBuscarConvenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarConvenioActionPerformed(evt);
            }
        });

        jTextAreaObs.setColumns(20);
        jTextAreaObs.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTextAreaObs.setLineWrap(true);
        jTextAreaObs.setRows(5);
        jTextAreaObs.setMinimumSize(new java.awt.Dimension(200, 21));
        jTextAreaObs.setPreferredSize(new java.awt.Dimension(200, 89));
        jScrollPane1.setViewportView(jTextAreaObs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(62, 62, 62))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelConv, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuscarConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel2)
                .addGap(16, 16, 16)
                .addComponent(jTextFieldEmpresa)
                .addGap(18, 18, 18)
                .addComponent(jButtonBuscarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonBuscarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelConv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonBuscarConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonEliminar))
                .addGap(49, 49, 49))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarEmpresaActionPerformed

        ObtenerEmpresa.sesion = sesion;
        ObtenerEmpresa jDialog= new ObtenerEmpresa(null, true);
        jDialog.setVisible(true);
        empresaActual = jDialog.getReturnStatus();
        if(empresaActual != null){
            jTextFieldEmpresa.setText(empresaActual.getNombre());
            BuscarConvenio.emp = empresaActual;
            BuscarConvenio jDialog2 = new BuscarConvenio(null, true);
            jDialog2.setVisible(true);
            ce = new Convenio();
            ce = jDialog2.getReturnStatus();
            if(ce != null){
                jLabelConv.setText(ce.getNomConv());
            }else {
            JOptionPane.showMessageDialog(null, "No se pudo recuperar la empresa" , "Obtener Empresa" , JOptionPane.QUESTION_MESSAGE );
            } 
        }
        
    }//GEN-LAST:event_jButtonBuscarEmpresaActionPerformed

    private void jButtonBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPacienteActionPerformed
        ObtenerPaciente jDialog= new ObtenerPaciente(null, true);
        jDialog.setVisible(true);
        pacActual = jDialog.getReturnStatus();
        if(pacActual != null){
            jTextFieldPaciente.setText(pacActual.getNombres()+" "+pacActual.getApellidos());
        }else {
            JOptionPane.showMessageDialog(null, "No se pudo recuperar el paciente" , "Obtener Paciente" , JOptionPane.QUESTION_MESSAGE );
        } 
    }//GEN-LAST:event_jButtonBuscarPacienteActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        
        boolean v= false;
        if(llamado.compareTo("insertar") == 0){
            obtenerNuevoConvenio();
            v = ConvenioControlador.insertarConvenioPaciente(conv);
        }else{          //Llamado a modificar
            obtenerConvenio();
            v = ConvenioControlador.modificarConvenioPaciente(conv, sesion);
        }
        if(v){
            JOptionPane.showMessageDialog(null, "Convenio guardado correctamente", "Convenios", WIDTH);
            limpiar();
            repaintPaciente();
            dispose();
        }else {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el convenio" , "Convenios" , JOptionPane.QUESTION_MESSAGE );
        }
                   
        
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        limpiar();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
       
        jButtonEliminar.setVisible(false);
        jButtonGuardar.setVisible(true);
        jButtonModificar.setVisible(false);
        jButtonBuscarConvenio.setVisible(false);
        jButtonBuscarEmpresa.setVisible(true);
        
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
       
        int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el convenio entre Empresa "
                +empresaActual.getNombre()+" y Paciente "+pacActual.getNombres()+" "+pacActual.getApellidos()+"?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            boolean i = ConvenioControlador.eliminarConvenioPaciente(conv, sesion);
            if(i){
                JOptionPane.showMessageDialog(null, "Convenio inactivado correctamente", "Inactivar Convenio", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                dispose();
            }else{
            JOptionPane.showMessageDialog(null, "No se pudo inactivar Convenio", "Inactivar Convenio", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonBuscarConvenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarConvenioActionPerformed
        // Abrir Convenio en modo consulta
        Convenios.empresaActual = empresaActual;
        Convenios.conv = conv.getConvenio();
        Convenios.user = user;
        Convenios.sesion = sesion;
        Convenios.main(null);
    }//GEN-LAST:event_jButtonBuscarConvenioActionPerformed
    
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
            java.util.logging.Logger.getLogger(DetalleConvenio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleConvenio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleConvenio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleConvenio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DetalleConvenio().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarConvenio;
    private javax.swing.JButton jButtonBuscarEmpresa;
    private javax.swing.JButton jButtonBuscarPaciente;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelConv;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaObs;
    private javax.swing.JTextField jTextFieldEmpresa;
    private javax.swing.JTextField jTextFieldPaciente;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        
        jTextFieldEmpresa.setText("");
        jTextFieldPaciente.setText("");
        pacActual = null;
        empresaActual = null;
        jLabelConv.setText("");
        
        jButtonBuscarEmpresa.setVisible(true);
        jButtonBuscarPaciente.setVisible(true);
        jButtonGuardar.setVisible(true);
        
        jTextFieldEmpresa.setEditable(false);
        jTextFieldPaciente.setEditable(false);
    }

    private void mostrarConvenio() {
        jTextFieldEmpresa.setText(empresaActual.getNombre());
        jTextFieldPaciente.setText(pacActual.getNombres()+" "+pacActual.getApellidos());
        jLabelConv.setText(conv.getConvenio().getNomConv());
        jTextAreaObs.setText(conv.getObservacion());
        
        jButtonBuscarEmpresa.setVisible(false);
        jButtonBuscarPaciente.setVisible(false);
        jButtonGuardar.setVisible(false);
        
        jTextFieldEmpresa.setEditable(false);
        jTextFieldPaciente.setEditable(false);
       
    }

    private void obtenerNuevoConvenio() {
        if(pacActual != null && ce != null){
            conv = new ConvPaciente();
            conv.setPaciente(pacActual);
            conv.setConvenio(ce);
            conv.setObservacion(jTextAreaObs.getText());
            conv.setEstado("Activo");
        }        
    }
        
   private void obtenerConvenio() {
        if(ce != null){
            conv.setConvenio(ce);
        }  
        conv.setObservacion(jTextAreaObs.getText());
        conv.setEstado("Activo");    
   }

    private void repaintPaciente() {
    
        Pacientes jFrame = new Pacientes();
        if(jFrame.isVisible()){
            jFrame.actualizarForm();
        }
        
    }


}
