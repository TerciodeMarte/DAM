/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author carra
 */
public class Form2 extends javax.swing.JPanel {

    /**
     * Creates new form Form1
     */
    public Form2() {
        initComponents();
        ImageIcon image = new ImageIcon("src/resources/check.png");
        Image imgEscalada = image.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon imgFinal = new ImageIcon(imgEscalada);
        next.setIcon(imgFinal);
        this.repaint();
        
        ImageIcon image2 = new ImageIcon("src/resources/flecha-izquierda.png");
        Image imgEscalada2 = image2.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon imgFinal2= new ImageIcon(imgEscalada2);
        back.setIcon(imgFinal2);
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

        fondo = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        next = new javax.swing.JLabel();
        JLDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TADes = new javax.swing.JTextArea();
        JLDescripcion1 = new javax.swing.JLabel();
        load = new javax.swing.JButton();
        JLDescripcion2 = new javax.swing.JLabel();
        TFRuta = new javax.swing.JTextField();
        JLDescripcion3 = new javax.swing.JLabel();
        TFVersion1 = new javax.swing.JTextField();
        precio = new javax.swing.JSpinner();
        JLDescripcion4 = new javax.swing.JLabel();

        fondo.setBackground(new java.awt.Color(27, 40, 56));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setName("JBack2"); // NOI18N
        fondo.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 40, 40));

        next.setName("JNext2"); // NOI18N
        fondo.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 40, 40));

        JLDescripcion.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        JLDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        JLDescripcion.setText("€ ");
        JLDescripcion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        fondo.add(JLDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 110, 40));

        TADes.setColumns(20);
        TADes.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        TADes.setRows(5);
        jScrollPane1.setViewportView(TADes);

        fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 550, 110));

        JLDescripcion1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        JLDescripcion1.setForeground(new java.awt.Color(255, 255, 255));
        JLDescripcion1.setText("Description: ");
        JLDescripcion1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        fondo.add(JLDescripcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 40));

        load.setBackground(new java.awt.Color(172, 213, 80));
        load.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        load.setForeground(new java.awt.Color(255, 255, 255));
        load.setText("LoadImage");
        load.setToolTipText("");
        load.setActionCommand("LoadImage");
        load.setBorder(null);
        load.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        load.setName("LoadImage"); // NOI18N
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadActionPerformed(evt);
            }
        });
        fondo.add(load, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 160, 40));

        JLDescripcion2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        JLDescripcion2.setForeground(new java.awt.Color(255, 255, 255));
        JLDescripcion2.setText("Image: ");
        JLDescripcion2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        fondo.add(JLDescripcion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 110, 40));

        TFRuta.setEditable(false);
        TFRuta.setBackground(new java.awt.Color(255, 255, 255));
        TFRuta.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        TFRuta.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        fondo.add(TFRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 350, 40));

        JLDescripcion3.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        JLDescripcion3.setForeground(new java.awt.Color(255, 255, 255));
        JLDescripcion3.setText("Version: ");
        JLDescripcion3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        fondo.add(JLDescripcion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 110, 40));

        TFVersion1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        fondo.add(TFVersion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 350, 40));

        precio.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, 70.0d, 0.1d));
        precio.setToolTipText("");
        fondo.add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 220, 40));

        JLDescripcion4.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        JLDescripcion4.setForeground(new java.awt.Color(255, 255, 255));
        JLDescripcion4.setText("Price: ");
        JLDescripcion4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        fondo.add(JLDescripcion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadActionPerformed

    public JLabel getBack() {
        return back;
    }

    public void setBack(JLabel back) {
        this.back = back;
    }

    public JLabel getNext() {
        return next;
    }

    public void setNext(JLabel next) {
        this.next = next;
    }

    public JTextField getTFVersion1() {
        return TFVersion1;
    }

    public void setTFVersion1(JTextField TFVersion1) {
        this.TFVersion1 = TFVersion1;
    }

    public JTextField getjRuta() {
        return TFRuta;
    }

    public void setjRuta(JTextField jRuta) {
        this.TFRuta = jRuta;
    }

    public JSpinner getjSpinner1() {
        return precio;
    }

    public void setjSpinner1(JSpinner jSpinner1) {
        this.precio = jSpinner1;
    }

    public JTextArea getjTextArea1() {
        return TADes;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.TADes = jTextArea1;
    }

    public JButton getLoad() {
        return load;
    }

    public void setLoad(JButton load) {
        this.load = load;
    }

    public JTextArea getTADes() {
        return TADes;
    }

    public JTextField getTFRuta() {
        return TFRuta;
    }

    public JSpinner getPrecio() {
        return precio;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLDescripcion;
    private javax.swing.JLabel JLDescripcion1;
    private javax.swing.JLabel JLDescripcion2;
    private javax.swing.JLabel JLDescripcion3;
    private javax.swing.JLabel JLDescripcion4;
    private javax.swing.JTextArea TADes;
    private javax.swing.JTextField TFRuta;
    private javax.swing.JTextField TFVersion1;
    private javax.swing.JLabel back;
    private javax.swing.JPanel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton load;
    private javax.swing.JLabel next;
    private javax.swing.JSpinner precio;
    // End of variables declaration//GEN-END:variables
}
