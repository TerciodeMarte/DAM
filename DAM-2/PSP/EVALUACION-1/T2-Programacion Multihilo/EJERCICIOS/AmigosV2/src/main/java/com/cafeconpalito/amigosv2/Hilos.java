/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.amigosv2;

import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Hilos extends Thread {

    private int limitmin, limitmax;
    private HashMap<Integer, Integer> p = new HashMap();

    public HashMap<Integer, Integer> getP() {
        return p;
    }
    
    public Hilos(int limitmin, int limitmax) {
        this.limitmin = limitmin;
        this.limitmax = limitmax;
    }

    @Override
    public void run() {
        for (int i = limitmax; i > limitmin; i--) {

            int sumaA = 1;
            int division = i / 2;
            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0 || i % 11 == 0 || i % 13 == 0) {
                //cont += 1;
                for (int j = 2; j < division; j++) {
                    division = i / j;
                    if (i % j == 0) {
                        sumaA += j + (division);
                    }
                }

            }
            if (sumaA != 1 && sumaA != i) {
                p.put(i, sumaA);

            }
        }
    }

}
