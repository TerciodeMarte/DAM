package examen3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main {

    static LinkedList<Juego> l = new LinkedList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Añado un juego
        System.out.println("Añadiendo Juego 1");
        Juego j1 = new Juego(1, "Minecraft", "+3");
        añadirJuego("ejercicio3.dat", j1);

        //Añado otro juego
        System.out.println("Añadiendo Juego 2");
        Juego j2 = new Juego(2, "GTA 5", "+18");
        añadirJuego("ejercicio3.dat", j2);

        //Listo los dos juegos
        leerJuegos("ejercicio3.dat");

        //Borro juego dos
        System.out.println("Borro Juego 2");
        borrarJuego("ejercicio3.dat", j2);

        //Listar despues de borrar
        leerJuegos("ejercicio3.dat");

    }

    /**
     * Metodo para añadir un objeto de la clase Juego a un fichero pasado por
     * parametro
     *
     * @param fichero Ruta + nombre + extension del fichero donde se que quieres
     * almacenar
     * @param nuevoJuego Objeto de la clase Juego que se quiere almacenar
     */
    public static void añadirJuego(String fichero, Juego nuevoJuego) {

        if (leerJuego(fichero, nuevoJuego)) {
            System.err.println("No se ha podido insertar el juego porque ya hay un Juego con la misma ID");
        } else {

            try (FileOutputStream fos = new FileOutputStream(fichero); ObjectOutputStream oos = new ObjectOutputStream(fos);) {

                l.add(nuevoJuego);
                System.out.println("Juego Insertado");
                //utilizamos el metodo oos.writeObject para pasarle el objeto
                //podemos utilizar este metodo tantos objetos tengamos
                oos.writeObject(l);

            } catch (IOException e) {
                System.err.println("Se ha producido una IoException" + e);
            }
        }

    }

    /**
     * Metodo para comprobar si existe un juego con la misma ID en el fichero
     *
     * @param fichero Ruta + nombre + extension del fichero donde se que leer
     * @param nuevoJuego Juego para comparar IDs
     * @return True si ya existe, false si no existe
     */
    private static boolean leerJuego(String ficherop, Juego a) {
        FileInputStream fis1 = null;
        ObjectInputStream ois1 = null;

        try {

            fis1 = new FileInputStream(ficherop);
            ois1 = new ObjectInputStream(fis1);
            LinkedList<Juego> aux = new LinkedList();

            //se utiliza el available del FIS para saber el tamaño del fichero y que lo recorra.
            while (fis1.available() > 0) {
                aux = (LinkedList<Juego>) ois1.readObject();
            }

            for (Juego i : aux) {
                if (i.getId() == a.getId()) {
                    return true;
                }
            }
            return false;

        } catch (FileNotFoundException fnf) {
             System.err.println("No hay juegos en la lista");
        } catch (IOException ioe) {
            System.err.println("Se ha producido una IoException" + ioe);
        } catch (ClassNotFoundException ex) {
            System.err.println("No se ha podido leer el objeto porque me falta la clase");
        } finally {
            try {
                if (fis1 != null) {
                    fis1.close();
                    ois1.close();
                }
            } catch (IOException ioe) {
                System.err.println("Ha ocurrido una IOException");
            }

        }
        return false;
    }

    /**
     * Metodo para leer todos los objetos
     *
     * @param fichero Fichero desde donde se queire leer
     */
    public static void leerJuegos(String fichero) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(fichero);
            ois = new ObjectInputStream(fis);
            LinkedList<Juego> aux = new LinkedList();

            //se utiliza el available del FIS para saber el tamaño del fichero y que lo recorra.
            while (fis.available() > 0) {
                aux = (LinkedList<Juego>) ois.readObject();
            }

            for (Juego juego : aux) {
                System.out.println(juego.toString());
            }

        } catch (FileNotFoundException fnf) {
            System.err.println("No hay juegos en la lista");
        } catch (IOException ioe) {
            System.err.println("Se ha producido una IoException" + ioe);
        } catch (ClassNotFoundException ex) {
            System.err.println("No se ha podido leer el objeto porque me falta la clase");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                    ois.close();
                }
            } catch (IOException ioe) {
                System.err.println("Ha ocurrido una IOException");
            }

        }
    }

    /**
     * Metodo para borrar un juego
     *
     * @param ficherop fichero donde se quiere borrar
     * @param a Juego para borrar
     */
    public static void borrarJuego(String ficherop, Juego a) {
        l.remove(a);

        try (FileOutputStream fos1 = new FileOutputStream(ficherop); ObjectOutputStream oos = new ObjectOutputStream(fos1);) {

            oos.writeObject(l);

        } catch (IOException e) {
            System.err.println("Se ha producido una IoException" + e);
        }
    }
}
