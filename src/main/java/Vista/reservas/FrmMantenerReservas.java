package Vista.reservas;

import Modelo.Reservas;
import Modelo.ReservasDao;
import Modelo.Productos;
import Vista.arriendos.FrmMenuArriendo;
import Vista.clientes.FrmMenuCliente;
import Vista.informes.FrmInformes;
import Vista.productos.FrmMenuProductos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public final class FrmMantenerReservas extends javax.swing.JFrame {

    Reservas ar = new Reservas();
    ReservasDao arDao = new ReservasDao();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel tmpProducto = new DefaultTableModel();
    FrmNuevoReserva frm = new FrmNuevoReserva();

    public FrmMantenerReservas() {
        initComponents();
        this.setLocationRelativeTo(null);
        listarArriendos("", "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupProdutos = new javax.swing.JPopupMenu();
        menuVer = new javax.swing.JMenuItem();
        menuModificar = new javax.swing.JMenuItem();
        menuBitacora = new javax.swing.JMenuItem();
        buttonGroupProductos = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        menuClientes = new javax.swing.JButton();
        menuProductos = new javax.swing.JButton();
        menuReservas = new javax.swing.JButton();
        menuArriendos = new javax.swing.JButton();
        menuInformes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMantenerArriendos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        aprobado = new javax.swing.JRadioButton();
        todos = new javax.swing.JRadioButton();
        rechazado = new javax.swing.JRadioButton();
        pendDocs = new javax.swing.JRadioButton();
        arrendado = new javax.swing.JRadioButton();
        txtBuscarArriendos = new javax.swing.JTextField();
        pendRevision = new javax.swing.JRadioButton();
        devuelto = new javax.swing.JRadioButton();
        demorado = new javax.swing.JRadioButton();

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

        menuBitacora.setText("BITACORA");
        menuBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBitacoraActionPerformed(evt);
            }
        });
        jPopupProdutos.add(menuBitacora);

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
                .addGap(65, 65, 65)
                .addComponent(menuReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(menuArriendos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(menuInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        tblMantenerArriendos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FECHA", "F. INICIO", "F. FIN", "F. DEVOLUCION", "CLIENTE", "VALOR", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMantenerArriendos.setComponentPopupMenu(jPopupProdutos);
        tblMantenerArriendos.setRowHeight(25);
        tblMantenerArriendos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMantenerArriendosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMantenerArriendos);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroupProductos.add(aprobado);
        aprobado.setText("APROBADO");
        aprobado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aprobadoActionPerformed(evt);
            }
        });

        buttonGroupProductos.add(todos);
        todos.setText("TODOS");
        todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todosActionPerformed(evt);
            }
        });

        buttonGroupProductos.add(rechazado);
        rechazado.setText("RECHAZADO");
        rechazado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechazadoActionPerformed(evt);
            }
        });

        buttonGroupProductos.add(pendDocs);
        pendDocs.setText("PENDIENTE DOCS");
        pendDocs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendDocsActionPerformed(evt);
            }
        });

        buttonGroupProductos.add(arrendado);
        arrendado.setText("ARRENDADO");
        arrendado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrendadoActionPerformed(evt);
            }
        });

        txtBuscarArriendos.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSCAR RESERVA"));
        txtBuscarArriendos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarArriendosKeyReleased(evt);
            }
        });

        buttonGroupProductos.add(pendRevision);
        pendRevision.setText("PENDIENTE REVISIÓN");
        pendRevision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendRevisionActionPerformed(evt);
            }
        });

        buttonGroupProductos.add(devuelto);
        devuelto.setText("DEVUELTO");
        devuelto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devueltoActionPerformed(evt);
            }
        });

        buttonGroupProductos.add(demorado);
        demorado.setText("DEMORADO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(todos)
                    .addComponent(aprobado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pendDocs)
                    .addComponent(rechazado))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(arrendado)
                        .addGap(18, 18, 18)
                        .addComponent(devuelto))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(pendRevision)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(demorado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 364, Short.MAX_VALUE)
                .addComponent(txtBuscarArriendos, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(rechazado)
                            .addComponent(pendRevision)
                            .addComponent(demorado))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aprobado)
                            .addComponent(pendDocs)
                            .addComponent(arrendado)
                            .addComponent(devuelto)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtBuscarArriendos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVerActionPerformed
        if (tblMantenerArriendos.getSelectedRow() >= 0) {
            mostrarArriendo();
            frm.btnRegistrar.setEnabled(false);
            frm.btnComprobante.setText("VER COMPROBANTE");
        }
    }//GEN-LAST:event_menuVerActionPerformed

    private void menuModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarActionPerformed
        if (tblMantenerArriendos.getSelectedRow() >= 0) {
            mostrarArriendo();
            frm.btnRegistrar.setEnabled(true);
        }
    }//GEN-LAST:event_menuModificarActionPerformed

    private void menuBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBitacoraActionPerformed
        FrmBitacoraReservas frmBit = new FrmBitacoraReservas();
        frmBit.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuBitacoraActionPerformed

    private void txtBuscarArriendosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarArriendosKeyReleased
        String estado;
        if (arrendado.isSelected()) {
            estado = "Arrendado";
        } else if (pendDocs.isSelected()) {
            estado = "Pendiente en Docs";
        } else if (aprobado.isSelected()) {
            estado = "Aprobado";
        } else if (rechazado.isSelected()) {
            estado = "Rechazado";
        } else if (pendRevision.isSelected()) {
            estado = "Pendiente en Revisión";
        }  else if (demorado.isSelected()) {
            estado = "Demorado";
        }else if (devuelto.isSelected()) {
            estado = "Devuelto";
        } else {
            estado = "";
        }
        LimpiarTable();
        listarArriendos(estado, txtBuscarArriendos.getText());
    }//GEN-LAST:event_txtBuscarArriendosKeyReleased

    private void todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todosActionPerformed
        if (todos.isSelected()) {
            LimpiarTable();
            listarArriendos("", txtBuscarArriendos.getText());
        }

    }//GEN-LAST:event_todosActionPerformed

    private void aprobadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aprobadoActionPerformed
        if (aprobado.isSelected()) {
            LimpiarTable();
            listarArriendos("Aprobado", txtBuscarArriendos.getText());
        }
    }//GEN-LAST:event_aprobadoActionPerformed

    private void arrendadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrendadoActionPerformed
        if (arrendado.isSelected()) {
            LimpiarTable();
            listarArriendos("Arrendado", txtBuscarArriendos.getText());
        }
    }//GEN-LAST:event_arrendadoActionPerformed

    private void rechazadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechazadoActionPerformed
        if (rechazado.isSelected()) {
            LimpiarTable();
            listarArriendos("Rechazado", txtBuscarArriendos.getText());
        }
    }//GEN-LAST:event_rechazadoActionPerformed

    private void pendDocsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendDocsActionPerformed
        if (pendDocs.isSelected()) {
            LimpiarTable();
            listarArriendos("Pendiente en Docs", txtBuscarArriendos.getText());
        }
    }//GEN-LAST:event_pendDocsActionPerformed

    private void pendRevisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendRevisionActionPerformed
        if (pendRevision.isSelected()) {
            LimpiarTable();
            listarArriendos("Pendiente en Revisión", txtBuscarArriendos.getText());
        }
    }//GEN-LAST:event_pendRevisionActionPerformed

    private void devueltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devueltoActionPerformed
        if (devuelto.isSelected()) {
            LimpiarTable();
            listarArriendos("Devuelto", txtBuscarArriendos.getText());
        }
    }//GEN-LAST:event_devueltoActionPerformed

    private void tblMantenerArriendosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMantenerArriendosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblMantenerArriendosMouseClicked

    private void menuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClientesActionPerformed
        FrmMenuCliente menu = new FrmMenuCliente();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuClientesActionPerformed

    private void menuProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProductosActionPerformed
        FrmMenuProductos menu = new FrmMenuProductos();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuProductosActionPerformed

    private void menuReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReservasActionPerformed
        FrmMenuReserva menu = new FrmMenuReserva();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuReservasActionPerformed

    private void menuInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInformesActionPerformed
       FrmInformes menu = new FrmInformes();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuInformesActionPerformed

    private void menuArriendosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArriendosActionPerformed
        FrmMenuArriendo menu = new FrmMenuArriendo();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuArriendosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton aprobado;
    private javax.swing.JRadioButton arrendado;
    private javax.swing.ButtonGroup buttonGroupProductos;
    private javax.swing.JRadioButton demorado;
    private javax.swing.JRadioButton devuelto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupProdutos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menuArriendos;
    private javax.swing.JMenuItem menuBitacora;
    private javax.swing.JButton menuClientes;
    private javax.swing.JButton menuInformes;
    private javax.swing.JMenuItem menuModificar;
    private javax.swing.JButton menuProductos;
    private javax.swing.JButton menuReservas;
    private javax.swing.JMenuItem menuVer;
    private javax.swing.JRadioButton pendDocs;
    private javax.swing.JRadioButton pendRevision;
    private javax.swing.JRadioButton rechazado;
    private javax.swing.JTable tblMantenerArriendos;
    private javax.swing.JRadioButton todos;
    private javax.swing.JTextField txtBuscarArriendos;
    // End of variables declaration//GEN-END:variables

    public void listarArriendos(String estado, String valorBusqueda) {
        List<Reservas> lista = arDao.listar(estado, valorBusqueda);
        modelo = (DefaultTableModel) tblMantenerArriendos.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getFecha();
            ob[2] = lista.get(i).getF_inicio();
            ob[3] = lista.get(i).getF_fin();
            ob[4] = lista.get(i).getF_devolucion();
            ob[5] = lista.get(i).getCliente();
            ob[6] = lista.get(i).getTotal();
            ob[7] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        tblMantenerArriendos.setModel(modelo);
    }

    private void mostrarArriendo() {
        Date fecha = null;
        Date inicio = null;
        Date fin = null;
        Date devolucion = null;
        String id = tblMantenerArriendos.getValueAt(tblMantenerArriendos.getSelectedRow(), 0).toString();
        ar = arDao.buscarArriendo(id);
        frm.txtIdArriendo.setText("" + ar.getId());
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            // Parseamos el String a un objeto LocalDate
            LocalDate localFecha = LocalDate.parse(ar.getFecha(), dateFormatter);
            LocalDate localIncio = LocalDate.parse(ar.getF_inicio(), dateFormatter);
            LocalDate localFin = LocalDate.parse(ar.getF_fin(), dateFormatter);
            LocalDate localDevolucion = LocalDate.parse(ar.getF_devolucion(), dateFormatter);
            // Convertimos el objeto LocalDate a un objeto Date
            fecha = java.sql.Date.valueOf(localFecha);
            inicio = java.sql.Date.valueOf(localIncio);
            fin = java.sql.Date.valueOf(localFin);
            devolucion = java.sql.Date.valueOf(localDevolucion);

        } catch (DateTimeParseException e) {
            System.err.println("Error al parsear la fecha: " + e.getMessage());
        }
        frm.txtIdCliente.setText("" + ar.getId_cliente());
        frm.txtCliente.setText("" + ar.getCliente());
        frm.txtFecha.setDate(fecha);
        frm.txtInicio.setDate(inicio);
        frm.txtFin.setDate(fin);
        frm.txtDevolucion.setDate(devolucion);
        frm.txtTotal.setText("" + ar.getTotal());
        frm.txtOtros.setText("" + ar.getOtros());
        frm.txtObservaciones.setText(ar.getObservaciones());
        frm.cbxEstado.setSelectedItem(ar.getEstado());
        frm.btnComprobante.setVisible(true);
        listarProductos("" + ar.getId());       
        frm.setVisible(true);
        dispose();
    }

    public void listarProductos(String id) {
        List<Productos> lista = arDao.buscarProducto(id);
        tmpProducto = (DefaultTableModel) frm.tempProductos.getModel();
        Object[] ob = new Object[4];
        double total = 0;
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getStock();
            ob[3] = lista.get(i).getPrecio();
            total = (total + lista.get(i).getPrecio());
            tmpProducto.addRow(ob);
        }
        frm.totalProducto.setText("" + total);
        frm.tempProductos.setModel(tmpProducto);
    }
    
    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

}
