package ejercicio6;

import ejercicio5.Alumno;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main6 {

    public static void main(String[] args) {
        FileInputStream fis = null; //Flujo para crear archivos
        ObjectInputStream ois = null; //Flujo para escribir objetos
        try {
            fis = new FileInputStream("alumnos.dat");
            ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                Alumno a = (Alumno) ois.readObject();
                System.out.println(a.getNombre() + a.getCalificaciones());
            }

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        }

    }

}
