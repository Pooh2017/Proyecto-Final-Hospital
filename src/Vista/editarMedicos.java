/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Conexion.Conexion;
import Modelo.Paciente;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JTable;
import Controlador.Ctlr_Paciente;
import Controlador.Ctrl_Usuario;
import Modelo.Doctor;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import Modelo.Internar;

/**
 *
 * @author ASUS
 */
public class editarMedicos extends javax.swing.JFrame {

    private String nombreSeleccionado;
    private String motivoSeleccionado;
    private InternarPacientes internarFrame;
   
    /**
     * Creates new form Consultar
     */
    private int paginaActual = 1;
    private final int registrosPorPagina = 20;

    public editarMedicos() {
        initComponents();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.internarFrame = internarFrame;
        this.CargarTablaPacientes(registrosPorPagina, paginaActual);
    }
    
    
    public void setInternarFrame(InternarPacientes internarFrame) {
        this.internarFrame = internarFrame;
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCriterio = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdmin = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel2.setFont(new java.awt.Font("Rockwell Condensed", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MEDICOS Y ADMINS");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Buscar");

        txtCriterio.setBackground(new java.awt.Color(204, 255, 255));
        txtCriterio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCriterio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioKeyReleased(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(0, 51, 102));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/flecha-izquierda.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        tblAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblAdmin);

        jButton2.setBackground(new java.awt.Color(0, 51, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Registrar nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(225, 225, 225)
                .addComponent(btnRegresar)
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(488, 488, 488)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 642, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))
                        .addComponent(btnRegresar))
                    .addComponent(jButton2))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        MenuADMIN m = new MenuADMIN();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        agregarUsuario rp = new agregarUsuario();
        rp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String criterio = txtCriterio.getText().trim();
        buscarPaciente(criterio);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtCriterioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCriterioKeyReleased

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
            java.util.logging.Logger.getLogger(editarMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editarMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editarMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editarMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editarMedicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblAdmin;
    private javax.swing.JTextField txtCriterio;
    // End of variables declaration//GEN-END:variables

    /*
    M+etodo para mostrar a los pacientes.
     */
    private void CargarTablaPacientes(int registrosPorPagina1, int paginaActual1) {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();

        int inicio = (paginaActual - 1) * registrosPorPagina;

        String sql = "SELECT correo, nombre, apellidoP, apellidoM, rol, telefono, cedulaProf, contraseña "
                + "FROM doctor LIMIT ? OFFSET ?";

        PreparedStatement ps;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, registrosPorPagina);
            ps.setInt(2, inicio);
            ResultSet rs = ps.executeQuery();

            model.setColumnIdentifiers(new String[]{
                "Correo", "Nombre", "Apellido Paterno", "Apellido Materno", "Rol", "Telefono", "Contraseña"
            });
            
            while (rs.next()) {
                Object[] fila = new Object[7];
                fila[0] = rs.getString("correo");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("apellidoP");
                fila[3] = rs.getString("apellidoM");
                fila[4] = rs.getString("rol");
                fila[5] = rs.getString("telefono");
                fila[6] = rs.getString("contraseña");
                model.addRow(fila);
            }
            
            

            while (model.getRowCount() < registrosPorPagina) {
                Object[] filaVacia = new Object[7];
                model.addRow(filaVacia);
            }

            tblAdmin.setModel(model);
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al rellenar la tabla Pacientes: " + e);
        }
    }

    

    private void buscarPaciente(String criterio) {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();

        int inicio = (paginaActual - 1) * registrosPorPagina;

        String sql = "SELECT nombre, apellido_paterno, apellido_materno, fecha_nacimiento, sexo, direccion, curp, rfc, telefono, motivo, modo_llegada, fecha_ingreso "
                + "FROM pacientes WHERE nombre LIKE ? OR rfc LIKE ? LIMIT ? OFFSET ?";

        PreparedStatement ps;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + criterio + "%");
            ps.setString(2, "%" + criterio + "%");
            ps.setInt(3, registrosPorPagina);
            ps.setInt(4, inicio);
            ResultSet rs = ps.executeQuery();

            model.setColumnIdentifiers(new String[]{
                "Nombre", "Apellido Paterno", "Apellido Materno", "Fecha de Nacimiento", "Sexo", "Dirección", "CURP", "RFC", "Telefono", "Motivo", "Modo de llegada", "Fecha de Ingreso"
            });

            while (rs.next()) {
                Object[] fila = new Object[12];
                for (int i = 0; i < 12; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }

            tblAdmin.setModel(model);
           
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar paciente: " + e);
        }
    }

    private void seleccionarPaciente() {
        int filaSeleccionada = tblAdmin.getSelectedRow();
        if (filaSeleccionada != -1) {
            nombreSeleccionado = (String) tblAdmin.getValueAt(filaSeleccionada, 0);
            motivoSeleccionado = (String) tblAdmin.getValueAt(filaSeleccionada, 9);

            Internar ventanaInternar = new Internar();

            ventanaInternar.setNombre(nombreSeleccionado);
            ventanaInternar.setMotivo(motivoSeleccionado);
            Vista.InternarPacientes in = new Vista.InternarPacientes();
            in.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un paciente.");
        }
    }

}