package Vista.usuarios;

import Vista.clientes.*;
import Modelo.Clientes;
import Modelo.ClientesDao;
import Modelo.Usuarios;
import Modelo.UsuariosDao;
import Vista.arriendos.FrmMenuArriendo;
import Vista.informes.FrmInformes;
import Vista.reservas.FrmMenuReserva;
import Vista.productos.FrmMenuProductos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class FrmMantenerUsuario extends javax.swing.JFrame {

    Usuarios us = new Usuarios();
    UsuariosDao usDao = new UsuariosDao();
    DefaultTableModel modelo = new DefaultTableModel();
    FrmNuevoUsuario frm = new FrmNuevoUsuario();

    public FrmMantenerUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        listarClientes("", "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupUsuarios = new javax.swing.JPopupMenu();
        ClModificar = new javax.swing.JMenuItem();
        ClVer = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btnMenuCliente = new javax.swing.JButton();
        btnMenuProducto = new javax.swing.JButton();
        btnMenuReserva = new javax.swing.JButton();
        btnMenuArriendo = new javax.swing.JButton();
        btnMenuInforme = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMantenerUsuarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtBuscarUsuario = new javax.swing.JTextField();

        ClModificar.setText("MODIFICAR");
        ClModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClModificarActionPerformed(evt);
            }
        });
        jPopupUsuarios.add(ClModificar);

        ClVer.setText("VER");
        ClVer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClVerActionPerformed(evt);
            }
        });
        jPopupUsuarios.add(ClVer);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnMenuCliente.setText("CLIENTES");
        btnMenuCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuCliente.setFocusable(false);
        btnMenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuClienteActionPerformed(evt);
            }
        });

        btnMenuProducto.setText("PRODUCTOS");
        btnMenuProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuProducto.setFocusable(false);
        btnMenuProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuProductoActionPerformed(evt);
            }
        });

        btnMenuReserva.setText("RESERVAS");
        btnMenuReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuReserva.setFocusable(false);
        btnMenuReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuReservaActionPerformed(evt);
            }
        });

        btnMenuArriendo.setText("ARRIENDOS");
        btnMenuArriendo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuArriendo.setFocusable(false);
        btnMenuArriendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuArriendoActionPerformed(evt);
            }
        });

        btnMenuInforme.setText("INFORMES");
        btnMenuInforme.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuInforme.setFocusable(false);
        btnMenuInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuInformeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMenuInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuArriendo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnMenuCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnMenuProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(btnMenuReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(btnMenuArriendo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(btnMenuInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        tblMantenerUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "USUARIO", "NOMBRE", "DIRECCIÓN", "TELEFONO", "CORREO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMantenerUsuarios.setComponentPopupMenu(jPopupUsuarios);
        jScrollPane1.setViewportView(tblMantenerUsuarios);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtBuscarUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCAR USUARIO"));
        txtBuscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarUsuarioKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(543, Short.MAX_VALUE)
                .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuClienteActionPerformed
        FrmMenuUsuario menuCliente = new FrmMenuUsuario();
        menuCliente.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMenuClienteActionPerformed

    private void ClModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClModificarActionPerformed
        if (tblMantenerUsuarios.getSelectedRow() >= 0) {
            mostrarUsuario();
            frm.setVisible(true);
            frm.btnRegistrar.setEnabled(true);
            dispose();
        }

    }//GEN-LAST:event_ClModificarActionPerformed

    private void ClVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClVerActionPerformed
        if (tblMantenerUsuarios.getSelectedRow() >= 0) {
            mostrarUsuario();
            frm.setVisible(true);
            frm.btnRegistrar.setEnabled(false);
            dispose();
        }
    }//GEN-LAST:event_ClVerActionPerformed

    private void txtBuscarUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarUsuarioKeyReleased
        LimpiarTable();
        listarClientes("1", txtBuscarUsuario.getText());
    }//GEN-LAST:event_txtBuscarUsuarioKeyReleased

    private void btnMenuProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuProductoActionPerformed
        FrmMenuProductos menu = new FrmMenuProductos();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMenuProductoActionPerformed

    private void btnMenuReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuReservaActionPerformed
        FrmMenuReserva menu = new FrmMenuReserva();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMenuReservaActionPerformed

    private void btnMenuArriendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuArriendoActionPerformed
        FrmMenuArriendo menu = new FrmMenuArriendo();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMenuArriendoActionPerformed

    private void btnMenuInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuInformeActionPerformed
        FrmInformes menu = new FrmInformes();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMenuInformeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ClModificar;
    private javax.swing.JMenuItem ClVer;
    private javax.swing.JButton btnMenuArriendo;
    private javax.swing.JButton btnMenuCliente;
    private javax.swing.JButton btnMenuInforme;
    private javax.swing.JButton btnMenuProducto;
    private javax.swing.JButton btnMenuReserva;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupUsuarios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMantenerUsuarios;
    private javax.swing.JTextField txtBuscarUsuario;
    // End of variables declaration//GEN-END:variables
    public void listarClientes(String estado, String valorBusqueda) {
        List<Usuarios> lista = usDao.listar(estado, valorBusqueda);
        modelo = (DefaultTableModel) tblMantenerUsuarios.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getUsuario();
            ob[2] = lista.get(i).getNombre() + " " + lista.get(i).getAp_paterno() + " " + lista.get(i).getAp_materno();
            ob[3] = lista.get(i).getDireccion();
            ob[4] = lista.get(i).getTelefono();
            ob[5] = lista.get(i).getCorreo();
            modelo.addRow(ob);
        }
        tblMantenerUsuarios.setModel(modelo);
    }

    private void mostrarUsuario() {
        String id = tblMantenerUsuarios.getValueAt(tblMantenerUsuarios.getSelectedRow(), 0).toString();
        us = usDao.buscarUsuario(id);
        frm.txtId.setText("" + us.getId());
        frm.txtNombre.setText(us.getNombre());
        frm.txtApMaterno.setText(us.getAp_materno());
        frm.txtApPaterno.setText(us.getAp_paterno());
        frm.txtCorreo.setText(us.getCorreo());
        frm.txtDireccion.setText(us.getDireccion());
        frm.txtUsuario.setText(us.getUsuario());
        frm.txtTelefono.setText(us.getTelefono());
        frm.setVisible(true);
        dispose();
    }

    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
}
