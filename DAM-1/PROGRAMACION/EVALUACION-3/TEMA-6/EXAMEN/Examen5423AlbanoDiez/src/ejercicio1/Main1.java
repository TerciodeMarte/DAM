package ejercicio1;

import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main1 {

    public static void main(String[] args) {
        boolean control = true;
        Scanner scInt = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
        byte opcion = -1;
        Gestion g=new Gestion();

        do {
            System.out.println("1. Añadir Empleado");
            System.out.println("2.Eliminar Empleado");
            System.out.println("3.Generar fichero .dat con los datos de los empleados");
            System.out.println("4.Leer fichero.dat");
            System.out.println("5.Salir");
            opcion = scInt.nextByte();
            switch (opcion) {
                case 1:
                    g.añadir_empleado();
                    break;
                case 2:
                    System.out.println("Dime el DNI del empleado que quieres borrar");
                    String dni=scString.nextLine();
                    g.eliminar_empleado(dni);
                    break;
                case 3:
                    g.grabar_fichero();
                    break;
                case 4:
                    g.leer_fichero();
                    break;
                case 5:
                    System.out.println("Saliendo");
                    control=false;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (control);
    }

}
