/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.hoja2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
/*2.- Realiza un programa en java que reciba como argumento el nombre de un 
fichero de texto. El programa debe crear un hilo. El hilo debe contar cuantas 
líneas hay en el fichero de texto. El programa principal espera a que el hilo 
termine de ejecutarse y se despide.*/
public class Ejercicio2 extends Thread {

    private String nombreFichero=null;
    private int suma=0;

    public Ejercicio2(String nombreFichero) {
        this.nombreFichero=nombreFichero;
    }

    @Override
    public void run() {
        suma();
        System.out.println("Numero de lineas: "+ suma);
    }
    
    private void suma() {


        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            while ((br.readLine()) != null) {
              suma+=1;
            }

        } catch (FileNotFoundException e) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
