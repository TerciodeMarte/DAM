package com.cafeconpalito.albanodiezpaulino_ex_ra2_e_20231123;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class DispositivosDrones {

    private int tubos, drones;

    private int golpes = 0;

    private boolean finalizar = false;

    public DispositivosDrones(int tubos, int drones) {
        this.tubos = tubos;
        this.drones = drones;
    }

    public boolean isFinalizar() {
        return finalizar;
    }

    /**
     * Metodo para que un hilo cree un dron para la batalla
     * @param nombre Identificador del hilo
     */
    public synchronized void setDron(String nombre) {
        while (tubos <= 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(DispositivosDrones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            if (!finalizar) {
                System.out.println("Beep Beep,crrk,beep, ingeniero " + nombre + " he tomado el control");
                System.out.println("\t Soy el ingenerio " + nombre + " y estoy configurando un nuevo dron asesino");
                Thread.sleep(100);
                drones++;
                tubos--;
                System.out.println("\t Soy el ingenerio " + nombre + " !He configurado un nuevo dron!");
                System.out.println("Tubos libres " + tubos);
                notifyAll();
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(DispositivosDrones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para que un hilo consumo un dron
     * @param nombre Identificador del hilo
     */
    public synchronized void getDron(String nombre) {

        while (drones <= 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(DispositivosDrones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            System.out.println("Beep Beep,crrk,beep, oficial " + nombre + " he tomado el control");
            System.out.println("\t Soy el oficial " + nombre + " Voy a coger un nuevo dron asesino");
            Thread.sleep(20);
            drones--;
            tubos++;
            System.out.println("\t Soy el oficial " + nombre + " !He disparado un dron asesino!");
            golpes++;
            System.out.println("Numero de golpes a la fragata " + golpes);
            System.out.println("Tubos libres " + tubos);

            finalizar();
            notifyAll();
        } catch (InterruptedException ex) {
            Logger.getLogger(DispositivosDrones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para comprobar el final de la batalla
     */
    private synchronized void finalizar() {
        if (golpes == 6) {
            finalizar = true;
        }
    }
}
