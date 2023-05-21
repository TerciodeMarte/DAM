//Contar los números positivos introducidos mediante teclado. Detener el algoritmo al 
//leer un nº cero o negativo.

package practica.pkg8;

import java.util.Scanner;

public class Practica82 {
    public static void main(String[] args) {
        int contador=0;
        float num;
        
        Scanner lectura = new Scanner(System.in);
        
        do {
            System.out.println("Dime un numero positivo");
            num=lectura.nextFloat();
            if(num>0){
                contador++;
            }
            
            
        } while (num>0);
        
        System.out.println("He contado "+ contador + " numeros positivos");
        
    }
    
}
