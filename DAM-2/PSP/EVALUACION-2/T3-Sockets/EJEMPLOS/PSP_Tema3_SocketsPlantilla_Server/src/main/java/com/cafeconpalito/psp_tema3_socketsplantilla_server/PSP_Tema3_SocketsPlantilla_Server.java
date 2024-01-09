/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.psp_tema3_socketsplantilla_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cafe Con Palito
 */
public class PSP_Tema3_SocketsPlantilla_Server {

    public static void main(String[] args) {

        ServerSocket servidor; //escucha del servidor
        final int PUERTO = 6666; //puerto de escucha (a partir del 1024)
        Socket cliente; // atencion a cliente

        System.out.println("Mensaje Inicio");

        try {

            //apertura de socket para escuchar a través de un puerto
            servidor = new ServerSocket(PUERTO);

            do {

                cliente = servidor.accept(); //aceptamos la conexión de un cliente

                HiloServer h = new HiloServer(cliente); // creamos un hilo de cliente

                Thread t = new Thread(h);

                t.start(); //lanzamos el hilo

            } while (true);

        } catch (IOException ex) {

            Logger.getLogger(PSP_Tema3_SocketsPlantilla_Server.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}
