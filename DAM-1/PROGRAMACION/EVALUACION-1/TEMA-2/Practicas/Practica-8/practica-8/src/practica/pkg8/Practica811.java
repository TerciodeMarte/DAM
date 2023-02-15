/*Realiza un programa en Java que pida un número, (lo lea como cadena), entre uno y 
diez y diga si es par o impar*/
package practica.pkg8;

import java.util.Scanner;

public class Practica811 {
    public static void main(String[] args) {
        
        Scanner lectura=new Scanner(System.in);
        String numero;
        boolean estado=false;
        
     
        do {
            System.out.println("Dime un numero entre 1 y 10");
            numero=lectura.nextLine();
            switch (numero) {
                case "1":
                case "3":
                case "5":
                case "7":
                case "9":
                    System.out.println("Es impar");
                    estado=false;
                    break;
                case "2":
                case "4":
                case "6":
                case "8":
                case "10":
                    System.out.println("Es par");
                    estado=false;
                    break;
                default:
                    System.out.println("Dime un numero valido,por favor");
                    estado=true;
            }   
        } while (estado==true);  
    }
}
