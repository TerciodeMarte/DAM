/*. Diseña un programa que permita almacenar el nombre de 5 personas en 
un array, que el usuario deberá introducir por teclado. Se mostrará por 
pantalla cuál es el nombre repetido (si lo hay). En caso contrario deberá 
aparecer un mensaje diciendo que no hay nombres repetidos.*/
package practica.pkg9;

import java.util.Scanner;

public class Practica96 {
    public static void main(String[] args) {
       
        String array[]=new String[5];
        Scanner lectura =new Scanner(System.in);
        int contador=0;
        
        for (int i = 0; i < array.length; i++) {
            System.out.println("Dime el "+(i+1)+" nombre");
            array[i]=lectura.nextLine();
            for (int j = 0; j < i; j++) {
                if (array[i].equalsIgnoreCase(array[j])) {
                    contador++;
                    System.out.println("Te has repetido con el "+(j+1)+" nombre");
                }
            }
        }
        if (contador==0) {
            System.out.println("No hay nombres iguales");
        }
        
    }
}
