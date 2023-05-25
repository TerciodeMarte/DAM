package ejemplo4;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import ejemplo1.Estudiante;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author carra
 */
public class Ejemplo4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File fichero = new File("Ejemplo");
        fichero.delete();
        Scanner scstring = new Scanner(System.in);
        Scanner scint = new Scanner(System.in);
        byte contador = 1;
        

        ObjectContainer bd = Db4oEmbedded.openFile("Ejemplo");

        bd.store(new Estudiante("Pedro", 6));
        bd.store(new Estudiante("Nuria", 7));
        bd.store(new Estudiante("Luis", 4));
        bd.store(new Estudiante("Pedro", 6));
        bd.store(new Estudiante("Pedro", 0));
        bd.store(new Estudiante("Pepe", 0));
        bd.store(new Estudiante("Pepe", 0));

        System.out.println("A que alumno quieres modificar la nota");
        String lectura = scstring.nextLine();

        Estudiante e1 = new Estudiante(lectura, 0);
        Estudiante e2 = null;
        Estudiante e3 = new Estudiante(null, 0);

        ObjectSet os = bd.queryByExample(e1);
        if (os.hasNext()) {
            while (os.hasNext()) {
                e1 = (Estudiante) os.next();
                bd.delete(e1);
                System.out.println("Que nota quieres ponerle al " + contador + " " + lectura);
                int nota = scint.nextInt();
                e2 = new Estudiante(lectura, nota);
                bd.store(e2);
                contador++;
            }
        } else {
            System.out.println("No existe el alumno");
        }

        ObjectSet os2 = bd.queryByExample(e3);
        System.out.println("Nuevas notas");
        while (os2.hasNext()) {

            e3 = (Estudiante) os2.next();
            e3.info();

        }
        bd.close();
    }

}
