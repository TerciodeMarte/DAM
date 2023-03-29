/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Calculadora;

/**
 *
 * @author carra
 */
public class calculadora2 extends javax.swing.JFrame {

    /**
     * Creates new form calculadora2
     */
    private double num1, num2, result = 0;
    private boolean control = true;
    private byte operacion = 0;

    public calculadora2() {
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

        TextCalculator = new javax.swing.JLabel();
        n1 = new javax.swing.JTextField();
        n2 = new javax.swing.JTextField();
        C = new javax.swing.JButton();
        resta = new javax.swing.JButton();
        division = new javax.swing.JButton();
        resultado = new javax.swing.JButton();
        suma = new javax.swing.JButton();
        producto = new javax.swing.JButton();
        re = new javax.swing.JTextField();
        Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora");
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(285, 299));
        setMinimumSize(new java.awt.Dimension(285, 299));
        setResizable(false);
        setSize(new java.awt.Dimension(285, 299));

        TextCalculator.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TextCalculator.setText("CALCULADORA");

        n1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        n1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        n1.setEnabled(false);
        n1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n1ActionPerformed(evt);
            }
        });

        n2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        n2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        n2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n2ActionPerformed(evt);
            }
        });

        C.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        C.setText("C");
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CActionPerformed(evt);
            }
        });

        resta.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        resta.setText("-");
        resta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaActionPerformed(evt);
            }
        });

        division.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        division.setText("÷");
        division.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        division.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divisionActionPerformed(evt);
            }
        });

        resultado.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        resultado.setText("=");
        resultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultadoActionPerformed(evt);
            }
        });

        suma.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        suma.setText("+");
        suma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumaActionPerformed(evt);
            }
        });

        producto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        producto.setText("x");
        producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoActionPerformed(evt);
            }
        });

        re.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        re.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        re.setEnabled(false);
        re.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reActionPerformed(evt);
            }
        });

        Salir.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(n1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(n2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(resultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(suma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(C, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(resta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(division, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(re, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(Salir, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TextCalculator, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(TextCalculator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(n1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(n2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(re, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(division, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(C, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void n1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n1ActionPerformed

    private void n2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n2ActionPerformed

    private void CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CActionPerformed
        //Borrar los campos
        n1.setText("");
        n2.setText("");
        re.setText("");
    }//GEN-LAST:event_CActionPerformed

    private void restaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaActionPerformed
        try {
            if (control) {
                num1 = Double.parseDouble(n2.getText());
                n1.setText(num1 + "-");
                n2.setText("");
                control = false;
                operacion = 2;
            } else {
                n1.setText(num1 + "-");
                n2.setText("");
                operacion = 2;
            }

        } catch (NumberFormatException e) {
            n2.setText("ERROR");
        }
    }//GEN-LAST:event_restaActionPerformed

    private void divisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divisionActionPerformed
        try {
            if (control) {
                num1 = Double.parseDouble(n2.getText());
                n1.setText(num1 + "÷");
                n2.setText("");
                control = false;
                operacion = 4;
            } else {
                n1.setText(num1 + "÷");
                n2.setText("");
                operacion = 4;
            }

        } catch (NumberFormatException e) {
            n2.setText("ERROR");
        }
    }//GEN-LAST:event_divisionActionPerformed

    private void resultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultadoActionPerformed
        try {
            num2 = Double.parseDouble(n2.getText());
            switch (operacion) {
                case 1:
                    n1.setText(num1 + "+" + num2);
                    n2.setText("");
                    re.setText(Double.toString(num1 + num2));
                    control = true;
                    num1 = 0;
                    num2 = 0;
                    break;
                case 2:
                    n1.setText(num1 + "-" + num2);
                    n2.setText("");
                    re.setText(Double.toString(num1 - num2));
                    control = true;
                    num1 = 0;
                    num2 = 0;
                    break;
                case 3:
                    n1.setText(num1 + "x" + num2);
                    n2.setText("");
                    re.setText(Double.toString(num1 * num2));
                    control = true;
                    num1 = 0;
                    num2 = 0;
                    break;
                case 4:
                    if (num2 == 0) {
                        re.setText("Math Error");

                    } else {
                        n1.setText(num1 + "÷" + num2);
                        n2.setText("");
                        re.setText(Double.toString(num1 / num2));
                        control = true;
                        num1 = 0;
                        num2 = 0;
                    }

                    break;
                default:

            }
        } catch (NumberFormatException e) {
            n2.setText("ERROR");
        }
    }//GEN-LAST:event_resultadoActionPerformed

    private void sumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumaActionPerformed
        try {
            if (control) {
                num1 = Double.parseDouble(n2.getText());
                n1.setText(num1 + "+");
                n2.setText("");
                control = false;
                operacion = 1;
            } else {
                n1.setText(num1 + "+");
                n2.setText("");
                operacion = 1;
            }

        } catch (NumberFormatException e) {
            n2.setText("ERROR");
        }
    }//GEN-LAST:event_sumaActionPerformed

    private void productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoActionPerformed
        try {
            if (control) {
                num1 = Double.parseDouble(n2.getText());
                n1.setText(num1 + "x");
                n2.setText("");
                control = false;
                operacion = 3;
            } else {
                n1.setText(num1 + "x");
                n2.setText("");
                operacion = 3;
            }

        } catch (NumberFormatException e) {
            n2.setText("ERROR");
        }
    }//GEN-LAST:event_productoActionPerformed

    private void reActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        //Salir de la aplicacion
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

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
            java.util.logging.Logger.getLogger(calculadora2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calculadora2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calculadora2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calculadora2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calculadora2().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton C;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel TextCalculator;
    private javax.swing.JButton division;
    private javax.swing.JTextField n1;
    private javax.swing.JTextField n2;
    private javax.swing.JButton producto;
    private javax.swing.JTextField re;
    private javax.swing.JButton resta;
    private javax.swing.JButton resultado;
    private javax.swing.JButton suma;
    // End of variables declaration//GEN-END:variables
}
