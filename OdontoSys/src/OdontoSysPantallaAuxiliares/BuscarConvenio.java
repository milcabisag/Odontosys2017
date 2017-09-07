/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysPantallaAuxiliares;

import OdontoSysControlador.ConvenioControlador;

import OdontoSysModelo.Convenio;
import OdontoSysModelo.Empresa;
import OdontoSysModelo.Paciente;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

    
public class BuscarConvenio extends javax.swing.JFrame {

    /**
     * Creates new form BuscarConvenio
     */
    public BuscarConvenio() {
        initComponents();
        inicializarTabla();        
        realizarConsulta();
        
        
        jTableUsuarios.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int fila = jTableUsuarios.rowAtPoint(e.getPoint());
                if (fila > -1){
                    if(elPaciente != null){
                        DetalleConvenio.empresaActual = lista.get(fila);
                        DetalleConvenio.pacActual = elPaciente;                    
                        irConvenios();      
                    }
                }
            }
        });
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jButtonMenu = new javax.swing.JButton();
        jButtonInsertarUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("Convenios del Paciente");

        jTableUsuarios.setModel(tabla);
        jScrollPane1.setViewportView(jTableUsuarios);

        jButtonMenu.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/accesos.png"))); // NOI18N
        jButtonMenu.setText("Volver");
        jButtonMenu.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });

        jButtonInsertarUser.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonInsertarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesOdontosys/DienteSanos/agregar.png"))); // NOI18N
        jButtonInsertarUser.setText("Insertar Convenio");
        jButtonInsertarUser.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonInsertarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonInsertarUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 442, Short.MAX_VALUE)
                        .addComponent(jButtonMenu)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMenu)
                    .addComponent(jButtonInsertarUser))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        this.setVisible(false);

    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonInsertarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarUserActionPerformed
        DetalleConvenio jFrame = new DetalleConvenio();
        jFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonInsertarUserActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarConvenio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarConvenio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarConvenio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarConvenio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BuscarConvenio().setVisible(true);
            }
        });
    }
    //Variables
    private DefaultTableModel tabla = new DefaultTableModel();
    private ArrayList<Empresa> lista = new ArrayList();
    public static Paciente elPaciente;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonInsertarUser;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarios;
    // End of variables declaration//GEN-END:variables

    private void inicializarTabla() {
        tabla.addColumn("Empresa");
    }

    private void realizarConsulta() {
        if(elPaciente == null){
            jLabel1.setText("Empresas con Convenios Registrados");
            lista = ConvenioControlador.BuscarConvenioEmpresa(null);
        }else{
            jLabel1.setText("Empresas con Convenios del Paciente");
            lista = ConvenioControlador.BuscarConvenioEmpresa(elPaciente);
        }                  
        
        for(Empresa nuevo : lista){
            tabla.addRow(new Object[]{nuevo.getNombre()});
        }
    }
    
    private void irConvenios() {
        DetalleConvenio jFrame= new DetalleConvenio();
        jFrame.setVisible(true); //Abre Form Usuario 
        this.setVisible(false);
    }
}
