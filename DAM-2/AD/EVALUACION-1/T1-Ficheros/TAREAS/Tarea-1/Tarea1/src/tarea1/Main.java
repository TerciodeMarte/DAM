package tarea1;

import java.io.BufferedReader;
import java.io.File;
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
/*Hoja de ejercicios 1. Ficheros de texto. 
1. Crea un método en java que escriba en un fichero de texto.
2. Crea un método en java que lea un fichero de texto línea a línea.
3. Crea un método en java que escriba en un fichero de configuración los parámetros de 
conexión utilizando las propiedades de setProperty de System Properties.
USER = administrador
PASSW = Admin-123
SERVER = localhost
PORT = 3306
4. Crea un método en java que lea las propiedades de un fichero de propiedades.props

 */
public class Main {

    public static void main(String[] args) {

    }

    /**
     * Método en java que escriba en un fichero de texto
     *
     * @param texto Texto a escribir en el fichero
     * @param ruta Ruta del archivo sin extensión
     */
    public static void escribirFichero(String texto, String ruta) {
        FileWriter fw = null;

        try {
            fw = new FileWriter(new File(ruta + ".txt"));
            fw.write(texto);
        } catch (IOException e) {
            System.err.println("IOException");
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.err.println("IOException cierre flujo");
            }
        }
    }

    /**
     * Método en java que lea un fichero de texto línea a línea.
     *
     * @param ruta Ruta del archivo sin extensión
     */
    public static void leerFichero(String ruta) {
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
}
