/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tarea1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
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
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        inputF = new javax.swing.JTextField();
        boton = new javax.swing.JButton();
        conversor = new javax.swing.JLabel();
        inputC = new javax.swing.JTextField();
        c = new javax.swing.JLabel();
        f = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conversor C a F");
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(230, 220));
        setName("Conversor"); // NOI18N
        setPreferredSize(new java.awt.Dimension(230, 200));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(153, 204, 255));
        background.setPreferredSize(new java.awt.Dimension(300, 200));

        inputF.setFocusable(false);
        inputF.setRequestFocusEnabled(false);

        boton.setBackground(new java.awt.Color(102, 255, 0));
        boton.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        boton.setText("Convertir");
        boton.setPreferredSize(new java.awt.Dimension(82, 22));
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMouseClicked(evt);
            }
        });

        conversor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        conversor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        conversor.setText("Conversor");

        inputC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputCFocusGained(evt);
            }
        });
        inputC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputCKeyPressed(evt);
            }
        });

        c.setText("ºC");

        f.setText("ºF");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(boton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputF, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputC, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(f)
                            .addComponent(c)))
                    .addComponent(conversor, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(conversor, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMouseClicked
        boton();
    }//GEN-LAST:event_botonMouseClicked

    private void inputCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputCFocusGained
        inputF.setText("");
        inputC.setText("");
    }//GEN-LAST:event_inputCFocusGained

    private void inputCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputCKeyPressed
        int key = evt.getKeyCode();

        if (key == KeyEvent.VK_ENTER) {
            boton();
        }
    }//GEN-LAST:event_inputCKeyPressed

    private void boton() {
        String valorCelsius = inputC.getText();
        double celsius;

        try {

            celsius = Double.parseDouble(valorCelsius);

            double fahren;

            fahren = (celsius * 9 / 5) + 32;

            inputF.setText(Double.toString(fahren));
            inputF.setForeground(Color.BLACK);

        } catch (NumberFormatException e) {
            inputF.setText("Error");
            inputF.setForeground(Color.RED);

            if (e.getMessage().contains(",")) {

                JOptionPane.showMessageDialog(null, "Dato con coma", "ERROR", JOptionPane.ERROR_MESSAGE);

            } else if (e.getMessage().contains("empty")) {

                JOptionPane.showMessageDialog(null, "Introduce un dato valido", "Info", JOptionPane.INFORMATION_MESSAGE);

            } else {

                JOptionPane.showMessageDialog(null, "Dato no numerico", "ERROR", JOptionPane.ERROR_MESSAGE);

            }

        }
        inputC.requestFocus();
    }

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
    private javax.swing.JPanel background;
    private javax.swing.JButton boton;
    private javax.swing.JLabel c;
    private javax.swing.JLabel conversor;
    private javax.swing.JLabel f;
    private javax.swing.JTextField inputC;
    private javax.swing.JTextField inputF;
    // End of variables declaration//GEN-END:variables
}
