/*Devuelve un mensaje con sobresaliente si la nota introducida está entre 9 y 10, 
notable si está entre 7 y 8, bien si está entre 6, 
suficiente si está entre 5 e insuficiente si está entre 0 y 5. Utiliza un elseif.
Trabajar con Decimales
*/
package tarea.pkg2;

//IMPORTACIÓN CLASE SCANNER
import java.util.Scanner;

public class Tarea22 {

    public static void main(String[] args) {
        
        //DECLARACIÓN DE VARIABLES Y OBJETOS
        float nota=0;
        Scanner lectura= new Scanner(System.in);
        
        //ALGORITMO PARA VERIFICAR SI LA NOTA INTRODUCCIDA ES VALIDA
        do {
            System.out.println("Introduce una nota");
            nota=lectura.nextFloat();
            if(nota<0||nota>10){
                System.out.println("Introduce una nota valida,por favor");
            } 
        } while (nota<0||nota>10);
      
        //ALGORITMO PARA MOSTRAR POR CONSOLA UN TEXTO SEGUN EL VALOR DE LA VARIABLE NOTA
        if (nota>=9) {
            System.out.println("SOBRESALIENTE");
        } else if(nota<9&&nota>=7) {
            System.out.println("NOTABLE");
        }else if(nota<7&&nota>=6) {
            System.out.println("BIEN");
        }else if(nota<6&&nota>=5) {
            System.out.println("SUFICIENTE");
        }else{
            System.out.println("INSUFICIENTE");
        }
    } 
}
