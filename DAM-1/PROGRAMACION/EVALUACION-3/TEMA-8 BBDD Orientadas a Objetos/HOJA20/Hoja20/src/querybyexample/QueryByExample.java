package querybyexample;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import estudiante.Estudiante;
import java.io.File;

public class QueryByExample {

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

        /*- Consulta todos los estudiantes con el primer nombre.*/
        Estudiante e1 = new Estudiante("Pedro", 0);

        System.out.println("Consulta todos los estudiantes con el primer nombre");
        ObjectSet os = bd.queryByExample(e1);
        while (os.hasNext()) {
            e1 = (Estudiante) os.next();
            e1.info();
        }

        /*- Consulta todos los estudiantes con el segundo nombre*/
        System.out.println("Consulta todos los estudiantes con el segundo nombre");

        Estudiante e2 = new Estudiante("Juan", 0);

        ObjectSet os2 = bd.queryByExample(e2);
        while (os2.hasNext()) {
            e2 = (Estudiante) os2.next();
            e2.info();
        }

        /*Consulta todos los estudiantes con nota de 0.*/
        System.out.println("Consulta todos los estudiantes con nota de 0");

        Estudiante e3 = new Estudiante(null, 0);

        ObjectSet os3 = bd.queryByExample(e3);
        while (os3.hasNext()) {
            e3 = (Estudiante) os3.next();
            if (e3.getNota() == 0) {
                e3.info();
            }

        }

        /* Consulta todos los estudiantes con nota de 7.*/
        System.out.println("Consulta todos los estudiantes con nota de 7");

        Estudiante e4 = new Estudiante(null, 7);

        ObjectSet os4 = bd.queryByExample(e4);
        while (os4.hasNext()) {
            e4 = (Estudiante) os4.next();
            e4.info();
        }

        /*Consulta todos los estudiantes aprobados.*/
        System.out.println("Consulta todos los estudiantes aprobados");

        Estudiante e5 = new Estudiante(null, 0);

        ObjectSet os5 = bd.queryByExample(e5);
        while (os5.hasNext()) {
            e5 = (Estudiante) os5.next();
            if (e5.getNota()>=5) {
                e5.info();
            }   
        }
        //- Consulta todos los estudiantes suspensos.
        System.out.println("Consulta todos los estudiantes suspensos");

        Estudiante e6 = new Estudiante(null, 0);

        ObjectSet os6 = bd.queryByExample(e6);
        while (os6.hasNext()) {
            e6 = (Estudiante) os6.next();
            if (e6.getNota()<5) {
                e6.info();
            }   
        }
        bd.close();
    }

}
