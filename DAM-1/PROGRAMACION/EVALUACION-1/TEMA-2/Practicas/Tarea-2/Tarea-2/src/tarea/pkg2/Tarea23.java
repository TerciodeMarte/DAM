/* Devuelve la tabla de multiplicar del número introducido, que debe ser un entero entre 1 y 9. 
La tabla mostrará los productos del número desde el 0 hasta el 10. 
Utiliza un for.*/
package tarea.pkg2;

//IMPORTACIÓN CLASE SCANNER
import java.util.Scanner;

public class Tarea23 {

    public static void main(String[] args) {
        
        //DECLARACIÓN DE VARIABLES Y OBJETOS
        byte num=0;
        Scanner lectura= new Scanner(System.in);
        
        //ALGORITMO PARA VERIFICAR SI LA NUM INTRODUCCIDA ES VALIDA
        do {
            System.out.println("Introduce que tabla de multiplicar quieres,(Numero Entero)");
            num=lectura.nextByte();
            if(num<=0||num>9){
                System.out.println("Introduce un numero,por favor");
            } 
        } while (num<=0||num>9);
        
        System.out.println("LA TABLA DE MULTIPLICAR DEL "+ num);
        
        //ALGORITMO QUE MUESTRA TODA LA TABLA DE MULTIPLICAR
        for (int i = 0; i < 10; i++) {
            System.out.println(num + "x"+ i+ "="+ (num*i));  
        }
     
    } 
}
