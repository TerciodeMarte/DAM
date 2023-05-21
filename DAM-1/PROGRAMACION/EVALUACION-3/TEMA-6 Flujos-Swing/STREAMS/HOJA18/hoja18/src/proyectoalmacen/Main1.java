package proyectoalmacen;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Main1 {

    static ArrayList<Articulo> almacen = new ArrayList();
    static String nombreAlmacen;

    public static void main(String[] args) {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(isr);
        try {
            System.out.println("Dime el nombre de tu almacen");
            nombreAlmacen=teclado.readLine();
        } catch (IOException e) {
            System.err.println("Ha habido un error");
        }
        
        int opcion = 0;
        do {
            try {
                System.out.println("\nMenú:");
                System.out.println("\t1. Añadir un nuevo artículo en el almacén.");
                System.out.println("\t2. Visualizar el contenido del almacén.");
                System.out.println("\t3. Pedidos necesarios de realizar.");
                System.out.println("\t4. Cantidad de artículos distintos en el almacén.");
                System.out.println("\t5. Total de existencias.");
                System.out.println("\t6. Modificar el número de existencias de un artículo del almacén.");
                System.out.println("\t7. Borrar un artículo del almacén.");
                System.out.println("\t8. Salir.");

                opcion = Integer.parseInt(teclado.readLine());
                switch (opcion) {
                    case 1:
                        annadirArticulo();
                        break;
                    case 2:
                        visualizarAlmacen();
                        break;
                    case 3:
                        mostrarPedidos();
                        break;
                    case 4:
                        cantidadDistintos();
                        break;
                    case 5:
                        totalExistencias();
                        break;
                    case 6:
                        modificarExistencias();
                        break;
                    case 7:
                        borrarArticulo();
                        break;
                    case 8:
                        guardarFichero();
                        System.out.println("Saliendo.");
                        break;
                    default:
                        System.out.println("Has escogido una opción incorrecta.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Tipo de dato inválido.");
            } catch (IOException e) {
                System.err.println("IOException");
            }
        } while (opcion != 10);

    }

    public static void annadirArticulo() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(isr);
        String codigo, descripcion;
        int existencias;
        boolean existe;
        
        try {
            do {
                existe = false;
                System.out.println("Introduce el código del artículo.");
                codigo = teclado.readLine();
                for (Articulo a : almacen) {
                    if (codigo.equals(a.getCodigo())) {
                        existe = true;
                        System.out.println("Ese código ya ha sido registrado.");
                    }
                }
            } while (Articulo.validarCodigo(codigo) == false || existe == true);

            do {
                System.out.println("Introduce la descripción del artículo.");
                descripcion = teclado.readLine();
            } while (!Articulo.validarDescripcion(descripcion));

            do {
                System.out.println("Introduce las existencias del artículo.");
                existencias = Integer.parseInt(teclado.readLine());
            } while (!Articulo.validarExistencias(existencias));
            almacen.add(new Articulo(codigo, descripcion, existencias));
        } catch (IOException e) {
            System.err.println("IOException");
        }

    }

    public static void visualizarAlmacen() {

        if (!almacen.isEmpty()) {
            System.out.println("Mostrando el inventario.");
            for (Articulo a : almacen) {
                System.out.println(a.toString());
            }
        } else {
            System.out.println("El almacén esta vacío.");
        }
    }

    public static void mostrarPedidos() {
        System.out.println("Mostrando pedidos necesarios a realizar.");
        for (Articulo a : almacen) {
            if (a.getExistencias() < 10) {
                System.out.println(a.toString());
                System.out.println("\tFaltan " + (10 - a.getExistencias()) + " unidades para tener diez.");
            }
        }
    }

    public static void cantidadDistintos() {
        int cantidad = 0;
        for (Articulo a : almacen) {
            cantidad++;
        }
        System.out.println("El número de artículos distintos es: " + cantidad);
    }

    public static void totalExistencias() {
        int total = 0;
        for (Articulo a : almacen) {
            total += a.getExistencias();
        }
        System.out.println("El total de existencias es: " + total);
    }

    public static void modificarExistencias() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(isr);
        String codigo;
        int existencias;
        try {
            System.out.println("Introduce el código del artículo.");
            codigo = teclado.readLine();
            System.out.println("Introduce la nueva cantidad de existencias.");
            existencias = Integer.parseInt(teclado.readLine());
            for (Articulo a : almacen) {
                if (codigo.equals(a.getCodigo())) {
                    a.setExistencias(existencias);
                }
            }
        } catch (IOException ex) {
            System.err.println("IOException");
        }
    }

    public static void borrarArticulo() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(isr);
        String codigo;
        boolean borrado = false;
        try {
            System.out.println("Introduce el código del artículo.");
            codigo = teclado.readLine();
            Iterator<Articulo> it = almacen.iterator();
            while (it.hasNext() && borrado == false) {
                Articulo a = it.next();
                if (a.getCodigo().equals(codigo)) {
                    it.remove();
                    borrado = true;
                    System.out.println("Elemento borrado.");
                }
            }
            if (borrado == false) {
                System.out.println("Ese artículo no se encuentra en el almacén.");
            }
        } catch (IOException ex) {
            System.err.println("IOException");
        }
    }

    public static void guardarFichero() {
        ObjectOutputStream oos = null;
        FileOutputStream fos=null;
        try {
            fos= new FileOutputStream(nombreAlmacen + ".dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(almacen);
        } catch (IOException ex) {
            System.err.println("IOException");
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                System.err.println("IOException");
            }
        }

    }

}
