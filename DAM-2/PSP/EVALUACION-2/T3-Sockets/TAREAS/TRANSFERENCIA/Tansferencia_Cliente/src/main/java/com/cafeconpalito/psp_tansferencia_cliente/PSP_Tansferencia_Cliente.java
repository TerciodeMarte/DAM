/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.psp_tansferencia_cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CafeConPalito
 */
public class PSP_Tansferencia_Cliente {

    public static void main(String[] args) {

        Socket servidor = null;
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
        Scanner sc = new Scanner(System.in);
        File f =null;
        FileWriter fw = null;
        
        System.out.println("Mensaje Inicio");

        try {

            //Parametros para conectar al server
            final String SERVER_IP = "localhost";
            final int PUERTO = 2223;

            //Constuimos el Socket con el server
            servidor = new Socket(SERVER_IP, PUERTO);

            //Inicializo las conexiones con el server con los parametros de este
            bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());
            
            //pregunto el nombre del fichero
            System.out.println("¿Qué fichero quieres leer?");
            
            String nombreFichero= sc.next();
            
            
            //1 Envío nombre del archivo
            bufferDatosSalida.writeUTF(nombreFichero);
            
            //2 recibo booleano existe
            
            if (!bufferDatosEntrada.readBoolean()) {
                
                System.out.println("El archivo no existe");
                
            }else{
                f= new File(nombreFichero);
                fw = new FileWriter(f);
                
                String cadena;
                //3 recibo texto archivo
                while (!(cadena = bufferDatosEntrada.readUTF()).equals("EOF")) {                    
                    System.out.println(cadena);
                    fw.write(cadena + "\n");
                }
                System.out.println("End Of File");
                
            }

        } catch (IOException ex) {
            Logger.getLogger(PSP_Tansferencia_Cliente.class.getName()).log(Level.SEVERE, null, ex);

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
                
                if (fw != null) {
                    fw.close();
                }
                
                System.out.println("Mensaje despedida");

            } catch (IOException ex) {
                Logger.getLogger(PSP_Tansferencia_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
