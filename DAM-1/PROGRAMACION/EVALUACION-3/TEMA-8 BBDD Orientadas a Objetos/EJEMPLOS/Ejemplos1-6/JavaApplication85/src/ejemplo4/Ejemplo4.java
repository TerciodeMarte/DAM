package ejemplo4;

import com.db4o.*;
import com.db4o.query.Query;
import ejemplo1.Estudiante;
import java.io.File;

public class Ejemplo4 {

    public static void main(String[] args) {

        File fichero = new File("Ejemplo");
        fichero.delete();

        ObjectContainer bd = Db4oEmbedded.openFile("Ejemplo");

        bd.store(new Estudiante("Pedro", 6));
        bd.store(new Estudiante("Nuria", 7));
        bd.store(new Estudiante("Luis", 4));
        bd.store(new Estudiante("Pedro", 6));
        bd.store(new Estudiante("Pedro", 5));
        bd.store(new Estudiante("Pepe", 0));

        Estudiante est;
        ObjectSet os;
        Query consulta = bd.query();

        consulta.constrain(Estudiante.class);
        consulta.descend("nota").constrain(5).smaller();
        os = consulta.execute();

        while (os.hasNext()) {
            est = (Estudiante) os.next();
            est.info();
        }

        bd.close();

    }

}
