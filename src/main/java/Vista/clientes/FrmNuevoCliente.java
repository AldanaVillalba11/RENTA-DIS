package Vista.clientes;

import Eventos.SessionManager;
import Modelo.Clientes;
import Modelo.ClientesDao;
import Eventos.Validar;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FrmNuevoCliente extends javax.swing.JFrame {

    Validar vl = new Validar();
    Clientes cl = new Clientes();
    ClientesDao clDao = new ClientesDao();
    SessionManager sessionMan = SessionManager.getInstance();
    int userId = sessionMan.getUserId();

    public FrmNuevoCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtId.setVisible(false);
        txtRutaBoleta.setVisible(false);
        txtRutaDni.setVisible(false);
        btnDni.setVisible(false);
        btnBoleta.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cbxEstado = new javax.swing.JComboBox<>();
        cbxCiudad = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMovil = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtApPaterno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApMaterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        btnDni = new javax.swing.JButton();
        btnBoleta = new javax.swing.JButton();
        txtRutaDni = new javax.swing.JTextField();
        txtRutaBoleta = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        txtBarrio = new javax.swing.JTextField();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente de documentación", "Pendiente de verificación", "Aprobado", "Rechazado", "Bloqueado" }));
        cbxEstado.setEnabled(false);
        jPanel1.add(cbxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 329, 30));

        cbxCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buenos Aires" }));
        jPanel1.add(cbxCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 146, 35));

        jLabel12.setText("PAIS");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, -1, -1));

        jLabel11.setText("CIUDAD");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, -1));

        jLabel10.setText("BARRIO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));
        jPanel1.add(txtMovil, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 151, 35));

        jLabel8.setText("MOVIL");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 210, 35));

        jLabel9.setText("DIRECCIÓN");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, -1));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 150, 35));

        jLabel7.setText("TELEFONO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, -1, -1));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 150, 30));

        jLabel6.setText("CORREO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, -1, -1));

        txtNacimiento.setDateFormatString("dd-MM-yyyy");
        jPanel1.add(txtNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 150, 35));

        jLabel5.setText("FECHA NACIMIENTO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));
        jPanel1.add(txtApPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 152, 30));

        jLabel3.setText("APELLIDO PATERNO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));
        jPanel1.add(txtApMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 141, 30));

        jLabel4.setText("APELLIDO MATERNO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        jLabel2.setText("NOMBRE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 141, 30));
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 152, 30));

        jLabel1.setText("DNI");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        btnCancelar.setText("CANCELAR");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, 110, 35));

        btnRegistrar.setText("GUARDAR");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 110, 35));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        btnDni.setText("DNI");
        btnDni.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDniActionPerformed(evt);
            }
        });
        jPanel1.add(btnDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 120, 35));

        btnBoleta.setText("BOLETA");
        btnBoleta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoletaActionPerformed(evt);
            }
        });
        jPanel1.add(btnBoleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 440, 120, 35));
        jPanel1.add(txtRutaDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 70, 23));
        jPanel1.add(txtRutaBoleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 70, -1));

        txtPais.setText("Argentina");
        txtPais.setEnabled(false);
        jPanel1.add(txtPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 150, 35));
        jPanel1.add(txtBarrio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 150, 35));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        System.out.println(userId);
        if (txtDni.getText().length() > 0 && txtNombre.getText().length() > 0
                && txtApPaterno.getText().length() > 0 && txtApMaterno.getText().length() > 0
                && txtCorreo.getText().length() > 0 && txtTelefono.getText().length() > 0
                && txtMovil.getText().length() > 0 && txtDireccion.getText().length() > 0) {
            if (vl.siexiste("clientes", "dni", txtDni.getText(), txtId.getText())) {
                JOptionPane.showMessageDialog(null, "EL DNI DEBE SER ÚNICO");
            } else if (vl.siexiste("clientes", "telefono", txtTelefono.getText(), txtId.getText())) {
                JOptionPane.showMessageDialog(null, "EL TELEFONO DEBE SER ÚNICO");
            } else if (vl.siexiste("clientes", "movil", txtMovil.getText(), txtId.getText())) {
                JOptionPane.showMessageDialog(null, "EL MOVIL DEBE SER ÚNICO");
            } else {
                LocalDate f_na = txtNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate fechaActual = LocalDate.now();
                Period periodo = Period.between(f_na, fechaActual);
                int edad = periodo.getYears();
                if (edad < 18) {
                    JOptionPane.showMessageDialog(null, "NO ERES MAYOR DE EDAD");
                } else if (!isValidEmail(txtCorreo.getText())) {
                    JOptionPane.showMessageDialog(null, "INGRESE UN CORREO VALIDO");
                } else {
                    cl.setDni(txtDni.getText());
                    cl.setNombre(txtNombre.getText());
                    cl.setAp_paterno(txtApPaterno.getText());
                    cl.setAp_materno(txtApMaterno.getText());
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    String date = sdf.format(txtNacimiento.getDate());
                    cl.setF_nacimiento(date);
                    cl.setCorreo(txtCorreo.getText());
                    cl.setTelefono(txtTelefono.getText());
                    cl.setMovil(txtMovil.getText());
                    cl.setDireccion(txtDireccion.getText());
                    cl.setBarrio(txtBarrio.getText());
                    cl.setCiudad(cbxCiudad.getSelectedItem().toString());
                    cl.setPais(txtPais.getText());
                    cl.setEstado(cbxEstado.getSelectedItem().toString());
                    if (txtId.getText().length() > 0) {
                        cl.setId(Integer.parseInt(txtId.getText()));
                        String dni = vl.verificarCampo("clientes", "dni", Integer.parseInt(txtId.getText()));
                        String nombre = vl.verificarCampo("clientes", "nombre", Integer.parseInt(txtId.getText()));
                        String ap_paterno = vl.verificarCampo("clientes", "ap_paterno", Integer.parseInt(txtId.getText()));
                        String ap_materno = vl.verificarCampo("clientes", "ap_materno", Integer.parseInt(txtId.getText()));
                        String f_nac = vl.verificarCampo("clientes", "f_nac", Integer.parseInt(txtId.getText()));
                        String correo = vl.verificarCampo("clientes", "correo", Integer.parseInt(txtId.getText()));
                        String telefono = vl.verificarCampo("clientes", "telefono", Integer.parseInt(txtId.getText()));
                        String movil = vl.verificarCampo("clientes", "movil", Integer.parseInt(txtId.getText()));
                        String direccion = vl.verificarCampo("clientes", "direccion", Integer.parseInt(txtId.getText()));
                        String barrio = vl.verificarCampo("clientes", "barrio", Integer.parseInt(txtId.getText()));
                        String ciudad = vl.verificarCampo("clientes", "ciudad", Integer.parseInt(txtId.getText()));
                        String estado = vl.verificarCampo("clientes", "estado", Integer.parseInt(txtId.getText()));
                        if (clDao.modificar(cl)) {
                            //comprobar ruta
                            if (!txtRutaDni.getText().equals("")) { 
                                clDao.registrarBitacora("Estado", "doc_dni", "Pendiente de documentación", "Pendiente de verificación", Integer.parseInt(txtId.getText()), userId);
                                clDao.actualizarEstado("doc_dni", dni, Integer.parseInt(txtId.getText()));
                                clDao.actualizarEstado("estado", "Pendiente de verificación", Integer.parseInt(txtId.getText()));
                                moverArchivo("dni");
                            }
                            if (!txtRutaBoleta.getText().equals("")) {
                                clDao.registrarBitacora("Estado", "doc_boleta", "Pendiente de documentación", "Pendiente de verificación", Integer.parseInt(txtId.getText()), userId);
                                clDao.actualizarEstado("doc_boleta", dni, Integer.parseInt(txtId.getText()));
                                clDao.actualizarEstado("estado", "Pendiente de verificación", Integer.parseInt(txtId.getText()));
                                moverArchivo("boleta");
                            }
                            registrarBitacora(dni, nombre, ap_paterno, ap_materno, f_nac, correo, telefono, movil, direccion, barrio, ciudad, estado, date);
                            limpiar();
                            FrmMenuCliente menu = new FrmMenuCliente();
                            menu.setVisible(true);
                            dispose();
                            JOptionPane.showMessageDialog(null, "CLIENTE MODIFICADO");
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR");
                        }
                    } else {
                        int registro = clDao.registrar(cl);
                        if (registro > 0) {
                            clDao.registrarBitacora("Registro de Nuevo Cliente", "", "", "", registro, userId);
                            limpiar();
                            FrmMenuCliente menu = new FrmMenuCliente();
                            menu.setVisible(true);
                            dispose();
                            JOptionPane.showMessageDialog(null, "CLIENTE REGISTRADO");
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR");
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

    private void btnDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDniActionPerformed
        if (btnDni.getText().equals("VER DNI")) {
            abrirArchivo("dni");
        } else {
            JFileChooser abrir = new JFileChooser();
            int ver = abrir.showOpenDialog(this);
            if (ver == JFileChooser.APPROVE_OPTION) {
                String ruta = abrir.getSelectedFile().getAbsolutePath();
                txtRutaDni.setText(ruta);
            }
        }

    }//GEN-LAST:event_btnDniActionPerformed

    private void btnBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoletaActionPerformed
        if (btnBoleta.getText().equals("VER BOLETA")) {
            abrirArchivo("boleta");
        } else {
            JFileChooser abrir = new JFileChooser();
            int ver = abrir.showOpenDialog(this);
            if (ver == JFileChooser.APPROVE_OPTION) {
                String ruta = abrir.getSelectedFile().getAbsolutePath();
                txtRutaBoleta.setText(ruta);
            }
        }
    }//GEN-LAST:event_btnBoletaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBoleta;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnDni;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JComboBox<String> cbxCiudad;
    public javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txtApMaterno;
    public javax.swing.JTextField txtApPaterno;
    public javax.swing.JTextField txtBarrio;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtDni;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtMovil;
    public com.toedter.calendar.JDateChooser txtNacimiento;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPais;
    public javax.swing.JTextField txtRutaBoleta;
    public javax.swing.JTextField txtRutaDni;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
    private void limpiar() {
        txtId.setText("");
        txtApMaterno.setText("");
        txtApPaterno.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtDni.setText("");
        txtMovil.setText("");
        txtNacimiento.setDate(null);
        txtNombre.setText("");
        txtTelefono.setText("");
        btnDni.setVisible(false);
        btnBoleta.setVisible(false);
        btnDni.setText("VERNI");
        btnBoleta.setText("VER");
    }

    private void registrarBitacora(String dni, String nombre, String ap_paterno, String ap_materno, String f_nac, String correo,
            String telefono, String movil, String direccion, String barrio, String ciudad, String estado, String date) {
        if (!txtDni.getText().equals(dni)) {
            clDao.registrarBitacora("Modificar Cliente", "DNI", dni, txtDni.getText(), Integer.parseInt(txtId.getText()), userId);
        }
        if (!txtNombre.getText().equals(nombre)) {
            clDao.registrarBitacora("Modificar Cliente", "NOMBRE", nombre, txtNombre.getText(), Integer.parseInt(txtId.getText()), userId);
        }
        if (!txtApPaterno.getText().equals(ap_paterno)) {
            clDao.registrarBitacora("Modificar Cliente", "APELLIDO PATERNO", ap_paterno, txtApPaterno.getText(), Integer.parseInt(txtId.getText()), userId);
        }
        if (!txtApMaterno.getText().equals(ap_materno)) {
            clDao.registrarBitacora("Modificar Cliente", "APELLIDO MATERNO", ap_materno, txtApMaterno.getText(), Integer.parseInt(txtId.getText()), userId);
        }
        if (!date.equals(f_nac)) {
            clDao.registrarBitacora("Modificar Cliente", "FECHA NACIMIENTO", f_nac, date, Integer.parseInt(txtId.getText()), userId);
        }
        if (!txtCorreo.getText().equals(correo)) {
            clDao.registrarBitacora("Modificar Cliente", "CORREO", correo, txtCorreo.getText(), Integer.parseInt(txtId.getText()), userId);
        }
        if (!txtTelefono.getText().equals(telefono)) {
            clDao.registrarBitacora("Modificar Cliente", "TELEFONO", telefono, txtTelefono.getText(), Integer.parseInt(txtId.getText()), userId);
        }
        if (!txtMovil.getText().equals(movil)) {
            clDao.registrarBitacora("Modificar Cliente", "MOVIL", movil, txtMovil.getText(), Integer.parseInt(txtId.getText()), userId);
        }
        if (!txtDireccion.getText().equals(direccion)) {
            clDao.registrarBitacora("Modificar Cliente", "DIRECCION", direccion, txtDireccion.getText(), Integer.parseInt(txtId.getText()), userId);
        }
        if (!txtBarrio.getText().equals(barrio)) {
            clDao.registrarBitacora("Modificar Cliente", "BARRIO", barrio, txtBarrio.getText(), Integer.parseInt(txtId.getText()), userId);
        }
        if (!cbxCiudad.getSelectedItem().toString().equals(ciudad)) {
            clDao.registrarBitacora("Modificar Cliente", "CIUDAD", ciudad, cbxCiudad.getSelectedItem().toString(), Integer.parseInt(txtId.getText()), userId);
        }
        if (!cbxEstado.getSelectedItem().toString().equals(estado)) {
            clDao.registrarBitacora("Modificar Cliente", "ESTADO", estado, cbxEstado.getSelectedItem().toString(), Integer.parseInt(txtId.getText()), userId);
        }
    }

    private void moverArchivo(String nombre) {
        Path origenPath = FileSystems.getDefault().getPath(txtRutaDni.getText());
        Path destinoPath = FileSystems.getDefault().getPath("src/main/resources/clientes/" + nombre + "/" + txtDni.getText() + ".pdf");
        System.out.println(destinoPath);
        try {
            Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private void abrirArchivo(String nombre) {
        String filePath = "src/main/resources/clientes/" + nombre + "/" + txtDni.getText() + ".pdf";
        try {
            File file = new File(filePath);
            // Comprueba si Desktop es compatible con la plataforma actual
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (file.exists()) {
                    desktop.open(file);
                } else {
                    JOptionPane.showMessageDialog(null, "El archivo no existe.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Desktop no está soportado en esta plataforma.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo.");
        }
    }

    private boolean isValidEmail(String email) {
        // Regular expression for email validation
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
