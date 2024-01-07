/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.psp_cliente_examen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author produccion
 */
public class PSP_Cliente_Examen {

    public static void main(String[] args) {

        Socket servidor = null;
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
        Scanner sc = new Scanner(System.in);

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
            
            // 1 ----------
            /*
            String texto;
            texto = bufferDatosEntrada.readUTF();
            System.out.println(texto);
            */
            //Recibimos opciones del Server
            System.out.println(bufferDatosEntrada.readUTF());
            
            // 2 ---------
            //SELECCIONAMOS OPCION 
            //NOS FIAMOS DEL USUARIO SINO METER UN WHILE!
            int opcion = sc.nextInt();
            bufferDatosSalida.writeInt(opcion);
            
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
                    opcion4(servidor);
                    break;
                default:
            }            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(PSP_Cliente_Examen.class.getName()).log(Level.SEVERE, null, ex);
        
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
                Logger.getLogger(PSP_Cliente_Examen.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("fin cliente");
        }

    }
    
    public static void opcion4(Socket servidor){
        
        try {
            servidor.close();
        } catch (IOException ex) {
            Logger.getLogger(PSP_Cliente_Examen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void opcion1(DataInputStream bufferDatosEntrada, DataOutputStream bufferDatosSalida) throws IOException{
        
        Scanner sc = new Scanner(System.in);
        boolean comprobar = true;
        do {
            // 1 RECIBO INFO
            System.out.println(bufferDatosEntrada.readUTF());
            
            // 2 ENVIO NUMERO
            bufferDatosSalida.writeInt(sc.nextInt());
            
            // 3 RECIBE MENSAJE
            System.out.println(bufferDatosEntrada.readUTF());
            
            // 4 Recibo BOOLEAN
            comprobar = bufferDatosEntrada.readBoolean();
            
        } while (comprobar);
    }
    
}
