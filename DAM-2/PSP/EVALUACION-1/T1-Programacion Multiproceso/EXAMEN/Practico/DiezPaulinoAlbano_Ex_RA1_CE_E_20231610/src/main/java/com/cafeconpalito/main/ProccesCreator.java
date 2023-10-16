package com.cafeconpalito.main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class ProccesCreator {

    private String ruta;
    private String fichero;

    private Process p;

    public ProccesCreator(String ruta, String fichero) {
        this.ruta = ruta;
        this.fichero= fichero;
    }

    public ProccesCreator(String fichero) {
        this.fichero = fichero;
    }
    
    

    public Process getP() {
        return p;
    }

    public void crearMetodo(boolean isjava) {
        ProcessBuilder pb = null;
        if (isjava) {
            pb = new ProcessBuilder("CMD", "/c", "java -jar " + ruta + " " + fichero);
        } else {
            pb = new ProcessBuilder("CMD", "/c", "notepad.exe "+ fichero );
        }

        try {
            p = pb.start();
            if (isjava) {
                 bloquearProceso();
            }
           
        } catch (IOException ex) {
            Logger.getLogger(ProccesCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void copy() {
        ProcessBuilder pb = null;

        pb = new ProcessBuilder("CMD", "/c", "copy " + ruta + " " + fichero);

        try {
            p = pb.start();
            bloquearProceso();
        } catch (IOException ex) {
            Logger.getLogger(ProccesCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void bloquearProceso() {

        try {
            p.waitFor();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProccesCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int valorSalida() {
        return p.exitValue();
    }

}
