/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicio7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author produccion
 */
public class Buffer {
    
    private Integer[] numeros = new Integer[6];
    private int pos = 0; // tiene que ir de 0 a 5 para el array.
    
    
    
    public synchronized void escritura(int id){
        
        while (pos == 6) {            
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
        
        System.out.println("Productor id: " + id);
        for (int i = pos; i < pos + 3 ; i++) {
            numeros[i] = (int) (Math.random()*(9-1+1)+1);
            System.out.println("Escritura del numero: " + numeros [i] + " de la posicion: " + i);
        }
        pos += 3;
        notifyAll();
    }
    
    
    public synchronized void lectura(int id){
        
        while (pos == 0) {            
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
        
        System.out.println("Consumidor id: " + id);
        for (int i = pos - 1; i >= pos - 3; i--) {
            System.out.println("Lectura del numero: " + numeros [i] + " de la posicion: " + i);
        }
        pos -= 3;
        notifyAll();
        
    }
    
}
