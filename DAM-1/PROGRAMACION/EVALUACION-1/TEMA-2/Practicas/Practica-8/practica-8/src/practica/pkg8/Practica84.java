//Sumar los números positivos introducidos mediante teclado. Detener el algoritmo al 
//leer un nº cero o negativo.
package practica.pkg8;

import java.util.Scanner;

public class Practica84 {
    public static void main(String[] args) {
        float suma=0.0f;
        float num=0;
        Scanner lectura = new Scanner(System.in);
        
        System.out.println("Dime hasta que numero quieres sumar");
        num=lectura.nextFloat();
        
        for (int i = 0; i <= num; i++) {
           suma=suma+i;
        }
        System.out.println("La suma desde el 0 hasta " + num + " es "+suma);
        
        
    
    }
    
    
}
