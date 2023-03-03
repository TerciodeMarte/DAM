package ejercicio1;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Gestion {

    private LinkedList<Personal> empleados;

    public Gestion() {
        empleados = new LinkedList<>();
    }

    public void inserta_empleado(String dni, int salario) {
        boolean comp = false;
        Personal p1 = new Personal(dni, salario);
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getDni().equalsIgnoreCase(dni)) {
                comp = true;
                break;
            }
        }
        if (comp) {
            System.out.println("No se ha podido introducir al usuario");
        } else {
            empleados.add(p1);
        }
    }

    public void borra_empleado(String dni) {
        boolean comp2 = true;

        for (Personal empleado : empleados) {
            if (empleado.getDni().equalsIgnoreCase(dni)) {
                comp2 = false;
                empleados.remove(empleado);
                break;
            }
        }
        if (comp2) {
            System.out.println("No se ha podido borrar al usuario");
        }
    }

    public void lista_empleados() {
        Iterator<Personal> it = empleados.iterator();
        while (it.hasNext()) {
            Personal next = it.next();
            System.out.println("DNI: " + next.getDni());
            System.out.println("Salario: " + next.getSalario());
        }
    }

}
