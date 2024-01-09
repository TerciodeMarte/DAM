/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema3_socketsplantilla_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cafe Con Palito
 */
public class HiloServer implements Runnable{
    
    private Socket cliente = null;

    public HiloServer(Socket cliente) {
        this.cliente = cliente;
    }
    
    
    @Override
    public void run() {
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
 
        try {
 
            //Inicilizo las conexiones con el server con los parametros de este
            bufferDatosEntrada = new DataInputStream(cliente.getInputStream());
            bufferDatosSalida = new DataOutputStream(cliente.getOutputStream());

            //
            //TODO LO QUE QUIERAS QUE HAGA LA CONEXION CON EL CLIENTE.
            //
            
            
            
        } catch (IOException ex) {
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
 
                System.out.println("Mensaje Despedida");
 
            } catch (IOException ex) {
                Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
