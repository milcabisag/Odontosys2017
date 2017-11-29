/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysPantalla;

import OdontoSysControlador.ConvenioControlador;
import OdontoSysModelo.Convenio;
import OdontoSysModelo.DetalleConvenio;
import OdontoSysModelo.Empresa;
import OdontoSysModelo.Servicio;
import OdontoSysModelo.Usuario;
import OdontoSysPantallaAuxiliares.BuscarServicio;
import OdontoSysPantallaAuxiliares.ObtenerEmpresa;
import OdontoSysUtil.Configuraciones;
import OdontoSysUtil.NewHibernateUtil;
import OdontoSysVista.ConvenioVista;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author user
 */
public class Convenios extends javax.swing.JFrame {

     //Variables
    public static Usuario user = null;
    public static Empresa empresaActual = null;
    public static Convenio conv = null;  
    public static Session sesion = null;
    
    String llamado = null;
    ArrayList<Servicio> serv = new ArrayList();
    ArrayList<DetalleConvenio> det = new ArrayList(); 
    
    int fila = 0;
    DefaultTableModel tabla = new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {   
            if(column == 1 || column == 2){
                return true;
            }else{
                return false;  
            }
        }};

    
    
    public Convenios() {
        initComponents();
        
        crearTabla();
        
        if(sesion == null){
            sesion = NewHibernateUtil.getSessionFactory().openSession();
        }
        
        if(user.getRol().compareTo("Administrador") == 0){
            if(empresaActual != null && conv != null){      //Llamado desde frame consultar convenios de paciente
                llamado = "consulta";
                mostrarConvenio();
                habilitarMod();     //habilitar botones para modificación
            }else{                          //Llamado a insertar
                llamado = "insertar";
                habilitarIns();
            }
        }else{
            if(empresaActual != null){      //Llamado desde frame consultar convenios de paciente
                llamado = "consulta";
                mostrarConvenio();
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
        jTextFieldEmpresa = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonBuscarEmpresa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConvenios = new javax.swing.JTable();
        jButtonEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButtonInsertarServicio = new javax.swing.JButton();
        jButtonElimConv = new javax.swing.JButton();
        jButtonModConv = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNombConv = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaObs = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(490, 530));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("Convenios con Empresas");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Empresa");

        jTextFieldEmpresa.setEditable(false);
        jTextFieldEmpresa.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

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

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setText("Servicios");

        jButtonInsertarServicio.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonInsertarServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/agregar.png"))); // NOI18N
        jButtonInsertarServicio.setText("Insertar");
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

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Observaciones");
        jLabel5.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Nombre del Convenio");

        jTextFieldNombConv.setEditable(false);
        jTextFieldNombConv.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jTextAreaObs.setColumns(20);
        jTextAreaObs.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTextAreaObs.setLineWrap(true);
        jTextAreaObs.setRows(5);
        jScrollPane2.setViewportView(jTextAreaObs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonInsertarServicio))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldNombConv, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldEmpresa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBuscarEmpresa)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonModConv, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonElimConv, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonBuscarEmpresa)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombConv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInsertarServicio))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButtonElimConv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModConv))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonEliminar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarEmpresaActionPerformed

        ObtenerEmpresa jDialog= new ObtenerEmpresa(null, true);
        jDialog.setVisible(true);
        empresaActual = new Empresa();
        empresaActual = jDialog.getReturnStatus();
        if(empresaActual != null){
            jTextFieldEmpresa.setText(empresaActual.getNombre());
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo recuperar la empresa" , "Obtener Empresa" , JOptionPane.QUESTION_MESSAGE );
        } 
        
    }//GEN-LAST:event_jButtonBuscarEmpresaActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        
        boolean v= false;
        if(llamado.compareTo("insertar") == 0){
            obtenerNuevoConvenio();
            v = ConvenioVista.validarConvenio(conv,det);
            if(v && det.size() >= 0){
                v = ConvenioControlador.insertarConvenio(conv, det);
                if(v){
                    JOptionPane.showMessageDialog(null, "Convenio guardado correctamente", "Convenios", WIDTH);
                    limpiar();
                    repaintEmpresa();                  //Actualiza la información nueva
                    dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar el convenio" , "Convenios" , JOptionPane.QUESTION_MESSAGE );
                }
            }
        }else if(llamado.compareTo("modificar") == 0){          //Llamado a modificar
            if(det.size() >= 0){    //Existe por lo menos un detalle de convenio
                v = ConvenioControlador.modificarConvenio(conv, det, sesion);
                if(v){
                    JOptionPane.showMessageDialog(null, "Convenio guardado correctamente", "Convenios", WIDTH);
                    limpiar();
                    dispose();
               }else {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar el convenio" , "Convenios" , JOptionPane.QUESTION_MESSAGE );
                } 
            }else{
                JOptionPane.showMessageDialog(null, "Debe cargar por lo menos un servicio en el detalle" , "Convenios" , JOptionPane.QUESTION_MESSAGE );
            }
        }
                   
        
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        limpiar();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
       
        jTableConvenios.setEnabled(true);
        jButtonGuardar.setVisible(true);
        jButtonEliminar.setVisible(false);
        jButtonInsertarServicio.setVisible(true);
        jButtonModificar.setVisible(false);
        jTextFieldNombConv.setEnabled(true);
        jTextAreaObs.setEnabled(true);
        llamado = "modificar";
        
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
       
        int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el convenio de la Empresa "
                +empresaActual.getNombre()+"?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            boolean i = ConvenioControlador.eliminarConvenio(conv, det);
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
        
        DetalleConvenio d = new DetalleConvenio();
        
        if(nserv != null){
            int c = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese porcentaje",
                "Convenio", JOptionPane.QUESTION_MESSAGE));
            boolean v = validarPorcentaje(c);
            if(v){
                Object[] nfila = new Object[3];
                nfila[0] = nserv.getDescripcion();
                nfila[1] = c + "%";
        
                tabla.addRow(nfila);
                
                serv.add(nserv);
                
                d.setEstado("Activo");
                d.setPorcentaje(c);
                d.setServicio(nserv);
            
                det.add(d);
            }
        }
        
    }//GEN-LAST:event_jButtonInsertarServicioActionPerformed

    private void jButtonElimConvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonElimConvActionPerformed

        int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            DetalleConvenio d = new DetalleConvenio();
            d = det.get(fila);
            d.setEstado("Inactivo");
            det.set(fila, d);
            tabla.removeRow(fila);
            System.out.println("Eliminado: "+det.get(fila).getEstado());
        }
        
    }//GEN-LAST:event_jButtonElimConvActionPerformed

    private void jButtonModConvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModConvActionPerformed

        DetalleConvenio m = new DetalleConvenio();
        m = det.get(fila);
        boolean v = false;
        Object o = JOptionPane.showInputDialog(null, "Ingrese nuevo porcentaje (sólo número)", "Convenio", JOptionPane.QUESTION_MESSAGE);
        if(o != null){
            int p = Integer.parseInt(o.toString());
            v = validarPorcentaje(p);
            if(v){
                m.setPorcentaje(p);
                det.set(fila, m);
                String n = p + "%";
                tabla.setValueAt(n, fila, 1);
                System.out.println("Modificado: "+det.get(fila).getPorcentaje()+"%");
            }
        }
    }//GEN-LAST:event_jButtonModConvActionPerformed
 
    private void jTableConveniosMouseClicked(java.awt.event.MouseEvent evt) {                                             
        boolean v = jButtonModificar.isVisible();
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
                new Convenios().setVisible(true);
            }
        });
    }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarEmpresa;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableConvenios;
    private javax.swing.JTextArea jTextAreaObs;
    private javax.swing.JTextField jTextFieldEmpresa;
    private javax.swing.JTextField jTextFieldNombConv;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        
        Configuraciones.limpiarModelo(tabla);
        jTextFieldEmpresa.setText("");
        jTextFieldNombConv.setText("");
        jTextAreaObs.setText("");
        empresaActual = null;
        user = null;
        conv = null;
        
        jButtonBuscarEmpresa.setVisible(true);
        jButtonInsertarServicio.setVisible(true);
        jButtonGuardar.setVisible(true);
        
        jButtonElimConv.setVisible(false);
        jButtonModConv.setVisible(false);
        jTextFieldEmpresa.setEditable(false);
        jTableConvenios.setEnabled(false);
        
    }

    private void mostrarConvenio() {
        jTextFieldEmpresa.setText(empresaActual.getNombre());
        jTextFieldNombConv.setText(conv.getNomConv());
        jTextAreaObs.setText(conv.getObservacion());
        
        jButtonBuscarEmpresa.setVisible(false);
        jButtonGuardar.setVisible(false);
        jButtonElimConv.setVisible(false);
        jButtonModConv.setVisible(false);
        jButtonInsertarServicio.setVisible(false);
        
        jTextFieldEmpresa.setEditable(false);
        jTextFieldNombConv.setEditable(false);
        jTextAreaObs.setEditable(false);
        jTableConvenios.setEnabled(false);
        
        obtenerTabla();
       
    }

    private void obtenerNuevoConvenio() {

        conv = new Convenio();
        conv.setEmpresa(empresaActual);
        conv.setNomConv(jTextFieldNombConv.getText());
        conv.setObservacion(jTextAreaObs.getText());
        conv.setEstado("Activo");
        
    }

    private void obtenerTabla() {        
        det = ConvenioControlador.BuscarDetalleConvenio(conv, sesion);
        for(DetalleConvenio d : det){
            Object[] f = new Object[2];
            f[0] = d.getServicio().getDescripcion();
            serv.add(d.getServicio());
            f[1] = d.getPorcentaje()+"%";
            tabla.addRow(f);
        }
    }

    private void crearTabla() {
        tabla.addColumn("Servicio");
        tabla.addColumn("Porcentaje Convenio");
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

    private void habilitarMod() {
    
        jButtonEliminar.setVisible(true);
        jButtonModificar.setVisible(true);
    
    }

    private void habilitarIns() {
        
        jTextFieldEmpresa.setText(empresaActual.getNombre());
        jButtonBuscarEmpresa.setVisible(false);
        jTextAreaObs.setEditable(true);
        jTextFieldNombConv.setEditable(true);
        
        jButtonModificar.setVisible(false);
        jButtonEliminar.setVisible(false);
        
        jButtonInsertarServicio.setVisible(true);
        jButtonElimConv.setVisible(false);
        jButtonModConv.setVisible(false);
        
    }

    private void repaintEmpresa() {
        Empresa jF = new Empresa();
        if(jF.isVisible()){
            jF.repaintForm();
        }
    }
}
