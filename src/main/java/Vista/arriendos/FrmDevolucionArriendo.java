package Vista.arriendos;

import Eventos.SessionManager;
import Modelo.ArriendosDao;
import Modelo.Reservas;
import Modelo.ReservasDao;
import Modelo.Productos;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmDevolucionArriendo extends javax.swing.JFrame {

    Reservas re = new Reservas();
    ReservasDao reDao = new ReservasDao();
    ArriendosDao arDao = new ArriendosDao();
    DefaultTableModel tmp = new DefaultTableModel();
    
    SessionManager sessionMan = SessionManager.getInstance();
    int userId = sessionMan.getUserId();

    public FrmDevolucionArriendo() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtIdArriendo.setVisible(false);
        txtFechaDev.setVisible(false);
        jTabbedPane1.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtIdArriendo = new javax.swing.JTextField();
        txtFechaDev = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("INGRESE COMPROBANTE DEL ARRIENDO");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtFechaDev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdArriendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnCancelar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdArriendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaDev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRODUCTO", "PRECIO", "ACCION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        jLabel2.setText("MARQUE LOS PRODUCTOS A DEVOLVER");

        btnCancel.setText("CANCELAR");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnConfirmar.setText("CONFIRMAR");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirmar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtBuscar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESE EL COMPROBANTE");
        } else {
            Date date = null;
            re = reDao.buscarComprobante(txtBuscar.getText());
            if (re.getId() > 0) {
                txtIdArriendo.setText("" + re.getId());
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                try {
                    // Parseamos el String a un objeto LocalDate
                    LocalDate localDate = LocalDate.parse(re.getF_fin(), dateFormatter);

                    // Convertimos el objeto LocalDate a un objeto Date
                    date = java.sql.Date.valueOf(localDate);

                } catch (DateTimeParseException e) {
                    System.err.println("Error al parsear la fecha: " + e.getMessage());
                }
                txtFechaDev.setDate(date);
                listarProductos(String.valueOf(re.getId()));
                jTabbedPane1.setSelectedIndex(1);
            } else {
                JOptionPane.showMessageDialog(null, "NO EXISTE EL COMPROBANTE");
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtBuscar.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "INGRESE EL COMPROBANTE");
            } else {
                Date date = null;
                re = reDao.buscarComprobante(txtBuscar.getText());
                if (re.getId() > 0) {
                    txtIdArriendo.setText("" + re.getId());
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    try {
                        // Parseamos el String a un objeto LocalDate
                        LocalDate localDate = LocalDate.parse(re.getF_fin(), dateFormatter);

                        // Convertimos el objeto LocalDate a un objeto Date
                        date = java.sql.Date.valueOf(localDate);

                    } catch (DateTimeParseException e) {
                        System.err.println("Error al parsear la fecha: " + e.getMessage());
                    }
                    txtFechaDev.setDate(date);
                    listarProductos(String.valueOf(re.getId()));
                    jTabbedPane1.setSelectedIndex(1);
                } else {
                    JOptionPane.showMessageDialog(null, "NO EXISTE EL COMPROBANTE");
                }
            }
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        int option = JOptionPane.showConfirmDialog(null,
                "¿Estás seguro de Procesar?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            Date currentdate = new Date();
            Date selectedDate = txtFechaDev.getDate();
            boolean estado;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String f_devolucion = sdf.format(txtFechaDev.getDate());
            if (selectedDate.after(currentdate)) {
                arDao.actualizarArriendoEstado("estado", "Devuelto", Integer.parseInt(txtIdArriendo.getText()));
                arDao.registrarBitacora("Devolucion Arriendo", "estado", "Arrendado", "Devuelto", Integer.parseInt(txtIdArriendo.getText()), userId);
                estado = reDao.devolucion(f_devolucion, "Devuelto", Integer.parseInt(txtIdArriendo.getText()));
            } else {
                arDao.actualizarArriendoEstado("estado", "Demorado", Integer.parseInt(txtIdArriendo.getText()));
                arDao.registrarBitacora("Devolucion Arriendo", "estado", "Arrendado", "Demorado", Integer.parseInt(txtIdArriendo.getText()), userId);
                estado = reDao.devolucion(f_devolucion, "Demorado", Integer.parseInt(txtIdArriendo.getText()));
            }
            if (estado) {
                for (int i = 0; i < tblProductos.getRowCount(); i++) {
                    int id_ejemplar = Integer.parseInt(tblProductos.getValueAt(i, 0).toString());
                    if (Boolean.parseBoolean(tblProductos.getValueAt(i, 3).toString())) {                        
                        arDao.actualizarEjemplar("estado", "Disponible", id_ejemplar);
                    }else{
                       arDao.actualizarEjemplar("estado", "No Disponible", id_ejemplar);
                       arDao.actualizarEstado(id_ejemplar, Integer.parseInt(txtIdArriendo.getText()), 0);
                    }
                }                
                dispose();
                JOptionPane.showMessageDialog(null, "PRODUCTOS DEVUELTO");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL HACER LA DEVOLUCION");
            }

        }

    }//GEN-LAST:event_btnConfirmarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscar;
    private com.toedter.calendar.JDateChooser txtFechaDev;
    private javax.swing.JTextField txtIdArriendo;
    // End of variables declaration//GEN-END:variables
    public void listarProductos(String id) {
        List<Productos> lista = reDao.buscarProducto(id);
        tmp = (DefaultTableModel) tblProductos.getModel();
        Object[] ob = new Object[4];
        double total = 0;
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getPrecio();
            ob[3] = false;
            total = (total + lista.get(i).getPrecio());
            tmp.addRow(ob);
        }
        tblProductos.setModel(tmp);
    }

}
