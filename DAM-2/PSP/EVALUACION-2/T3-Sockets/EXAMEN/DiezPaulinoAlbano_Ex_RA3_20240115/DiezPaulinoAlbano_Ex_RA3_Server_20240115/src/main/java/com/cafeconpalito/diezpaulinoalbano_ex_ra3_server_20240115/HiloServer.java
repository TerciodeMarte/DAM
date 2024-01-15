/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.diezpaulinoalbano_ex_ra3_server_20240115;

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
public class HiloServer implements Runnable {

    private Socket cliente = null;
    private int id = 0;
    private int numintentos = 3;

    private String user, pwd;

    public HiloServer(Socket cliente, int id) {
        this.cliente = cliente;
        this.id = id;
    }

    @Override
    public void run() {
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
        String mensaje = "*******************************\n"
                + "* SERVIDOR DE LOGIN\n"
                + "*. por Albano Díez de Paulino *\n"
                + "* Cafe Con Palito (R)\n"
                + "*******************************\n"
                + "- Eres el cliente número: "
                + id + "\n"
                + "- Por favor, introduce un usuario y \n"
                + "contraseña para entrar";

        try {

            //Inicilizo las conexiones con el server con los parametros de este
            bufferDatosEntrada = new DataInputStream(cliente.getInputStream());
            bufferDatosSalida = new DataOutputStream(cliente.getOutputStream());

            //
            //TODO LO QUE QUIERAS QUE HAGA LA CONEXION CON EL CLIENTE.
            //
            //Escribo el mensaje de bienvenida
            bufferDatosSalida.writeUTF(mensaje);

            //Valido sesion
            do {
                //Leo usuario
                user = bufferDatosEntrada.readUTF();
                //Leo PWD
                pwd = bufferDatosEntrada.readUTF();
                if (user.equals("DAMAlbano") && pwd.equals("Diez")) {
                    bufferDatosSalida.writeUTF("Credenciales correctas. \nBIENVENIDO AL SERVIDOR");
                    bufferDatosSalida.writeBoolean(true);
                    break;
                } else {
                    numintentos--;
                    if (numintentos >= 1) {
                        bufferDatosSalida.writeUTF("Credenciales incorrectas, vuelve a intentarlo te quedan " + numintentos + " oportunidades");
                        bufferDatosSalida.writeBoolean(false);
                    } else {

                        bufferDatosSalida.writeUTF("Credenciales incorrectas, ya no quedan mas intentos\n NO SE PUDO CONECTAR AL SERVIDOR");
                        bufferDatosSalida.writeBoolean(true);
                    }

                }

            } while (numintentos > 0);

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
