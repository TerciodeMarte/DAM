/*
 Hacer un programa que pida al usuario su nombre, apellidos y edad y 
devuelva todo por pantalla en una misma línea. La edad deberá ser un valor entero.
*/
package ejercicios;

import java.util.Scanner;

public class ejercicio5 {

    public static void main(String[] args) {
        //Variables y objetos a usar
        String nombre,apellidos;
        int edad;
        Scanner lectura=new Scanner(System.in);
      
        //Introducion de datos
        System.out.println("Dime tu nombre");
        nombre=lectura.nextLine();
        System.out.println("Dime tus apellidos");
        apellidos=lectura.nextLine();
        System.out.println("Dime tu edad");
        edad=lectura.nextInt();
        
        //Mostrar los datos
        System.out.print("Tu nombre es "+ nombre);
        System.out.print(" Tus apellidos son "+ apellidos);
        System.out.println(" Tu edad es "+ edad);
        
    }
    
}
