// Introduce un String de cinco caracteres por teclado y muestra por pantalla su longitud 
//y segundo caracter.
package practica.pkg7;

import java.util.Scanner;

public class ejercicio6 {
    
    public static void main(String[] args) {
        
        //Declaración objeto scanner y String
        System.out.println("Dime una cadena de 5 caracteres");
        Scanner lectura= new Scanner(System.in);
        String dato=lectura.nextLine();
       
        //Metodo length() devuelve longitud y charAt devuelve dato de una posición(EMPIEZA EN 0)
        System.out.println("La longitud de la cadena es " + dato.length());
        System.out.println("El segundo caracter es " + dato.charAt(1));
    }
    
}
