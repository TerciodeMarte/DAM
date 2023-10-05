/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Metodos {

    /**
     * Metodo para generar ficheros con extension .txt con 10 numeros aleatorios
     *
     * @param numeroFicheros numero de ficheros a generar
     */
    public static void generarFichero(int numeroFicheros) {
        for (int i = 0; i < numeroFicheros; i++) {
            File archivo = new File("contabilidad" + (i + 1) + ".txt");

            try (FileWriter fw = new FileWriter(archivo)) {

                for (int j = 0; j < 10; j++) {
                    fw.write((int) (Math.random() * 50) + "\n");
                }

            } catch (IOException e) {
                System.err.println("IOException");
            }

        }
    }

    /**
     * Metodo que suma los numeros del fichero que le pases como parametro y
     * genera un fichero .res
     *
     * @param nombreFichero Fichero para sumar
     */
    public static void suma(String nombreFichero) {

        int suma = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero)); FileWriter fw = new FileWriter(nombreFichero + ".res")) {

            String cadena;

            while ((cadena = br.readLine()) != null) {
                suma += Integer.parseInt(cadena);
            }
            fw.write(suma);
            System.out.println(suma);

        } catch (FileNotFoundException e) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void sumaTotalesSecuencial(String[] argumentos) {
        int sumaTotal = 0;
        for (String i : argumentos) {

            try (BufferedReader br = new BufferedReader(new FileReader(i));) {

                String cadena;

                while ((cadena = br.readLine()) != null) {
                    sumaTotal += Integer.parseInt(cadena);
                }

            } catch (FileNotFoundException e) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, e);
            } catch (IOException e) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
