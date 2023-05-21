//Diseñar un algoritmo para imprimir la suma de los números impares menores o 
//iguales que n.
package practica.pkg8;

import java.util.Scanner;

public class Practica85 {
    public static void main(String[] args) {
        float num;
        float suma = 0;
        
        System.out.println("Dime un numero positivo");
        Scanner lectura= new Scanner(System.in);
        num=lectura.nextFloat();
        
        for (int i = 0; i <= num; i++) {
            if(i%2!=0){
                suma=suma+i;
            }  
        }
        System.out.println("La suma de los numeros impares hasta "+ num + " es "+ suma);
    }
    
}
