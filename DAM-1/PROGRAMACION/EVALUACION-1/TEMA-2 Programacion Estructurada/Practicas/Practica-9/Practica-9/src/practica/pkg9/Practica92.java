/*Crea un programa donde, a partir de un array de 8 números enteros, se 
invierta el orden de los números del array*/
package practica.pkg9;

import java.util.Arrays;


public class Practica92 {

    public static void main(String[] args) {
        int array[]=new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i]=i+20;
        }
        System.out.println(Arrays.toString(array));
        for (int i = array.length-1; i >-1; i--) {
            System.out.println(array[i]);
        }
    }
    
}
