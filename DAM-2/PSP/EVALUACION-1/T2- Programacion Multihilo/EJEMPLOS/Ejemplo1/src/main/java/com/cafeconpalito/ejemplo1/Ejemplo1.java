/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.ejemplo1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carra
 */
public class Ejemplo1 {

    public static void main(String[] args) {
        //Obtener la referencia del hilo actual
        Thread t= Thread.currentThread();
        
        //Thread[main,5,main], nombre del hilo, prioridad, nombre del grupo.
        System.out.println("Hilo actual:" + t.toString() );
        
        //Dormir el hilo principal
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejemplo1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
