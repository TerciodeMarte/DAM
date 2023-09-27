/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Suma;
import vista.JFsuma;

/**
 *
 * @author msola
 */
public class ControladorSuma implements ActionListener {

    private final Suma modelo;
    private final JFsuma vista;

    public ControladorSuma(JFsuma vista, Suma modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.jBsuma.addActionListener(this);
        this.vista.jBlimpiar.addActionListener(this);
    }

    /**
     * MÉTODO PUBLICO PARA INICIAR EL PROGRAMA. LO INVOCARÁ MAIN
     *
     */
    public void iniciar() {
        vista.setTitle("Calculadora sumadora");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int numero1 = Integer.parseInt(vista.jTnum1.getText());
            int numero2 = Integer.parseInt(vista.jTnum2.getText());

            modelo.setN1(numero1);
            modelo.setN2(numero2);

            int resultado = modelo.sumar();

            vista.jTresultado.setText("" + resultado);
            // vista.jTextResultado.setText(String.valueOf(resultado));
        } catch (NumberFormatException ex) {
            System.err.println("Error de formato. " + ex.getMessage());
            vista.jTnum1.setText("");
            vista.jTnum2.setText("");
            vista.jTresultado.setText("Debes escribir dos números enteros.");
        }

    }

    private void limpiar() {
        vista.jTnum1.setText("");
        vista.jTnum2.setText("");
        vista.jTresultado.setText("");
    }

}
