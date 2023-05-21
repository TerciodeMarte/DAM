/*Devuelve un mensaje con sobresaliente si la nota introducida está entre 9 y 10, 
notable si está entre 7 y 8, bien si está entre 6 y 7, 
suficiente si está entre 5 y 6 e insuficiente si está entre 0 y 5. Utiliza un switch.
*/

package tarea.pkg2;

//IMPORTACIÓN CLASE SCANNER
import java.util.Scanner;

public class Tarea21 {

    public static void main(String[] args) {
        
        //DECLARACIÓN DE VARIABLES Y OBJETOS
        byte nota=0;
        Scanner lectura= new Scanner(System.in);
        
        //ALGORITMO PARA VERIFICAR SI LA NOTA INTRODUCCIDA ES VALIDA
        do {
            System.out.println("Introduce una nota,Numero Entero");
            nota=lectura.nextByte();
            if(nota<0||nota>10){
                System.out.println("Introduce una nota valida,por favor");
            } 
        } while (nota<0||nota>10);
        
      
        //ALGORITMO PARA MOSTRAR POR CONSOLA UN TEXTO SEGUN EL VALOR DE LA VARIABLE NOTA
        switch (nota) {
            case 10:
                System.out.println("SOBRESALIENTE");
                break;
            case 9:
                System.out.println("SOBRESALIENTE");
                break;
            case 8:
                System.out.println("NOTABLE");
                break;
            case 7:
                System.out.println("NOTABLE");
                break;
            case 6:
                System.out.println("BIEN");
                break;
            case 5:
                System.out.println("SUFICIENTE");
                break;
            default:
                System.out.println("INSUFICIENTE");
        }
    } 
}
