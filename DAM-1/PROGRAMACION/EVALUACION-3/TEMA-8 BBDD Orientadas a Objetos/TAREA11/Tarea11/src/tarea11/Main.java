package tarea11;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.File;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File fichero = new File("Ejemplo");
        fichero.delete();

        ObjectContainer bd = Db4oEmbedded.openFile("Ejemplo");

        /*Añade 20 productos distintos al inventario y realiza las siguientes consultas:*/
        bd.store(new Producto("Nevera", "Electrodomesticos", (int) (Math.random() * 250), (int) (Math.random() * 60)));
        bd.store(new Producto("Ordenador", "Informatica", (int) (Math.random() * 1000), 70));
        bd.store(new Producto("Sarten", "Utensilios", (int) (Math.random() * 10), 50));
        bd.store(new Producto("Television", "Electrodomesticos", 100, 0));
        bd.store(new Producto("Movil", "Telefonia", 100, 0));
        bd.store(new Producto("Telefono", "Telefonia", 50, 0));
        bd.store(new Producto("PS5", "consolas", 500, 0));
        bd.store(new Producto("PS4", "consolas", 500, 10));
        bd.store(new Producto("PS3", "consolas", 500, 20));
        bd.store(new Producto("PS2", "consolas", 200, 2));
        bd.store(new Producto("PS1", "consolas", 50, 1));
        bd.store(new Producto("xbox360", "consolas", 100, 20));
        bd.store(new Producto("xboxone", "consolas", 50, 0));
        bd.store(new Producto("Lavadora", "Electrodomesticos", 11, 11));
        bd.store(new Producto("Secadora", "Electrodomesticos", 100, 12));
        bd.store(new Producto("Oppo", "Telefonia", 50, 10));
        bd.store(new Producto("Iphone14", "Telefonia", 1200, 1));
        bd.store(new Producto("Fornite", "juego", 50, 1));
        bd.store(new Producto("Zelda", "juego", 50, 1));
        bd.store(new Producto("Minecraft", "juego", 50, 1));

        /*1.-Productos de la categoría "Electrodomésticos".*/
        System.out.println("Productos de la categoria \"Electrodomesticos\"");
        System.out.println("");

        Query q1 = bd.query();
        q1.constrain(Producto.class);
        q1.descend("categoria").constrain("Electrodomesticos");
        ObjectSet os = q1.execute();

        while (os.hasNext()) {
            Producto next1 = (Producto) os.next();
            next1.info();
        }
        System.out.println("");

        /*2.-Productos con un precio de 100 €.*/
        System.out.println("2.-Productos con un precio de 100 e.");
        System.out.println("");

        Query q2 = bd.query();
        q2.constrain(Producto.class);
        q2.descend("precio").constrain(100);
        ObjectSet os2 = q2.execute();

        while (os2.hasNext()) {
            Producto next2 = (Producto) os2.next();
            next2.info();
        }

        System.out.println("");
        /*3.-Productos que cuestan más de 200 €.*/
        System.out.println("3.-Productos que cuestan mas de 200 e.");
        System.out.println("");

        Query q3 = bd.query();
        q3.constrain(Producto.class);
        q3.descend("precio").constrain(200).greater();
        ObjectSet os3 = q3.execute();

        while (os3.hasNext()) {
            Producto next3 = (Producto) os3.next();
            next3.info();
        }
        System.out.println("");

        /*4.-Productos con más de 50 unidades en stock.*/
        System.out.println("4.-Productos con mas de 50 unidades en stock.");

        System.out.println("");
        Query q4 = bd.query();
        q4.constrain(Producto.class);
        q4.descend("stock").constrain(50).greater();
        ObjectSet os4 = q4.execute();

        while (os4.hasNext()) {
            Producto next4 = (Producto) os4.next();
            next4.info();
        }
        System.out.println("");
        /*5.-Productos con 0 unidades en stock (usando QBE).*/

        System.out.println("5.-Productos con 0 unidades en stock (usando QBE)");
        System.out.println("");
        Producto c5 = new Producto(null, null, 0, 0);

        ObjectSet os5 = bd.queryByExample(c5);
        while (os5.hasNext()) {
            c5 = (Producto) os5.next();
            if (c5.getStock() == 0) {
                c5.info();
            }
        }
        System.out.println("");
        /*6.-Productos con 0 unidades en stock (usando SODA).*/
        System.out.println("6.-Productos con 0 unidades en stock (usando SODA).");

        System.out.println("");
        Query q6 = bd.query();
        q6.constrain(Producto.class);
        q6.descend("stock").constrain(0);
        ObjectSet os6 = q6.execute();

        while (os6.hasNext()) {
            Producto next6 = (Producto) os6.next();
            next6.info();
        }
        System.out.println("");
        /*7.-Productos que cuestan menos de 150 € (usando QBE).*/
        System.out.println("7.-Productos que cuestan menos de 150 e (usando QBE)");
        Producto c7 = new Producto(null, null, 0, 0);

        System.out.println("");
        ObjectSet os7 = bd.queryByExample(c7);
        while (os7.hasNext()) {
            c7 = (Producto) os7.next();
            if (c7.getPrecio() < 150) {
                c7.info();
            }
        }
        System.out.println("");
        /*8.-Productos que cuestan menos de 150 € (usando SODA).*/

        System.out.println("8.-Productos que cuestan menos de 150 e (usando SODA).");

        System.out.println("");
        Query q8 = bd.query();
        q8.constrain(Producto.class);
        q8.descend("precio").constrain(150).smaller();
        ObjectSet os8 = q8.execute();

        while (os8.hasNext()) {
            Producto next8 = (Producto) os8.next();
            next8.info();
        }
        System.out.println("");

        /*9.-Productos en stock (usando QBE).*/
        System.out.println("9.-Productos en stock (usando QBE).");
        Producto c9 = new Producto(null, null, 0, 0);
        System.out.println("");
        ObjectSet os9 = bd.queryByExample(c9);
        while (os9.hasNext()) {
            c9 = (Producto) os9.next();
            if (c9.getStock() != 0) {
                c9.info();
            }
        }
        System.out.println("");

        /*10.-Productos con el nombre "ordenador".*/
        System.out.println("10.-Productos con el nombre \"ordenador\".");
        System.out.println("");

        Query q10 = bd.query();
        q10.constrain(Producto.class);
        q10.descend("nombre").constrain("Ordenador");
        ObjectSet os10 = q10.execute();

        while (os10.hasNext()) {
            Producto next10 = (Producto) os10.next();
            next10.info();
        }
        System.out.println("");

        bd.close();
    }

}
