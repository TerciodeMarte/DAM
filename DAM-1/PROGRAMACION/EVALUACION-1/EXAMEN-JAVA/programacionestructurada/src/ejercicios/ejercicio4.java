/*
Hacer un programa que solicite al usuario una cadena de caracteres y 
devuelva el número de vocales que contiene.
*/
package ejercicios;

import java.util.Scanner;

public class ejercicio4 {

    public static void main(String[] args) {
        //Variables y objetos a usar
        Scanner lectura=new Scanner(System.in);
        String cadena;
        char aux;
        byte contador=0;
        
        //Lectura de la palabra
        
        System.out.println("Dime una palabra(sin caracteres especiales,ni numeros)");
        cadena=lectura.nextLine();
        
        //Comprobacion si es una vocal
        for (int i = 0; i < cadena.length(); i++) {
            aux=cadena.charAt(i);
            switch (aux) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    contador++;
                    break;
                default:
                    break;
            }
        }
        System.out.println("En la palabra que me has dicho hay :"+contador+" vocales");
    }
    
}
