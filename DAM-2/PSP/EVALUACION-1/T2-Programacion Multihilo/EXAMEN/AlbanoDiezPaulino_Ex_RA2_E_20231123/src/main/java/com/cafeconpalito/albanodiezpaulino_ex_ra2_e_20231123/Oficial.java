package com.cafeconpalito.albanodiezpaulino_ex_ra2_e_20231123;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Oficial extends Thread {

    private String nombre;
    private DispositivosDrones dd;
    private int contador = 0;
    private int tiempo;

    public String getNombre() {
        return nombre;
    }

    public int getContador() {
        return contador;
    }

    public Oficial(DispositivosDrones dd, String nombre, int tiempo) {
        this.dd = dd;
        this.nombre = nombre;
        this.tiempo = tiempo;
        System.out.println("Oficial " + nombre + ": Siempre");
    }

    /**
     * Metodo para implementar el codigo de ejecucion del hilo
     */
    @Override
    public void run() {

        while (!dd.isFinalizar()) {

            try {
                dd.getDron(nombre);
                contador++;

                Thread.sleep(tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Oficial.class.getName()).log(Level.SEVERE, null, ex);
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
