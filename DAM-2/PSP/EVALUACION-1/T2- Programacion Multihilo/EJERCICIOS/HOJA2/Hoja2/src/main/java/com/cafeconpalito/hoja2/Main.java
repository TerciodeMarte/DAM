/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.hoja2;


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
        System.out.println("Hola Mundo");
        Ejercicio2 ej = new Ejercicio2(args[0]);
        ej.start();
        while (ej.isAlive()) {
           Thread.currentThread().interrupt();
        }
      
        System.out.println("Adios Mundo");

    }
}
