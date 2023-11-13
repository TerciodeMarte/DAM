/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.hoja5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class HiloEntrar implements Runnable {

    Garaje g;

    public HiloEntrar(Garaje g) {
        this.g = g;
    }

    @Override
    public void run() {

        int coches = g.entrar();

    }

}
