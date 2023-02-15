/*
Hacer un programa, al que se le pase una palabra por teclado, que 
transforme a mayúscula las letras impares (1ª, 3ª, 5ª …) y a minúscula las pares (2ª, 
4ª, 6ª …), con independencia de cómo se introduzca la palabra.

*/
package ejercicios;

import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        
        //Variables y objetos a usar
        Scanner lectura=new Scanner(System.in);
        String palabra;
        String aux="";
        
        //Introduccion de la palabra
        System.out.println("Dime una palabra(sin caracteres especiales,ni numeros)");
        palabra=lectura.nextLine();
        
        //Bucle para poner las letras en mayusculas o minusculas
        for (int i = 0; i < palabra.length(); i++) {
            if((i+1)%2==0){
                palabra=palabra.toLowerCase();
                aux=aux+palabra.charAt(i);
            }else{
                palabra=palabra.toUpperCase();
                aux=aux+palabra.charAt(i);
            }
        }
        //Mostrar la palabra transformada
        System.out.println(aux);
        
    }
}