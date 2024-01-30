/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.cafeconpalito.pokedex;

/**
 *
 * @author Albano Díez de Paulino
 */
public class EntryPoint {

    private static int contador = 1;

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        EntryPoint.contador = contador;
    }
    
    public static void main(String[] args) {

        App.main(args);

    }

}
