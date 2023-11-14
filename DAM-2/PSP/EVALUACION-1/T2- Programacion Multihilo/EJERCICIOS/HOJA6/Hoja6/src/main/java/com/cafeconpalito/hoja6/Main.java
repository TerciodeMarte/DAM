/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.hoja6;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carra
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Thread> ar = new ArrayList();
        Pista p = new Pista();
        
        for (int i = 1; i <= 4; i++) {
             Thread corredor = new Thread(new Corredores(p, i));
                corredor.start();
                ar.add(corredor);
        }
        
        for (Thread thread : ar) {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Todos han terminado de correr");
    }
}
