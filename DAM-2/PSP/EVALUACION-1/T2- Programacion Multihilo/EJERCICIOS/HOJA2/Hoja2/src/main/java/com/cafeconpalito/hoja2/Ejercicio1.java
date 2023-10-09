/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.hoja2;

/**
 *
 * @author Albano Díez de Paulino
 */
/*1.- Realiza un programa en java que ejecute dos hilos de forma concurrente. Uno 
de ellos debe sumar los números pares del 1 al 1000 y el otro los impares.*/
public class Ejercicio1 extends Thread {

    private boolean isPar;
    private int suma = 0;

    public Ejercicio1(boolean isPar) {
        this.isPar = isPar;
    }

    @Override
    public void run() {
        if (isPar) {
            sumarPares();
        }else{
            sumarImpares();
        }
    }

    public void sumarPares() {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                suma += i;
            }
        }
        System.out.println("la suma de los pares es: " + suma);
    }

    public void sumarImpares() {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 != 0) {
                suma += i;
            }
        }
        System.out.println("la suma de los impares es: " + suma);
    }
}
