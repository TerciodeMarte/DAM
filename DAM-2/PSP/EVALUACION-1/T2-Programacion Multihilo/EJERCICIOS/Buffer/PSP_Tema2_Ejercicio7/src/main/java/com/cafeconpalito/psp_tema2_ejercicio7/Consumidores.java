/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicio7;

/**
 *
 * @author produccion
 */
public class Consumidores implements Runnable {

    int id;
    Buffer b;

    public Consumidores(int id, Buffer b) {
        this.id = id;
        this.b = b;
    }

    @Override
    public void run() {
        b.lectura(id);
    }

}
