//Crea un array de seis números enteros y muéstralo por pantalla.

package practica.pkg7;
import java.util.Arrays;
import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
       //Declaración e inicialización del array de tipo int(DIMENSIÓN 6)
       int array[]= new int[6];
       Scanner lectura =new Scanner(System.in);
       
       //Dar datos por consola al array
        for (int i = 0; i < 6; i++) {
            System.out.println("Dime el numero de la posicion "+ (i+1));
            array[i]=lectura.nextInt();
        }
    
       
       //Mostrar dato por consola transformando a String
       //Metodo toString de la clase Arrays
       System.out.println(Arrays.toString(array));
    }  
}
