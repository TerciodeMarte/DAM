/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicio8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author produccion
 */
public class Relevo {
    
    private boolean relevo = false;
    private int idCalle;
    private int tiempoTotal;

    public int getTiempoTotal() {
        return tiempoTotal;
    }
    
    //MEJORAS
    private int corredor;

    public Relevo(int idCalle) {
        this.idCalle = idCalle;
        this.tiempoTotal = 0;
        this.corredor = 0;
    }

    //Carrera con mejoras
    public synchronized void relevo(String idcorredor, int numCorredor){
        while (!relevo || this.corredor != numCorredor ) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Relevo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println(idcorredor + " inicia Carrera");
        
        //Tiempo de carrera
        int tiempo = (int) (Math.random()*(3000-1000+1)+1000); 
        tiempoTotal += tiempo;
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Relevo.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        System.out.println(idcorredor + " termina carrera, tiempo: " + tiempo);
        corredor += 1;
        notifyAll(); 
    }
    
    public synchronized void iniciarCalle(){
        relevo = true;
        corredor = 1; //Mejora
        notifyAll(); //Mejora
    }
    
    
    
    // Sin mejoras
    
    /*
    public synchronized void relevo(String corredor){
        while (!relevo) {  
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Relevo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println(corredor + " inicia Carrera");
        //Tiempo de carrera
        int tiempo = (int) (Math.random()*(3000-1000+1)+1000);        
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Relevo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(corredor + " termina carrera, tiempo: " + tiempo);
        notify(); 
    }
    
    public void iniciarCalle(){
        relevo = true;
    }
    */
}
