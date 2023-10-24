/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.Controller;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import models.UserDAO;

/**
 *
 * @author carra
 */
public class Login extends javax.swing.JPanel {

    private static Games games = new Games();
    private static Main view = new Main();

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        ImageIcon image = new ImageIcon("resources/logo-valve.png");
        Image imgEscalada = image.getImage().getScaledInstance(150, 80, Image.SCALE_DEFAULT);
        ImageIcon imgFinal = new ImageIcon(imgEscalada);
        logo.setIcon(imgFinal);
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondologin = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        TFPass = new javax.swing.JPasswordField();
        errorP = new javax.swing.JLabel();
        JLPass = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        JLEmail = new javax.swing.JLabel();
        TFEmail = new javax.swing.JTextField();
        errorE = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        login = new javax.swing.JButton();
        copyright = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        fondologin.setBackground(new java.awt.Color(42, 71, 94));
        fondologin.setPreferredSize(new java.awt.Dimension(700, 750));
        fondologin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(27, 40, 56));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TFPass.setBackground(new java.awt.Color(42, 71, 94));
        TFPass.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        TFPass.setForeground(new java.awt.Color(153, 153, 153));
        TFPass.setText("password");
        TFPass.setActionCommand("TFPass");
        TFPass.setBorder(null);
        TFPass.setCaretColor(new java.awt.Color(255, 255, 255));
        TFPass.setName("TFPass"); // NOI18N
        jPanel2.add(TFPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 420, 40));

        errorP.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        errorP.setForeground(new java.awt.Color(255, 51, 51));
        errorP.setText("Password incorrect");
        errorP.setToolTipText("");
        errorP.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel2.add(errorP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 420, 40));

        JLPass.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        JLPass.setForeground(new java.awt.Color(255, 255, 255));
        JLPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLPass.setText("PASSWORD");
        JLPass.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JLPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JLPassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JLPassMouseExited(evt);
            }
        });
        jPanel2.add(JLPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 380, 40));

        fondologin.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 700, 160));

        jPanel1.setBackground(new java.awt.Color(27, 40, 56));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLEmail.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        JLEmail.setForeground(new java.awt.Color(255, 255, 255));
        JLEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLEmail.setText("EMAIL");
        JLEmail.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JLEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JLEmailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JLEmailMouseExited(evt);
            }
        });
        jPanel1.add(JLEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 380, 40));

        TFEmail.setBackground(new java.awt.Color(42, 71, 94));
        TFEmail.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        TFEmail.setForeground(new java.awt.Color(153, 153, 153));
        TFEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TFEmail.setText("email@steam.com");
        TFEmail.setActionCommand("TFEmail");
        TFEmail.setBorder(null);
        TFEmail.setCaretColor(new java.awt.Color(255, 255, 255));
        TFEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TFEmail.setName("TFEmail"); // NOI18N
        TFEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TFEmailFocusGained(evt);
            }
        });
        TFEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TFEmailMousePressed(evt);
            }
        });
        TFEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFEmailActionPerformed(evt);
            }
        });
        jPanel1.add(TFEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 420, 40));

        errorE.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        errorE.setForeground(new java.awt.Color(255, 51, 51));
        errorE.setText("Email no found");
        errorE.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel1.add(errorE, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 100, 420, 43));

        fondologin.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 700, 190));

        exit.setBackground(new java.awt.Color(204, 204, 204));
        exit.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        exit.setText("Exit");
        exit.setBorder(null);
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fondologin.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, 180, 40));

        login.setBackground(new java.awt.Color(172, 213, 80));
        login.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("Login");
        login.setBorder(null);
        login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fondologin.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, 180, 40));

        copyright.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        copyright.setForeground(new java.awt.Color(255, 255, 255));
        copyright.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyright.setText("<html>\n<body>\n© 2023 Valve Corporation. Todos los derechos reservados. <br>\nTodas las marcas registradas pertenecen a sus respectivos dueños en EE. UU. y otros países.<br>\n Todos los precios incluyen IVA (donde sea aplicable). \n</body>\n</html"); // NOI18N
        copyright.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        copyright.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                copyrightMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                copyrightMouseExited(evt);
            }
        });
        fondologin.add(copyright, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 700, 70));

        jPanel3.setBackground(new java.awt.Color(23, 26, 33));

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Steam");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Workers");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(379, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        fondologin.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 160));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondologin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondologin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JLEmailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLEmailMouseEntered

    }//GEN-LAST:event_JLEmailMouseEntered

    private void JLEmailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLEmailMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_JLEmailMouseExited

    private void TFEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFEmailFocusGained

    }//GEN-LAST:event_TFEmailFocusGained

    private void TFEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TFEmailMousePressed

    }//GEN-LAST:event_TFEmailMousePressed

    private void TFEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFEmailActionPerformed

    private void JLPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLPassMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JLPassMouseEntered

    private void JLPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLPassMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JLPassMouseExited

    private void copyrightMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyrightMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_copyrightMouseEntered

    private void copyrightMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyrightMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_copyrightMouseExited

    public JTextField getTFEmail() {
        return TFEmail;
    }

    public JPasswordField getTFPass() {
        return TFPass;
    }

    public JLabel getErrorE() {
        return errorE;
    }

    public JLabel getErrorP() {
        return errorP;
    }

    public JButton getExit() {
        return exit;
    }

    public JButton getLogin() {
        return login;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLEmail;
    private javax.swing.JLabel JLPass;
    private javax.swing.JTextField TFEmail;
    private javax.swing.JPasswordField TFPass;
    private javax.swing.JLabel copyright;
    private javax.swing.JLabel errorE;
    private javax.swing.JLabel errorP;
    private javax.swing.JButton exit;
    private javax.swing.JPanel fondologin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton login;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
