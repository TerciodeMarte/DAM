/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicio8;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author produccion
 */
public class Carrera {

//Controlas que todas las calles esten listas.
    private final int numeroCalles; //Calles
    private final int numeroRelevos; // Corredores
    private static Integer ganador;
    private static Integer t;
    
    ArrayList<Thread> lista = new ArrayList<>();

    //System.out.println ("Preparando Carrera");
    //se crea un bojeto Carrera y se indican el nº de calles y relevos.
    // se inicia las calles 
    // start y join.
    public Carrera(int numeroCalles, int numeroRelevos) {
        this.numeroCalles = numeroCalles;
        this.numeroRelevos = numeroRelevos;
    }

    //Creo las calles;
    public void prepararCarrera() {
        for (int i = 0; i < numeroCalles; i++) {
            Calle c = new Calle(i+1, numeroRelevos);
            Thread t = new Thread(c);
            lista.add(t);
        }
        
        
        
        //LAS PRIORIDADES VAN UN POCO AL TURUN TUN TUN
        /*
        lista.get(numeroCalles-1).setPriority(Thread.MIN_PRIORITY);
        lista.get(0).setPriority(Thread.MAX_PRIORITY);
        */

        System.out.println("DATOS DE LA CARRERA");
        System.out.println("Numero de Calles: " + (numeroCalles+1) );
        System.out.println("Numero de Relevos: " + numeroRelevos);
        System.out.println("");
        System.out.println("Corredores a sus puestos");
        System.out.println("");
        
    }

    //Lanzando las calles
    public void lanzarCarrera() {
        
        System.out.println("Inicia la carrera ");
        System.out.println("");
        for (Thread calle : lista) {
            calle.start();
        }
        
        for (Thread calle : lista) {
            try {
                calle.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(PSP_Tema2_Ejercicio8.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("");
        System.out.println("FIN DE LA CARRERA");
        System.out.println("Ganador de la carrera la calle: "  + ganador + " tiempo: " + t);
    }
    
    
    

    public static void ganador(int idCalle, int tiempoTotal){
        if (ganador == null) {
            ganador = idCalle;
            t= tiempoTotal;
        }
    }


}
