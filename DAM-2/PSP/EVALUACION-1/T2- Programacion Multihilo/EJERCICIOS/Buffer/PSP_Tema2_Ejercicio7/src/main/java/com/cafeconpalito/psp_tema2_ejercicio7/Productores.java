/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicio7;

/**
 *
 * @author produccion
 */
public class Productores implements Runnable{

    int id;
    Buffer b;

    public Productores(int id, Buffer b) {
        this.id = id;
        this.b = b;
    }

    @Override
    public void run() {
        b.escritura(id);
    }
    
}
