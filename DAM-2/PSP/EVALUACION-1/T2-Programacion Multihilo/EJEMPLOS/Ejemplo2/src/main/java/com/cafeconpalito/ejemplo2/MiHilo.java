/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.ejemplo2;

/**
 *
 * @author Albano Díez de Paulino
 */
public class MiHilo extends Thread{

    String nombreHilo;

    public MiHilo(String nombre) {
        this.nombreHilo = nombre;
    }

    @Override
    public void run() {
        System.out.println("Comenzado Hilo" + nombreHilo);
        for (int i = 0; i < 10; i++) {
            System.out.println("En "+ nombreHilo + ", el recuento "+ i);
        }
        System.out.println("Terminado " + nombreHilo);
    }
    
    
    
    
}
