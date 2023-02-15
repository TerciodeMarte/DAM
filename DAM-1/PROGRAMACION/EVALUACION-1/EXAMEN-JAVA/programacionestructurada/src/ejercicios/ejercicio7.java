/*
Hacer un programa que permita introducir edades de personas del 1 al 
90, hasta que se introduzca un 0, momento en el cual se mostrará al usuario el 
siguiente menú:
• Elige una opción:
1. Mostrar cuántas edades se han introducido, y cuántas personas 
son mayores y menores de edad.
2. Mostrar la media de las edades introducidas.
3. Salir
*/
package ejercicios;

import java.util.Scanner;

public class ejercicio7 {

    public static void main(String[] args) {
        //Variables y objetos a usar
        int edad,contadoredad,contadormayor,contadormenor,num;
        double suma=0;
        contadoredad=0;
        contadormayor=0;
        contadormenor=0;
        Scanner lectura=new Scanner(System.in);
        
        //Introduccion de las edades
        do {
            System.out.println("Dime una edad entre 1 y 90(introduce 0 para salir)");
            edad=lectura.nextInt();
            if (edad>=18) {
                contadormayor++;
            }else{
                contadormenor++;
            }
            suma=suma+edad;
            contadoredad++;
        } while (edad!=0);
        
        //Menu de opciones
        System.out.println("Dime que quieres hacer");
        System.out.println("1. Mostrar cuantas edades se han introducido, y cuantas personas son mayores y menores de edad.");
        System.out.println("2. Mostrar la media de las edades introducidas.");
        num=lectura.nextInt();
        
        //Hacer las cosas del menu anterior
        switch (num) {
            case 1:
                System.out.println("Edades introducidas: "+ (contadoredad-1));
                System.out.println("Mayores de edad: "+ contadormayor);
                System.out.println("Menores de edad: "+ (contadormenor-1));
                break;
            case 2:
                System.out.println("La media de las edades introducidas es: "+(suma/(contadoredad-1)));
                break;
            default:      
        }
        
    }
    
}
