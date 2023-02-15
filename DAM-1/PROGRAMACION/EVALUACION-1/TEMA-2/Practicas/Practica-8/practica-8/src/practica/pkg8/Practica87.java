/*Escribir un algoritmo que permita escribir en pantalla la frase:
“Esta es la ejecución del programa"
"¿Desea continuar? S/N” 
Si la respuesta es S volvemos a ofrecer la ejecución del programa
Si la respuesta es N salimos del programa con una despedida
Si la respuesta es distinta de S o N informamos del dato inválido y se pregunta de 
nuevo si desea continuar.*/

package practica.pkg8;

import java.util.Scanner;

public class Practica87 {
    public static void main(String[] args) {
        String respuesta;
        char aux;
        Scanner lectura= new Scanner(System.in);
        do {            
            System.out.println("Esta es la ejecución del programa");
            System.out.println("¿Desea continuar? S/N");
            respuesta=lectura.nextLine();
            aux=respuesta.charAt(0);
            if (aux!='S'&& aux!='N') {
                System.out.println("Respuesta Invalida");
            } else {
            }
        } while (aux!='N');
       
    }
    
}
