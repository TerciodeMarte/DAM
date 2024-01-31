/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.cafeconpalito.pokedex;

/**
 * Clase que crea el punto de entrada para que javafx funcione correctamente en el build
 * @author Albano Díez de Paulino
 */
public class EntryPoint {

    /**
     * Variable para saber que id estamos buscando rango 1-1025
     */
    private static int contador = 1;

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        EntryPoint.contador = contador;
    }
    
    public static void main(String[] args) {
        if (args.length==1) {
            try {
                if (Integer.parseInt(args[0])>0 && Integer.parseInt(args[0])<=1025 ) {
                    contador=Integer.parseInt(args[0]);
                }
            } catch (Exception e) {
                contador=1;
            }
        }

        App.main(args);

    }

}
