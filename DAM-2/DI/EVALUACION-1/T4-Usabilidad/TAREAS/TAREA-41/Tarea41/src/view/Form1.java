/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import com.toedter.calendar.JDateChooser;
import controller.Validation;
import java.awt.Color;
import java.awt.Image;
import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author carra
 */
public class Form1 extends javax.swing.JPanel {

    /**
     * Creates new form Form1
     */
    public Form1() {
        initComponents();
        ImageIcon image = new ImageIcon("src/resources/flecha-derecha.png");
        Image imgEscalada = image.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon imgFinal = new ImageIcon(imgEscalada);
        next.setIcon(imgFinal);
        this.repaint();
        JLFNameError.setVisible(false);
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
        TFFName = new javax.swing.JTextField();
        JLFNameError = new javax.swing.JLabel();
        next = new javax.swing.JLabel();
        TFGenre = new javax.swing.JTextField();
        JLGenre = new javax.swing.JLabel();
        JLGenre1 = new javax.swing.JLabel();
        ComboCompany = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        JLCompany2 = new javax.swing.JLabel();
        ComboDistribution = new javax.swing.JComboBox<>();
        JLContinent = new javax.swing.JLabel();
        JLContinent1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        JLFName1 = new javax.swing.JLabel();

        fondo.setBackground(new java.awt.Color(27, 40, 56));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TFFName.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        TFFName.setForeground(new java.awt.Color(153, 153, 153));
        TFFName.setText("Name");
        TFFName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TFFNameFocusGained(evt);
            }
        });
        TFFName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFFNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFFNameKeyTyped(evt);
            }
        });
        fondo.add(TFFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 220, 40));

        JLFNameError.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        JLFNameError.setForeground(new java.awt.Color(255, 51, 51));
        JLFNameError.setText("This Game already exists or Field Null");
        JLFNameError.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        fondo.add(JLFNameError, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 260, 40));

        next.setName("JNext1"); // NOI18N
        fondo.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 40, 40));

        TFGenre.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        TFGenre.setForeground(new java.awt.Color(153, 153, 153));
        TFGenre.setText("Genre");
        TFGenre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TFGenreFocusGained(evt);
            }
        });
        fondo.add(TFGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 220, 40));

        JLGenre.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        JLGenre.setForeground(new java.awt.Color(255, 255, 255));
        JLGenre.setText("Genre: ");
        JLGenre.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        fondo.add(JLGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 50, 40));

        JLGenre1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        JLGenre1.setForeground(new java.awt.Color(255, 255, 255));
        JLGenre1.setText("Date Release: ");
        JLGenre1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        fondo.add(JLGenre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 100, 40));

        ComboCompany.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        ComboCompany.setForeground(new java.awt.Color(153, 153, 153));
        ComboCompany.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Seleccionar>", "Valve Corporation", "Paradox Interactive", "Microsoft Games", "Blizzard Games" }));
        ComboCompany.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ComboCompanyFocusGained(evt);
            }
        });
        fondo.add(ComboCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 220, 40));

        jDateChooser1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jDateChooser1.setMaxSelectableDate(new java.util.Date(2524608080000L));
        jDateChooser1.setMinSelectableDate(new java.util.Date(455324462000L));
        fondo.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 220, 40));

        JLCompany2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        JLCompany2.setForeground(new java.awt.Color(255, 255, 255));
        JLCompany2.setText("Company: ");
        JLCompany2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        fondo.add(JLCompany2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 80, 40));

        ComboDistribution.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        ComboDistribution.setForeground(new java.awt.Color(153, 153, 153));
        ComboDistribution.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Seleccionar>", "America", "Europa", "Asia", "Africa", "Oceania" }));
        ComboDistribution.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ComboDistributionFocusGained(evt);
            }
        });
        fondo.add(ComboDistribution, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 220, 40));

        JLContinent.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        JLContinent.setForeground(new java.awt.Color(255, 255, 255));
        JLContinent.setText("PEGI: ");
        JLContinent.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        fondo.add(JLContinent, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 100, 40));

        JLContinent1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        JLContinent1.setForeground(new java.awt.Color(255, 255, 255));
        JLContinent1.setText("Distribution: ");
        JLContinent1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        fondo.add(JLContinent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 100, 40));

        jSpinner1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerListModel(new String[] {"+3", "+7", "+12", "+16", "+18"}));
        fondo.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 220, 40));

        JLFName1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        JLFName1.setForeground(new java.awt.Color(255, 255, 255));
        JLFName1.setText("Name: ");
        JLFName1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        fondo.add(JLFName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 50, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TFFNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFFNameKeyTyped

    }//GEN-LAST:event_TFFNameKeyTyped

    private void TFFNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFFNameKeyReleased
        if (Validation.name(TFFName.getText())) {
            JLFNameError.setVisible(true);
        } else {
            JLFNameError.setVisible(false);
        }
    }//GEN-LAST:event_TFFNameKeyReleased

    private void TFFNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFFNameFocusGained
        // TODO add your handling code here:
        if (TFFName.getText().equals("Name")) {
            TFFName.setText("");
            TFFName.setForeground(Color.BLACK);
        }
        if (TFGenre.getText().isBlank()) {
            TFGenre.setText("Genre");
            TFGenre.setForeground(Color.GRAY);
        }
        if (ComboCompany.getSelectedIndex() == 0) {
            ComboCompany.setForeground(Color.GRAY);
        }
        if (ComboDistribution.getSelectedIndex() == 0) {
            ComboDistribution.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_TFFNameFocusGained

    private void TFGenreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFGenreFocusGained
        if (TFGenre.getText().equals("Genre")) {
            TFGenre.setText("");
            TFGenre.setForeground(Color.BLACK);
        }
        if (TFFName.getText().isBlank()) {
            TFFName.setText("Name");
            TFFName.setForeground(Color.GRAY);
        }
        if (ComboCompany.getSelectedIndex() == 0) {
            ComboCompany.setForeground(Color.GRAY);
        }
        if (ComboDistribution.getSelectedIndex() == 0) {
            ComboDistribution.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_TFGenreFocusGained

    private void ComboDistributionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ComboDistributionFocusGained
        if (TFFName.getText().isBlank()) {
            TFFName.setText("Name");
            TFFName.setForeground(Color.GRAY);
        }
        if (TFGenre.getText().isBlank()) {
            TFGenre.setText("Genre");
            TFGenre.setForeground(Color.GRAY);
        }
        if (ComboCompany.getSelectedIndex() == 0) {
            ComboCompany.setForeground(Color.GRAY);
        }

        ComboDistribution.setForeground(Color.BLACK);

    }//GEN-LAST:event_ComboDistributionFocusGained

    private void ComboCompanyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ComboCompanyFocusGained
        if (TFFName.getText().isBlank()) {
            TFFName.setText("Name");
            TFFName.setForeground(Color.GRAY);
        }
        if (TFGenre.getText().isBlank()) {
            TFGenre.setText("Genre");
            TFGenre.setForeground(Color.GRAY);
        }
        if (ComboDistribution.getSelectedIndex() == 0) {
            ComboDistribution.setForeground(Color.GRAY);
        }

        ComboCompany.setForeground(Color.BLACK);
    }//GEN-LAST:event_ComboCompanyFocusGained

    public JComboBox<String> getComboCompany() {
        return ComboCompany;
    }

    public JComboBox<String> getComboDistribution() {
        return ComboDistribution;
    }

    public JTextField getTFFName() {
        return TFFName;
    }

    public JTextField getTFGenre() {
        return TFGenre;
    }

    public JDateChooser getjDateChooser1() {
        return jDateChooser1;
    }

    public JSpinner getjSpinner1() {
        return jSpinner1;
    }

    public JLabel getNext() {
        return next;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboCompany;
    private javax.swing.JComboBox<String> ComboDistribution;
    private javax.swing.JLabel JLCompany2;
    private javax.swing.JLabel JLContinent;
    private javax.swing.JLabel JLContinent1;
    private javax.swing.JLabel JLFName1;
    private javax.swing.JLabel JLFNameError;
    private javax.swing.JLabel JLGenre;
    private javax.swing.JLabel JLGenre1;
    private javax.swing.JTextField TFFName;
    private javax.swing.JTextField TFGenre;
    private javax.swing.JPanel fondo;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel next;
    // End of variables declaration//GEN-END:variables
}
