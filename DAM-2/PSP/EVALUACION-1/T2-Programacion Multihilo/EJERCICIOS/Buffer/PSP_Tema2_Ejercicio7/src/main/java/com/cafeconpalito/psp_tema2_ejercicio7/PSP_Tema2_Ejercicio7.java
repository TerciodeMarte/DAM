/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.psp_tema2_ejercicio7;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author produccion
 */
public class PSP_Tema2_Ejercicio7 {

    public static void main(String[] args) {
        
        System.out.println("Iniciando Programa lectura de Buffer");
        
        Buffer b = new Buffer();
        
        ArrayList<Thread> lista = new ArrayList();
        
        for (int i = 0; i < 15; i++) {
            Consumidores c = new Consumidores(i,b);
            lista.add(new Thread(c));
        }
        
        for (int i = 0; i < 15; i++) {
            Productores p = new Productores(i,b);
            lista.add(new Thread(p));
        }
        
        for (Thread t : lista) {
            t.start();
        }
        
        for (Thread t : lista) {
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(PSP_Tema2_Ejercicio7.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        System.out.println("FIN DEL PROGRAMA: BUFFER VACÍO");
    }      
}
