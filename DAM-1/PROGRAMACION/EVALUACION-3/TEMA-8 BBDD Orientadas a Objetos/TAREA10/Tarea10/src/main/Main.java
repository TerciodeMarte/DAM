package main;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import concesionario.Concesionario;
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
        File fichero = new File("Ejemplo");
        fichero.delete();

        ObjectContainer bd = Db4oEmbedded.openFile("Ejemplo");

        /*Añade 20 coches distintos al concesionario y realiza las siguientes consultas:*/
        for (int i = 0; i < 20; i++) {
            int x = (int) (Math.random() * 10);
            if (x % 5 == 0) {
                bd.store(new Concesionario("Seat", "Leon", (int) (Math.random() * 30000), (int) (Math.random() * 5000)));
            } else if (x % 3 == 0) {
                bd.store(new Concesionario("Audi", "M3", (int) (Math.random() * 30000), 0));
            } else if (x % 2 == 0) {
                bd.store(new Concesionario("Volkswagen", "Golf", (int) (Math.random() * 30000), (int) (Math.random() * 5000)));
            } else {
                bd.store(new Concesionario("Renault", "Clio", 15000, (int) (Math.random() * 5000)));
            }
        }

        //1. Coches de la marca Seat.
        System.err.println("Coches de la marca Seat");

        Query q1 = bd.query();
        q1.constrain(Concesionario.class);
        q1.descend("marca").constrain("Seat");
        ObjectSet os = q1.execute();

        while (os.hasNext()) {
            Concesionario next = (Concesionario) os.next();
            next.info();
        }

        //2.Coches con un precio de 15000 €.
        System.err.println("2.Coches con un precio de 15000 e.");

        Query q2 = bd.query();
        q2.constrain(Concesionario.class);
        q2.descend("precio").constrain(15000);
        os = q2.execute();

        while (os.hasNext()) {
            Concesionario next = (Concesionario) os.next();
            next.info();
        }

        //3.Coches que valen más de 20000 €.
        System.err.println("3.Coches que valen mas de 20000 e");

        Query q3 = bd.query();
        q3.constrain(Concesionario.class);
        q3.descend("precio").constrain(20000).greater();
        os = q3.execute();

        while (os.hasNext()) {
            Concesionario next = (Concesionario) os.next();
            next.info();
        }

        //4.Coches con más de 3000 km.
        System.err.println("4.Coches con mas de 3000 km");

        Query q4 = bd.query();
        q4.constrain(Concesionario.class);
        q4.descend("kilometros").constrain(3000).greater();
        os = q4.execute();

        while (os.hasNext()) {
            Concesionario next = (Concesionario) os.next();
            next.info();
        }

        //5.Coches con 0 km (usando QBE)
        System.err.println("5.Coches con 0 km (usando QBE)");

        Concesionario c1 = new Concesionario(null, null, 0, 0);

        os = bd.queryByExample(c1);
        while (os.hasNext()) {
            c1 = (Concesionario) os.next();
            if (c1.getKilometros() == 0) {
                c1.info();
            }
        }

        //6.Coches con 0 km (usando SODA).
        System.err.println("Coches con 0 km (usando SODA)");

        Query q6 = bd.query();
        q6.constrain(Concesionario.class);
        q6.descend("kilometros").constrain(0);
        os = q6.execute();

        while (os.hasNext()) {
            Concesionario next = (Concesionario) os.next();
            next.info();
        }

        //7.Coches de la marca Audi.
        Query q7 = bd.query();
        q7.constrain(Concesionario.class);
        q7.descend("marca").constrain("Audi");
        os = q7.execute();

        while (os.hasNext()) {
            Concesionario next = (Concesionario) os.next();
            next.info();
        }
        
        //8.Coches que valen menos de 18000 € (usando QBE).
         System.err.println("8.Coches que valen menos de 18000 e (usando QBE)");

        Concesionario c2 = new Concesionario(null, null, 0, 0);

        os = bd.queryByExample(c2);
        while (os.hasNext()) {
            c2 = (Concesionario) os.next();
            if (c2.getKilometros() < 18000) {
                c2.info();
            }
        }
        
        //9.Coches que valen menos de 18000 € (usando SODA).
        
        System.err.println("9.Coches que valen menos de 18000 e (usando SODA)");

        Query q9 = bd.query();
        q9.constrain(Concesionario.class);
        q9.descend("precio").constrain(18000).smaller();
        os = q9.execute();

        while (os.hasNext()) {
            Concesionario next = (Concesionario) os.next();
            next.info();
        }
        
        bd.close();


    }

}
