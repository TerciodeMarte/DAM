/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.hoja3;


/**
 *
 * @author Albano Díez de Paulino
 */
public class HiloSuma implements Runnable {

    Jardin j;

    public HiloSuma(Jardin j) {
        this.j = j;
    }
    
    
    @Override
    public void run() {
        j.sumarPersona(1);
    }

}
