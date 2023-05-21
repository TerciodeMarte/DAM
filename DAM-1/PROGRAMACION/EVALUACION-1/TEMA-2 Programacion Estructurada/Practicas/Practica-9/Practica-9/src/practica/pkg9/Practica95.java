/*Diseña un programa que genere un array que almacene los números 
enteros del 1 al 20 (ambos incluidos). El array deberá generarse con un 
bucle for. Después, deberá sustituirse el tercer elemento por el décimo y 
mostrar el resultado en pantalla.
*/
package practica.pkg9;

import java.util.Arrays;

public class Practica95 {
    public static void main(String[] args) {
        int array[]=new int[20];
        int aux=0;
        
        for (int i = 0; i < array.length; i++) {
            array[i]=i+1;
        }
        
        aux=array[2];
        array[2]=array[9];
        array[9]=aux;
        
        System.out.println(Arrays.toString(array));
    }
}
