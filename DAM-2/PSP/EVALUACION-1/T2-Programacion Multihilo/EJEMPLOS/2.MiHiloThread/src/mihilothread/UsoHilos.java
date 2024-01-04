/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mihilothread;

/**
 *
 * @author joaqf
 */
public class UsoHilos {
     public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");

        //Primero, construye un objeto MiHilo.
        MiHiloThread m1=new MiHiloThread("#1");
        MiHiloThread m2= new MiHiloThread("#2");
        MiHiloThread m3= new MiHiloThread("#3");
        //Finalmente, comienza la ejecución del hilo.
       m1.start();
       m2.start();
       m3.start();
        try {
            for (int i = 0; i < 50; i++) {
                System.out.print(" .");
                Thread.sleep(100);
            }
        } catch (InterruptedException exc) {
            System.out.println("Hilo principal interrumpido.");
        }

        System.out.println("Hilo principal finalizado.");
    }

}
