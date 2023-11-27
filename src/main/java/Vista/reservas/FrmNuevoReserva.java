package Vista.reservas;

import Eventos.SessionManager;
import Eventos.Validar;
import Modelo.Reservas;
import Modelo.ReservasDao;
import Modelo.Clientes;
import Modelo.ClientesDao;
import Modelo.DetalleReservas;
import Modelo.Ejemplares;
import Modelo.EjemplaresDao;
import Modelo.Productos;
import Modelo.ProductosDao;
import Modelo.Usuarios;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public final class FrmNuevoReserva extends javax.swing.JFrame {

    Validar vl = new Validar();
    Usuarios us = new Usuarios();
    EjemplaresDao ejDao = new EjemplaresDao();
    ProductosDao proDao = new ProductosDao();
    ClientesDao clDao = new ClientesDao();
    Reservas ar = new Reservas();
    ReservasDao arDao = new ReservasDao();
    DetalleReservas det = new DetalleReservas();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel tmpProducto = new DefaultTableModel();
    SessionManager sessionMan = SessionManager.getInstance();
    int userId = sessionMan.getUserId();
    int item;
    double totalpagar;
    Date fecha = new Date();

    public FrmNuevoReserva() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtFecha.setDate(fecha);
        txtInicio.setDate(fecha);
        txtFin.setDate(fecha);
        txtIdCliente.setVisible(false);
        txtIdArriendo.setVisible(false);
        btnComprobante.setVisible(false);
        txtUrl.setVisible(false);
        jTabbedPane1.setEnabled(false);
        us = arDao.buscarUsuario(userId);
        txtVendedor.setText(us.getNombre());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupProductos = new javax.swing.JPopupMenu();
        eliminarProducto = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtInicio = new com.toedter.calendar.JDateChooser();
        txtFin = new com.toedter.calendar.JDateChooser();
        txtDevolucion = new com.toedter.calendar.JDateChooser();
        btnClientes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tempProductos = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnProductos = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextPane();
        jLabel10 = new javax.swing.JLabel();
        txtVendedor = new javax.swing.JTextField();
        totalProducto = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtIdCliente = new javax.swing.JTextField();
        txtIdArriendo = new javax.swing.JTextField();
        btnComprobante = new javax.swing.JButton();
        txtUrl = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtOtros = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        txtBuscarProducto = new javax.swing.JTextField();
        btnArriendoPro = new javax.swing.JButton();
        txtPrecio = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtBuscarCliente = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblEjemplares = new javax.swing.JTable();
        btnArriendoEjem = new javax.swing.JButton();

        eliminarProducto.setText("ELIMINAR");
        eliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProductoActionPerformed(evt);
            }
        });
        jPopupProductos.add(eliminarProducto);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRODUCTOS");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("ARRIENDO"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("ESTADO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, -1, -1));

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente en Docs", "Pendiente en Revisión", "Aprobado", "Arrendado", "Rechazado", "Demorado", "Devuelto" }));
        cbxEstado.setEnabled(false);
        cbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 285, 35));

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, 110, 35));

        btnRegistrar.setText("GUARDAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 380, 120, 35));

        txtTotal.setEditable(false);
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 101, 35));

        jLabel5.setText("TOTAL");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        txtFecha.setEnabled(false);
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 58, 214, 35));

        jLabel3.setText("FECHA RESERVA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 30, 106, -1));

        jLabel6.setText("FECHA INICIO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 30, -1, -1));

        jLabel7.setText("FECHA FIN");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 30, -1, -1));

        jLabel8.setText("FECHA DEVOLUCIÓN");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 24, -1, -1));
        jPanel1.add(txtInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 64, 180, 35));
        jPanel1.add(txtFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 64, 180, 35));

        txtDevolucion.setEnabled(false);
        jPanel1.add(txtDevolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 58, 148, 35));

        btnClientes.setText("CLIENTE");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        jPanel1.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, 148, 35));

        tempProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRODUCTO", "EJEMPLAR", "PRECIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tempProductos.setComponentPopupMenu(jPopupProductos);
        tempProductos.setRowHeight(25);
        jScrollPane1.setViewportView(tempProductos);
        if (tempProductos.getColumnModel().getColumnCount() > 0) {
            tempProductos.getColumnModel().getColumn(0).setMinWidth(30);
            tempProductos.getColumnModel().getColumn(0).setPreferredWidth(30);
            tempProductos.getColumnModel().getColumn(0).setMaxWidth(50);
            tempProductos.getColumnModel().getColumn(2).setMinWidth(80);
            tempProductos.getColumnModel().getColumn(2).setPreferredWidth(80);
            tempProductos.getColumnModel().getColumn(2).setMaxWidth(100);
            tempProductos.getColumnModel().getColumn(3).setMinWidth(80);
            tempProductos.getColumnModel().getColumn(3).setPreferredWidth(80);
            tempProductos.getColumnModel().getColumn(3).setMaxWidth(120);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 593, 151));

        jLabel9.setText("OBSERVACIONES");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, -1, -1));

        btnProductos.setText("SELECCIONAR PRODUCTOS");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        jPanel1.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 214, 35));

        jScrollPane3.setViewportView(txtObservaciones);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 310, 74));

        jLabel10.setText("VENDEDOR");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 76, -1));

        txtVendedor.setEditable(false);
        txtVendedor.setText("NOMBRE DEL USUARIO");
        jPanel1.add(txtVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, 260, 35));

        totalProducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalProducto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalProducto.setText("0.00");
        jPanel1.add(totalProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 150, -1));

        txtCliente.setEditable(false);
        jPanel1.add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 260, 35));
        jPanel1.add(txtIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 71, -1, -1));
        jPanel1.add(txtIdArriendo, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 44, -1, -1));

        btnComprobante.setText("Comprobante de pago");
        btnComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprobanteActionPerformed(evt);
            }
        });
        jPanel1.add(btnComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 430, 160, 35));
        jPanel1.add(txtUrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 254, -1));

        jLabel1.setText("Otros");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));
        jPanel1.add(txtOtros, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 170, 35));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRODUCTO", "STOCK", "PRECIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.setRowHeight(35);
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblProductos);
        if (tblProductos.getColumnModel().getColumnCount() > 0) {
            tblProductos.getColumnModel().getColumn(0).setMinWidth(100);
            tblProductos.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblProductos.getColumnModel().getColumn(0).setMaxWidth(150);
        }

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 910, 430));

        txtBuscarProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSCAR PRODUCTO"));
        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyReleased(evt);
            }
        });
        jPanel3.add(txtBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 19, 396, 51));

        btnArriendoPro.setText("ARRIENDO");
        btnArriendoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArriendoProActionPerformed(evt);
            }
        });
        jPanel3.add(btnArriendoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 27, 191, 43));
        jPanel3.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, -1));

        jTabbedPane1.addTab("tab2", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "TELEFONO", "DIRECCION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.setRowHeight(25);
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblClientes);

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 900, 440));

        txtBuscarCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSCAR CLIENTE"));
        txtBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarClienteKeyReleased(evt);
            }
        });
        jPanel4.add(txtBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 19, 396, 51));

        jTabbedPane1.addTab("tab3", jPanel4);

        tblEjemplares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEjemplares.setRowHeight(25);
        tblEjemplares.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEjemplaresMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblEjemplares);

        btnArriendoEjem.setText("ARRIENDO");
        btnArriendoEjem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArriendoEjemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnArriendoEjem, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(740, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(9, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnArriendoEjem, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(471, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(99, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(10, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab4", jPanel5);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 6, 950, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtIdCliente.getText().isEmpty()
                || txtTotal.getText().isEmpty()
                || txtFecha.getDate() == null
                || txtInicio.getDate() == null || txtFin.getDate() == null) {
            JOptionPane.showMessageDialog(null, "TODO LOS CAMPOS SON REQUERIDOS");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ar.setFecha(sdf.format(txtFecha.getDate()));
            ar.setF_inicio(sdf.format(txtInicio.getDate()));
            ar.setF_fin(sdf.format(txtFin.getDate()));
            ar.setF_devolucion(sdf.format(txtFin.getDate()));
            ar.setTotal(Double.parseDouble(txtTotal.getText()));
            double otroMonto = 0;
            if(!txtOtros.getText().isEmpty()){
                otroMonto = Double.parseDouble(txtOtros.getText());
            }
            ar.setOtros(otroMonto);
            ar.setObservaciones(txtObservaciones.getText());
            ar.setEstado(cbxEstado.getSelectedItem().toString());
            ar.setId_cliente(Integer.parseInt(txtIdCliente.getText()));
            ar.setId_usuario(userId);
            if (txtIdArriendo.getText().equals("")) {
                int id = arDao.registrar(ar);
                if (id > 0) {
                    //registrar detalles
                    det.setId_arriendo(id);
                    for (int i = 0; i < tempProductos.getRowCount(); i++) {
                        int id_ejemplar = Integer.parseInt(tempProductos.getValueAt(i, 0).toString());
                        //arDao.actualizarEjemplar("estado", "No Disponible", id_ejemplar);
                        det.setPrecio(Double.parseDouble(tempProductos.getValueAt(i, 3).toString()));
                        det.setCantidad(Integer.parseInt(tempProductos.getValueAt(i, 2).toString()));
                        det.setInicio(sdf.format(txtInicio.getDate()));
                        det.setFin(sdf.format(txtFin.getDate()));
                        det.setId_ejemplar(id_ejemplar);
                        arDao.registrarDetalle(det);
                    }
                    arDao.registrarBitacora("Registro de Nuevo Reserva", "", "", "", id, userId);
                    JOptionPane.showMessageDialog(null, "RESERVADO");
                    arDao.reporteReserva(id);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR AL RESERVAR");
                }

            } else {
                ar.setId(Integer.parseInt(txtIdArriendo.getText()));
                String fecha_a = vl.verificarCampo("reservas", "fecha", Integer.parseInt(txtIdArriendo.getText()));
                String incio = vl.verificarCampo("reservas", "f_inicio", Integer.parseInt(txtIdArriendo.getText()));
                String fin = vl.verificarCampo("reservas", "f_fin", Integer.parseInt(txtIdArriendo.getText()));
                String devolucion = vl.verificarCampo("reservas", "f_devolucion", Integer.parseInt(txtIdArriendo.getText()));
                String obs = vl.verificarCampo("reservas", "obs", Integer.parseInt(txtIdArriendo.getText()));
                String estado = vl.verificarCampo("reservas", "estado", Integer.parseInt(txtIdArriendo.getText()));
                String id_cliente = vl.verificarCampo("reservas", "id_cliente", Integer.parseInt(txtIdArriendo.getText()));
                String total = vl.verificarCampo("reservas", "total", Integer.parseInt(txtIdArriendo.getText()));
                String otros = vl.verificarCampo("reservas", "otros", Integer.parseInt(txtIdArriendo.getText()));
                if (arDao.modificar(ar)) {
                    registrarBitacora(fecha_a, incio, fin, devolucion, id_cliente, obs, estado, total, otros);
                    //actualizar detalles
                    det.setId_arriendo(Integer.parseInt(txtIdArriendo.getText()));
                    arDao.eliminarDetalle("arriendoproductos", Integer.parseInt(txtIdArriendo.getText()));
                    for (int i = 0; i < tempProductos.getRowCount(); i++) {
                        int id_ejemplar = Integer.parseInt(tempProductos.getValueAt(i, 0).toString());
                        //arDao.actualizarEjemplar("estado", "No Disponible", id_ejemplar);
                        det.setPrecio(Double.parseDouble(tempProductos.getValueAt(i, 3).toString()));
                        det.setCantidad(Integer.parseInt(tempProductos.getValueAt(i, 2).toString()));
                        det.setInicio(sdf.format(txtInicio.getDate()));
                        det.setFin(sdf.format(txtFin.getDate()));
                        det.setId_ejemplar(id_ejemplar);
                        arDao.registrarDetalle(det);
                    }
                    if (!txtUrl.getText().equals("")) {
                        arDao.registrarBitacora("Comprobante", "Estado", "Pendiente Docs", "Pendiente en Revisión", Integer.parseInt(txtIdArriendo.getText()), userId);
                        arDao.actualizarEstado("estado", "Pendiente en Revisión", Integer.parseInt(txtIdArriendo.getText()));
                        moverArchivo("comprobante");
                    }
                    FrmMenuReserva menu = new FrmMenuReserva();
                    menu.setVisible(true);
                    dispose();
                    JOptionPane.showMessageDialog(null, "ARRIENDO MODIFICADO");
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR");
                }
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        if (txtInicio.getDate() != null && txtFin.getDate() != null) {
            jTabbedPane1.setSelectedIndex(1);
            LimpiarTable();
            listarProductos("Aprobado", "");
        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONA FECHA INICIO Y FIN");
        }

    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        jTabbedPane1.setSelectedIndex(2);
        LimpiarTable();
        listarClientes("Aprobado", "");
    }//GEN-LAST:event_btnClientesActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        if (tblClientes.getSelectedRow() >= 0) {
            int id = Integer.parseInt(tblClientes.getValueAt(tblClientes.getSelectedRow(), 0).toString());
            String nombre = tblClientes.getValueAt(tblClientes.getSelectedRow(), 1).toString();
            txtCliente.setText(nombre);
            txtIdCliente.setText("" + id);
            jTabbedPane1.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONA UNA FILA");
        }
    }//GEN-LAST:event_tblClientesMouseClicked

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        if (tblProductos.getSelectedRow() >= 0) {
            int id = Integer.parseInt(tblProductos.getValueAt(tblProductos.getSelectedRow(), 0).toString());
            txtPrecio.setText(tblProductos.getValueAt(tblProductos.getSelectedRow(), 3).toString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String inicio = sdf.format(txtInicio.getDate());
            String fin = sdf.format(txtFin.getDate());
            LimpiarTable();
            listarEjemplares(inicio, fin, id);
            jTabbedPane1.setSelectedIndex(3);
        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONA UN PRODUCTO");
        }
    }//GEN-LAST:event_tblProductosMouseClicked

    private void eliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProductoActionPerformed
        if (tempProductos.getSelectedRow() >= 0) {
            tmpProducto = (DefaultTableModel) tempProductos.getModel();
            tmpProducto.removeRow(tempProductos.getSelectedRow());
            calcularTotal(tempProductos, totalProducto);
        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONA UNA FILA");
        }
    }//GEN-LAST:event_eliminarProductoActionPerformed

    private void btnArriendoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArriendoProActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnArriendoProActionPerformed

    private void btnComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprobanteActionPerformed
        if (btnComprobante.getText().equals("VER COMPROBANTE")) {
            abrirArchivo("comprobante");
        } else {
            JFileChooser abrir = new JFileChooser();
            int ver = abrir.showOpenDialog(this);
            if (ver == JFileChooser.APPROVE_OPTION) {
                String ruta = abrir.getSelectedFile().getAbsolutePath();
                txtUrl.setText(ruta);
            }
        }

    }//GEN-LAST:event_btnComprobanteActionPerformed

    private void tblEjemplaresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEjemplaresMouseClicked
        if (tblEjemplares.getSelectedRow() >= 0) {
            int id = Integer.parseInt(tblEjemplares.getValueAt(tblEjemplares.getSelectedRow(), 0).toString());
            String nombre = tblEjemplares.getValueAt(tblEjemplares.getSelectedRow(), 1).toString();
            String precio = txtPrecio.getText();
            int stock = 1;
            agregarProducto(id, nombre, stock, precio);
            calcularTotal(tempProductos, totalProducto);
        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONA UN PRODUCTO");
        }
    }//GEN-LAST:event_tblEjemplaresMouseClicked

    private void btnArriendoEjemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArriendoEjemActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnArriendoEjemActionPerformed

    private void txtBuscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClienteKeyReleased
        LimpiarTable();
        listarClientes("Aprobado", txtBuscarCliente.getText());
    }//GEN-LAST:event_txtBuscarClienteKeyReleased

    private void txtBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyReleased
        LimpiarTable();
        listarProductos("Aprobado", txtBuscarProducto.getText());
    }//GEN-LAST:event_txtBuscarProductoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArriendoEjem;
    private javax.swing.JButton btnArriendoPro;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnClientes;
    public javax.swing.JButton btnComprobante;
    public javax.swing.JButton btnProductos;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JMenuItem eliminarProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupProductos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblEjemplares;
    private javax.swing.JTable tblProductos;
    public javax.swing.JTable tempProductos;
    public javax.swing.JLabel totalProducto;
    private javax.swing.JTextField txtBuscarCliente;
    private javax.swing.JTextField txtBuscarProducto;
    public javax.swing.JTextField txtCliente;
    public com.toedter.calendar.JDateChooser txtDevolucion;
    public com.toedter.calendar.JDateChooser txtFecha;
    public com.toedter.calendar.JDateChooser txtFin;
    public javax.swing.JTextField txtIdArriendo;
    public javax.swing.JTextField txtIdCliente;
    public com.toedter.calendar.JDateChooser txtInicio;
    public javax.swing.JTextPane txtObservaciones;
    public javax.swing.JTextField txtOtros;
    private javax.swing.JTextField txtPrecio;
    public javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUrl;
    public javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables

    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void listarProductos(String estado, String valorBusqueda) {
        List<Productos> lista = proDao.listar(estado, valorBusqueda);
        modelo = (DefaultTableModel) tblProductos.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            int stock = ejDao.totalProductos(String.valueOf(lista.get(i).getId()));
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre();
            ob[2] = stock;
            ob[3] = lista.get(i).getPrecio();
            ob[4] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        tblProductos.setModel(modelo);
    }

    public void listarEjemplares(String inicio, String fin, int id_producto) {
        List<Ejemplares> lista = arDao.getReservas(inicio, fin, id_producto);
        modelo = (DefaultTableModel) tblEjemplares.getModel();
        Object[] ob = new Object[3];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        tblEjemplares.setModel(modelo);
    }

    public void listarClientes(String estado, String valorBusqueda) {
        List<Clientes> lista = clDao.listar(estado, valorBusqueda);
        modelo = (DefaultTableModel) tblClientes.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre() + " " + lista.get(i).getAp_paterno() + " " + lista.get(i).getAp_materno();
            ob[2] = lista.get(i).getTelefono();
            ob[3] = lista.get(i).getDireccion();
            modelo.addRow(ob);
        }
        tblClientes.setModel(modelo);
    }

    private void agregarProducto(int id, String nombre, int stock, String precio) {
        item = item + 1;
        tmpProducto = (DefaultTableModel) tempProductos.getModel();
        for (int i = 0; i < tempProductos.getRowCount(); i++) {
            if (tempProductos.getValueAt(i, 0).equals(id)) {
                return;
            }
        }
        ArrayList lista = new ArrayList();
        lista.add(item);
        lista.add(id);
        lista.add(nombre);
        lista.add(stock);
        lista.add(precio);
        Object[] O = new Object[4];
        O[0] = lista.get(1);
        O[1] = lista.get(2);
        O[2] = lista.get(3);
        O[3] = lista.get(4);

        tmpProducto.addRow(O);
        tempProductos.setModel(tmpProducto);
    }

    private void calcularTotal(JTable nombre, JLabel label) {
        totalpagar = 0.00;
        int numFila = nombre.getRowCount();
        for (int i = 0; i < numFila; i++) {
            double cal = Double.parseDouble(String.valueOf(nombre.getModel().getValueAt(i, 3)));
            totalpagar = totalpagar + cal;
        }
        label.setText(String.format("%.2f", totalpagar));
        double totalPro = totalProducto.getText().equals("") ? 0 : Double.parseDouble(totalProducto.getText());
        txtTotal.setText("" + (totalPro));
    }

    private void moverArchivo(String nombre) {
        Path origenPath = FileSystems.getDefault().getPath(txtUrl.getText());
        Path destinoPath = FileSystems.getDefault().getPath("src/main/resources/reservas/" + nombre + "/" + txtIdArriendo.getText() + ".pdf");
        System.out.println(destinoPath);
        try {
            Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private void abrirArchivo(String nombre) {
        String filePath = "src/main/resources/reservas/" + nombre + "/" + txtIdArriendo.getText() + ".pdf";

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

    private void registrarBitacora(String fecha, String inicio,
            String fin, String devolucion, String id_cliente, String obs, String estado, String total, String otros) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fecha1 = sdf.format(txtFecha.getDate());
        String inicio1 = sdf.format(txtInicio.getDate());
        String fin1 = sdf.format(txtFin.getDate());
        String devolucion1 = sdf.format(txtDevolucion.getDate());
        if (!fecha.equals(fecha1)) {
            arDao.registrarBitacora("Modificar Arriendo", "FECHA", fecha, fecha1, Integer.parseInt(txtIdArriendo.getText()), userId);
        }
        if (!inicio.equals(inicio1)) {
            arDao.registrarBitacora("Modificar Arriendo", "FECHA INICIO", inicio, inicio1, Integer.parseInt(txtIdArriendo.getText()), userId);
        }
        if (!fin.equals(fin1)) {
            arDao.registrarBitacora("Modificar Arriendo", "FECHA FIN", fin, fin1, Integer.parseInt(txtIdArriendo.getText()), userId);
        }
        if (!devolucion.equals(devolucion1)) {
            arDao.registrarBitacora("Modificar Arriendo", "FECHA DEVOLUCIÓN", devolucion, devolucion1, Integer.parseInt(txtIdArriendo.getText()), userId);
        }
        if (!id_cliente.equals(txtIdCliente.getText())) {
            arDao.registrarBitacora("Modificar Arriendo", "ID CLIENTE", id_cliente, txtIdCliente.getText(), Integer.parseInt(txtIdArriendo.getText()), userId);
        }
        if (!total.equals(txtTotal.getText())) {
            arDao.registrarBitacora("Modificar Arriendo", "TOTAL", total, txtTotal.getText(), Integer.parseInt(txtIdArriendo.getText()), userId);
        }
        if (!otros.equals(txtOtros.getText())) {
            arDao.registrarBitacora("Modificar Arriendo", "OTROS", otros, txtOtros.getText(), Integer.parseInt(txtIdArriendo.getText()), userId);
        }
        if (!txtObservaciones.getText().equals(obs)) {
            arDao.registrarBitacora("Modificar Arriendo", "OBSERVACIONES", obs, txtObservaciones.getText(), Integer.parseInt(txtIdArriendo.getText()), userId);
        }
        if (!cbxEstado.getSelectedItem().toString().equals(estado)) {
            arDao.registrarBitacora("Modificar Arriendo", "ESTADO", estado, cbxEstado.getSelectedItem().toString(), Integer.parseInt(txtIdArriendo.getText()), userId);
        }
    }
}
