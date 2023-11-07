/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tarea31;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Logueo extends javax.swing.JPanel implements Serializable {

    /**
     * Creates new form Logueo
     */
    public Logueo() {
        initComponents();
    }

    private File rutaImage;
    private String userName,Date;
    
    public JLabel getjLabelDate() {
        return jLabelDate;
    }

    public JLabel getjLabelUsername() {
        return jLabelUsername;
    }

    public JPanelImagen getjPanelImagen() {
        return jPanelImagen;
    }

    public File getRutaImage() {
        return rutaImage;
    }

    public void setRutaImage(File rutaImage) {
        this.rutaImage = rutaImage;
        jPanelImagen.setRutaImage(rutaImage);
    }

    public void setUserName(String userName) {
        this.userName = userName;
        jLabelUsername.setText(userName);
    }

    public void setDate(String Date) {
        this.Date = Date;
        jLabelDate.setText(Date);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelUsername = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jPanelImagen = new tarea31.JPanelImagen();

        jLabelUsername.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelUsername.setText("Username");

        jLabelDate.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelDate.setText("DateLogin");

        javax.swing.GroupLayout jPanelImagenLayout = new javax.swing.GroupLayout(jPanelImagen);
        jPanelImagen.setLayout(jPanelImagenLayout);
        jPanelImagenLayout.setHorizontalGroup(
            jPanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanelImagenLayout.setVerticalGroup(
            jPanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jPanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelUsername)
                        .addGap(26, 26, 26)
                        .addComponent(jLabelDate)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelUsername;
    private tarea31.JPanelImagen jPanelImagen;
    // End of variables declaration//GEN-END:variables
}
