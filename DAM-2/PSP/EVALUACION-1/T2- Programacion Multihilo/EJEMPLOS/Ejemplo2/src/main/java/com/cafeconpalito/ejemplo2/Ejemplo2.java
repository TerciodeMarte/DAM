/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.ejemplo2;

/**
 *
 * @author carra
 */
public class Ejemplo2 {

    public static void main(String[] args) {
        System.out.println("Hilo Inicial iniciando");
        MiHilo mh1 = new MiHilo("#1");
        MiHilo mh2 = new MiHilo("#2");
        MiHilo mh3 = new MiHilo("#3");
        
        mh1.start();
        mh2.start();
        mh3.start();
        
        for (int i = 0; i < 50; i++) {
            System.out.println("+");
        }
        System.out.println("Hilo Principal Finalizando");
        
    }
}
