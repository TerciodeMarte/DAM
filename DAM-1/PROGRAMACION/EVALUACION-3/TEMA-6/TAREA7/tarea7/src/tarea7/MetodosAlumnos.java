package tarea7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Albano Díez de Paulino
 */
public class MetodosAlumnos {

    static ArrayList<Alumno> arrayAlumnos = new ArrayList();

    /* public static void grabar_coleccion_en_fichero(): graba el arraylist en el fichero.*/
    public static void grabar_coleccion_en_fichero() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("alumnos.dat");
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
            fis = new FileInputStream("alumnos.dat");
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
                System.out.println("Dime las calificaciones");
                a1.setCalificaciones(Integer.parseInt(br.readLine()));
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
        try {
            System.out.println("Dime el nombre a buscar");
            String nombre = br.readLine();
            for (Alumno i : arrayAlumnos) {
                if (i.getNombre().equals(nombre)) {
                    System.out.println("Alumno encontrado");
                    System.out.println("Su nota es:"+i.getCalificaciones());
                    break;
                }else{
                    System.out.println("Alumno no encontrado");
                }

            }

        } catch (IOException e) {
            System.err.println("Ha ocurido una IOexception");
        }

    }
    
    /* borrar_alumno() que permita borrar un alumno concreto preguntando antes todos los 
    datos del mismo. No es necesario leer nada del fichero, se recorre el arraylist 
    buscando. Una vez encontrado se borra el objeto concreto con los métodos de 
    ArrayList.*/
    public static void borrar_alumno(){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            System.out.println("Dime el nombre a borrar");
            String nombre = br.readLine();
            Iterator<Alumno> it=arrayAlumnos.iterator();
            
            while (it.hasNext()) {
                Alumno next = it.next();
                if (next.getNombre().equals(nombre)) {
                    System.out.println("Alumno encontrado");
                    System.out.println("Alumno borrado");
                    it.remove();
                    break;
                }else{
                    System.out.println("Alumno no encontrado");
                } 
            }
            
        } catch (IOException e) {
            System.err.println("Ha ocurido una IOexception");
        }
    }
    
    /*borrarFichero() que borre la existencia del fichero creado.*/
    

}
