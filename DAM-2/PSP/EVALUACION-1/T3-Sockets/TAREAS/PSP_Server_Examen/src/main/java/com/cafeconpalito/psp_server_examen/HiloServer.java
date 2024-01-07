/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_server_examen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author produccion
 */
public class HiloServer implements Runnable {

    private Socket cliente;
    private int numAleat;

    public HiloServer(Socket cliente) {
        this.cliente = cliente;
        numAleat = (int) (Math.random() * 100 + 1);
    }

    @Override
    public void run() {
        System.out.println("el numero aleatorio es: " + numAleat);

        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;

        try {

            //Inicilizo las conexiones con el server con los parametros de este
            bufferDatosEntrada = new DataInputStream(cliente.getInputStream());
            bufferDatosSalida = new DataOutputStream(cliente.getOutputStream());

            // 1 -----------
            // Enviamos Opciones al cliente
            bufferDatosSalida.writeUTF("Selecciona una Opcion \n\t1. Jugar Aleatorio\n\t2. Enviar Imagen\n\t3. Recibir Imagen\n\t4. Cerrar Server");

            // 2 -----------
            //SELECCIONAMOS OPCION
            int opcion = bufferDatosEntrada.readInt();
            //System.out.println(opcion);

            switch (opcion) {
                case 1:
                
                    opcion1(bufferDatosEntrada, bufferDatosSalida);
                    //METODO!!!
                    
                    break;
                case 2:
                    
                    //METODO!!!
                    
                    break;  
                case 3:
                    
                    //METODO
                    
                    break;
                case 4:

                    //METODO
                    System.out.println("Cerrando Server");
                    System.exit(0);
                    break;
                default:
            }

        } catch (IOException ex) {
            Logger.getLogger(PSP_Server_Examen.class.getName()).log(Level.SEVERE, null, ex);

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

                System.out.println("Adios Cliente");

            } catch (IOException ex) {
                Logger.getLogger(PSP_Server_Examen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    private void opcion1(DataInputStream bufferDatosEntrada, DataOutputStream bufferDatosSalida) throws IOException{
        
        boolean comprobar = true;
        do {
            // 1 ENVIO INFO
            bufferDatosSalida.writeUTF("introduce un numero: ");
            
            // 2 RECIBO NUMERO
            int numero = bufferDatosEntrada.readInt();
            
            // 3 ENVIANDO MENSAJE AL CLIENTE
            if (numero < numAleat) {
                bufferDatosSalida.writeUTF("TE FALTA");
            }
            
            if (numero > numAleat) {
                bufferDatosSalida.writeUTF("TE PASTE");
            }
            
            if (numero == numAleat) {
                bufferDatosSalida.writeUTF("ACERTASTE");
                comprobar=false;
            }
            
            // 4 Envio BOOLEAN
            bufferDatosSalida.writeBoolean(comprobar);
            
        } while (comprobar);
        
    }
    

}
