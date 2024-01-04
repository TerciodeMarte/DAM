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
public class DemoPrioridad {

    public static void main(String[] args) {
        PrioridadHilos ph1 = new PrioridadHilos("Prioridad Alta");
        PrioridadHilos ph2 = new PrioridadHilos("Prioridad Baja");
        PrioridadHilos ph3 = new PrioridadHilos("Prioridad Normal #1");
        PrioridadHilos ph4 = new PrioridadHilos("Prioridad Normal #2");
        PrioridadHilos ph5 = new PrioridadHilos("Prioridad Normal #3");

        //Establecer prioridades
        ph1.setPriority(Thread.MAX_PRIORITY);
        ph2.setPriority(Thread.MIN_PRIORITY);
        //Deje ph3, ph4 y ph5 en el nivel de prioridad normal predeterminado

        //Comenzar los hilos
        ph1.start();
        ph2.start();
        ph3.start();
        ph4.start();
        ph5.start();
        try {
            ph1.join();
            ph2.join();
            ph3.join();
            ph4.join();
            ph5.join();
        } catch (InterruptedException exc) {
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("\nHilo de alta prioridad contó hasta " + ph1.contar);
        System.out.println("Hilo de baja prioridad contó hasta " + ph2.contar);
        System.out.println("Hilo de normal prioridad #1 contó hasta " + ph3.contar);
        System.out.println("Hilo de normal prioridad #2 contó hasta " + ph4.contar);
        System.out.println("Hilo de normal prioridad #3 contó hasta " + ph5.contar);

    }
    
}
