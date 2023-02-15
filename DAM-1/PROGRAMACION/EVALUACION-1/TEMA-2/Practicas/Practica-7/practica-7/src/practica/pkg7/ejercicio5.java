// Introduce por teclado dos Strings y muestra por pantalla una variable booleana que 
//indique si son iguales o no
package practica.pkg7;

import java.util.Scanner;

public class ejercicio5 {

    public static void main(String[] args) {
        //Declaración de Variables y objetos
        Scanner lectura = new Scanner(System.in);
        String lectura1,lectura2;
        //boolean condicion;
        
        //Introducir por teclado de dos strings
        System.out.println("Dime la primera frase");
        lectura1=lectura.nextLine();
        System.out.println("Dime la segunda frase");
        lectura2=lectura.nextLine();

        //Compración con metodo .equals() de la clase String
        //condicion=lectura1.equals(lectura2);
        //System.out.println(condicion);
        
        if(lectura1.equals(lectura2)){
            System.out.println("Son iguales");
        }else{  
            System.out.println("Son diferentes");
        }
    }
}
