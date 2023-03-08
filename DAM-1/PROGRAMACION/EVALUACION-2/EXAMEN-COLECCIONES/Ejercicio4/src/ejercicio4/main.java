package ejercicio4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class main {

    public static void main(String[] args) {

        ArrayList<String> al = new ArrayList();
        String palabra = "";
        Scanner scS = new Scanner(System.in);

        do {
            System.out.println("Dime que quieres annadir a la lista");
            System.out.println("Si me introduces fin paro");
            palabra = scS.nextLine();

            if (!palabra.equalsIgnoreCase("fin")) {
                al.add(palabra);
                System.out.println("Tengo almacenado");
                for (String i : al) {
                    System.out.println(i);
                }
            }

        } while (!palabra.equalsIgnoreCase("fin"));

    }

}
