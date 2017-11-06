/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysPantalla;

import OdontoSysControlador.ConvenioControlador;
import OdontoSysControlador.FacturaControlador;
import OdontoSysControlador.NumberToLetterConverter;
import OdontoSysControlador.OrdenServicioControlador;
import OdontoSysControlador.TalonarioControlador;
import OdontoSysModelo.ConvPaciente;
import OdontoSysModelo.Convenio;
import OdontoSysModelo.Datos;
import OdontoSysModelo.DetalleOrden;
import OdontoSysModelo.Factura;
import OdontoSysModelo.OrdenServicio;
import OdontoSysModelo.Paciente;
import OdontoSysModelo.Talonario;
import OdontoSysUtil.TipoPago;
import OdontoSysModelo.Usuario;
import OdontoSysPantallaAuxiliares.ObtenerTipoPagoContado;
import OdontoSysPantallaAuxiliares.OrdenDeServicio;
import OdontoSysUtil.Configuraciones;
import static java.awt.image.ImageObserver.WIDTH;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Facturas extends javax.swing.JFrame {

    /**
     * Variables
     */
    public static Paciente pacActual = null;                    //A pasarse desde el frame padre
    public static OrdenServicio ordenActual = null;             //A pasarse desde el frame padre
    public static ArrayList<DetalleOrden> lista = null;         //A pasarse desde el frame padre
    ArrayList<ConvPaciente> cp = null;
    ArrayList<Convenio> convenios = null;
    DefaultTableModel tabla = new DefaultTableModel(){
        public boolean isCellEditable(int row, int column) {            
                return false;            
        }};
    public static Factura facActual = null;
    public static int monto;
    DecimalFormat formateador = new DecimalFormat("###,###");
    int total;
    int subt;
    public static Usuario user;
    Talonario tal = new Talonario();
    Datos dat = new Datos();
    
    
    public Facturas() {
        initComponents();
        setearFactura();
        obtenerHoy();      
        inicTabla();
            if(ordenActual == null){                 // Llamado desde Paciente, sólo modo de consulta
                    jButtonVerOrdenServicio.setVisible(true);
                }else{                                   // Llamado desde Orden Servicio
                    setearDatos();
                    obtenerDetalle();
                    jButtonVerOrdenServicio.setVisible(false);
                    
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

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabelRUC = new javax.swing.JLabel();
        jLabelTimbrado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelNroFac = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxFactTipo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldNombrePac = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldCI = new javax.swing.JTextField();
        jTextFieldFactOrden = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetalle = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldFactDescuento = new javax.swing.JTextField();
        jTextFieldFactTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldFactIVA10 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldFactIVA5 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldFactIVA = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jButtonVerOrdenServicio = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldFactTotalLetras = new javax.swing.JTextField();
        jLabelFecha = new javax.swing.JLabel();
        jTextFieldFactSubt = new javax.swing.JFormattedTextField();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Fecha");

        jLabelRUC.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelRUC.setText("RUC Nro");

        jLabelTimbrado.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelTimbrado.setText("Timbrado");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel4.setText("FACTURA");

        jLabelNroFac.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelNroFac.setText("Nro");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Tipo");

        jComboBoxFactTipo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jComboBoxFactTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Contado", "Crédito" }));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Nombre y Apellido");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Orden de Servicio Nro");

        jTextFieldNombrePac.setEditable(false);
        jTextFieldNombrePac.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextFieldNombrePac.setFocusable(false);
        jTextFieldNombrePac.setRequestFocusEnabled(false);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("CI o RUC Nro");

        jTextFieldCI.setEditable(false);
        jTextFieldCI.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextFieldCI.setFocusable(false);
        jTextFieldCI.setRequestFocusEnabled(false);

        jTextFieldFactOrden.setEditable(false);
        jTextFieldFactOrden.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextFieldFactOrden.setRequestFocusEnabled(false);

        jTableDetalle.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTableDetalle.setModel(tabla);
        jTableDetalle.setEnabled(false);
        jTableDetalle.setFocusable(false);
        jScrollPane1.setViewportView(jTableDetalle);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("SubTotal");

        jTextFieldFactDescuento.setEditable(false);
        jTextFieldFactDescuento.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextFieldFactDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFactDescuentoKeyTyped(evt);
            }
        });

        jTextFieldFactTotal.setEditable(false);
        jTextFieldFactTotal.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextFieldFactTotal.setFocusable(false);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Descuento");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Total");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("IVA");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("10%");

        jTextFieldFactIVA10.setEditable(false);
        jTextFieldFactIVA10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextFieldFactIVA10.setFocusable(false);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("5%");

        jTextFieldFactIVA5.setEditable(false);
        jTextFieldFactIVA5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextFieldFactIVA5.setFocusable(false);
        jTextFieldFactIVA5.setRequestFocusEnabled(false);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Total IVA");

        jTextFieldFactIVA.setEditable(false);
        jTextFieldFactIVA.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextFieldFactIVA.setFocusable(false);
        jTextFieldFactIVA.setRequestFocusEnabled(false);

        jButtonCancelar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/eliminar.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonAceptar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/ingresar.png"))); // NOI18N
        jButtonAceptar.setText("Guardar e Imprimir");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonVerOrdenServicio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButtonVerOrdenServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/menus.png"))); // NOI18N
        jButtonVerOrdenServicio.setText("Ver");
        jButtonVerOrdenServicio.setMargin(new java.awt.Insets(2, 7, 2, 7));
        jButtonVerOrdenServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerOrdenServicioActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("Total en letras");

        jTextFieldFactTotalLetras.setEditable(false);
        jTextFieldFactTotalLetras.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextFieldFactTotalLetras.setFocusable(false);

        jLabelFecha.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jTextFieldFactSubt.setEditable(false);
        jTextFieldFactSubt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jTextFieldFactSubt.setFocusable(false);
        jTextFieldFactSubt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextFieldFactSubt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFactSubtKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextFieldFactOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonVerOrdenServicio))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldNombrePac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(264, 264, 264)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxFactTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(jLabelTimbrado)))
                                        .addGap(19, 19, 19))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabelRUC)
                                        .addGap(81, 81, 81))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelNroFac, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(48, 48, 48))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonAceptar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancelar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldFactIVA10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldFactIVA5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldFactIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldFactTotalLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTextFieldFactTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTextFieldFactDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldFactSubt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelRUC, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldCI, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelTimbrado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldNombrePac, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNroFac, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFactOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVerOrdenServicio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFactTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldFactIVA10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldFactIVA5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldFactIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldFactTotalLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldFactSubt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldFactDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldFactTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonAceptar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
              
        obtenerFactura();
        ArrayList<TipoPago> tipo = null;
        if(facActual.getTipoFactura().compareTo("Contado") == 0){
            //Obtener tipo de pago
             ObtenerTipoPagoContado.montoFactura = facActual.getMontoTotal();
             ObtenerTipoPagoContado jDialog = new ObtenerTipoPagoContado(null, true);
             jDialog.setVisible(true);
             tipo =  jDialog.getReturnStatus();
             if(tipo != null){
                 facActual = FacturaControlador.insertarFactura(facActual, tal, user, tipo); 
                 imprimirFactura();
                this.dispose();   
             }
        }else{          //Factura Crédito
            facActual = FacturaControlador.insertarFactura(facActual, tal, user, null);
            imprimirFactura();
            this.dispose();
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonVerOrdenServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerOrdenServicioActionPerformed
        OrdenDeServicio.ordenActual = ordenActual;
        OrdenDeServicio jFrame = new OrdenDeServicio();
        jFrame.setVisible(true);
    }//GEN-LAST:event_jButtonVerOrdenServicioActionPerformed

    private void jTextFieldFactDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFactDescuentoKeyTyped
        char c = evt.getKeyChar();
        int i = c;
        if((c < '0' || c > '9') && (i != 8 && i != 9 && i != 10)){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Este campo sólo admite numeros", "Validez de Campo", WIDTH);
        }else{
            int nuevoTotal = Integer.parseInt(jTextFieldFactSubt.getText()) - Integer.parseInt(jTextFieldFactDescuento.getText());
            jTextFieldFactTotal.setText(String.valueOf(nuevoTotal));
            actIVA(nuevoTotal);
        }
    }//GEN-LAST:event_jTextFieldFactDescuentoKeyTyped

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldFactSubtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFactSubtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFactSubtKeyTyped

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
            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Facturas().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonVerOrdenServicio;
    private javax.swing.JComboBox jComboBoxFactTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelNroFac;
    private javax.swing.JLabel jLabelRUC;
    private javax.swing.JLabel jLabelTimbrado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDetalle;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldCI;
    private javax.swing.JTextField jTextFieldFactDescuento;
    private javax.swing.JTextField jTextFieldFactIVA;
    private javax.swing.JTextField jTextFieldFactIVA10;
    private javax.swing.JTextField jTextFieldFactIVA5;
    private javax.swing.JTextField jTextFieldFactOrden;
    private javax.swing.JFormattedTextField jTextFieldFactSubt;
    private javax.swing.JTextField jTextFieldFactTotal;
    private javax.swing.JTextField jTextFieldFactTotalLetras;
    private javax.swing.JTextField jTextFieldNombrePac;
    // End of variables declaration//GEN-END:variables

    private void obtenerHoy() {
        Date fecha = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String fec = f.format(fecha);
        jLabelFecha.setText(fec);
    }

    private void inicTabla() {
        tabla.addColumn("Descripción del Servicio");
        tabla.addColumn("Precio");
        tabla.addColumn("Exenta");
        tabla.addColumn("IVA 5%");
        tabla.addColumn("IVA 10%");
    }

    private void obtenerDetalle() {
        lista = new ArrayList();
        lista = OrdenServicioControlador.BuscarDetalleOrden(ordenActual.getIdordenServicio());
        cp = new ArrayList();
        cp = ConvenioControlador.BuscarConvenioPaciente(pacActual);
        for(DetalleOrden n : lista){
            Object[] f = new Object[5];
            f[0] = n.getServicio().getDescripcion();
            f[1] = n.getPrecio();
            f[2] = null;
            f[3] = null;
            f[4] = n.getPrecio(); //- verConvenio(n);
            subt = Integer.parseInt(f[1].toString()) + subt;
            total = Integer.parseInt(f[4].toString()) + total;
            tabla.addRow(f);
            jTableDetalle.setValueAt(formateador.format(f[1]), tabla.getRowCount()-1, 1);
            jTableDetalle.setValueAt(formateador.format(f[4]), tabla.getRowCount()-1, 4);
        }
        jTextFieldFactSubt.setText(String.valueOf(formateador.format(subt)));
        jTextFieldFactTotal.setText(String.valueOf(formateador.format(total)));
        jTextFieldFactDescuento.setText(String.valueOf(formateador.format(subt-total)));
        actIVA(total);
    }

    private void actIVA(int total) {
        jTextFieldFactIVA10.setText(String.valueOf(formateador.format(total/11)));
        jTextFieldFactIVA.setText(String.valueOf(formateador.format(total/11)));
        jTextFieldFactIVA5.setText("0");
        jTextFieldFactTotalLetras.setText(NumberToLetterConverter.convertNumberToLetter(total));
    }

    private void obtenerFactura() {
        
            facActual = new Factura();
            facActual.setFecha(new Date());
            String tipo = jComboBoxFactTipo.getSelectedItem().toString();
            facActual.setTipoFactura(tipo);
            if(tipo.compareTo("Contado") ==  0){
                facActual.setEstado("Cancelado");
                facActual.setSaldo(0);
            }else{                          //Factura Crédito
                facActual.setEstado("Pendiente");
                facActual.setSaldo(total);
            }
            facActual.setPaciente(pacActual);
            facActual.setOrdenServicio(ordenActual);
            facActual.setTalonario(tal);
            facActual.setDescuento(subt-total);
            facActual.setMontoTotal(total);
            facActual.setUsuario(user);
    }

    private void setearDatos() {
        jTextFieldCI.setText(String.valueOf(pacActual.getNroCi()));
        jTextFieldNombrePac.setText(pacActual.getNombres()+" "+pacActual.getApellidos());
        jTextFieldFactOrden.setText(ordenActual.getIdordenServicio().toString());
    }

 /*   private int verConvenio(DetalleOrden det) {     //Retorna el porcentaje total sobre el servicio que se le pasa  
        Session sesion;
        sesion = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.getTransaction().begin();
         
        int sum = 0;
        if(cp != null){       //El paciente tiene convenio
            for(ConvPaciente c : cp){
                int a = ConvenioControlador.BuscarPorcentajeConvenio(pacActual.getIdPaciente(), e.getIdempresa(), det.getServicio().getIdservicio(), sesion);
                int desc = det.getPrecio() * a /100;
                sum = desc + sum;
            }            
        }
        sesion.getTransaction().commit();            
        sesion.close();
        
        return sum;
    }*/

   /* private boolean guardarFacturaConvenio(Session sesion) {
        boolean v = false;       
        for(Empresa e : empresas){
            int total = 0;
            for(DetalleOrden d : lista){
                int c = ConvenioControlador.BuscarPorcentajeConvenio(pacActual.getIdPaciente(), e.getIdempresa(), d.getServicio().getIdservicio(), sesion);
                int m =  d.getPrecio() * c / 100;
                total = m + total;
            }
            if(total > 0){
            FacturaConvenio fc = new FacturaConvenio();
                fc.setFactura(facActual);
                fc.setEstado("Pendiente");
                fc.setEmpresa(e);
                fc.setMonto(total);
                FacturaControlador.insertarFacturaConvenio(fc, sesion);
            }
            v = true;
        }
        return v;
    }
*/
    private void imprimirFactura() {
        String reporte="reportes/factura";
        
        int idFactura = facActual.getIdfactura();
        String let = jTextFieldFactTotalLetras.getText();
        
        System.out.println("Factura "+idFactura);
        System.out.println("Letras "+let);
        
        Map parametros = new HashMap();
        parametros.put("idFactura", idFactura);
        parametros.put("total_letras", let);
        
        Configuraciones.imprimirReporteHB(reporte, parametros);
    }

    private void setearFactura() {
        
        
        dat = TalonarioControlador.DatosdeFactura();
        tal = TalonarioControlador.BuscarFacturaLibre();
        if(tal != null && dat != null){
            jLabelRUC.setText("RUC "+dat.getRuc());
            jLabelTimbrado.setText("Timbrado "+tal.getTimbrado());
            jLabelNroFac.setText("Nro 001-001-000"+tal.getNroFactura());
        }
    
    }



}
