package tarea7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author Albano Díez de Paulino
 */
public class MetodosAlumnos {

    static ArrayList<Alumno> arrayAlumnos = new ArrayList();
    static File f = new File("alumnos.dat");


    /* public static void grabar_coleccion_en_fichero(): graba el arraylist en el fichero.*/
    public static void grabar_coleccion_en_fichero() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(arrayAlumnos);

            System.out.println("Alumnos Guardados correctamente");

        } catch (IOException e) {
            System.err.println("Ha ocurido una IOexception");
        } finally {
            try {
                if (fos != null) {
                    oos.close();
                    fos.close();
                }
            } catch (IOException e) {
                System.err.println("Ha ocurido una IOexception");
            }
        }
    }

    /*public static void leer_coleccion_del_fichero(): permite cargar el arraylist leyendo del 
    fichero un solo objeto, haciendo el casting al tipo (ArrayList).*/
    public static void leer_coleccion_del_fichero() {
        FileInputStream fis = null; //Flujo para crear archivos
        ObjectInputStream ois = null; //Flujo para escribir objetos
        try {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                arrayAlumnos = (ArrayList) ois.readObject();
            }

        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (fis != null) {
                    ois.close();
                    fis.close();
                }
            } catch (IOException e) {
                System.err.println("Ha ocurido una IOexception");
            }

        }
    }

    /*public static void anadir_alumno(): permite almacenar un objeto de tipo Alumno en el 
    arraylist.*/
    public static void anadir_alumno() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Alumno a1 = new Alumno();
        boolean control = false;

        try {
            do {
                System.out.println("Dime el nombre del alumno");
                a1.setNombre(br.readLine());
                do {
                    System.out.println("Dime las calificaciones");
                    a1.setCalificaciones(Integer.parseInt(br.readLine()));
                } while (a1.getCalificaciones() < 0 || a1.getCalificaciones() > 10);
                arrayAlumnos.add(a1);
                control = false;
            } while (control);

        } catch (NumberFormatException e) {
            System.err.println("Ha ocurrido un error en la conversion");
            control = true;
        } catch (IOException e) {
            System.err.println("Ha ocurido una IOexception");
        }
    }

    /*public static void listar_alumnos(): recorre el arraylist con un bucle for, un bucle for-each, o un iterador, 
    imprimiendo cada objeto Alumno contenido en el ArrayList.*/
    public static void listar_alumnos() {
        for (Alumno i : arrayAlumnos) {
            System.out.println(i.toString());
        }
    }

    /*buscar_alumno() que permita buscar un alumno concreto (por nombre). No es 
    necesario leer nada del fichero, se recorre el arraylist buscando.*/
    public static void buscar_alumno() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        boolean control = true;
        try {
            System.out.println("Dime el nombre a buscar");
            String nombre = br.readLine();
            for (Alumno i : arrayAlumnos) {
                if (i.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println("Alumno encontrado");
                    System.out.println("Su nota es:" + i.getCalificaciones());
                    control = false;
                    break;
                } else {
                    control = true;
                }
            }
            if (control) {
                System.out.println("Alumno no encontrado");
            }

        } catch (IOException e) {
            System.err.println("Ha ocurido una IOexception");
        }

    }

    /* borrar_alumno() que permita borrar un alumno concreto preguntando antes todos los 
    datos del mismo. No es necesario leer nada del fichero, se recorre el arraylist 
    buscando. Una vez encontrado se borra el objeto concreto con los métodos de 
    ArrayList.*/
    public static void borrar_alumno() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        boolean control = true;
        try {
            System.out.println("Dime el nombre a borrar");
            String nombre = br.readLine();
            Iterator<Alumno> it = arrayAlumnos.iterator();

            while (it.hasNext()) {
                Alumno next = it.next();
                if (next.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println("Alumno encontrado");
                    System.out.println("Alumno borrado");
                    it.remove();
                    control = false;
                    break;
                } else {
                    control = true;
                }
            }
            if (control) {
                System.out.println("Alumno no encontrado");
            }

        } catch (IOException e) {
            System.err.println("Ha ocurido una IOexception");
        }
    }

    /*borrarFichero() que borre la existencia del fichero creado.*/
    public static void borrar_Fichero() {

        if (f.exists()) {
            System.out.println("Borrando fichero");
            f.delete();
        } else {
            System.out.println("Fichero no encontrado");
        }

    }

    /*renombrar_fichero() que permita cambiar de nombre un fichero ya existente. */
    public static void renombrar_fichero() {
        File renombraArchivo = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nombreArchivo = "";

        if (f.exists()) {
            try {
                do {
                    System.out.println("Introduce el nuevo nombre para el fichero");
                    System.out.println("(no es necesario introducir la extencion)");
                    nombreArchivo = br.readLine();
                } while (nombreArchivo == "");

                renombraArchivo = new File(nombreArchivo + ".dat");
                f.renameTo(renombraArchivo);
                f = renombraArchivo;

            } catch (IOException e) {
                System.err.println("IOException");
            }
        } else {
            System.out.println("El fichero " + f.getName() + " no existe, no se puede renombrar");
        }

    }

    //METODOS NO PEDIDOS PERO NECESARIOS
    /*"3. Mostar todos los alumnos en orden alfabético"*/
    public static void alumnos_alfabetico() {

        ArrayList<String> arrayAlumnos2 = new ArrayList();
        for (Alumno q : arrayAlumnos) {
            arrayAlumnos2.add(q.getNombre());
        }

        Collections.sort(arrayAlumnos2);
        System.out.println(arrayAlumnos2);

    }

    /*"4. Hacer la media de los aprobados, de los suspensos y de todos.*/
    public static void media_alumnos() {
        double media = 0;
        byte contador = 0;
        for (Alumno i : arrayAlumnos) {
            if (i.getCalificaciones() >= 5) {
                media += i.getCalificaciones();
                contador++;
            }
        }
        System.out.println("La media de los aprobados es " + (media / contador));
        contador = 0;
        media = 0;

        for (Alumno i : arrayAlumnos) {
            if (i.getCalificaciones() < 5) {
                media += i.getCalificaciones();
                contador++;
            }
        }
        System.out.println("La media de los suspensos es " + (media / contador));
        media = 0;
        for (Alumno i : arrayAlumnos) {
            media += i.getCalificaciones();
        }
        System.out.println("La media de todos es " + (media / arrayAlumnos.size()));
    }

    /*"6. Modificar la nota de un alumno concreto."*/
    public static void modificar_nota() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        boolean control = false;
        boolean alumno = true;
        try {
            do {
                System.out.println("Dime el nombre del alumno para modificar su nota");
                String nombre = br.readLine();

                for (Alumno i : arrayAlumnos) {
                    if (i.getNombre().equalsIgnoreCase(nombre)) {
                        System.out.println("Alumno encontrado");
                        
                        do {
                           System.out.println("Dime su nueva nota");
                           i.setCalificaciones(Integer.parseInt(br.readLine()));
                        } while (i.getCalificaciones() < 0 || i.getCalificaciones() > 10);
                        System.out.println("Su nueva nota es:" + i.getCalificaciones());
                        alumno = false;
                        break;
                    } else {
                        alumno = true;
                    }

                }
                if (alumno) {
                    System.out.println("Alumno no encontrado");
                }
                control = false;

            } while (control);

        } catch (NumberFormatException e) {
            System.err.println("Ha ocurrido un error en la conversion");
            control = true;
        } catch (IOException e) {
            System.err.println("Ha ocurido una IOexception");
        }
    }

}
