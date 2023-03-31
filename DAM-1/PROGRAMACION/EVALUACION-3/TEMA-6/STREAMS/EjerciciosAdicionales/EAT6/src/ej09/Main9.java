package ej09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main9 {

    public static void main(String[] args) {
        BufferedReader br = null;
        String cadena = null;
        int contLineas = 0;

        try {

            br = new BufferedReader(new FileReader("cancion.txt"));

            while ((cadena = br.readLine()) != null) {
                contLineas++;
                String[] arrayPalabras = cadena.split(" ");
                System.out.println("La " + contLineas + "º linea tiene " + (arrayPalabras.length) + " palabras");

            }

        } catch (IOException e) {
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
            }
        }
    }

}
