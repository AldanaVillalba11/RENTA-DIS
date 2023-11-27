package Vista.reservas;

import Modelo.BitReservas;
import Modelo.ReservasDao;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public final class FrmBitacoraReservas extends javax.swing.JFrame {

    ReservasDao reDao = new ReservasDao();
    DefaultTableModel modelo = new DefaultTableModel();
    public FrmBitacoraReservas() {
        initComponents();
        this.setLocationRelativeTo(null);
        listarBitacora("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtBuscarReserva = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBitacora = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtBuscarReserva.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSCAR"));
        txtBuscarReserva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarReservaKeyReleased(evt);
            }
        });

        tblBitacora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CLIENTE", "FECHA/HORA", "ACCIÓN", "CAMPO", "VALOR ANTERIOR", "VALOR NUEVO", "USUARIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBitacora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBitacoraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBitacora);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtBuscarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtBuscarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab1", jPanel1);

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

    private void txtBuscarReservaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarReservaKeyReleased
        LimpiarTable();
        listarBitacora(txtBuscarReserva.getText());
    }//GEN-LAST:event_txtBuscarReservaKeyReleased

    private void tblBitacoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBitacoraMouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_tblBitacoraMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblBitacora;
    private javax.swing.JTextField txtBuscarReserva;
    // End of variables declaration//GEN-END:variables
    public void listarBitacora(String valorBusqueda) {
        List<BitReservas> lista = reDao.listarBitacora(valorBusqueda);
        modelo = (DefaultTableModel) tblBitacora.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getCliente();
            ob[2] = lista.get(i).getFecha_hora();
            ob[3] = lista.get(i).getAccion();
            ob[4] = lista.get(i).getCampo();
            ob[5] = lista.get(i).getValor_ant();
            ob[6] = lista.get(i).getValor_nuevo();
            ob[7] = lista.get(i).getUsuario();
            modelo.addRow(ob);
        }
        tblBitacora.setModel(modelo);
    }
    
    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
}
