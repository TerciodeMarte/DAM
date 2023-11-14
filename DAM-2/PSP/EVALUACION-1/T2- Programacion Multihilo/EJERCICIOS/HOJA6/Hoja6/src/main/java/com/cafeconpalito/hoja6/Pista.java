package com.cafeconpalito.hoja6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Pista {

    private int corredores;
    private int encarrera;
    private boolean enmarcas;

    public Pista() {
        this.corredores = 0;
        this.enmarcas = false;
    }

    public synchronized void marcas() {
        while (corredores < 3) {
            try {
                corredores++;
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!enmarcas) {
            encarrera = corredores + 1;
            System.out.println("Todos en sus marcas");
            enmarcas = true;
        }
    }

    public synchronized void correr() {

        try {

            Thread.sleep((long) (Math.random() * ((2000-1000+1)+1000)));
            encarrera--;
            if (encarrera != 0) {
                System.out.println("Pasando el testigo");
            }

            notify();

        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
