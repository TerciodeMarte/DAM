package com.cafeconpalito.hoja6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Pista {

    private int corredores;
    private int encarrera;
    private boolean relevo;
    private boolean enmarcas;

    public void setRelevo(boolean relevo) {
        this.relevo = relevo;
    }
    

    public Pista() {
        this.corredores = 0;
        this.relevo = false;
        this.enmarcas=false;
    }

    public synchronized void marcas() {
        while (corredores < 3) {
            try {
                corredores++;
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!enmarcas) {
            encarrera=corredores+1;
            System.out.println("Todos en sus marcas");
            enmarcas=true;
        }
    }
    
    public synchronized void correr(){
        while (relevo) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            relevo= true;
            Thread.sleep((long) (Math.random()*2000));
            encarrera--;
            if (encarrera!=0) {
                System.out.println("Pasando el testigo");
            }
            
            relevo=false;
            
            notify();
 
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

}
