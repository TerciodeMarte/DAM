/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoprioridad;

/**
 *
 * @author joaqf
 */
public class PrioridadHilos extends Thread {

    int contar;

    static boolean stop = false;
    private String actualNombre;

    //Construye un nuevo hilo.
    PrioridadHilos(String nombre) {
        contar = 0;
        actualNombre = nombre;
    }

    //Punto de entrada de hilo.
    public void run() {
        System.out.println(getName() + " iniciando.");
        do {
            contar++;
            //if (actualNombre.compareTo(getName()) != 0) {
             //   actualNombre = getName();
             //   System.out.println("En " + actualNombre + contar);
            //}
        } while (stop == false && contar < 100000000);
        stop = true;
        System.out.println("\n" + getName() + " terminado.");
    }

}
