package ejercicio8;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Clase {

    private int array[] = new int[5];

    public Clase() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Dime el numero de la posicion: " + i);
            array[i] = sc.nextInt();
        }
    }
    
    public int menor(){
        Arrays.sort(array);
        return array[0];
    }
    
    public int mayor(){
        Arrays.sort(array);
        return array[array.length-1];
    }
    
    public int media(){
        int suma=0;
        for (int i = 0; i <array.length ; i++) {
            suma=suma+array[i];
        }
        return suma/array.length;
    }
}
