/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysPantallaAuxiliares;

import OdontoSysControlador.ConvenioControlador;
import OdontoSysControlador.ServicioControlador;
import OdontoSysModelo.Convenio;
import OdontoSysModelo.Empresa;
import OdontoSysModelo.Paciente;
import OdontoSysModelo.Servicio;
import OdontoSysPantalla.Convenios;
import OdontoSysPantallaAuxiliares.BuscarServicio;
import OdontoSysPantallaAuxiliares.ObtenerEmpresa;
import OdontoSysPantallaAuxiliares.ObtenerPaciente;
import OdontoSysUtil.Configuraciones;
import OdontoSysVista.ConvenioVista;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import static javassist.CtMethod.ConstParameter.string;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class DetalleConvenio extends javax.swing.JFrame {

    /**
     * Creates new form ConveniosPacientes
     */
    public DetalleConvenio() {
        initComponents();
        crearTabla();
        if(empresaActual != null && pacActual != null){      //Llamado desde frame consultar convenios
            llamado = "consulta";
            mostrarConvenio();
            
        }else{                          //Llamado a insertar
            llamado = "insertar";
            jButtonModificar.setVisible(false);
            jButtonEliminar.setVisible(false);
            jButtonInsertarServicio.setVisible(true);
            jButtonElimConv.setVisible(false);
            jButtonModConv.setVisible(false);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConvenios = new javax.swing.JTable();
        jButtonEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButtonInsertarServicio = new javax.swing.JButton();
        jButtonElimConv = new javax.swing.JButton();
        jButtonModConv = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("Convenios entre Pacientes y Empresas");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Empresa");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Paciente");

        jTextFieldEmpresa.setEditable(false);
        jTextFieldEmpresa.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jTextFieldPaciente.setEditable(false);
        jTextFieldPaciente.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

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

        jTableConvenios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableConveniosMouseClicked(evt);
            }
        });
        jTableConvenios.setModel(tabla
        );
        jScrollPane1.setViewportView(jTableConvenios);

        jButtonEliminar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/borrar.png"))); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Servicios");

        jButtonInsertarServicio.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonInsertarServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/agregar.png"))); // NOI18N
        jButtonInsertarServicio.setText("Insertar nuevo");
        jButtonInsertarServicio.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonInsertarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarServicioActionPerformed(evt);
            }
        });

        jButtonElimConv.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonElimConv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/borrar.png"))); // NOI18N
        jButtonElimConv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonElimConvActionPerformed(evt);
            }
        });

        jButtonModConv.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonModConv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/modificar.png"))); // NOI18N
        jButtonModConv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModConvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 32, Short.MAX_VALUE)
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonElimConv, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonModConv, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonBuscarPaciente))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonBuscarEmpresa))
                                    .addComponent(jButtonInsertarServicio))))
                        .addGap(62, 62, 62))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscarEmpresa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonBuscarPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInsertarServicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonElimConv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModConv)
                        .addGap(93, 93, 93)))
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

        ObtenerEmpresa jDialog= new ObtenerEmpresa(null, true);
        jDialog.setVisible(true);
        empresaActual = jDialog.getReturnStatus();
        if(empresaActual != null){
            jTextFieldEmpresa.setText(empresaActual.getNombre());
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo recuperar la empresa" , "Obtener Empresa" , JOptionPane.QUESTION_MESSAGE );
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
            v = ConvenioVista.validarConvenio(conv);
            if(v){
                v = ConvenioControlador.insertarConvenio(conv);
                if(v){
                    JOptionPane.showMessageDialog(null, "Convenio guardado correctamente", "Convenios", WIDTH);
                    limpiar();
                }else {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar el convenio" , "Convenios" , JOptionPane.QUESTION_MESSAGE );
                }
            }
        }else{          //Llamado a modificar
            v = ConvenioControlador.modificarConvenio(conv);
            if(v){
                JOptionPane.showMessageDialog(null, "Convenio guardado correctamente", "Convenios", WIDTH);
                limpiar();
                abrirConvenio();
                dispose();
            }else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el convenio" , "Convenios" , JOptionPane.QUESTION_MESSAGE );
            } 
        }
                   
        
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        limpiar();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
       
        jTableConvenios.setEnabled(true);
        jButtonEliminar.setVisible(false);
        jButtonGuardar.setVisible(true);
        jButtonInsertarServicio.setVisible(true);
        jButtonModificar.setVisible(false);
        
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
       
        int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el convenio entre Empresa "
                +empresaActual.getNombre()+" y Paciente "+pacActual.getNombres()+" "+pacActual.getApellidos()+"?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            boolean i = ConvenioControlador.eliminarConvenio(conv);
            if(i){
                JOptionPane.showMessageDialog(null, "Convenio inactivado correctamente", "Inactivar Convenio", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                dispose();
            }else{
            JOptionPane.showMessageDialog(null, "No se pudo inactivar Convenio", "Inactivar Convenio", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonInsertarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarServicioActionPerformed

        BuscarServicio jDialog = new BuscarServicio(null, true);
        jDialog.setVisible(true);
        Servicio nserv = jDialog.getReturnStatus();
        
        Convenio nc = new Convenio();
        
        if(nserv != null){
            int c = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese porcentaje",
                "Convenio", JOptionPane.QUESTION_MESSAGE));
            boolean v = validarPorcentaje(c);
            if(v){
                String ob = JOptionPane.showInputDialog(null, "Ingrese observación", "Convenio", JOptionPane.QUESTION_MESSAGE);
        
                Object[] nfila = new Object[3];
                nfila[0] = nserv.getDescripcion();
                nfila[1] = c + "%";
                nfila[2] = ob;
        
                tabla.addRow(nfila);
                
                serv.add(nserv);
                
                nc.setEmpresa(empresaActual);
                nc.setPaciente(pacActual);
                nc.setEstado("Activo");
                nc.setObservacion(ob);
                nc.setPorcentaje(c);
                nc.setServicio(nserv);
            
                conv.add(nc);
            }
        }
        
    }//GEN-LAST:event_jButtonInsertarServicioActionPerformed

    private void jButtonElimConvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonElimConvActionPerformed

        int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            Convenio c = new Convenio();
            c = conv.get(fila);
            c.setEstado("Inactivo");
            conv.set(fila, c);
            tabla.removeRow(fila);
        }
        
    }//GEN-LAST:event_jButtonElimConvActionPerformed

    private void jButtonModConvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModConvActionPerformed

        Convenio m = new Convenio();
        m = conv.get(fila);
        boolean v = false;
        int p;
        String modif = JOptionPane.showInputDialog(null, "Modificar:", "Modificar Detalle de Convenio", 
            JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Porcentaje", "Observación"}, 0).toString();
        
        if(modif.compareTo("Porcentaje") == 0){
            do{
                p = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese nuevo porcentaje del convenio en el servicio "+serv.get(fila).getDescripcion(),
                "Convenio", JOptionPane.QUESTION_MESSAGE));
                v = validarPorcentaje(p);
            }while (v = false);
            if(v){
                m.setPorcentaje(p);
                conv.set(fila, m);
                tabla.setValueAt(p, fila, 1);
            }
        }else{              //Modificar Observación
            String o = JOptionPane.showInputDialog(null, "Ingrese observación del convenio para el servicio "+serv.get(fila).getDescripcion(),
                "Convenio", JOptionPane.QUESTION_MESSAGE).toString();
            m.setObservacion(o);
            conv.set(fila, m);
            tabla.setValueAt(o, fila, 2);
        }
       
        
    }//GEN-LAST:event_jButtonModConvActionPerformed
 
    private void jTableConveniosMouseClicked(java.awt.event.MouseEvent evt) {                                             
        boolean v = jButtonModificar.isVisible();
        System.out.println("V "+v);
        if(v == false){
            fila = jTableConvenios.getSelectedRow();       
            jButtonElimConv.setVisible(true);
            jButtonModConv.setVisible(true);
        }
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
    //Variables
    String llamado = null;
    ArrayList<Convenio> conv = new ArrayList();
    ArrayList<Servicio> serv = new ArrayList();
    public static Empresa empresaActual = null;
    public static Paciente pacActual = null;
    int fila = 0;
    DefaultTableModel tabla = new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {   
            if(column == 1 || column == 2){
                return true;
            }else{
                return false;  
            }
        }};

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarEmpresa;
    private javax.swing.JButton jButtonBuscarPaciente;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonElimConv;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonInsertarServicio;
    private javax.swing.JButton jButtonModConv;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConvenios;
    private javax.swing.JTextField jTextFieldEmpresa;
    private javax.swing.JTextField jTextFieldPaciente;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        
        Configuraciones.limpiarModelo(tabla);
        jTextFieldEmpresa.setText("");
        jTextFieldPaciente.setText("");
        pacActual = null;
        empresaActual = null;
        
        jButtonBuscarEmpresa.setVisible(true);
        jButtonBuscarPaciente.setVisible(true);
        jButtonInsertarServicio.setVisible(true);
        jButtonGuardar.setVisible(true);
        
        jButtonElimConv.setVisible(false);
        jButtonModConv.setVisible(false);
        jTextFieldEmpresa.setEditable(false);
        jTextFieldPaciente.setEditable(false);
        jTableConvenios.setEnabled(false);
    }

    private void mostrarConvenio() {
        jTextFieldEmpresa.setText(empresaActual.getNombre());
        jTextFieldPaciente.setText(pacActual.getNombres()+" "+pacActual.getApellidos());
        
        jButtonBuscarEmpresa.setVisible(false);
        jButtonBuscarPaciente.setVisible(false);
        jButtonGuardar.setVisible(false);
        jButtonElimConv.setVisible(false);
        jButtonModConv.setVisible(false);
        jButtonInsertarServicio.setVisible(false);
        
        jTextFieldEmpresa.setEditable(false);
        jTextFieldPaciente.setEditable(false);
        jTableConvenios.setEnabled(false);
        
        obtenerTabla();
       
    }

    private void obtenerNuevoConvenio() {

        for(int x=0;x<conv.size();x++){
            conv.get(x).setEmpresa(empresaActual);
            conv.get(x).setPaciente(pacActual);
            conv.get(x).setServicio(serv.get(x));
            }
        
    }

    private void obtenerTabla() {        
        conv = ConvenioControlador.BuscarConvenios(pacActual, empresaActual);
        for(Convenio c : conv){
            Object[] f = new Object[3];
            f[0] = c.getServicio().getDescripcion();
            serv.add(c.getServicio());
            f[1] = c.getPorcentaje()+"%";
            f[2] = c.getObservacion();
            tabla.addRow(f);
        }
    }

    private void crearTabla() {
        tabla.addColumn("Servicio");
        tabla.addColumn("Porcentaje Convenio");
        tabla.addColumn("Observación");
    }

    private boolean validarPorcentaje(int p) {
        boolean v = false;
        if(p <= 0 || p > 100){
            JOptionPane.showMessageDialog(null, "El porcentaje debe ser mayor a 0 y no superar a 100", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE );
        }else{
            v = true;
        }
        return v;
    }

    private void abrirConvenio() {
    
        Convenios jFrame = new Convenios();
        jFrame.setVisible(true);
        
    }
}
