/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.refuerzo;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Hilo1 extends Thread {

    private boolean isCorrect = false;

    public boolean isIsCorrect() {
        return isCorrect;
    }

    @Override
    public void run() {

        do {
            int random = (int) (Math.random() * 9);
            System.out.println("Dime un numero entre 0 y 10");
            //System.out.println(random);
            Scanner sc = new Scanner(System.in);

            if (sc.nextInt() == random) {
                isCorrect = true;
                System.out.println("GANASTE EL JUEGO");
            }else{
                System.out.println("Fallaste");
            }
        } while (!isCorrect && !this.isInterrupted());

    }

}
