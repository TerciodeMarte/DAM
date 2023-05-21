package ej11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Albano Díez de Paulino
 */

/*11.- Tienes un fichero de texto llamado “PoemaE.txt” que contiene una estrofa de un 
conocido poema encriptado.
Para encriptarlo he cogido la primera línea y le he sumado un 1 a cada carácter de la 
línea, a la segunda línea le he sumado un 2 a cada carácter, a la tercera un 3 y así 
sucesivamente…
 */
public class main11 {

    public static void main(String[] args) {
        BufferedReader br = null;
        String cadena = null;
        int cont = 1;
        try {
            br = new BufferedReader(new FileReader("poemaE.txt"));
            while ((cadena = br.readLine()) != null) {
                for (int i = 0; i < cadena.length(); i++) {
                    System.out.print((char) (cadena.charAt(i) - cont));
                }
                System.out.println("");
                cont++;
            }
        } catch (IOException e) {
            System.err.println("Ha ocurrido un IOException");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.err.println("Ha ocurrido un IOException");
            }
        }

    }

}
