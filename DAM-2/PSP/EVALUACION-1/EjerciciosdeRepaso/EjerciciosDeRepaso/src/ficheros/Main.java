package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        leerLinea("hola");

        leerCaracter("hola");
    }

    public static void leerLinea(String ruta) {
        FileReader fr = null;
        BufferedReader br = null;

        try {

            String cadena;
            br = new BufferedReader(new FileReader(new File(ruta + ".txt")));
            while ((cadena = br.readLine()) != null) {
                System.out.println(cadena);
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
     public static void leerCaracter(String ruta) {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(ruta+".txt");
            int caracter;
            String cadena = "";
            while ((caracter = fr.read())>0) {                
                //recasteo el valor a un char para imprimirlo lo almaceno en un String
                cadena += (char)caracter;
            }
            System.out.println(cadena);
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
