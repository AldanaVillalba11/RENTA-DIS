package Vista.productos;

import Eventos.SessionManager;
import Eventos.Validar;
import Modelo.Ejemplares;
import Modelo.EjemplaresDao;
import Modelo.Productos;
import Modelo.ProductosDao;
import Vista.arriendos.FrmMenuArriendo;
import Vista.clientes.FrmBitacoraCliente;
import Vista.clientes.FrmMenuCliente;
import Vista.ejemplares.FrmBitacoraEjemplares;
import Vista.informes.FrmInformes;
import Vista.reservas.FrmMenuReserva;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class FrmMantenerProducto extends javax.swing.JFrame {

    Validar vl = new Validar();
    Ejemplares ej = new Ejemplares();
    EjemplaresDao ejDao = new EjemplaresDao();

    Productos pro = new Productos();
    ProductosDao proDao = new ProductosDao();
    DefaultTableModel modelo = new DefaultTableModel();
    FrmNuevoProducto frm = new FrmNuevoProducto();
    SessionManager sessionMan = SessionManager.getInstance();
    int userId = sessionMan.getUserId();

    public FrmMantenerProducto() {
        initComponents();
        this.setLocationRelativeTo(null);
        listarProductos("", "");
        txtIdproducto.setVisible(false);
        txtIdEjemplar.setVisible(false);
        jTabbedPane1.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupProdutos = new javax.swing.JPopupMenu();
        menuVer = new javax.swing.JMenuItem();
        menuModificar = new javax.swing.JMenuItem();
        menuVerificar = new javax.swing.JMenuItem();
        menuEjemplares = new javax.swing.JMenuItem();
        menuBitacora = new javax.swing.JMenuItem();
        buttonGroupProductos = new javax.swing.ButtonGroup();
        jPopupEjemplares = new javax.swing.JPopupMenu();
        bitacoraEjemp = new javax.swing.JMenuItem();
        buttonGroupEjemplares = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        menuClientes = new javax.swing.JButton();
        menuProductos = new javax.swing.JButton();
        menuReservas = new javax.swing.JButton();
        menuArriendos = new javax.swing.JButton();
        menuInformes = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pendVerify = new javax.swing.JRadioButton();
        todos = new javax.swing.JRadioButton();
        rechazados = new javax.swing.JRadioButton();
        aprobados = new javax.swing.JRadioButton();
        pendDocs = new javax.swing.JRadioButton();
        txtBuscarProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMantenerProductos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        cbxGeo = new javax.swing.JComboBox<>();
        txtIdproducto = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreEjem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxEstadoEjem = new javax.swing.JComboBox<>();
        btnGuardarEjem = new javax.swing.JButton();
        btnCancelEjem = new javax.swing.JButton();
        cbxGeoEjem = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEjemplares = new javax.swing.JTable();
        txtBuscarEjemplar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        txtIdEjemplar = new javax.swing.JTextField();
        nodisponible = new javax.swing.JRadioButton();
        baja = new javax.swing.JRadioButton();
        reparacion = new javax.swing.JRadioButton();
        arrendado = new javax.swing.JRadioButton();
        disponible = new javax.swing.JRadioButton();
        todos1 = new javax.swing.JRadioButton();
        lavado = new javax.swing.JRadioButton();

        menuVer.setText("VER");
        menuVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVerActionPerformed(evt);
            }
        });
        jPopupProdutos.add(menuVer);

        menuModificar.setText("MODIFICAR");
        menuModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarActionPerformed(evt);
            }
        });
        jPopupProdutos.add(menuModificar);

        menuVerificar.setText("VERIFICAR");
        menuVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVerificarActionPerformed(evt);
            }
        });
        jPopupProdutos.add(menuVerificar);

        menuEjemplares.setText("EJEMPLARES");
        menuEjemplares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEjemplaresActionPerformed(evt);
            }
        });
        jPopupProdutos.add(menuEjemplares);

        menuBitacora.setText("BITACORA");
        menuBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBitacoraActionPerformed(evt);
            }
        });
        jPopupProdutos.add(menuBitacora);

        bitacoraEjemp.setText("Bitacora");
        bitacoraEjemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bitacoraEjempActionPerformed(evt);
            }
        });
        jPopupEjemplares.add(bitacoraEjemp);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        menuClientes.setText("CLIENTES");
        menuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClientesActionPerformed(evt);
            }
        });

        menuProductos.setText("PRODUCTOS");
        menuProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProductosActionPerformed(evt);
            }
        });

        menuReservas.setText("RESERVAS");
        menuReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReservasActionPerformed(evt);
            }
        });

        menuArriendos.setText("ARRIENDOS");
        menuArriendos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArriendosActionPerformed(evt);
            }
        });

        menuInformes.setText("INFORMES");
        menuInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInformesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuArriendos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(menuClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(menuProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(menuReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(menuArriendos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(menuInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroupProductos.add(pendVerify);
        pendVerify.setText("PENDIENTE DE VERIFICACIÓN");
        pendVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendVerifyActionPerformed(evt);
            }
        });

        buttonGroupProductos.add(todos);
        todos.setText("TODOS");
        todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todosActionPerformed(evt);
            }
        });

        buttonGroupProductos.add(rechazados);
        rechazados.setText("RECHAZADOS");
        rechazados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechazadosActionPerformed(evt);
            }
        });

        buttonGroupProductos.add(aprobados);
        aprobados.setText("APROBADOS");
        aprobados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aprobadosActionPerformed(evt);
            }
        });

        buttonGroupProductos.add(pendDocs);
        pendDocs.setText("PENDIENTE DE DOCS");
        pendDocs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendDocsActionPerformed(evt);
            }
        });

        txtBuscarProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSCAR PRODUCTO"));
        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(todos)
                    .addComponent(pendVerify))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(aprobados)
                        .addGap(45, 45, 45)
                        .addComponent(pendDocs))
                    .addComponent(rechazados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(todos)
                            .addComponent(rechazados))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pendVerify)
                            .addComponent(aprobados)
                            .addComponent(pendDocs)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tblMantenerProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRODUCTO", "DESCRIPCIÓN", "PRECIO", "STOCK", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMantenerProductos.setComponentPopupMenu(jPopupProdutos);
        jScrollPane1.setViewportView(tblMantenerProductos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab1", jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("EJEMPLARES"));

        jLabel1.setText("NOMBRE");

        jLabel2.setText("GEOLOCALIZACION");

        jLabel4.setText("ESTADO");

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Lavado", "Baja", "No Disponible", "En Reparación" }));

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("GUARDAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        cbxGeo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Parchero 1", "Parchero 2", "Parchero 3", "Parchero 4", "Parchero 5", "Parchero 6", "Parchero 7", "Parchero 8", "Parchero 9", "Parchero 10" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(114, 114, 114)
                        .addComponent(txtIdproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(jLabel2)
                        .addComponent(txtNombre)
                        .addComponent(cbxGeo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxEstado, 0, 275, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(26, 26, 26)
                        .addComponent(btnRegistrar)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtIdproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cbxGeo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(310, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(269, 269, 269))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel4);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("EJEMPLARES"));

        jLabel3.setText("NOMBRE");

        jLabel6.setText("GEOLOCALIZACIÓN");

        jLabel5.setText("ESTADO");

        cbxEstadoEjem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Lavado", "Baja", "No Disponible", "En Reparación" }));

        btnGuardarEjem.setText("GUARDAR");
        btnGuardarEjem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEjemActionPerformed(evt);
            }
        });

        btnCancelEjem.setText("CANCELAR");
        btnCancelEjem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelEjemActionPerformed(evt);
            }
        });

        cbxGeoEjem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Parchero 1", "Parchero 2", "Parchero 3", "Parchero 4", "Parchero 5", "Parchero 6", "Parchero 7", "Parchero 8", "Parchero 9", "Parchero 10" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreEjem, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbxEstadoEjem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxGeoEjem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelEjem)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarEjem)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreEjem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxGeoEjem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(cbxEstadoEjem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarEjem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelEjem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblEjemplares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "GEOLOCALIZACION", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEjemplares.setComponentPopupMenu(jPopupEjemplares);
        tblEjemplares.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEjemplaresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEjemplares);

        txtBuscarEjemplar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarEjemplarKeyReleased(evt);
            }
        });

        jLabel7.setText("BUSCAR");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        buttonGroupEjemplares.add(nodisponible);
        nodisponible.setText("NO DISPONIBLE");
        nodisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nodisponibleActionPerformed(evt);
            }
        });

        buttonGroupEjemplares.add(baja);
        baja.setText("BAJA");
        baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaActionPerformed(evt);
            }
        });

        buttonGroupEjemplares.add(reparacion);
        reparacion.setText("EN REPARACIÓN");
        reparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reparacionActionPerformed(evt);
            }
        });

        buttonGroupEjemplares.add(arrendado);
        arrendado.setText("ARRENDADO");
        arrendado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrendadoActionPerformed(evt);
            }
        });

        buttonGroupEjemplares.add(disponible);
        disponible.setText("DISPONIBLE");
        disponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disponibleActionPerformed(evt);
            }
        });

        buttonGroupEjemplares.add(todos1);
        todos1.setText("TODOS");
        todos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todos1ActionPerformed(evt);
            }
        });

        buttonGroupEjemplares.add(lavado);
        lavado.setText("LAVADO");
        lavado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lavadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(txtIdEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(todos1)
                            .addComponent(lavado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(arrendado)
                            .addComponent(disponible))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(baja)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nodisponible))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reparacion)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtBuscarEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIdEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscarEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(todos1)
                                    .addComponent(disponible)
                                    .addComponent(reparacion))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lavado)
                                    .addComponent(arrendado)
                                    .addComponent(baja)
                                    .addComponent(nodisponible))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab3", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jTabbedPane1)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVerActionPerformed
        if (tblMantenerProductos.getSelectedRow() >= 0) {
            mostrarProducto();
            frm.btnRegistrar.setEnabled(false);
            frm.btnFicha.setText("VER FICHA");
        }
    }//GEN-LAST:event_menuVerActionPerformed

    private void menuModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarActionPerformed
        if (tblMantenerProductos.getSelectedRow() >= 0) {
            frm.btnRegistrar.setEnabled(true);
            mostrarProducto();
        }
    }//GEN-LAST:event_menuModificarActionPerformed

    private void menuVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVerificarActionPerformed
        if (tblMantenerProductos.getSelectedRow() >= 0) {
            String id = tblMantenerProductos.getValueAt(tblMantenerProductos.getSelectedRow(), 0).toString();
            pro = proDao.buscarProducto(id);
            String producto = pro.getNombre();
            FrmVerificarProducto frmVer = new FrmVerificarProducto(pro.getId(), producto);
            frmVer.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_menuVerificarActionPerformed

    private void menuBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBitacoraActionPerformed
        FrmBitacoraProducto frmBit = new FrmBitacoraProducto();
        frmBit.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuBitacoraActionPerformed

    private void txtBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyReleased
        String estado;
        if (pendDocs.isSelected()) {
            estado = "Pendiente de documentación";
        } else if (aprobados.isSelected()) {
            estado = "Aprobado";
        } else if (pendVerify.isSelected()) {
            estado = "Pendiente de verificación";
        } else if (rechazados.isSelected()) {
            estado = "Rechazado";
        } else {
            estado = "";
        }
        LimpiarTable();
        listarProductos(estado, txtBuscarProducto.getText());
    }//GEN-LAST:event_txtBuscarProductoKeyReleased

    private void todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todosActionPerformed
        LimpiarTable();
        listarProductos("", txtBuscarProducto.getText());
    }//GEN-LAST:event_todosActionPerformed

    private void pendVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendVerifyActionPerformed
        if (pendVerify.isSelected()) {
            LimpiarTable();
            listarProductos("Pendiente de verificación", txtBuscarProducto.getText());
        }
    }//GEN-LAST:event_pendVerifyActionPerformed

    private void pendDocsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendDocsActionPerformed
        if (pendDocs.isSelected()) {
            LimpiarTable();
            listarProductos("Pendiente de documentación", txtBuscarProducto.getText());
        }
    }//GEN-LAST:event_pendDocsActionPerformed

    private void rechazadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechazadosActionPerformed
        if (rechazados.isSelected()) {
            LimpiarTable();
            listarProductos("Rechazado", txtBuscarProducto.getText());
        }
    }//GEN-LAST:event_rechazadosActionPerformed

    private void aprobadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aprobadosActionPerformed
        if (aprobados.isSelected()) {
            LimpiarTable();
            listarProductos("Aprobado", txtBuscarProducto.getText());
        }
    }//GEN-LAST:event_aprobadosActionPerformed

    private void menuEjemplaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEjemplaresActionPerformed
        if (tblMantenerProductos.getSelectedRow() >= 0) {
            String id_producto = tblMantenerProductos.getValueAt(tblMantenerProductos.getSelectedRow(), 0).toString();
            txtIdproducto.setText(id_producto);
            LimpiarTable();
            listarEjemplar(Integer.parseInt(id_producto), txtBuscarEjemplar.getText());
            jTabbedPane1.setSelectedIndex(2);
        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONA UNA FILA");
        }
    }//GEN-LAST:event_menuEjemplaresActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (!txtNombre.getText().equals("") && !cbxGeo.getSelectedItem().equals("")
                && !cbxEstado.getSelectedItem().equals("")) {
            ej.setNombre(txtNombre.getText());
            ej.setGeolocalizacion(cbxGeo.getSelectedItem().toString());
            ej.setEstado(cbxEstado.getSelectedItem().toString());
            ej.setId_producto(Integer.parseInt(txtIdproducto.getText()));
            int id = ejDao.registrar(ej);
            if (id > 0) {
                ejDao.registrarBitacora("Nuevo Registro", "", "", "", id, 1);
                dispose();
                JOptionPane.showMessageDialog(null, "EJEMPLAR REGISTRADO");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR");
            }
        } else {
            JOptionPane.showMessageDialog(null, "TODO LOS CAMPOS SON REQUERIDOS");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void menuArriendosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArriendosActionPerformed
        FrmMenuArriendo menu = new FrmMenuArriendo();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuArriendosActionPerformed

    private void menuInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInformesActionPerformed
        FrmInformes menu = new FrmInformes();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuInformesActionPerformed

    private void menuReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReservasActionPerformed
        FrmMenuReserva menu = new FrmMenuReserva();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuReservasActionPerformed

    private void menuProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProductosActionPerformed
        FrmMenuProductos menu = new FrmMenuProductos();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuProductosActionPerformed

    private void menuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClientesActionPerformed
        FrmMenuCliente menu = new FrmMenuCliente();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuClientesActionPerformed

    private void btnCancelEjemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelEjemActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelEjemActionPerformed

    private void tblEjemplaresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEjemplaresMouseClicked
        int fila = tblEjemplares.rowAtPoint(evt.getPoint());
        txtIdEjemplar.setText(tblEjemplares.getValueAt(fila, 0).toString());
        txtNombreEjem.setText(tblEjemplares.getValueAt(fila, 1).toString());
        cbxGeoEjem.setSelectedItem(tblEjemplares.getValueAt(fila, 2).toString());
        cbxEstadoEjem.setSelectedItem(tblEjemplares.getValueAt(fila, 3).toString());
    }//GEN-LAST:event_tblEjemplaresMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarEjemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEjemActionPerformed
        if (!txtNombreEjem.getText().equals("") && !cbxGeoEjem.getSelectedItem().equals("")
                && !cbxEstadoEjem.getSelectedItem().equals("")) {
            ej.setNombre(txtNombreEjem.getText());
            ej.setGeolocalizacion(cbxGeoEjem.getSelectedItem().toString());
            ej.setEstado(cbxEstadoEjem.getSelectedItem().toString());
            ej.setId_producto(Integer.parseInt(txtIdproducto.getText()));
            ej.setId(Integer.parseInt(txtIdEjemplar.getText()));
            String nombre = vl.verificarCampo("ejemplares", "nombre", Integer.parseInt(txtIdEjemplar.getText()));
            String geolocalizacion = vl.verificarCampo("ejemplares", "geolocalizacion", Integer.parseInt(txtIdEjemplar.getText()));
            String estado = vl.verificarCampo("ejemplares", "estado", Integer.parseInt(txtIdEjemplar.getText()));
            if (ejDao.modificar(ej)) {
                registrarBitacora(nombre, geolocalizacion, estado);
                LimpiarTable();
                listarEjemplar(Integer.parseInt(txtIdproducto.getText()), txtBuscarEjemplar.getText());
                JOptionPane.showMessageDialog(null, "EJEMPLAR MODIFICADO");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR");
            }

        } else {
            JOptionPane.showMessageDialog(null, "TODO LOS CAMPOS SON REQUERIDOS");
        }
    }//GEN-LAST:event_btnGuardarEjemActionPerformed

    private void txtBuscarEjemplarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarEjemplarKeyReleased
        LimpiarTable();
        listarEjemplar(Integer.parseInt(txtIdproducto.getText()), txtBuscarEjemplar.getText());
    }//GEN-LAST:event_txtBuscarEjemplarKeyReleased

    private void nodisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nodisponibleActionPerformed
        if (nodisponible.isSelected()) {
            LimpiarTable();            
            txtBuscarEjemplar.setText("No Disponible");
            listarEjemplarEstado(Integer.parseInt(txtIdproducto.getText()), txtBuscarEjemplar.getText());
        }
    }//GEN-LAST:event_nodisponibleActionPerformed

    private void bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaActionPerformed
        if (baja.isSelected()) {
            LimpiarTable();
            txtBuscarEjemplar.setText("Baja");
            listarEjemplarEstado(Integer.parseInt(txtIdproducto.getText()), txtBuscarEjemplar.getText());
        }
    }//GEN-LAST:event_bajaActionPerformed

    private void reparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reparacionActionPerformed
        if (reparacion.isSelected()) {
            LimpiarTable();
            txtBuscarEjemplar.setText("En Reparación");            
            listarEjemplarEstado(Integer.parseInt(txtIdproducto.getText()), txtBuscarEjemplar.getText());
        }
    }//GEN-LAST:event_reparacionActionPerformed

    private void arrendadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrendadoActionPerformed
        if (arrendado.isSelected()) {
            LimpiarTable();
            txtBuscarEjemplar.setText("Arrendado");            
            listarEjemplarEstado(Integer.parseInt(txtIdproducto.getText()), txtBuscarEjemplar.getText());
        }
    }//GEN-LAST:event_arrendadoActionPerformed

    private void disponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disponibleActionPerformed
        if (disponible.isSelected()) {
            LimpiarTable();
            txtBuscarEjemplar.setText("Disponible");            
            listarEjemplarEstado(Integer.parseInt(txtIdproducto.getText()), txtBuscarEjemplar.getText());
        }
    }//GEN-LAST:event_disponibleActionPerformed

    private void todos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todos1ActionPerformed
        if (todos1.isSelected()) {
            LimpiarTable();
            txtBuscarEjemplar.setText("");            
            listarEjemplar(Integer.parseInt(txtIdproducto.getText()), txtBuscarEjemplar.getText());
        }
    }//GEN-LAST:event_todos1ActionPerformed

    private void lavadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lavadoActionPerformed
        if (lavado.isSelected()) {
            LimpiarTable();
            txtBuscarEjemplar.setText("Lavado");            
            listarEjemplarEstado(Integer.parseInt(txtIdproducto.getText()), txtBuscarEjemplar.getText());
        }
    }//GEN-LAST:event_lavadoActionPerformed

    private void bitacoraEjempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bitacoraEjempActionPerformed
        FrmBitacoraEjemplares menu = new FrmBitacoraEjemplares();
        menu.setVisible(true);
    }//GEN-LAST:event_bitacoraEjempActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton aprobados;
    private javax.swing.JRadioButton arrendado;
    private javax.swing.JRadioButton baja;
    private javax.swing.JMenuItem bitacoraEjemp;
    private javax.swing.JButton btnCancelEjem;
    public javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardarEjem;
    private javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnRegistrar;
    private javax.swing.ButtonGroup buttonGroupEjemplares;
    private javax.swing.ButtonGroup buttonGroupProductos;
    public javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxEstadoEjem;
    public javax.swing.JComboBox<String> cbxGeo;
    public javax.swing.JComboBox<String> cbxGeoEjem;
    private javax.swing.JRadioButton disponible;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupEjemplares;
    private javax.swing.JPopupMenu jPopupProdutos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton lavado;
    private javax.swing.JButton menuArriendos;
    private javax.swing.JMenuItem menuBitacora;
    private javax.swing.JButton menuClientes;
    private javax.swing.JMenuItem menuEjemplares;
    private javax.swing.JButton menuInformes;
    private javax.swing.JMenuItem menuModificar;
    private javax.swing.JButton menuProductos;
    private javax.swing.JButton menuReservas;
    private javax.swing.JMenuItem menuVer;
    private javax.swing.JMenuItem menuVerificar;
    private javax.swing.JRadioButton nodisponible;
    private javax.swing.JRadioButton pendDocs;
    private javax.swing.JRadioButton pendVerify;
    private javax.swing.JRadioButton rechazados;
    private javax.swing.JRadioButton reparacion;
    private javax.swing.JTable tblEjemplares;
    private javax.swing.JTable tblMantenerProductos;
    private javax.swing.JRadioButton todos;
    private javax.swing.JRadioButton todos1;
    private javax.swing.JTextField txtBuscarEjemplar;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtIdEjemplar;
    private javax.swing.JTextField txtIdproducto;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtNombreEjem;
    // End of variables declaration//GEN-END:variables

    public void listarProductos(String estado, String valorBusqueda) {
        List<Productos> lista = proDao.listar(estado, valorBusqueda);
        modelo = (DefaultTableModel) tblMantenerProductos.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            int stock = ejDao.totalProductos(String.valueOf(lista.get(i).getId()));
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getDescripcion();
            ob[3] = lista.get(i).getPrecio();
            ob[4] = stock;
            ob[5] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        tblMantenerProductos.setModel(modelo);
    }

    private void mostrarProducto() {
        String id = tblMantenerProductos.getValueAt(tblMantenerProductos.getSelectedRow(), 0).toString();
        pro = proDao.buscarProducto(id);
        frm.txtId.setText("" + pro.getId());
        frm.txtNombre.setText(pro.getNombre());
        frm.txtDescripcion.setText(pro.getDescripcion());
        frm.txtPrecio.setText(String.valueOf(pro.getPrecio()));
        frm.cbxEstado.setSelectedItem(pro.getEstado());
        frm.btnFicha.setVisible(true);
        frm.setVisible(true);
        dispose();
    }

    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void listarEjemplar(int id_producto, String valorBusqueda) {
        List<Ejemplares> lista = ejDao.listarEjemplar(id_producto, valorBusqueda);
        modelo = (DefaultTableModel) tblEjemplares.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getGeolocalizacion();
            ob[3] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        tblEjemplares.setModel(modelo);
    }
    
    public void listarEjemplarEstado(int id_producto, String valorBusqueda) {
        List<Ejemplares> lista = ejDao.listarEjemplarEstado(id_producto, valorBusqueda);
        modelo = (DefaultTableModel) tblEjemplares.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getGeolocalizacion();
            ob[3] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        tblEjemplares.setModel(modelo);
    }
    
    private void registrarBitacora(String nombre, String geo, String estado) {
        if (!txtNombre.getText().equals(nombre)) {
            ejDao.registrarBitacora("Modificar Ejemplar", "NOMBRE", nombre, txtNombre.getText(), Integer.parseInt(txtIdEjemplar.getText()), userId);
        }
        if (!cbxGeoEjem.getSelectedItem().equals(geo)) {
            ejDao.registrarBitacora("Modificar Ejemplar", "geolocalizacion", geo, cbxGeoEjem.getSelectedItem().toString(), Integer.parseInt(txtIdEjemplar.getText()), userId);
        }
        if (!cbxEstado.getSelectedItem().toString().equals(estado)) {
            ejDao.registrarBitacora("Modificar Ejemplar", "ESTADO", estado, cbxEstado.getSelectedItem().toString(), Integer.parseInt(txtIdEjemplar.getText()), userId);
        }
    }

}
