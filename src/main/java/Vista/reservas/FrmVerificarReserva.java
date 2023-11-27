package Vista.reservas;

import Vista.ejemplares.*;
import Modelo.EjemplaresDao;
import javax.swing.JOptionPane;

public class FrmVerificarReserva extends javax.swing.JFrame {
    
    EjemplaresDao ejDao = new EjemplaresDao();

    public FrmVerificarReserva(int idProducto, String nombre) {
        initComponents();
        this.setLocationRelativeTo(null);
        txtIdEjemplar.setText("" + idProducto);
        jLabelEjemplar.setText(nombre);
        txtIdEjemplar.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtVerificar = new javax.swing.JTextPane();
        btnCancelar = new javax.swing.JButton();
        btnNoDisponible = new javax.swing.JButton();
        btnDisponible = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIdEjemplar = new javax.swing.JTextField();
        jLabelEjemplar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(txtVerificar);

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnNoDisponible.setText("NO DISPONIBLE");
        btnNoDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoDisponibleActionPerformed(evt);
            }
        });

        btnDisponible.setText("DISPONIBLE");
        btnDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisponibleActionPerformed(evt);
            }
        });

        jLabel1.setText("COMENTARIO");

        jLabelEjemplar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEjemplar.setText("Nombre del ejemplar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNoDisponible)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDisponible))
                    .addComponent(jLabelEjemplar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtIdEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLabelEjemplar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNoDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoDisponibleActionPerformed
        int option = JOptionPane.showConfirmDialog(null,
                "¿Marcar como no disponible?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            if(ejDao.actualizarEstado("estado", "No Disponible", Integer.parseInt(txtIdEjemplar.getText()))){
                ejDao.actualizarEstado("comentarios", txtVerificar.getText(), Integer.parseInt(txtIdEjemplar.getText()));
                JOptionPane.showMessageDialog(null, "ESTADO CAMBIADO");
                dispose();
            }
            
        }
    }//GEN-LAST:event_btnNoDisponibleActionPerformed

    private void btnDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisponibleActionPerformed
        int option = JOptionPane.showConfirmDialog(null,
                "¿Marcar como Disponible?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            // El usuario ha seleccionado "Sí"
            if(ejDao.actualizarEstado("estado", "Disponible", Integer.parseInt(txtIdEjemplar.getText()))){
                ejDao.actualizarEstado("comentarios", txtVerificar.getText(), Integer.parseInt(txtIdEjemplar.getText()));
                JOptionPane.showMessageDialog(null, "ESTADO CAMBIADO");
                dispose();
            }
        }
    }//GEN-LAST:event_btnDisponibleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDisponible;
    private javax.swing.JButton btnNoDisponible;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEjemplar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtIdEjemplar;
    private javax.swing.JTextPane txtVerificar;
    // End of variables declaration//GEN-END:variables
}
