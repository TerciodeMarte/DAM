package tarea7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Albano Díez de Paulino
 */

/*Ofrece un menú repetitivo al usuario con las opciones:
1. Grabar un nuevo alumno.
2. Listar los alumnos grabados.
3. Mostar todos los alumnos en orden alfabético
4. Hacer la media de los aprobados, de los suspensos y de todos.
5. Buscar un alumno concreto.
6. Modificar la nota de un alumno concreto.
7. Mostar todos los alumnos en orden alfabético.
8. Borrar un alumno concreto.
9. Borrar el fichero guardado.
10. Cambiar el nombre del fichero.
11. Salir.
Cada vez que se realice una operación sobre el arraylist que lo modifique, se guardará el 
arraylist en el fichero (es decir se llamará al método grabar_coleccion_en_fichero). Recuerda 
tratar las excepciones.*/
public class main {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String opcion = "";
        boolean control = true;

        do {
            try {
                System.out.println("1. Grabar un nuevo alumno.\n"
                        + "2. Listar los alumnos grabados.\n"
                        + "3. Mostar todos los alumnos en orden alfabetico\n"
                        + "4. Hacer la media de los aprobados, de los suspensos y de todos.\n"
                        + "5. Buscar un alumno concreto.\n"
                        + "6. Modificar la nota de un alumno concreto.\n"
                        + "7. Borrar un alumno concreto.\n"
                        + "8. Borrar el fichero guardado.\n"
                        + "9. Cambiar el nombre del fichero.\n"
                        + "10. Salir.");

                opcion = br.readLine();
                switch (opcion) {
                    case "1":
                        MetodosAlumnos.anadir_alumno();
                        MetodosAlumnos.grabar_coleccion_en_fichero();
                        break;
                    case "2":
                        MetodosAlumnos.listar_alumnos();
                        break;
                    case "3":
                        MetodosAlumnos.alumnos_alfabetico();
                        break;
                    case "4":
                        MetodosAlumnos.media_alumnos();
                        break;
                    case "5":
                        MetodosAlumnos.buscar_alumno();
                        break;
                    case "6":
                        MetodosAlumnos.modificar_nota();
                        MetodosAlumnos.grabar_coleccion_en_fichero();
                        break;
                    case "7":
                        MetodosAlumnos.borrar_alumno();
                        MetodosAlumnos.grabar_coleccion_en_fichero();
                        break;
                    case "8":
                        MetodosAlumnos.borrar_Fichero();
                        break;
                    case "9":
                        MetodosAlumnos.renombrar_fichero();
                        break;
                    case "10":
                        System.out.println("Saliendo");
                        control = false;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            } catch (IOException ex) {
                System.err.println("Ha ocurido una IOexception");
            }
        } while (control);
    }

}
