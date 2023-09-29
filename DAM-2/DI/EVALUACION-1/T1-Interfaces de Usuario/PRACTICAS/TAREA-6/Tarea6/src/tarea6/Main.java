/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tarea6;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author carra
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        so = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        slider = new javax.swing.JSlider();
        numero = new javax.swing.JLabel();
        Windows = new javax.swing.JRadioButton();
        Mac = new javax.swing.JRadioButton();
        Linux = new javax.swing.JRadioButton();
        Ubuntu = new javax.swing.JRadioButton();
        Otros = new javax.swing.JRadioButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        generar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tarea 1_4_MiniEncuesta_Albano_Diez_Paulino");

        so.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        so.setText("Elige tu Sistema Operativo");
        so.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Elige tu Campo de Especializacion");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Horas de Uso o Visualizacion de Pantallas");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        slider.setMajorTickSpacing(1);
        slider.setMaximum(24);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setValue(12);
        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });

        numero.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        numero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numero.setText("12");
        numero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        grupo.add(Windows);
        Windows.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Windows.setText("Windows");
        Windows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WindowsActionPerformed(evt);
            }
        });

        grupo.add(Mac);
        Mac.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Mac.setText("MacOs");
        Mac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MacActionPerformed(evt);
            }
        });

        grupo.add(Linux);
        Linux.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Linux.setText("Linux");
        Linux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LinuxActionPerformed(evt);
            }
        });

        grupo.add(Ubuntu);
        Ubuntu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Ubuntu.setText("Ubuntu");
        Ubuntu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UbuntuActionPerformed(evt);
            }
        });

        grupo.add(Otros);
        Otros.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Otros.setText("Otros ...");
        Otros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OtrosActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBox1.setText("Programación");

        jCheckBox2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBox2.setText("Diseño Grafico");

        jCheckBox3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBox3.setText("Administración y Gestión");

        generar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        generar.setText("Generar");
        generar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Windows)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(so)
                                .addComponent(jSeparator1))
                            .addComponent(Mac)
                            .addComponent(Linux)
                            .addComponent(Ubuntu)
                            .addComponent(Otros)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(generar)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(so)
                .addGap(18, 18, 18)
                .addComponent(Windows)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Linux)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ubuntu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Otros)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(generar)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void WindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WindowsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WindowsActionPerformed

    private void MacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MacActionPerformed

    private void LinuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LinuxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LinuxActionPerformed

    private void UbuntuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UbuntuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UbuntuActionPerformed

    private void OtrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OtrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OtrosActionPerformed

    private void generarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generarMouseClicked
        // TODO add your handling code here:
        String radio = "";
        String esp = "";

        if (Windows.isSelected()) {
            radio = Windows.getText();
        } else if (Mac.isSelected()) {
            radio = Mac.getText();
        } else if (Linux.isSelected()) {
            radio = Linux.getText();
        } else if (Ubuntu.isSelected()) {
            radio = Ubuntu.getText();
        } else if (Otros.isSelected()) {
            radio = Otros.getText();
        }
        if (jCheckBox1.isSelected()) {
            esp += "\n" + jCheckBox1.getText();
        }
        if (jCheckBox2.isSelected()) {
            esp += "\n" + jCheckBox2.getText();
        }
        if (jCheckBox3.isSelected()) {
            esp += "\n" + jCheckBox3.getText();
        }
        JOptionPane jop = new JOptionPane("Sistema operativo seleccionado: " + radio + "\n"
                + "Especialidades seleccionadas: " + esp + "\n"
                + "Nº de horas dedicadas: " + slider.getValue(), JOptionPane.INFORMATION_MESSAGE);
        JDialog jd = jop.createDialog("Muestra de datos");
        jd.setLocation(0, 0);
        jd.setVisible(true);
        jd.setAlwaysOnTop(true);

        grupo.clearSelection();

        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        
        slider.setValue(12);
        

    }//GEN-LAST:event_generarMouseClicked

    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged
        // TODO add your handling code here:
        numero.setText(Integer.toString(slider.getValue()));
    }//GEN-LAST:event_sliderStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Linux;
    private javax.swing.JRadioButton Mac;
    private javax.swing.JRadioButton Otros;
    private javax.swing.JRadioButton Ubuntu;
    private javax.swing.JRadioButton Windows;
    private javax.swing.JButton generar;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel numero;
    private javax.swing.JSlider slider;
    private javax.swing.JLabel so;
    // End of variables declaration//GEN-END:variables
}