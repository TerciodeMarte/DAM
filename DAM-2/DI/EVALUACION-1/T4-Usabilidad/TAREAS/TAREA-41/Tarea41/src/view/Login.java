/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author carra
 */
public class Login extends javax.swing.JPanel {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();

        ImageIcon image = new ImageIcon("src/resources/logo-valve.png");
        Image imgEscalada = image.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), WIDTH);
        ImageIcon imgFinal = new ImageIcon(imgEscalada);
        logo.setIcon(imgFinal);
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
        logo = new javax.swing.JLabel();

        fondologin.setBackground(new java.awt.Color(27, 40, 56));

        javax.swing.GroupLayout fondologinLayout = new javax.swing.GroupLayout(fondologin);
        fondologin.setLayout(fondologinLayout);
        fondologinLayout.setHorizontalGroup(
            fondologinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondologinLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(390, Short.MAX_VALUE))
        );
        fondologinLayout.setVerticalGroup(
            fondologinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondologinLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(587, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondologin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondologin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fondologin;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}