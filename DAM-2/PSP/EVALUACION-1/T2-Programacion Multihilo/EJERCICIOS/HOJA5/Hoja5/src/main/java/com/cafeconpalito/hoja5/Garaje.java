package com.cafeconpalito.hoja5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Garaje {

    private int cuenta = 100;


    public synchronized int entrar() {
        while (cuenta >= 200) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Garaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        cuenta++;
    

        System.out.println("Coche " + cuenta + " ENTRA al garaje");
        System.out.println("Coches en el garaje " + cuenta);

        notifyAll();
        return cuenta;
    }

    public synchronized int salir() {
        while (cuenta <= 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Garaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        cuenta--;
        System.out.println("Coche " + cuenta + " SALE al garaje");
        System.out.println("Coches en el garaje " + cuenta);
        
        notifyAll();
        return cuenta;
    }

}
