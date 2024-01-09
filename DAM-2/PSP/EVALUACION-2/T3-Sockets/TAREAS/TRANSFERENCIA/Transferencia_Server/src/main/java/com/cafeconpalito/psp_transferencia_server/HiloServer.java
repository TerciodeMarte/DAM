/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_transferencia_server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CafeConPalito
 */
public class HiloServer implements Runnable {

    private Socket cliente;

    public HiloServer(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {

        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            //Inicilizo las conexiones con el server con los parametros de este
            bufferDatosEntrada = new DataInputStream(cliente.getInputStream());
            bufferDatosSalida = new DataOutputStream(cliente.getOutputStream());

            //1 recibo el nombre del fichero            
            String nombreFichero = bufferDatosEntrada.readUTF();

            File f = new File(nombreFichero);

            //2 envio booleano existe
            if (!f.exists()) {
                bufferDatosSalida.writeBoolean(false);

            } else {
                bufferDatosSalida.writeBoolean(true);

                fr = new FileReader(f);

                String cadena;
                //bucle para leer linea a linea se necesita introducir un BufferReader se le pasa como parametro el FileReader
                br = new BufferedReader(fr);
                while ((cadena = br.readLine()) != null) {
                    //3 envio texto archivo                  
                    bufferDatosSalida.writeUTF(cadena);
                }

                //3 Aviso fin del envio
                bufferDatosSalida.writeUTF("EOF");
            }

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

                if (fr != null) {
                    fr.close();
                }
                
                if (br !=null) {
                    br.close();
                }
                System.out.println("Mensaje Despedida");

            } catch (IOException ex) {
                Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
