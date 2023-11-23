package com.cafeconpalito.albanodiezpaulino_ex_ra2_e_20231123;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Ingeniero extends Thread {

    private String nombre;
    private DispositivosDrones dd;
    private int tiempo;

    public Ingeniero(DispositivosDrones dd, String nombre, int tiempo) {
        this.dd = dd;
        this.nombre = nombre;
        this.tiempo = tiempo;
        System.out.println("Ingenerio " + nombre + ": Que la fuerza nos acompañe");
    }

     /**
     * Metodo para implementar el codigo de ejecucion del hilo
     */
    @Override
    public void run() {
        
        while (!dd.isFinalizar()) {
            try {
                dd.setDron(nombre);
                Thread.sleep(tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ingeniero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

     /**
     * Metodo para imprimir por pantalla el mensaje final de batalla
     */
    public void finalizar() {
        System.out.println(nombre + ": Si! La batalla ha terminado");
    }

}
