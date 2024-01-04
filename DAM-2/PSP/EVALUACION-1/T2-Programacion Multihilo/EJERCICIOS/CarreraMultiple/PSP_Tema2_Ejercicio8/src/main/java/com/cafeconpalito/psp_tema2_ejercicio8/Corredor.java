/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicio8;

/**
 *
 * @author produccion
 */
public class Corredor extends Thread{

    String idCorredor;
    int numCorredor;
    Relevo r;

    public Corredor(int calle , int corredor, Relevo r) {
        this.idCorredor = "Calle: " + calle  +  " Corredor: " + corredor;
        this.numCorredor = corredor;
        this.r = r;
    }
    
    
    @Override
    public void run() {
        
        //Mejoras
        r.relevo(idCorredor , numCorredor);
        
        //Sin Mejoras
        //r.relevo(idCorredor);
    }
    
}
