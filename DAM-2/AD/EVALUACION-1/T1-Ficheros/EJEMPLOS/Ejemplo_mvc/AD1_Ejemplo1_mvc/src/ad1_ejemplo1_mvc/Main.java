/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad1_ejemplo1_mvc;

import controlador.ControladorSuma;
import modelo.Suma;
import vista.JFsuma;

/**
 *
 * @author msola
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Suma modelo =new Suma();
        JFsuma vista = new JFsuma();
        ControladorSuma controlador = new ControladorSuma(vista, modelo);
        controlador.iniciar();
        
    }
    
}
