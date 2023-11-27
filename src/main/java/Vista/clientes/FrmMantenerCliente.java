package Vista.clientes;

import Modelo.Clientes;
import Modelo.ClientesDao;
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

public final class FrmMantenerCliente extends javax.swing.JFrame {

    Clientes cl = new Clientes();
    ClientesDao clDao = new ClientesDao();
    DefaultTableModel modelo = new DefaultTableModel();
    FrmNuevoCliente frm = new FrmNuevoCliente();

    public FrmMantenerCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        listarClientes("", "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupClientes = new javax.swing.JPopupMenu();
        ClModificar = new javax.swing.JMenuItem();
        ClVer = new javax.swing.JMenuItem();
        ClBitacora = new javax.swing.JMenuItem();
        ClVerificar = new javax.swing.JMenuItem();
        ClBloquear = new javax.swing.JMenuItem();
        ClDesBloquear = new javax.swing.JMenuItem();
        buttonClientes = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnMenuCliente = new javax.swing.JButton();
        btnMenuProducto = new javax.swing.JButton();
        btnMenuReserva = new javax.swing.JButton();
        btnMenuArriendo = new javax.swing.JButton();
        btnMenuInforme = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMantenerClientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        todos = new javax.swing.JRadioButton();
        pendVerify = new javax.swing.JRadioButton();
        rechazados = new javax.swing.JRadioButton();
        aprobados = new javax.swing.JRadioButton();
        pendDocs = new javax.swing.JRadioButton();
        bloqueados = new javax.swing.JRadioButton();
        txtBuscarCliente = new javax.swing.JTextField();

        ClModificar.setText("MODIFICAR");
        ClModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClModificarActionPerformed(evt);
            }
        });
        jPopupClientes.add(ClModificar);

        ClVer.setText("VER");
        ClVer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClVerActionPerformed(evt);
            }
        });
        jPopupClientes.add(ClVer);

        ClBitacora.setText("BITACORA");
        ClBitacora.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClBitacoraActionPerformed(evt);
            }
        });
        jPopupClientes.add(ClBitacora);

        ClVerificar.setText("VERIFICAR");
        ClVerificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClVerificarActionPerformed(evt);
            }
        });
        jPopupClientes.add(ClVerificar);

        ClBloquear.setText("BLOQUEAR");
        ClBloquear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClBloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClBloquearActionPerformed(evt);
            }
        });
        jPopupClientes.add(ClBloquear);

        ClDesBloquear.setText("DESBLOQUEAR");
        jPopupClientes.add(ClDesBloquear);

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

        tblMantenerClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICACIÓN", "CLIENTE", "DIRECCIÓN", "TELEFONO", "MOVIL", "BARRIO", "CIUDAD", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMantenerClientes.setComponentPopupMenu(jPopupClientes);
        jScrollPane1.setViewportView(tblMantenerClientes);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        buttonClientes.add(todos);
        todos.setText("TODOS");
        todos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todosActionPerformed(evt);
            }
        });

        buttonClientes.add(pendVerify);
        pendVerify.setText("PENDIENTE DE VERIFICACIÓN");
        pendVerify.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pendVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendVerifyActionPerformed(evt);
            }
        });

        buttonClientes.add(rechazados);
        rechazados.setText("RECHAZADOS");
        rechazados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rechazados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechazadosActionPerformed(evt);
            }
        });

        buttonClientes.add(aprobados);
        aprobados.setText("APROBADOS");
        aprobados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aprobados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aprobadosActionPerformed(evt);
            }
        });

        buttonClientes.add(pendDocs);
        pendDocs.setText("PENDIENTE DE DOCS");
        pendDocs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pendDocs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendDocsActionPerformed(evt);
            }
        });

        buttonClientes.add(bloqueados);
        bloqueados.setText("BLOQUEADO");
        bloqueados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bloqueados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloqueadosActionPerformed(evt);
            }
        });

        txtBuscarCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSCAR CLIENTE"));
        txtBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarClienteKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pendVerify)
                    .addComponent(todos))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(aprobados)
                        .addGap(69, 69, 69)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bloqueados)
                            .addComponent(pendDocs)))
                    .addComponent(rechazados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(todos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rechazados)
                                .addComponent(bloqueados)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(aprobados)
                                .addComponent(pendVerify))
                            .addComponent(pendDocs, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
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
        FrmMenuCliente menuCliente = new FrmMenuCliente();
        menuCliente.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMenuClienteActionPerformed

    private void ClModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClModificarActionPerformed
        if (tblMantenerClientes.getSelectedRow() >= 0) {
            mostrarCliente();
            frm.btnDni.setVisible(true);
            frm.btnBoleta.setVisible(true);
            frm.btnRegistrar.setEnabled(true);
            frm.setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_ClModificarActionPerformed

    private void ClBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClBitacoraActionPerformed
        FrmBitacoraCliente frmBit = new FrmBitacoraCliente();
        frmBit.setVisible(true);
        dispose();
    }//GEN-LAST:event_ClBitacoraActionPerformed

    private void ClVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClVerActionPerformed
        if (tblMantenerClientes.getSelectedRow() >= 0) {
            mostrarCliente();
            frm.btnDni.setVisible(true);
            frm.btnDni.setText("VER DNI");
            frm.btnBoleta.setText("VER BOLETA");
            frm.btnBoleta.setVisible(true);
            frm.btnRegistrar.setEnabled(false);            
            frm.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_ClVerActionPerformed

    private void ClVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClVerificarActionPerformed
        if (tblMantenerClientes.getSelectedRow() >= 0) {
            String dni = tblMantenerClientes.getValueAt(tblMantenerClientes.getSelectedRow(), 0).toString();
            cl = clDao.buscarCliente(dni);
            String cliente = cl.getNombre() + " " + cl.getAp_paterno() + " " + cl.getAp_materno();
            FrmVerificarCliente frmVer = new FrmVerificarCliente(cl.getId(), cliente);
            frmVer.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_ClVerificarActionPerformed

    private void ClBloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClBloquearActionPerformed
        if (tblMantenerClientes.getSelectedRow() >= 0) {
            String dni = tblMantenerClientes.getValueAt(tblMantenerClientes.getSelectedRow(), 0).toString();
            cl = clDao.buscarCliente(dni);
            int option = JOptionPane.showConfirmDialog(null,
                    "¿Estás seguro de Bloquear?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                if (clDao.actualizarEstado("estado", "Bloqueado", cl.getId())) {
                    JOptionPane.showMessageDialog(null, "BLOQUEADO");
                    LimpiarTable();
                    listarClientes("", "");
                }
            }
        }
    }//GEN-LAST:event_ClBloquearActionPerformed

    private void todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todosActionPerformed
        LimpiarTable();
        listarClientes("", txtBuscarCliente.getText());
    }//GEN-LAST:event_todosActionPerformed

    private void rechazadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechazadosActionPerformed
        if (rechazados.isSelected()) {
            LimpiarTable();
            listarClientes("Rechazado", txtBuscarCliente.getText());
        }
    }//GEN-LAST:event_rechazadosActionPerformed

    private void bloqueadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloqueadosActionPerformed
        if (bloqueados.isSelected()) {
            LimpiarTable();
            listarClientes("Bloqueado", txtBuscarCliente.getText());
        }
    }//GEN-LAST:event_bloqueadosActionPerformed

    private void pendVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendVerifyActionPerformed
        if (pendVerify.isSelected()) {
            LimpiarTable();
            listarClientes("Pendiente de verificación", txtBuscarCliente.getText());
        }
    }//GEN-LAST:event_pendVerifyActionPerformed

    private void aprobadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aprobadosActionPerformed
        if (aprobados.isSelected()) {
            LimpiarTable();
            listarClientes("Aprobado", txtBuscarCliente.getText());
        }

    }//GEN-LAST:event_aprobadosActionPerformed

    private void pendDocsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendDocsActionPerformed
        if (pendDocs.isSelected()) {
            LimpiarTable();
            listarClientes("Pendiente de documentación", txtBuscarCliente.getText());
        }
    }//GEN-LAST:event_pendDocsActionPerformed

    private void txtBuscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClienteKeyReleased
        String estado;
        if (pendDocs.isSelected()) {
            estado = "Pendiente de documentación";
        } else if (aprobados.isSelected()) {
            estado = "Aprobado";
        } else if (pendVerify.isSelected()) {
            estado = "Pendiente de verificación";
        } else if (bloqueados.isSelected()) {
            estado = "Bloqueado";
        } else if (rechazados.isSelected()) {
            estado = "Rechazado";
        } else {
            estado = "";
        }
        LimpiarTable();
        listarClientes(estado, txtBuscarCliente.getText());
    }//GEN-LAST:event_txtBuscarClienteKeyReleased

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
    private javax.swing.JMenuItem ClBitacora;
    private javax.swing.JMenuItem ClBloquear;
    private javax.swing.JMenuItem ClDesBloquear;
    private javax.swing.JMenuItem ClModificar;
    private javax.swing.JMenuItem ClVer;
    private javax.swing.JMenuItem ClVerificar;
    private javax.swing.JRadioButton aprobados;
    private javax.swing.JRadioButton bloqueados;
    private javax.swing.JButton btnMenuArriendo;
    private javax.swing.JButton btnMenuCliente;
    private javax.swing.JButton btnMenuInforme;
    private javax.swing.JButton btnMenuProducto;
    private javax.swing.JButton btnMenuReserva;
    private javax.swing.ButtonGroup buttonClientes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupClientes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton pendDocs;
    private javax.swing.JRadioButton pendVerify;
    private javax.swing.JRadioButton rechazados;
    private javax.swing.JTable tblMantenerClientes;
    private javax.swing.JRadioButton todos;
    private javax.swing.JTextField txtBuscarCliente;
    // End of variables declaration//GEN-END:variables
    public void listarClientes(String estado, String valorBusqueda) {
        List<Clientes> lista = clDao.listar(estado, valorBusqueda);
        modelo = (DefaultTableModel) tblMantenerClientes.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getDni();
            ob[1] = lista.get(i).getNombre() + " " + lista.get(i).getAp_paterno() + " " + lista.get(i).getAp_materno();
            ob[2] = lista.get(i).getDireccion();
            ob[3] = lista.get(i).getTelefono();
            ob[4] = lista.get(i).getMovil();
            ob[5] = lista.get(i).getBarrio();
            ob[6] = lista.get(i).getCiudad();
            ob[7] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        tblMantenerClientes.setModel(modelo);
    }

    private void mostrarCliente() {
        Date date = null;
        String dni = tblMantenerClientes.getValueAt(tblMantenerClientes.getSelectedRow(), 0).toString();
        cl = clDao.buscarCliente(dni);
        frm.txtId.setText("" + cl.getId());
        frm.txtApMaterno.setText(cl.getAp_materno());
        frm.txtApPaterno.setText(cl.getAp_paterno());
        frm.txtCorreo.setText(cl.getCorreo());
        frm.txtDireccion.setText(cl.getDireccion());
        frm.txtDni.setText(cl.getDni());
        frm.txtMovil.setText(cl.getMovil());
        frm.txtNombre.setText(cl.getNombre());
        frm.txtTelefono.setText(cl.getTelefono());
        frm.txtBarrio.setText(cl.getBarrio());
        frm.cbxCiudad.setSelectedItem(cl.getCiudad());
        frm.txtPais.setText(cl.getPais());
        frm.cbxEstado.setSelectedItem(cl.getEstado());
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            // Parseamos el String a un objeto LocalDate
            LocalDate localDate = LocalDate.parse(cl.getF_nacimiento(), dateFormatter);

            // Convertimos el objeto LocalDate a un objeto Date
            date = java.sql.Date.valueOf(localDate);

        } catch (DateTimeParseException e) {
            System.err.println("Error al parsear la fecha: " + e.getMessage());
        }
        frm.txtNacimiento.setDate(date);
        frm.btnDni.setVisible(true);
        frm.btnBoleta.setVisible(true);        
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
