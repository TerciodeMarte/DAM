/*Diseña un programa Java que solicite un número de 5 dígitos del teclado, 
tratándolo como cadena, separe el número en sus dígitos individuales y además los 
muestre por pantalla.*/
package practica.pkg8;

import java.util.Scanner;

public class Practica810 {

    
    public static void main(String[] args) {
        String cadena="";
        Scanner lectura = new Scanner(System.in);
        do {
            System.out.println("Dime un numero entero de 5 cifras");
            cadena=lectura.nextLine();
        } while (cadena.length()!=5);
        
        System.out.println("Unidades: "+cadena.charAt(4));
        System.out.println("Decenas: "+cadena.charAt(3));
        System.out.println("Centenas: "+cadena.charAt(2));
        System.out.println("Unidades de millar: "+cadena.charAt(1));
        System.out.println("Decenas de millar: "+cadena.charAt(0));
    }
    
}
