/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.diezpaulinoalbano_ex_ra3_server_20240115;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class MainServer {

    /**
     * Metodo que lanza un hilo cada vez que se conecta un cliente
     * @param args argumentos pasados por comando
     */
    public static void main(String[] args) {

        ServerSocket servidor; //escucha del servidor
        final int PUERTO = 9666; //puerto de escucha (a partir del 1024)
        Socket cliente; // atencion a cliente
        int contador=0;

        System.out.println("Mensaje Inicio");

        try {

            //apertura de socket para escuchar a través de un puerto
            servidor = new ServerSocket(PUERTO);

            do {

                cliente = servidor.accept(); //aceptamos la conexión de un cliente

                contador++;
                
                HiloServer h = new HiloServer(cliente,contador); // creamos un hilo de cliente

                Thread t = new Thread(h);

                t.start(); //lanzamos el hilo

            } while (true);

        } catch (IOException ex) {

            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
