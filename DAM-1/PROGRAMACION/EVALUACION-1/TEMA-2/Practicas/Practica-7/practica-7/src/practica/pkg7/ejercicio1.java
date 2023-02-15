
package practica.pkg7;

import java.util.Scanner;

/**
 *
 * @author Albano Díez
 */
//Calcula y muestra por pantalla la superficie y el volumen de una esfera a partir de su 
//radio, el cual se debe poder introducir por teclado

public class ejercicio1 {


    public static void main(String[] args) {
        //Declaración de Variables y Objetos
        Scanner lectura =new Scanner(System.in);//Objeto Scanner copiar tal cual
        double radio,superficie,volumen; //Declaración de 3 variables en una linea
        
        //Lectura de dato por consola(Tipo Double)
        System.out.println("Dame el radio de la esfera");
        radio=lectura.nextDouble();
        
        /* Formula Superficie 4*PI*r^2
        Formula Volumen (4*PI*r^3)/3 */
        
        //Asignación de variables con formula matematica
        superficie = 4*Math.PI*Math.pow(radio,2);
        volumen = (4*Math.PI*Math.pow(radio,3))/3;
        
        //Mostrar por consola los datos
        System.out.println("La superficie de la esfera con radio " + radio + " es " + superficie);
        System.out.println("El volumen de la esfera con radio " + radio + " es " + volumen); 
    }
    
}
