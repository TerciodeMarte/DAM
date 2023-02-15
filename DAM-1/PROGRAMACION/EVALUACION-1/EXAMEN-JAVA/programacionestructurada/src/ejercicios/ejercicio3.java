/*
 Hacer un programa que, a partir de un array de dos números enteros
que el usuario introducirá por teclado, muestre por pantalla cuál es el mayor y cuál 
el menor. Si son iguales, deberá aparecer el mensaje: “¡Te repites!”.
*/
package ejercicios;

import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        //Variables a usar
        Scanner lectura=new Scanner(System.in);
        int numeros[]=new int[2];
        
        //Introduccion por teclado
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Dime un numero");
            numeros[i]=lectura.nextInt();
        }
        
        //Comprobacion de numeros
        if (numeros[0]>numeros[1]) {
            System.out.println("El primer numero es mayor");
        }else if(numeros[1]>numeros[0]){
            System.out.println("El segundo es el mayor");
        }else{
            System.out.println("!Te repites!");
        }
    }
}
