/*Crea un programa donde, a partir de un array de 10 números enteros, se 
sume una unidad a todos los números y se muestre por pantalla el array 
antes y después de la suma.*/
package practica.pkg9;

import java.util.Arrays;


public class Practica94 {

 
    public static void main(String[] args) {
        int array[]={0,1,2,3,4,5,6,7,8,9};
        
        System.out.println(Arrays.toString(array));
     
        for (int i = 0; i < 10; i++) {
          array[i]=array[i]+1;
        }
        System.out.println(Arrays.toString(array));
    }
    
}
