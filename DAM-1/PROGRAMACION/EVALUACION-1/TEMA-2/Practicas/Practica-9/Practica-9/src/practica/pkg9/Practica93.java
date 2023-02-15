////////////////////////////////////////////////////////////////////////////////////
//   AUTOR: Albano Díez de Paulino                                    Noviembre/2022
////////////////////////////////////////////////////////////////////////////////////
//   PROGRAMA:   HOJA 9 EJERCICIO 3                      VERSIÓN: 1.0      
//   DISPOSITIVO: Lenovo V510/Intel Core I7 7ºGen                              
//   Versión JDK: SE 18
//   Version Netbeans: 15                             
//   S.O USADO: Windows 10                  
////////////////////////////////////////////////////////////////////////////////////
/*
Crea un programa que pregunte al usuario cuántos números quiere 
almacenar. El usuario podrá introducir números con decimales que se 
almacenarán en un array y el programa deberá devolver el valor medio de 
los números
*/
////////////////////////////////////////////////////////////////////////////////////
///                    IMPORTAR LIBRERÍAS Y ASIGNAR PACKAGE                      ///
////////////////////////////////////////////////////////////////////////////////////

package practica.pkg9;
import java.util.Scanner;

////////////////////////////////////////////////////////////////////////////////////
///                              CLASE PRINCIPAL                                 ///
////////////////////////////////////////////////////////////////////////////////////
public class Practica93 {
 
////////////////////////////////////////////////////////////////////////////////////
///                              METODO DE ACCESO                                ///
////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
////////////////////////////////////////////////////////////////////////////////////
///                       VARIABLES Y OBJETOS GLOBALES                           ///
//////////////////////////////////////////////////////////////////////////////////// 

        int num;
        double suma=0;
        Scanner lectura =new Scanner(System.in);
            
////////////////////////////////////////////////////////////////////////////////////
///                               PROGRAMA PRINCIPAL                             ///
////////////////////////////////////////////////////////////////////////////////////
        do {
            System.out.println("Dime cuantos numeros quieres almacenar(minimo 1)");
            num= lectura.nextInt();
        } while (num<0);
        
       double array[]=new double[num];
       
        for (int i = 0; i <array.length; i++) {
            System.out.println("Dime el numero que quieres almacenar en la posicion " + i+1);
            array[i]=lectura.nextDouble();
            suma=suma+array[i];
        }
        System.out.println("La media de los numeros introducidos es "+(suma/num));
       
    }
 
}










