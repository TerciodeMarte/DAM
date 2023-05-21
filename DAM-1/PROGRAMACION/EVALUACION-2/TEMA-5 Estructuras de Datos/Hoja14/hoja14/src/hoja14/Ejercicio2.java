/*Ejercicio 2: Realiza una aplicación que pida diferentes nombres con el fin de visualizarlos 
en el orden que se insertaron y en orden contrario. Para saber si el usuario quiere 
insertar más nombres se pregunta
¿Quiere insertar otro nombre? s/n
 */
package hoja14;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        String lectura;
        int edad;
        LinkedList<Candidatos> listado = new LinkedList();

        do {
            System.out.println("Dime el nombre del candidato");
            lectura = sc.nextLine();
            System.out.println("Dime su edad");
            edad = sc2.nextInt();
            Candidatos c1 = new Candidatos(lectura, edad);
            listado.add(c1);

           do {
                System.out.println("¿Quiere insertar otro nombre? s/n");
                lectura = sc.nextLine();
                switch (lectura) {
                    case "s":  
                    case "S":
                    case "n":  
                    case "N":
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }

            } while (!lectura.equalsIgnoreCase("s") && !lectura.equalsIgnoreCase("n"));

        } while (!lectura.equalsIgnoreCase("n"));

        System.out.println("Todos los candidatos introducidos en orden son");
        for (Candidatos candidatos : listado) {
            System.out.println(candidatos.imprimirInfo());
        }
        System.out.println("Todos los candidatos introducidos al reves son");
        for (int i = listado.size()-1; i>=0; i--) {
            System.out.println(listado.get(i).imprimirInfo());
        }
    }

}
