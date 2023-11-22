/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicio8;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author produccion
 */
public class Calle implements Runnable {

    int calleId;
    Thread[] corredores;
    Relevo r;
    
    public Calle(int calleId, int numCorredores) {

        this.corredores = new Corredor[numCorredores];
        this.calleId = calleId;

        r = new Relevo(calleId);

        for (int i = 0; i < numCorredores; i++) {
            corredores[i] = new Corredor(calleId, i + 1, r);
        }
    }

    @Override
    public void run() {

        for (Thread c : corredores) {
            c.start();
        }

        r.iniciarCalle();

        for (Thread c : corredores) {
            try {
                c.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Calle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

        
        
        //mejora 
        Carrera.ganador(calleId ,r.getTiempoTotal());
        System.out.println("Calle: " + calleId+ " Finalizo, Tiempo total: " + r.getTiempoTotal());
        
        //sin Mejora
        //Carrera.ganador(calleId);
        //System.out.println("Calle: " + calleId+ " Finalizo");

    }
    

    
}
