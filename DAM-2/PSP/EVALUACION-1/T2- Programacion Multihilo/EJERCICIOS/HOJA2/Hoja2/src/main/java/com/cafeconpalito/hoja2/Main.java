/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.hoja2;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Albano Díez de Paulino
 */
public class Main {

    public static void main(String[] args) {
        // Ejercicio1
        /*
        Ejercicio1 e1=new Ejercicio1(true);
        Ejercicio1 e2=new Ejercicio1(false);
        
        e1.start();
        e2.start();
         */
        
        // Ejercicio2
        
        /*System.out.println("Hola Mundo");
        Ejercicio2 ej = new Ejercicio2(args[0]);
        ej.start();
        try {
            ej.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        System.out.println("Adios Mundo");*/
        
        //Ejercicio 3
        
        System.out.println("Hola Mundo");
        
        ArrayList <Ejercicio3> lista = new ArrayList();
        for (int i = 0; i < args.length; i++) {
            Ejercicio3 e = new Ejercicio3(args[i]);
            lista.add(e);
        }

        for (Ejercicio3 i : lista) {
            i.run();
        }

        for (Ejercicio3 i : lista) {
            try {
                i.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Adios Mundo");

    }
}
