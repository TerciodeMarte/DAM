/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tarea5;

import java.util.LinkedList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author TerciodeMarte
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private LinkedList<String> lista = new LinkedList<>();

    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fondo = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        inputpanel = new javax.swing.JPanel();
        anadir = new javax.swing.JButton();
        TF = new javax.swing.JTextField();
        combobox = new javax.swing.JComboBox<>();
        foto = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tarea 1_3_Películas_Albano_Diez_Paulino");
        setResizable(false);

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        titulo.setText("TOP 10 Mejores Peliculas de la Historia");

        anadir.setText("Añadir");
        anadir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        anadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadirActionPerformed(evt);
            }
        });

        combobox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout inputpanelLayout = new javax.swing.GroupLayout(inputpanel);
        inputpanel.setLayout(inputpanelLayout);
        inputpanelLayout.setHorizontalGroup(
            inputpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputpanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(inputpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(combobox, 0, 189, Short.MAX_VALUE)
                    .addComponent(TF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anadir)
                .addGap(56, 56, 56))
        );
        inputpanelLayout.setVerticalGroup(
            inputpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputpanelLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(inputpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anadir)
                    .addComponent(TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/fondo.jpg"))); // NOI18N

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(titulo))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 958, Short.MAX_VALUE)
                            .addComponent(inputpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 450, Short.MAX_VALUE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void anadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirActionPerformed
        String nombre = TF.getText();
        if (lista.size()< 10) {
            if (nombre.isBlank()) {
                JOptionPane jop = new JOptionPane("Introduce un nombre, por favor", JOptionPane.ERROR_MESSAGE);
                JDialog jd = jop.createDialog("ERROR");
                jd.setLocation(0, 0);
                jd.setVisible(true);
                jd.setAlwaysOnTop(true);

            } else if (!lista.contains(nombre)) {
                lista.add(nombre);
                combobox.addItem(nombre);


                JOptionPane jop = new JOptionPane("¡Pelicula añadida con exito!", JOptionPane.INFORMATION_MESSAGE);
                JDialog jd = jop.createDialog("¡Exito!");
                jd.setLocation(0, 0);
                jd.setVisible(true);
                jd.setAlwaysOnTop(true);

            } else {
                JOptionPane jop = new JOptionPane("Nombre Repetido, introduce otro", JOptionPane.ERROR_MESSAGE);
                JDialog jd = jop.createDialog("ERROR");
                jd.setLocation(0, 0);
                jd.setVisible(true);
                jd.setAlwaysOnTop(true);
            }

        } else {
            JOptionPane jop = new JOptionPane("Maximo numero alcanzdo(Maximo 10 Peliculas)", JOptionPane.ERROR_MESSAGE);
            JDialog jd = jop.createDialog("ERROR");
            jd.setLocation(0, 0);
            jd.setVisible(true);
            jd.setAlwaysOnTop(true);
        }

    }//GEN-LAST:event_anadirActionPerformed

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
    private javax.swing.JTextField TF;
    private javax.swing.JButton anadir;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel foto;
    private javax.swing.JPanel inputpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}