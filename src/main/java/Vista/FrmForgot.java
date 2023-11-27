package Vista;

import Modelo.Usuarios;
import Modelo.UsuariosDao;
import java.util.Properties;
import java.util.UUID;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class FrmForgot extends javax.swing.JFrame {

    UsuariosDao usDao = new UsuariosDao();

    public FrmForgot() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCorreo = new javax.swing.JTextField();
        btnProcesar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnProcesar.setText("PROCESAR");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        jLabel1.setText("CORREO ELECTRÓNICO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        if (txtCorreo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESA UN CORREO");
        } else {
            UUID uuid = UUID.randomUUID();
            String codigo = uuid.toString();
            String consulta = usDao.insertarToken(codigo, txtCorreo.getText());
            switch (consulta) {
                case "ok" -> {
                    String subject = "¡Hola!";
                    String body = "Tu código para cambiar tu contrraseña es: " + codigo;
                    
                    sendEmail(txtCorreo.getText(), subject, body, codigo);
                }
                case "no" ->
                    JOptionPane.showMessageDialog(null, "EL CORREO NO ESTA REGISTRADO");
                default ->
                    JOptionPane.showMessageDialog(null, "ERROR");
            }
        }

    }//GEN-LAST:event_btnProcesarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcesar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables

    private void sendEmail(String to, String subject, String mensaje, String codigo) {

        final String username = "ana.info1999@gmail.com";
        final String password = "ibzqqzlenwwkrkba";

        // Configuración de las propiedades del servidor de correo
        String host = "smtp.gmail.com";
        String port = "587"; // Puerto para TLS, 465 para SSL

        // Configurar las propiedades del sistema para enviar el correo
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Habilitar TLS

        // Crear una sesión de correo electrónico con autenticación
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Crear un mensaje de correo electrónico
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(mensaje);

            // Enviar el mensaje
            Transport.send(message);

            JOptionPane.showMessageDialog(null, "El correo ha sido enviado exitosamente.");
            usDao.insertarToken(codigo, to);
            FrmReset frm = new FrmReset(to);
            frm.setVisible(true);
            dispose();

        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Error al enviar el correo: " + e.getMessage());
        }
    }
}
