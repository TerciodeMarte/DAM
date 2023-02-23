package ejercicio3;

import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main3 {

    public static void main(String[] args) {
        int array[] = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el numero a buscar en el array");
        int num = sc.nextInt();

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
            if (array[i] == num) {
                System.out.println("Numero en encontrado en la posicion: " + i);
            }
        }

    }

}
