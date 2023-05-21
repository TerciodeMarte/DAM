/*Introducir el valor de un radio y ofrecer un menú que permita al usuario elegir la 
opción para calcular uno de los cuatro casos: calcular y visualizar la longitud de la 
circunferencia, la superficie del círculo, el volumen de la esfera o salir. No permitir 
valores negativos o cero para el radio y hacer que el programa anterior sea repetitivo, 
volviendo a ofrecer el menú para el mismo radio.*/

package practica.pkg8;

import java.util.Scanner;

public class Practica86 {

    public static void main(String[] args) {
        float radio=0;
        byte opcion=0;
        Scanner lectura= new Scanner(System.in);
        
        do {   
            System.out.println("Dime el radio del circulo"); 
            radio=lectura.nextFloat();  
        } while (radio<=0);
      
        do {    
            
            System.out.println("TE PUEDO MOSTRAR LAS SIGUIENTES OPCIONES");
            System.out.println("1:Longitud de la circuferencia");
            System.out.println("2:Superficie del circulo");
            System.out.println("3:Volumen de la esfera");
            System.out.println("4:Salir");
            
            
            opcion=lectura.nextByte();
            
            switch (opcion) {
                case 1:
                    //Formula Longitud de la circunferencia 2*r*PI
                    System.out.println("Longitud de la circunferencia con radio "+ radio + " es "+ (2*radio*Math.PI));
                    break;
                case 2:
                    //Formula Superficie del circulo r^2*PI
                    System.out.println("Superficie del circulo con radio "+ radio + " es "+ (Math.pow(radio,2)*Math.PI));
                    break;
                case 3:
                    //Formula Volumen de la esfera V = 4/3 PI*R^3
                    System.out.println("Volumen de la esfera con radio "+ radio + " es "+ (4/3*Math.pow(radio,3)*Math.PI));
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Dime una opcion valida");
            }
            
        } while (opcion!=4);   
    }  
}
