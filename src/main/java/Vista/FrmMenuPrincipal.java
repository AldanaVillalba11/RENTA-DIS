package Vista;

import Modelo.Usuarios;
import Vista.arriendos.FrmMenuArriendo;
import Vista.reservas.FrmMenuReserva;
import Vista.clientes.FrmMenuCliente;
import Vista.informes.FrmInformes;
import Vista.productos.FrmMenuProductos;
import Vista.usuarios.FrmMenuUsuario;

public class FrmMenuPrincipal extends javax.swing.JFrame {

    public FrmMenuPrincipal(Usuarios us) {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        menuClientes = new javax.swing.JButton();
        menuProductos = new javax.swing.JButton();
        menuArriendo = new javax.swing.JButton();
        menuVenta = new javax.swing.JButton();
        menuInformes = new javax.swing.JButton();
        menuUsuarios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU PRINCIPAL");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Menú Principal"));
        jPanel1.setToolTipText("");

        menuClientes.setText("CLIENTE");
        menuClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClientesActionPerformed(evt);
            }
        });

        menuProductos.setText("PRODUCTO");
        menuProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProductosActionPerformed(evt);
            }
        });

        menuArriendo.setText("RESERVAS");
        menuArriendo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuArriendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArriendoActionPerformed(evt);
            }
        });

        menuVenta.setText("ARRIENDO");
        menuVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVentaActionPerformed(evt);
            }
        });

        menuInformes.setText("INFORME");
        menuInformes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInformesActionPerformed(evt);
            }
        });

        menuUsuarios.setBackground(new java.awt.Color(51, 153, 255));
        menuUsuarios.setText("USUARIOS");
        menuUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(menuProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menuClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(menuArriendo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menuVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menuInformes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(119, 119, 119))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(menuUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(menuClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(menuProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(menuArriendo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(menuVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(menuInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClientesActionPerformed
        FrmMenuCliente menu = new FrmMenuCliente();
        menu.setVisible(true);
    }//GEN-LAST:event_menuClientesActionPerformed

    private void menuProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProductosActionPerformed
        FrmMenuProductos menu = new FrmMenuProductos();
        menu.setVisible(true);
    }//GEN-LAST:event_menuProductosActionPerformed

    private void menuArriendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArriendoActionPerformed
        FrmMenuReserva menu = new FrmMenuReserva();
        menu.setVisible(true);
    }//GEN-LAST:event_menuArriendoActionPerformed

    private void menuVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVentaActionPerformed
        FrmMenuArriendo menu = new FrmMenuArriendo();
        menu.setVisible(true);
    }//GEN-LAST:event_menuVentaActionPerformed

    private void menuInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInformesActionPerformed
        FrmInformes menu = new FrmInformes();
        menu.setVisible(true);
    }//GEN-LAST:event_menuInformesActionPerformed

    private void menuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuariosActionPerformed
        FrmMenuUsuario menu = new FrmMenuUsuario();
        menu.setVisible(true);
    }//GEN-LAST:event_menuUsuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton menuArriendo;
    private javax.swing.JButton menuClientes;
    private javax.swing.JButton menuInformes;
    private javax.swing.JButton menuProductos;
    private javax.swing.JButton menuUsuarios;
    private javax.swing.JButton menuVenta;
    // End of variables declaration//GEN-END:variables
}
