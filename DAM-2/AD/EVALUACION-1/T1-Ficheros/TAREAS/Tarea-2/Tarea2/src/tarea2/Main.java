package tarea2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Creo el fichero Persona.dat");
        crearPersona();
        System.out.println("Persona Guardada correctamente");
        System.out.println("Leo el fichero Persona.dat");
        leerPersona();
        System.out.println("Escribir un ArrayList de personas");
        crearPersonas();
        System.out.println("Leer el ArrayList de personas");
        leerPersonas();
    }

    /**
     * Metodo para crear un fichero con extension .dat para almacenar una persona
     */
    public static void crearPersona() {
        Persona am1 = new Persona("Albano", 660850948);

        FileOutputStream fos = null;
        ObjectOutputStream flujosalidaobjetos = null;

        try {

            fos = new FileOutputStream("Persona.dat");

            flujosalidaobjetos = new ObjectOutputStream(fos);

            flujosalidaobjetos.writeObject(am1);

        } catch (IOException e) {
            System.err.println("Ha ocurrido una IOException");
        } finally {
            try {
                if (fos != null) {
                    flujosalidaobjetos.close();
                    fos.close();
                }
            } catch (IOException e) {
                System.err.println("Ha ocurrido una IOException");

            }

        }
    }

    /**
     * Metodo para leer un fichero .dat creado con el metodo crearPersona();
     */
    public static void leerPersona() {
        File fichero;
        FileInputStream fis = null;
        ObjectInputStream flujoentradaobjetos = null;

        try {

            fichero = new File("Persona.dat");

            if (fichero.exists()) {

                fis = new FileInputStream(fichero);
                flujoentradaobjetos = new ObjectInputStream(fis);

                while (fis.available() > 0) {
                    Persona a = (Persona) flujoentradaobjetos.readObject();
                    System.out.println(a.toString());
                }

            }
        } catch (EOFException eof) {
            System.err.println("---------------------------------------");
        } catch (FileNotFoundException fnf) {
            System.err.println("Fichero no encontrado" + fnf.getMessage());
        } catch (IOException ioe) {
            System.err.println("Se ha producido una IoException" + ioe.getMessage());
        } catch (Throwable e) {
            System.err.println("Error de programa: " + e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    flujoentradaobjetos.close();
                    fis.close();
                }
            } catch (IOException ioe) {
                System.err.println("Ha ocurrido una IOException");
            }

        }
    }

    /**
     * Metodo para crear un fichero con extension .dat para almacenar varias Personas en un ArrayList
     */
    public static void crearPersonas() {
        ArrayList<Persona> arrayPersonas = new ArrayList();
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File fichero = null;
        try {
            fichero = new File("Personas.dat");
            fos = new FileOutputStream(fichero);
            oos = new ObjectOutputStream(fos);

            Persona am1 = new Persona("Albano", 660850948);
            Persona am2 = new Persona("Daniel", 666555444);
            Persona am3 = new Persona("Ramiro", 444555666);
            Persona am4 = new Persona("Carmen", 111222333);

            arrayPersonas.add(am1);
            arrayPersonas.add(am2);
            arrayPersonas.add(am3);
            arrayPersonas.add(am4);

            oos.writeObject(arrayPersonas);

            System.out.println("Personas Guardadas correctamente");

        } catch (IOException e) {
            System.err.println("Ha ocurido una IOexception");
        } finally {
            try {
                if (fos != null) {
                    oos.close();
                    fos.close();
                }
            } catch (IOException e) {
                System.err.println("Ha ocurido una IOexception");
            }
        }
    }

    /**
     * Metodo para leer un fichero .dat creado con el metodo crearPersonas();
     */
    public static void leerPersonas() {
        ArrayList<Persona> arrayPersonas = new ArrayList();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        File fichero = null;
        try {
            fichero = new File("Personas.dat");
            fis = new FileInputStream(fichero);
            ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                arrayPersonas = (ArrayList) ois.readObject();
            }

            for (Persona i : arrayPersonas) {
                System.out.println(i.toString());
            }

        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (fis != null) {
                    ois.close();
                    fis.close();
                }
            } catch (IOException e) {
                System.err.println("Ha ocurido una IOexception");
            }

        }
    }

}
