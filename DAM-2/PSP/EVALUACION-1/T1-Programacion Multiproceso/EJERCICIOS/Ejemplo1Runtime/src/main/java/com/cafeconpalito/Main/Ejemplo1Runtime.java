/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.Main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de paulino
 */
public class Ejemplo1Runtime {

    public static void main(String[] args) {

        try {
            Runtime rt = Runtime.getRuntime();
            String[] comando = {"notepad.exe"};
            Process p = rt.exec(comando);
        } catch (IOException ex) {
            Logger.getLogger(Ejemplo1Runtime.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
