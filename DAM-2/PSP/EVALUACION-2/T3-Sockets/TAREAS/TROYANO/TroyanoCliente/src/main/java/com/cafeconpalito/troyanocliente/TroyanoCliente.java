package com.cafeconpalito.troyanocliente;


/**
 *
 * @author carra
 */
public class TroyanoCliente {

    public static void main(String[] args) {
        System.out.println("Hola Mundo");

        HiloCliente h = new HiloCliente(); // creamos un hilo de cliente

        Thread t = new Thread(h);

        t.start(); //lanzamos el hilo
        System.out.println("Adios Mundo");

    }

}
