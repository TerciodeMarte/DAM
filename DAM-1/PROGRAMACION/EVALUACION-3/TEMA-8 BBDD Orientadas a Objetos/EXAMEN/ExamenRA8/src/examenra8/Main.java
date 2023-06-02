package examenra8;

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

    public static void main(String[] args) {

        File fichero = new File("Ejemplo");
        fichero.delete();

        ObjectContainer bd = Db4oEmbedded.openFile("Ejemplo");

        // Genero 10 estudiantes y los meto ne la base de datos
        bd.store(new Colegio("Albano", 12, 1));
        bd.store(new Colegio("Danie", 11, 2));
        bd.store(new Colegio("Ramiro", 10, 3));
        bd.store(new Colegio("Carmen", 9, 4));
        bd.store(new Colegio("Javier", 8, 5));
        bd.store(new Colegio("Miguel", 7, 6));
        bd.store(new Colegio("Jose", 6, 1));
        bd.store(new Colegio("Victor", 7, 2));
        bd.store(new Colegio("Paula", 8, 3));
        bd.store(new Colegio("Roberto", 9, 4));

        //Consulta punto 3 SODA
        System.out.println("Consulta punto 3 SODA");
        Query q1 = bd.query();
        q1.constrain(Colegio.class);
        ObjectSet os = q1.execute();

        while (os.hasNext()) {
            Colegio next = (Colegio) os.next();
            next.info();
        }

        //Consulta punto 3 QBE
        System.out.println("Consulta punto 3 QBE");
        Colegio c1 = new Colegio(null, 0, 0);

        os = bd.queryByExample(c1);
        while (os.hasNext()) {
            c1 = (Colegio) os.next();
            c1.info();
        }
        //Consulta punto 4
        System.out.println("Estudiantes con menos de 7 annos");

        Colegio c2 = new Colegio(null, 0, 0);

        os = bd.queryByExample(c2);
        while (os.hasNext()) {

            c2 = (Colegio) os.next();
            if (c2.getEdad() < 7) {
                c2.info();
            }

        }

        //Consulta punto 5
        System.out.println("Estudiantes con mas de 8 annos");

        Query q3 = bd.query();
        q3.constrain(Colegio.class);
        q3.descend("edad").constrain(8).greater();
        os = q3.execute();

        while (os.hasNext()) {
            Colegio next = (Colegio) os.next();
            next.info();
        }

        //Consulta punto 6
        System.out.println("Estudiantes curso 1,3,5");
        Colegio c3 = new Colegio(null, 0, 0);

        ObjectSet os2 = bd.queryByExample(c3);
        while (os2.hasNext()) {
            c3 = (Colegio) os2.next();
            if (c3.getCurso() == 1 || c3.getCurso() == 3 || c3.getCurso() == 5) {
                c3.info();
            }
        }

        //Consulta punto 7
        System.out.println("Eliminar estudiantes mas de 10 annos");

        Query q6 = bd.query();
        q6.constrain(Colegio.class);
        q6.descend("edad").constrain(10).greater();
        os = q6.execute();

        while (os.hasNext()) {
            Colegio next = (Colegio) os.next();
            bd.delete(next);
        }
        System.out.println("Echo");

        //Consulta punto 8
        System.out.println("Cmabiar la edad de Jose a 26");

        Query q7 = bd.query();
        q7.constrain(Colegio.class);
        q7.descend("nombre").constrain("Jose");
        os = q7.execute();

        while (os.hasNext()) {
            Colegio next = (Colegio) os.next();
            next.setEdad(26);
            bd.store(next);
        }
        System.out.println("Echo");
        //Mostrar todos los alumnos
         System.out.println("Mostrar todos los alumnos");
        Query q10 = bd.query();
        q10.constrain(Colegio.class);
        ObjectSet os6 = q10.execute();

        while (os6.hasNext()) {
            Colegio next = (Colegio) os6.next();
            next.info();
        }
        bd.close();
    }
}
