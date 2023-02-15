package Ejercicio3;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main {

    public static void main(String[] args) {
        
        int array[]=new int[5];
        
        Scanner sc=new Scanner(System.in);
        
        for (int i = 0; i < array.length; i++) {
            System.out.println("Dime el numero " +(i+1));
            array[i]=sc.nextInt();
        }
        int mayor=array[0];
        int menor=array[0];
        int posmayor=0;
        int posmenor=0;
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i]>mayor) {
                mayor=array[i];
                posmayor=i;
            }
            if (array[i]<menor) {
                menor=array[i];
                posmenor=i;
            }
            
        }
      
        System.out.println("El mayor es: " + mayor+" y el menor es :"+ menor );
        System.out.println("Posicion mayor: "+ (posmayor+1)+" posicion menor "+(posmenor+1));
        
    }

}
