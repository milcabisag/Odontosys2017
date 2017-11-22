/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysPantalla;

import OdontoSysControlador.DiagnosticoControlador;
import OdontoSysControlador.OdontogramaControlador;
import OdontoSysControlador.PacienteControlador;
import OdontoSysModelo.Diagnostico;
import OdontoSysModelo.Odontograma;
import OdontoSysModelo.Paciente;
import OdontoSysModelo.Usuario;
import OdontoSysPantallaAuxiliares.ObtenerPaciente;
import OdontoSysUtil.Configuraciones;
import OdontoSysVista.PacienteVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class PacienteHojaClinica extends javax.swing.JFrame {

    /**
     * Creates new form PacienteHojaClinica
     */
    public PacienteHojaClinica() {
        initComponents();
        deshabilitarTodo();        
        
        tabla.addColumn("Tipo");
        tabla.addColumn("Fecha");
        tabla.addColumn("Doctor");
        
        tablaOdontograma.addColumn("Fecha");
        tablaOdontograma.addColumn("Tipo");
        tablaOdontograma.addColumn("Doctor");
        
       
        jTableDiagnosticos.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                int fila = jTableDiagnosticos.rowAtPoint(e.getPoint());
                if (fila > -1){
                    Diagnosticos.dactual = Lista.get(fila);
                    Diagnosticos jFrame= new Diagnosticos();
                    jFrame.setVisible(true); //Abre Form Diagnosticos
         }
      }
   });
        
        if(pacienteActual != null){
            escribirPaciente(pacienteActual);
            habilitarBotones();
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

        jButtonBuscar = new javax.swing.JButton();
        jButtonModPaciente = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonAtras = new javax.swing.JButton();
        jButtonMenu = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelHojaClinica = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelHPeso = new javax.swing.JLabel();
        jTextFieldHPeso = new javax.swing.JTextField();
        jLabelHEnferm = new javax.swing.JLabel();
        jLabelHMedic = new javax.swing.JLabel();
        jLabelHAlerg = new javax.swing.JLabel();
        jLabelHCirug = new javax.swing.JLabel();
        jLabelHObs = new javax.swing.JLabel();
        jTextFieldHEnferm = new javax.swing.JTextField();
        jTextFieldHMedic = new javax.swing.JTextField();
        jTextFieldHAlerg = new javax.swing.JTextField();
        jTextFieldHCirug = new javax.swing.JTextField();
        jTextFieldHObs = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabelNombrePaciente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonDiagnostico = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDiagnosticos = new javax.swing.JTable();
        jPanelOdontogramas = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableOdontogramas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jButtonBuscar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/buscar.png"))); // NOI18N
        jButtonBuscar.setText("Buscar Paciente");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonModPaciente.setBackground(new java.awt.Color(204, 204, 204));
        jButtonModPaciente.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonModPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/modificar.png"))); // NOI18N
        jButtonModPaciente.setText("Modificar Paciente");
        jButtonModPaciente.setMaximumSize(new java.awt.Dimension(125, 23));
        jButtonModPaciente.setMinimumSize(new java.awt.Dimension(125, 23));
        jButtonModPaciente.setRolloverEnabled(false);
        jButtonModPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModPacienteActionPerformed(evt);
            }
        });

        jButtonModificar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/ingresar.png"))); // NOI18N
        jButtonModificar.setText("Guardar");
        jButtonModificar.setActionCommand("");
        jButtonModificar.setAutoscrolls(true);
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonAtras.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/eliminar.png"))); // NOI18N
        jButtonAtras.setText("Atrás");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jButtonMenu.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/accesos.png"))); // NOI18N
        jButtonMenu.setText("Volver al menú principal");
        jButtonMenu.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("Hoja Clínica");

        jLabelHPeso.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabelHPeso.setText("Peso (Kg.)");

        jTextFieldHPeso.setEditable(false);
        jTextFieldHPeso.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTextFieldHPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHPesoActionPerformed(evt);
            }
        });
        jTextFieldHPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldHPesoPacienteKeyReleased(evt);
            }
        });

        jLabelHEnferm.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabelHEnferm.setText("Enfermedades");

        jLabelHMedic.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabelHMedic.setText("Medicamentos");

        jLabelHAlerg.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabelHAlerg.setText("Alergias");

        jLabelHCirug.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabelHCirug.setText("Cirugías");

        jLabelHObs.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabelHObs.setText("Observaciones");

        jTextFieldHEnferm.setEditable(false);
        jTextFieldHEnferm.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jTextFieldHMedic.setEditable(false);
        jTextFieldHMedic.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jTextFieldHAlerg.setEditable(false);
        jTextFieldHAlerg.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jTextFieldHCirug.setEditable(false);
        jTextFieldHCirug.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jTextFieldHObs.setEditable(false);
        jTextFieldHObs.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");

        jLabelNombrePaciente.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel3.setText("Diagnósticos");

        jButtonDiagnostico.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonDiagnostico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/hoja.png"))); // NOI18N
        jButtonDiagnostico.setText("Ingresar Diagnóstico");
        jButtonDiagnostico.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonDiagnostico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDiagnosticoActionPerformed(evt);
            }
        });

        jTableDiagnosticos.setModel(tabla);
        jScrollPane1.setViewportView(jTableDiagnosticos);

        javax.swing.GroupLayout jPanelHojaClinicaLayout = new javax.swing.GroupLayout(jPanelHojaClinica);
        jPanelHojaClinica.setLayout(jPanelHojaClinicaLayout);
        jPanelHojaClinicaLayout.setHorizontalGroup(
            jPanelHojaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHojaClinicaLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(jPanelHojaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHojaClinicaLayout.createSequentialGroup()
                        .addGroup(jPanelHojaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelHojaClinicaLayout.createSequentialGroup()
                                .addGroup(jPanelHojaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelHEnferm)
                                    .addComponent(jLabelHPeso)
                                    .addComponent(jLabelHAlerg)
                                    .addComponent(jLabelHCirug)
                                    .addComponent(jLabelHObs)
                                    .addComponent(jLabel2))
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHojaClinicaLayout.createSequentialGroup()
                                .addComponent(jLabelHMedic)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanelHojaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelHojaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldHPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldHEnferm)
                                .addComponent(jTextFieldHMedic)
                                .addComponent(jTextFieldHAlerg)
                                .addComponent(jTextFieldHCirug)
                                .addComponent(jTextFieldHObs, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHojaClinicaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(256, 256, 256))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHojaClinicaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(65, 65, 65)
                .addComponent(jButtonDiagnostico)
                .addGap(36, 36, 36))
        );
        jPanelHojaClinicaLayout.setVerticalGroup(
            jPanelHojaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHojaClinicaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelHojaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHojaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHPeso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHojaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHEnferm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHEnferm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHojaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHMedic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHMedic))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHojaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHAlerg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHAlerg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHojaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHCirug, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHCirug))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHojaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHObs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHObs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelHojaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButtonDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jTabbedPane1.addTab("Hoja Clínica", jPanelHojaClinica);

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setText("Histórico de Odontogramas");

        jTableOdontogramas.setModel(tablaOdontograma);
        jTableOdontogramas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOdontogramasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableOdontogramas);

        javax.swing.GroupLayout jPanelOdontogramasLayout = new javax.swing.GroupLayout(jPanelOdontogramas);
        jPanelOdontogramas.setLayout(jPanelOdontogramasLayout);
        jPanelOdontogramasLayout.setHorizontalGroup(
            jPanelOdontogramasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOdontogramasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(171, 171, 171))
            .addGroup(jPanelOdontogramasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelOdontogramasLayout.setVerticalGroup(
            jPanelOdontogramasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOdontogramasLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Odontogramas", jPanelOdontogramas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(214, 214, 214)
                        .addComponent(jButtonModificar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonBuscar)
                        .addGap(356, 356, 356)
                        .addComponent(jButtonModPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jButtonModPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtras)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonMenu))
                .addGap(37, 37, 37))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
    if(pacienteActual == null){
        limpiar();
        
        ObtenerPaciente frameP = new ObtenerPaciente(this, true);
        frameP.setVisible(true);
        pacienteActual = frameP.getReturnStatus();
        
        if (pacienteActual != null) {
           escribirPaciente(pacienteActual);
           habilitarBotones();
        } else {
           JOptionPane.showMessageDialog(null, "Paciente no encontrado!" , "PacienteControlador" , JOptionPane.QUESTION_MESSAGE );
        }
     }else{
        escribirPaciente(pacienteActual);
        habilitarBotones();
     }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        pacienteActual = null;
        this.setVisible(false);//oculta el jFrame actual
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonModPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModPacienteActionPerformed
        habilitarDatos();
        jButtonModPaciente.setVisible(false);
        jButtonModificar.setVisible(true);
        jButtonAtras.setVisible(true);
    }//GEN-LAST:event_jButtonModPacienteActionPerformed

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        limpiar();
        deshabilitarTodo();
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        actualizarPaciente(pacienteActual);
        if(pacienteActual != null && pacienteActual.getIdPaciente() > 0){
           int i = PacienteVista.UpDateHojaClinica(pacienteActual);
           if(i > 0){
              JOptionPane.showMessageDialog(rootPane, "Se modificó correctamente", "Modificar Paciente", WIDTH);
              limpiar();
              deshabilitarTodo();
           }
        }        
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jTextFieldHPesoPacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHPesoPacienteKeyReleased
        
    }//GEN-LAST:event_jTextFieldHPesoPacienteKeyReleased

    private void jTextFieldHPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHPesoActionPerformed

    private void jButtonDiagnosticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDiagnosticoActionPerformed
        Diagnosticos.idPaciente = pacienteActual.getIdPaciente();
        Diagnosticos.user = user;
        Diagnosticos jFrame = new Diagnosticos();
        jFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonDiagnosticoActionPerformed

    private void jTableOdontogramasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOdontogramasMouseClicked
        int fila = jTableOdontogramas.getSelectedRow();
        Odontograma o = odon.get(fila);
        OdontogramaFrame.odon = o;
        OdontogramaFrame.elPaciente = pacienteActual;
        OdontogramaFrame.elUsuario = user;
        OdontogramaFrame.main(null);
    }//GEN-LAST:event_jTableOdontogramasMouseClicked

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
            java.util.logging.Logger.getLogger(PacienteHojaClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PacienteHojaClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PacienteHojaClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PacienteHojaClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PacienteHojaClinica().setVisible(true);
            }
        });
    }
    // Variables
    public static Paciente pacienteActual = null;
    public static Usuario user = null;
    
    ArrayList<Diagnostico> Lista = null;
    ArrayList<Odontograma> odon = null;
    
    DefaultTableModel tabla = new DefaultTableModel();
    DefaultTableModel tablaOdontograma = new DefaultTableModel();
    
    SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonDiagnostico;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonModPaciente;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelHAlerg;
    private javax.swing.JLabel jLabelHCirug;
    private javax.swing.JLabel jLabelHEnferm;
    private javax.swing.JLabel jLabelHMedic;
    private javax.swing.JLabel jLabelHObs;
    private javax.swing.JLabel jLabelHPeso;
    private javax.swing.JLabel jLabelNombrePaciente;
    private javax.swing.JPanel jPanelHojaClinica;
    private javax.swing.JPanel jPanelOdontogramas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableDiagnosticos;
    private javax.swing.JTable jTableOdontogramas;
    private javax.swing.JTextField jTextFieldHAlerg;
    private javax.swing.JTextField jTextFieldHCirug;
    private javax.swing.JTextField jTextFieldHEnferm;
    private javax.swing.JTextField jTextFieldHMedic;
    private javax.swing.JTextField jTextFieldHObs;
    private javax.swing.JTextField jTextFieldHPeso;
    // End of variables declaration//GEN-END:variables

    private void escribirPaciente(Paciente pacienteActual) {
        jLabelNombrePaciente.setText(pacienteActual.getNombres()+" "+pacienteActual.getApellidos());
        jTextFieldHPeso.setText(String.valueOf(pacienteActual.getPeso()));
        jTextFieldHEnferm.setText(pacienteActual.getEnfermedades());
        jTextFieldHMedic.setText(pacienteActual.getMedicamentos());
        jTextFieldHAlerg.setText(pacienteActual.getAlergias());
        jTextFieldHCirug.setText(pacienteActual.getCirugias());
        jTextFieldHObs.setText(pacienteActual.getObservaciones());
        
        setearTabla();
        recuperarOdontogramas();
        
    }

    private void habilitarBotones() {
        jButtonBuscar.setVisible(false);
        jButtonModPaciente.setVisible(true);
        jButtonAtras.setVisible(true);
        jButtonDiagnostico.setVisible(true);
    }

    private void limpiar() {
        jTextFieldHPeso.setText("");
        jTextFieldHEnferm.setText("");
        jTextFieldHMedic.setText("");
        jTextFieldHAlerg.setText("");
        jTextFieldHCirug.setText("");
        jTextFieldHObs.setText("");
        jLabelNombrePaciente.setText("");
        
        Configuraciones.limpiarModelo(tabla);
        Configuraciones.limpiarModelo(tablaOdontograma);
        
        pacienteActual = null;
        
        jTextFieldHPeso.setEditable(false);
        jTextFieldHEnferm.setEditable(false);
        jTextFieldHMedic.setEditable(false);
        jTextFieldHAlerg.setEditable(false);
        jTextFieldHCirug.setEditable(false);
        jTextFieldHObs.setEditable(false);
    }

    private void habilitarDatos() {
        jTextFieldHPeso.setEditable(true);
        jTextFieldHEnferm.setEditable(true);
        jTextFieldHMedic.setEditable(true);
        jTextFieldHAlerg.setEditable(true);
        jTextFieldHCirug.setEditable(true);
        jTextFieldHObs.setEditable(true);
    }

    private void deshabilitarTodo() {
        jTextFieldHPeso.setEditable(false);
        jTextFieldHEnferm.setEditable(false);
        jTextFieldHMedic.setEditable(false);
        jTextFieldHAlerg.setEditable(false);
        jTextFieldHCirug.setEditable(false);
        jTextFieldHObs.setEditable(false);
        
        jButtonBuscar.setVisible(true);
        jButtonModPaciente.setVisible(false);
        jButtonAtras.setVisible(false);
        jButtonModificar.setVisible(false);
        jButtonDiagnostico.setVisible(false);        
        
    }

    private void actualizarPaciente(Paciente pacienteActual) {
        pacienteActual.setPeso(Integer.parseInt(jTextFieldHPeso.getText()));
        pacienteActual.setEnfermedades(jTextFieldHEnferm.getText());
        pacienteActual.setObservaciones(jTextFieldHObs.getText());
        pacienteActual.setAlergias(jTextFieldHAlerg.getText());
        pacienteActual.setCirugias(jTextFieldHCirug.getText());
        pacienteActual.setMedicamentos(jTextFieldHMedic.getText());  
    }

    private void setearTabla() {
        
        Lista = DiagnosticoControlador.ConsultarDiagnosticos(pacienteActual.getIdPaciente());
        if(Lista != null){        
            for(Diagnostico nuevo : Lista){                
                String[] fila = new String[3];
                fila[0] = nuevo.getTipo();
                fila[1] =  String.valueOf(nuevo.getFecha());
                if(nuevo.getTipo().compareTo("Interno") == 0){
                    if(nuevo.getUsuario().getDoctor() == null){
                        fila[2] = "Usuario " + nuevo.getUsuario().getNombre();
                    }else{                                                      //Rol Doctor
                        fila[2] = nuevo.getUsuario().getDoctor().getNombre() +" "+ nuevo.getUsuario().getDoctor().getApellido();
                    }
                }else{
                    fila[2] = "Empresa " + nuevo.getEmpresa();
                }
                tabla.addRow(fila);
               
            }
        }else{
            limpiarTabla();
            jButtonModPaciente.doClick();       //Obliga a insertar por lo menos un diagnostico
        }
    }

    private void limpiarTabla() {
        Configuraciones.limpiarModelo(tabla);
    }

    private void recuperarOdontogramas() {
         odon = new ArrayList();
        odon = OdontogramaControlador.HistoricoPaciente(pacienteActual);
        if(odon != null){
            for(Odontograma o : odon){
                Object[] f = new Object[3];
                f[0] = fecha.format(o.getFecha());
                f[1] = o.getTipo();
                if(o.getUsuario().getDoctor() == null){
                    f[2] = "Usuario "+ o.getUsuario().getNombre();
                }else{
                    f[2] = o.getUsuario().getDoctor().getNombre() + " " + o.getUsuario().getDoctor().getApellido();
                }
                tablaOdontograma.addRow(f);
            }
        }
        
    }
}
