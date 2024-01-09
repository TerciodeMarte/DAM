/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.psp_tema3_socketsplantilla_cliente;

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
public class PSP_Tema3_SocketsPlantilla_Cliente {

    public static void main(String[] args) {
        
        System.out.println("Mensaje Inicio Cliente");
        
        Socket servidor = null;
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
        
        //Inicializo las conexionas a nulo dentro del TRY para que se cierren solas al salir
        try {

            //Parametros para conectar al server
            final String SERVER_IP = "localhost"; // "127.0.0.1"
            final int PUERTO = 6666;

            //Constuimos el Socket con el server
            servidor = new Socket(SERVER_IP, PUERTO);

            //Inicilizo las conexiones con el server con los parametros de este
            bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());
            
            //
            // TODO LO QUE QUIERAS HACER CON EL SERVIDOR
            //
            
                    
            
        } catch (IOException ex) {
            Logger.getLogger(PSP_Tema3_SocketsPlantilla_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        
        } finally {
            
            try {
                
                //Cerrando los flujos
                if (bufferDatosEntrada != null) {
                    bufferDatosEntrada.close();
                }
                if (bufferDatosSalida != null) {
                    bufferDatosSalida.close();
                }
                //Cerrando Server
                if (servidor != null) {
                    servidor.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(PSP_Tema3_SocketsPlantilla_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }

    }
    
}
