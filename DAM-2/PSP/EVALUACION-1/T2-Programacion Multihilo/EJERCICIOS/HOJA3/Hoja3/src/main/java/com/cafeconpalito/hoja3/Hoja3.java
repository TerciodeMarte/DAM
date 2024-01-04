package com.cafeconpalito.hoja3;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Hoja3 {

    public static void main(String[] args) {

        Jardin j = new Jardin();

        ArrayList<Thread> hs = new ArrayList();

        for (int i = 0; i < 10; i++) {
            System.out.println("Suma 1 persona");
            Thread th = new Thread(new HiloSuma(j));
            th.start();
            hs.add(th);

        }

        for (int i = 0; i < 15; i++) {
            System.out.println("Resto una persona");
            Thread th = new Thread(new HiloResta(j));
            th.start();
            hs.add(th);
        }
        
        for (Thread h : hs) {
            try {
                h.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Hoja3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("El numero de personas en el jardin es de: " +j.getPersonas());

    }
}
