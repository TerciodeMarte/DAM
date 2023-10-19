package com.cafeconpalito.hoja2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
/*
3.- Modifica el programa anterior para que lea el número de líneas de todos los 
ficheros pasados como argumentos. El programa creará un array de hilos con 
tantos elementos como ficheros pasados como argumentos. El programa 
principal esperará a que termine la ejecución de todos los hilos.
En este caso se creará un hilo por fichero a leer las líneas. Por cada hilo se 
guardará una referencia en un array para hacer al final un join de todos los hilos
*/
public class Ejercicio3 extends Thread {

    private String nombreFichero=null;
    private int suma=0;

    public Ejercicio3(String nombreFichero) {
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
