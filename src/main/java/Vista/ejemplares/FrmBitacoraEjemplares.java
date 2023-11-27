package Vista.ejemplares;

import Modelo.BitEjemplares;
import Modelo.EjemplaresDao;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public final class FrmBitacoraEjemplares extends javax.swing.JFrame {

    EjemplaresDao ejDao = new EjemplaresDao();
    DefaultTableModel modelo = new DefaultTableModel();
    public FrmBitacoraEjemplares() {
        initComponents();
        this.setLocationRelativeTo(null);
        listarBitacora("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBitacora = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblBitacora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID REGISTRO", "EJEMPLAR", "FECHA/HORA", "ACCIÓN", "CAMPO", "VALOR ANTERIOR", "VALOR NUEVO", "USUARIO"
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

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSCAR"));

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
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblBitacora;
    // End of variables declaration//GEN-END:variables
    public void listarBitacora(String valorBusqueda) {

        List<BitEjemplares> lista = ejDao.listarBitacora(valorBusqueda);
        modelo = (DefaultTableModel) tblBitacora.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getEjemplar();
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
}
