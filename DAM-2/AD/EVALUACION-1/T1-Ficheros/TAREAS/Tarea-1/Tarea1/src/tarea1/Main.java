package tarea1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

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
        boolean control = true;
        Scanner scint = new Scanner(System.in);
        Scanner scstring = new Scanner(System.in);

        int opcion = 5;

        do {
            try {
                System.out.println("Que deseas hacer?");
                System.out.println("1- Escribir en un fichero de texto");
                System.out.println("2- Leer un fichero de texto linea a linea");
                System.out.println("3- Crear el archivo de propiedades en la ruta raiz del proyecto");
                System.out.println("4- Leer el archivo de propiedades en la ruta raiz del proyecto");
                System.out.println("5- Salir");

                opcion = scint.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Donde quieres crear el fichero?");
                        String ruta= scstring.nextLine();
                        System.out.println("Que quieres escribir?");
                        String texto= scstring.nextLine();
                        escribirFichero(texto, ruta);            
                        break;
                    case 2:
                        System.out.println("Que fichero quieres leer");
                        ruta= scstring.nextLine();
                        leerFichero(ruta);
                        break;
                    case 3:
                        System.out.println("Haciendo el fichero");
                        crearPropiedades();
                        System.out.println("Fichero creado");
                        break;
                    case 4:
                        System.out.println("Las propiedades son");
                        leerPropiedades();
                        break;
                    case 5:
                        System.out.println("SALIENDO");
                        control = false;
                        break;
                    default:
                        control = false;
                }
            } catch (InputMismatchException ex) {
                System.err.println(ex.getMessage());
                control = true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                control = true;
            }

        } while (control);
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
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
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

    /**
     * Metodo para crear un fichero de propiedades.props con las siguientes
     * propiedades USER = administrador PASSW = Admin-123 SERVER = localhost
     * PORT = 3306
     */
    public static void crearPropiedades() {
        File fichero = new File("propiedades.props");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {

            if (fichero.exists()) {
                fichero.delete();
            }
            fichero.createNewFile();

            fos = new FileOutputStream(fichero);
            oos = new ObjectOutputStream(fos);

            Properties p = new Properties(System.getProperties());

            p.setProperty("USER", "administrador");
            p.setProperty("PASSW", "Admin-123");
            p.setProperty("SERVER", "localhost");
            p.setProperty("PORT", "3306");

            oos.writeObject(p);

        } catch (IOException ex) {

            System.err.println(ex.getMessage());

        } finally {
            try {
                if (oos != null) {
                    oos.close();
                    fos.close();
                }
            } catch (IOException e) {
            }

        }
    }

    /**
     * Metodo para leer las propiedades del fichero propiedades.props
     */
    public static void leerPropiedades() {
        File fichero = new File("propiedades.props");
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(fichero);
            ois = new ObjectInputStream(fis);
            Properties p = new Properties();

            while (fis.available() > 0) {
                p = (Properties) ois.readObject();
                System.out.println(p.toString());
            }

        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                    ois.close();
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }

    }
}
