package Vista;

import Modelo.Usuarios;
import Modelo.UsuariosDao;
import javax.swing.JOptionPane;

public class FrmReset extends javax.swing.JFrame {

    Usuarios us = new Usuarios();
    UsuariosDao usDao = new UsuariosDao();
    
    public FrmReset() {
        
    }

    public FrmReset(String correo) {
        initComponents();
        this.setLocationRelativeTo(null);
        txtCorreo.setText(correo);
        txtCorreo.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNueva = new javax.swing.JTextField();
        txtConfirmar = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RECUPERAR CONTRASEÑA");

        jButton1.setText("CANCELAR");

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel1.setText("NUEVA CONTRASEÑA");

        jLabel2.setText("CONFIRMAR CONTRASEÑA");

        jLabel3.setText("CÓDIGO DE VERIFICACIÓN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                                .addComponent(btnGuardar))
                            .addComponent(txtNueva)
                            .addComponent(txtConfirmar)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNueva.getText().equals("") || txtConfirmar.getText().equals("") || txtCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "TODO LOS CAMPOS ON OBLIGATORIOS");
        } else {
            if (txtNueva.getText().equals(txtConfirmar.getText())) {
                us = usDao.validarCodigo(txtCorreo.getText());
                if (us.getCodigo() != null) {
                    if (txtCodigo.getText().equals(us.getCodigo())) {
                        String modificar = usDao.modificarClave(txtNueva.getText(), txtCorreo.getText());
                        if(modificar.equals("ok")){
                            JOptionPane.showMessageDialog(null, "CONTRASEÑA MODIFICADA");
                            FrmLogin frm = new FrmLogin();
                            frm.setVisible(true);
                            dispose();
                        }else{
                            JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "CODIGO INCORRECTO");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "EL CODIGO NO EXISTE");
                }
            }else{
                JOptionPane.showMessageDialog(null, "LAS CONTRASEÑA NO COINCDEN");
            }

        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtConfirmar;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNueva;
    // End of variables declaration//GEN-END:variables
}
