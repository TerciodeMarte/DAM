/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.refuerzo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TerciodeMarte
 */
public class Hilo2 {

    public static void main(String[] args) {
        Hilo1 h1 = new Hilo1();
        h1.start();

        for (int i = 0; i < 10; i++) {
            try {
                if (h1.isAlive()) {
                    Thread.sleep(1000);
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (!h1.isIsCorrect()) {
            //h1.stop(); //DEPRECATED
            h1.interrupt();
            System.out.println("ULTIMA OPORTUNIDAD");
        }
    }
}
