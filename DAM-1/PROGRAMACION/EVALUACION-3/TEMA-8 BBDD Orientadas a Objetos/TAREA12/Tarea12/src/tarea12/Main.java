/*A partir de la clase Empleados, cuyos atributos son el nombre, estudios, edad y antigüedad:
Genera 20 empleados. Debe haber al menos tres nombres repetidos. Los estudios serán: ASIR, DAM o DAW. El rango de edad de los empleados será entre 24 y 50 años (ambos incluidos). La antigüedad estará entre 1 y 20 años (ambos incluidos).
Añade los 20 empleados a una base de datos orientada a objetos.
Realiza una consulta que muestre todos los empleados.
Modifica el nombre de todos los empleados con menos de 2 años de antigüedad.
Cambia los estudios de todos los empleados mayores de 30 años a ASIR.
Elimina todos los empleados que tengan menos de 25 años.
Elimina todos los empleados que tengan más de 20 años de antigüedad.
Realiza una consulta que muestre todos los empleados.*/
package tarea12;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.File;

/**
 *
 * @author Albano Diez de Paulino
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File fichero = new File("Ejemplo");
        fichero.delete();

        ObjectContainer bd = Db4oEmbedded.openFile("Ejemplo");

        /*Añade los 20 empleados a una base de datos orientada a objetos.*/
        for (int i = 0; i < 20; i++) {
            int x = (int) (Math.random() * 10);
            if (x % 5 == 0) {
                bd.store(new Empleado("Albano", "DAM", 19, 3));
            } else if (x % 3 == 0) {
                bd.store(new Empleado("Daniel", "DAW", 40, 18));
            } else if (x % 2 == 0) {
                bd.store(new Empleado("Ramiro", "DAW", 35, 1));
            } else {
                bd.store(new Empleado("Javier", "ASIR", 50, 20));
            }
        }

        /*Realiza una consulta que muestre todos los empleados.*/
        System.out.println("1- Realiza una consulta que muestre todos los empleados");

        Query q1 = bd.query();
        q1.constrain(Empleado.class);
        ObjectSet os = q1.execute();

        while (os.hasNext()) {
            Empleado next = (Empleado) os.next();
            next.info();
        }
        /*Modifica el nombre de todos los empleados con menos de 2 años de antigüedad.*/

        System.out.println("2- Modifica el nombre de todos los empleados con menos de 2 annos de antiguedad.");

        Query q2 = bd.query();
        q2.constrain(Empleado.class);
        q2.descend("antiguedad").constrain(2).smaller();
        ObjectSet os2 = q2.execute();

        while (os2.hasNext()) {
            Empleado next2 = (Empleado) os2.next();
            next2.setNombre("Pepe");
            bd.store(next2);

        }

        /*Cambia los estudios de todos los empleados mayores de 30 años a ASIR.*/
        System.out.println("3- Cambia los estudios de todos los empleados mayores de 30 annos a ASIR.");

        Query q3 = bd.query();
        q3.constrain(Empleado.class);
        q3.descend("edad").constrain(30).greater();
        ObjectSet os3 = q3.execute();

        while (os3.hasNext()) {
            Empleado next3 = (Empleado) os3.next();
            next3.setEstudios("ASIR");
            bd.store(next3);

        }

        /*Elimina todos los empleados que tengan menos de 25 años.*/
        System.out.println("4- Elimina todos los empleados que tengan menos de 25 annos.");

        Query q4 = bd.query();
        q4.constrain(Empleado.class);
        q4.descend("edad").constrain(25).smaller();
        ObjectSet os4 = q4.execute();

        while (os4.hasNext()) {
            Empleado next4 = (Empleado) os4.next();
            bd.delete(next4);
        }

        /*Elimina todos los empleados que tengan más de 20 años de antigüedad.*/
        System.out.println("5- Elimina todos los empleados que tengan mas de 18 annos de antiguedad");

        Query q5 = bd.query();
        q5.constrain(Empleado.class);
        q5.descend("antiguedad").constrain(18).greater();
        ObjectSet os5 = q5.execute();

        while (os5.hasNext()) {
            Empleado next5 = (Empleado) os5.next();
            bd.delete(next5);
        }

        /*Realiza una consulta que muestre todos los empleados.*/
          System.out.println("6- Realiza una consulta que muestre todos los empleados.");

        Query q6 = bd.query();
        q6.constrain(Empleado.class);
        ObjectSet os6 = q6.execute();

        while (os6.hasNext()) {
            Empleado next6 = (Empleado) os6.next();
            next6.info();
        }
        bd.close();

    }

}
