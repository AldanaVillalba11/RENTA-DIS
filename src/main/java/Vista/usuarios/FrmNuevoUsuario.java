package Vista.usuarios;

import Eventos.Validar;
import Modelo.Usuarios;
import Modelo.UsuariosDao;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class FrmNuevoUsuario extends javax.swing.JFrame {

    Validar vl = new Validar();
    Usuarios us = new Usuarios();
    UsuariosDao usDao = new UsuariosDao();

    public FrmNuevoUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtId.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtApPaterno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApMaterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 150, 35));

        jLabel9.setText("DIRECCIÓN");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 150, 35));

        jLabel7.setText("TELEFONO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, -1, -1));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 160, 35));

        jLabel6.setText("CORREO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));
        jPanel1.add(txtApPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 152, 35));

        jLabel3.setText("APELLIDO PATERNO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));
        jPanel1.add(txtApMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 150, 35));

        jLabel4.setText("APELLIDO MATERNO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel2.setText("NOMBRE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 160, 35));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 152, 35));

        jLabel1.setText("USUARIO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        btnCancelar.setText("CANCELAR");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 150, 35));

        btnRegistrar.setText("GUARDAR");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 150, 35));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jLabel13.setText("CONTRASEÑA");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, -1));
        jPanel1.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 170, 35));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String pass = String.valueOf(txtClave.getPassword());
        if (txtUsuario.getText().length() > 0 && txtNombre.getText().length() > 0
                && txtApPaterno.getText().length() > 0 && txtApMaterno.getText().length() > 0
                && txtCorreo.getText().length() > 0 && txtTelefono.getText().length() > 0
                && txtDireccion.getText().length() > 0) {
            if (vl.siexiste("usuarios", "usuario", txtUsuario.getText(), txtId.getText())) {
                JOptionPane.showMessageDialog(null, "EL DNI DEBE SER ÚNICO");
            } else if (vl.siexiste("usuarios", "telefono", txtTelefono.getText(), txtId.getText())) {
                JOptionPane.showMessageDialog(null, "EL TELEFONO DEBE SER ÚNICO");
            } else if (vl.siexiste("usuarios", "correo", txtCorreo.getText(), txtId.getText())) {
                JOptionPane.showMessageDialog(null, "EL CORREO DEBE SER ÚNICO");
            } else {
                if (!isValidEmail(txtCorreo.getText())) {
                    JOptionPane.showMessageDialog(null, "INGRESE UN CORREO VALIDO");
                } else {
                    us.setUsuario(txtUsuario.getText());
                    us.setNombre(txtNombre.getText());
                    us.setAp_paterno(txtApPaterno.getText());
                    us.setAp_materno(txtApMaterno.getText());
                    us.setCorreo(txtCorreo.getText());
                    us.setTelefono(txtTelefono.getText());
                    us.setClave(pass);
                    us.setDireccion(txtDireccion.getText());
                    if (txtId.getText().length() > 0) {
                        us.setId(Integer.parseInt(txtId.getText()));
                        if (usDao.modificar(us)) {
                            limpiar();
                            FrmMenuUsuario menu = new FrmMenuUsuario();
                            menu.setVisible(true);
                            dispose();
                            JOptionPane.showMessageDialog(null, "USUARIO MODIFICADO");
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR");
                        }
                    } else {
                        if (pass.length() > 0) {
                            int registro = usDao.registrar(us);
                            if (registro > 0) {
                                limpiar();
                                FrmMenuUsuario menu = new FrmMenuUsuario();
                                menu.setVisible(true);
                                dispose();
                                JOptionPane.showMessageDialog(null, "USUARIO REGISTRADO");
                            } else {
                                JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "LA CONTRASEÑA ES REQUERIDO");
                        }

                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "TODO LOS CAMPOS SON REQUERIDOS");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txtApMaterno;
    public javax.swing.JTextField txtApPaterno;
    private javax.swing.JPasswordField txtClave;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelefono;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    private void limpiar() {
        txtId.setText("");
        txtApMaterno.setText("");
        txtApPaterno.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtUsuario.setText("");
        txtClave.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
    }

    private boolean isValidEmail(String email) {
        // Regular expression for email validation
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
