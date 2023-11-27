package Vista.productos;

import Eventos.SessionManager;
import Modelo.Productos;
import Modelo.ProductosDao;
import Eventos.Validar;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class FrmNuevoProducto extends javax.swing.JFrame {

    Validar vl = new Validar();
    Productos pro = new Productos();
    ProductosDao proDao = new ProductosDao();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel tmp = new DefaultTableModel();
    
    SessionManager sessionMan = SessionManager.getInstance();
    int userId = sessionMan.getUserId();

    public FrmNuevoProducto() {
        initComponents();
        this.setLocationRelativeTo(null);
        btnFicha.setVisible(false);
        btnRegistrar.setEnabled(true);
        txtId.setVisible(false);
        txtRutaFicha.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        txtId = new javax.swing.JTextField();
        btnFicha = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        txtRutaFicha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRODUCTOS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("NOMBRE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 35, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 57, 220, 35));

        jLabel2.setText("DESCRIPCIÓN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jScrollPane1.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 400, 60));

        jLabel3.setText("PRECIO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 101, 35));

        jLabel4.setText("ESTADO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente de documentación", "Pendiente de verificación", "Aprobado", "Rechazado" }));
        cbxEstado.setEnabled(false);
        jPanel1.add(cbxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 210, 35));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 73, -1));

        btnFicha.setText("FICHA TÉCNICA");
        btnFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFichaActionPerformed(evt);
            }
        });
        jPanel1.add(btnFicha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 210, 35));

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 130, 35));

        btnRegistrar.setText("GUARDAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 130, 35));
        jPanel1.add(txtRutaFicha, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 40, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 17, 440, 430));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (!txtNombre.getText().equals("") && !txtDescripcion.getText().equals("")
                && !txtPrecio.getText().equals("") && !cbxEstado.getSelectedItem().equals("")) {
            pro.setNombre(txtNombre.getText());
            pro.setDescripcion(txtDescripcion.getText());
            pro.setPrecio(Double.parseDouble(txtPrecio.getText()));
            pro.setStock(0);
            pro.setEstado(cbxEstado.getSelectedItem().toString());
            if (txtId.getText().length() > 0) {
                pro.setId(Integer.parseInt(txtId.getText()));
                String nombre = vl.verificarCampo("productos", "nombre", Integer.parseInt(txtId.getText()));
                String descripcion = vl.verificarCampo("productos", "descripcion", Integer.parseInt(txtId.getText()));
                String precio = vl.verificarCampo("productos", "precio", Integer.parseInt(txtId.getText()));
                String estado = vl.verificarCampo("productos", "estado", Integer.parseInt(txtId.getText()));
                if (proDao.modificar(pro)) {
                    //comprobar ruta
                    if (!txtRutaFicha.getText().equals("")) {
                        proDao.registrarBitacora("Estado", "ficha_tecnica", "Pendiente de documentación", "Pendiente de verificación", Integer.parseInt(txtId.getText()), userId);
                        proDao.actualizarEstado("estado", "Pendiente de verificación", Integer.parseInt(txtId.getText()));
                        proDao.actualizarEstado("ficha_tecnica", "ficha", Integer.parseInt(txtId.getText()));
                        moverArchivo("ficha");
                    }
                    registrarBitacora(nombre, descripcion, precio, estado);
                    FrmMenuProductos menu = new FrmMenuProductos();
                    menu.setVisible(true);
                    dispose();
                    JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO");
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR PRODUCTO");
                }
            } else {
                int id = proDao.registrar(pro);
                if (id > 0) {
                    proDao.registrarBitacora("Registro de Nuevo Producto", "", "", "", id, userId);
                    limpiarProducto();
                    dispose();
                    JOptionPane.showMessageDialog(null, "PRODUCTO REGISTRADO");
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR PRODUCTO");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "TODO LOS CAMPOS SON REQUERIDOS");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFichaActionPerformed
        if (btnFicha.getText().equals("VER FICHA")) {
            abrirArchivo("ficha");
        } else {
            JFileChooser abrir = new JFileChooser();
            int ver = abrir.showOpenDialog(this);
            if (ver == JFileChooser.APPROVE_OPTION) {
                String ruta = abrir.getSelectedFile().getAbsolutePath();
                txtRutaFicha.setText(ruta);
            }
        }
    }//GEN-LAST:event_btnFichaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnFicha;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextPane txtDescripcion;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRutaFicha;
    // End of variables declaration//GEN-END:variables

    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    private void limpiarProducto() {
        txtId.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        for (int i = 0; i < tmp.getRowCount(); i++) {
            tmp.removeRow(i);
            i = i - 1;
        }
    }

    private void registrarBitacora(String nombre, String descripcion, String precio, String estado) {
        if (!txtNombre.getText().equals(nombre)) {
            proDao.registrarBitacora("Modificar Producto", "NOMBRE", nombre, txtNombre.getText(), Integer.parseInt(txtId.getText()), userId);
        }
        if (!txtDescripcion.getText().equals(descripcion)) {
            proDao.registrarBitacora("Modificar Producto", "DESCRIPCION", descripcion, txtDescripcion.getText(), Integer.parseInt(txtId.getText()), userId);
        }
        if (!txtPrecio.getText().equals(precio)) {
            proDao.registrarBitacora("Modificar Producto", "PRECIO", precio, txtPrecio.getText(), Integer.parseInt(txtId.getText()), userId);
        }
        if (!cbxEstado.getSelectedItem().toString().equals(estado)) {
            proDao.registrarBitacora("Modificar Producto", "ESTADO", estado, cbxEstado.getSelectedItem().toString(), Integer.parseInt(txtId.getText()), userId);
        }
    }

    private void moverArchivo(String nombre) {
        Path origenPath = FileSystems.getDefault().getPath(txtRutaFicha.getText());
        Path destinoPath = FileSystems.getDefault().getPath("src/main/resources/productos/" + nombre + "/" + txtId.getText() + ".pdf");
        System.out.println(destinoPath);
        try {
            Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private void abrirArchivo(String nombre) {
        String filePath = "src/main/resources/productos/" + nombre + "/" + txtId.getText() + ".pdf";

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
}
