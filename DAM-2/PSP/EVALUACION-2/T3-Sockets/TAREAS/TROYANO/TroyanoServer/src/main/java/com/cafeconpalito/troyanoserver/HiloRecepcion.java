/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.troyanoserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class HiloRecepcion implements Runnable {

    ServerSocket servidor; //escucha del servidor
    final int PUERTO = 6666; //puerto de escucha (a partir del 1024)

    Socket cliente; // atencion a cliente

    @Override
    public void run() {

        try {
            servidor = new ServerSocket(PUERTO);
            do {
                cliente = servidor.accept();

                HiloServer h = new HiloServer(cliente); // creamos un hilo de cliente

                h.start();

                TroyanoServer.getListaactivos().add(h);
                

            } while (true);

        } catch (IOException ex) {
            Logger.getLogger(TroyanoServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
