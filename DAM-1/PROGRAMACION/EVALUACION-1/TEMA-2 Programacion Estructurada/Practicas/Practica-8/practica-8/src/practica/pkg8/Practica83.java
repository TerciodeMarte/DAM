//Sumar los números positivos introducidos mediante teclado. Detener el algoritmo al 
//leer un nº cero o negativo.
package practica.pkg8;
import java.util.Scanner;


public class Practica83 {
    public static void main(String[] args) {
        float suma=0.0f;
        float num;
        
        Scanner lectura = new Scanner(System.in);
        
        do {
            System.out.println("Dime un numero positivo");
            num=lectura.nextFloat();
            if(num>0)suma=suma+num;
            
        } while (num>0);
        
        System.out.println("La suma de los numeros introduccidos es  "+ suma);
        
    }
    
}
