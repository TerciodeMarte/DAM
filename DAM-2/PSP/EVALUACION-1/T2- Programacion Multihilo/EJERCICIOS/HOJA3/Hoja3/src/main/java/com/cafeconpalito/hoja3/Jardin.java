/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.hoja3;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Jardin {

    private int personas;

    public Jardin() {
        personas=100;
    }

    public int getPersonas() {
        return personas;
    }
    
    public synchronized void sumarPersona(int valor){
        personas+=1;
    }
    
    public synchronized void restarPersona(int valor){
        personas-=1;
    }
    
    
}
