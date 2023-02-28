package ejercicio02;

import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main2 {

    public static void main(String[] args) {
        //No necesito un array para esto pero lo hago con el para practicar
        double temperaturas[] = new double[10];
        Scanner sc = new Scanner(System.in);
        double suma = 0;

        for (int i = 0; i < temperaturas.length; i++) {
            System.out.println("Dime la temperatura de la ciudad " + (i + 1));
            temperaturas[i] = sc.nextDouble();
            suma = suma + temperaturas[i];
        }
        System.out.println("La temperatura media de todas las ciudades es: "+(suma/temperaturas.length));

    }

}
