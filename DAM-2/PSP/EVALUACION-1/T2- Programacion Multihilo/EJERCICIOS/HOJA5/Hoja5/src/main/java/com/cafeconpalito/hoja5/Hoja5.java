package com.cafeconpalito.hoja5;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Hoja5 {

    public static void main(String[] args) {
        try {
            Garaje g = new Garaje();

            ArrayList<Thread> a = new ArrayList();
            for (int i = 0; i < 150; i++) {
                Thread entrar = new Thread(new HiloEntrar(g));
                entrar.start();
                a.add(entrar);
            }

            for (int i = 0; i < 60; i++) {
                Thread salir = new Thread(new HiloSalir(g));
                salir.start();
                a.add(salir);
            }

            for (Thread thread : a) {
                thread.join();
            }

            System.out.println("GARAJE CERRADO");
        } catch (InterruptedException ex) {
            Logger.getLogger(Hoja5.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
