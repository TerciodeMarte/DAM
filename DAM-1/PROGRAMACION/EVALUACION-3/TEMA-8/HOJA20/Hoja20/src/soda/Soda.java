package soda;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import estudiante.Estudiante;
import java.io.File;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Soda {

    public static void main(String[] args) {
        File fichero = new File("Ejemplo");
        fichero.delete();

        ObjectContainer bd = Db4oEmbedded.openFile("Ejemplo");

        /*- Añade 20 estudiantes una base de datos orientada a objetos con notas 
aleatorias entre 0 y 10 (ambos incluidos). Debes incluir al menos 4 nombres 
repetidos.
         */
        for (int i = 0; i < 20; i++) {
            int x = (int) (Math.random() * 10);
            if (x % 5 == 0) {
                bd.store(new Estudiante("Pedro", (int) (Math.random() * 10)));
            } else if (x % 3 == 0) {
                bd.store(new Estudiante("Juan", (int) (Math.random() * 10)));
            } else if (x % 2 == 0) {
                bd.store(new Estudiante("Albano", (int) (Math.random() * 10)));
            } else {
                bd.store(new Estudiante("Ramiro", (int) (Math.random() * 10)));
            }
        }

        // /*- Consulta todos los estudiantes con el primer nombre.*/
        System.out.println("Consulta todos los estudiantes con el primer nombre");

        Query q1 = bd.query();
        q1.constrain(Estudiante.class);
        q1.descend("nombre").constrain("Pedro");
        ObjectSet os = q1.execute();

        while (os.hasNext()) {
            Estudiante next = (Estudiante) os.next();
            next.info();
        }

        // /*- Consulta todos los estudiantes con el segundo nombre*/
        System.out.println("Consulta todos los estudiantes con el segundo nombre");
        Query q2 = bd.query();
        q2.descend("nombre").constrain("Juan");
        os = q2.execute();

        while (os.hasNext()) {
            Estudiante next = (Estudiante) os.next();
            next.info();
        }

        /*Consulta todos los estudiantes con nota de 0.*/
        System.out.println("Consulta todos los estudiantes con nota de 0.");
        Query q3 = bd.query();
        q3.descend("nota").constrain(0);
        os = q3.execute();

        while (os.hasNext()) {
            Estudiante next = (Estudiante) os.next();
            next.info();
        }

        /* Consulta todos los estudiantes con nota de 7.*/
        System.out.println("Consulta todos los estudiantes con nota de 7.");
        Query q4 = bd.query();
        q4.descend("nota").constrain(7);
        os = q4.execute();

        while (os.hasNext()) {
            Estudiante next = (Estudiante) os.next();
            next.info();
        }
        /*Consulta todos los estudiantes aprobados.*/

        System.out.println("Consulta todos los estudiantes aprobados.");
        Query q5 = bd.query();
        q5.descend("nota").constrain(4).greater();
        os = q5.execute();

        while (os.hasNext()) {
            Estudiante next = (Estudiante) os.next();
            next.info();
        }
        //- Consulta todos los estudiantes suspensos.
        System.out.println("Consulta todos los estudiantes aprobados.");
        Query q6 = bd.query();
        q6.descend("nota").constrain(5).smaller();
        os = q6.execute();

        while (os.hasNext()) {
            Estudiante next = (Estudiante) os.next();
            next.info();
        }
        bd.close();
    }
}
