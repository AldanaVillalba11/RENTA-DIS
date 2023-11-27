package Vista.clientes;

import Modelo.BitClientes;
import Modelo.ClientesDao;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public final class FrmBitacoraCliente extends javax.swing.JFrame {

    ClientesDao clDao = new ClientesDao();
    DefaultTableModel modelo = new DefaultTableModel();
    public FrmBitacoraCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        listarBitacora("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBitacora = new javax.swing.JTable();
        txtBuscarCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblBitacora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID REGISTRO", "ID CLIENTE", "FECHA/HORA", "ACCIÓN", "CAMPO", "VALOR ANTERIOR", "VALOR NUEVO", "USUARIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblBitacora);

        txtBuscarCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSCAR"));
        txtBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarClienteKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClienteKeyReleased
        LimpiarTable();
        listarBitacora(txtBuscarCliente.getText());
    }//GEN-LAST:event_txtBuscarClienteKeyReleased

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBitacora;
    private javax.swing.JTextField txtBuscarCliente;
    // End of variables declaration//GEN-END:variables
    public void listarBitacora(String valorBusqueda) {

        List<BitClientes> lista = clDao.listarBitacora(valorBusqueda);
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
