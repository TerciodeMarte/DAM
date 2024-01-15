/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.diezpaulinoalbano_ex_ra3_client_20240115;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class MainCliente {

    /**
     * Metodo con la logica del cliente
     * @param args argumentos pasados por comando
     */
    public static void main(String[] args) {
         Socket servidor = null;
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
        
        Scanner scstring= new Scanner(System.in);
        Scanner scint = new Scanner(System.in);
        
        String user="";
        String pwd="";
        
        boolean login=false;
        
        //Inicializo las conexionas a nulo dentro del TRY para que se cierren solas al salir
        try {

            //Parametros para conectar al server
            String SERVER_IP = "localhost"; // "127.0.0.1"
            int PUERTO = 9666;
            
            System.out.println("Dime la ip del servidor");
            SERVER_IP= scstring.nextLine();
            
            System.out.println("Dime el puerto de escucha del servidor");
            PUERTO= scint.nextInt();

            //Constuimos el Socket con el server
            servidor = new Socket(SERVER_IP, PUERTO);

            //Inicilizo las conexiones con el server con los parametros de este
            bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());
            
            //
            // TODO LO QUE QUIERAS HACER CON EL SERVIDOR
            //
            //Leo mensaje de bienvenida
            System.out.println(bufferDatosEntrada.readUTF());
            
            //Pido la contraseña
            do {
                System.out.println("Por favor, introduce el usuario");
                user = scstring.nextLine();
                bufferDatosSalida.writeUTF(user);
                
                System.out.println("Por favor, introduce la password");
                pwd= scstring.nextLine();
                bufferDatosSalida.writeUTF(pwd);
                
                System.out.println(bufferDatosEntrada.readUTF());
                login=bufferDatosEntrada.readBoolean();
                
                
            } while (!login);
                    
            
        } catch (IOException ioe) {
            System.err.println("Imposible conectar con el servidor");
        }catch(InputMismatchException ime){
            System.err.println("El puerto debe de ser un numero");
        }finally {
            
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
                Logger.getLogger(MainCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
}
