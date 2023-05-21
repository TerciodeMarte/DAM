package practica.pkg7;
//Calcula y muestra por pantalla la superficie y el volumen de un cilindro a partir de su 
//radio y su altura, que se deben poder introducir por teclado.

import java.util.Scanner;


//Volumen=(PI*R^2)*h
//Superficie=(2π*r*h + 2π*r^2)

public class ejercicio2 {
    public static void main(String[] args) {
        //Declaración de Variables y Objetos
        Scanner lectura =new Scanner(System.in);
        double radio,altura,volumen,superficie;
        
        //Lectura de radio y altura por consola(Tipo Double)
        System.out.println("Dame el radio del cilindro");
        radio=lectura.nextDouble();
        
        System.out.println("Dame la altura del cilindro");
        altura=lectura.nextDouble();
        
        //Asignación de variables por formula matematica
        superficie = 2*Math.PI*radio*altura+2*Math.PI*Math.pow(radio,2);
        volumen = (Math.PI*Math.pow(radio,2))*altura;
        
        //Mostrar por consola los datos
        System.out.println("La superficie del cilindro es " + superficie);
        System.out.println("El volumen del cilindro es " +volumen); 
        
    }
    
}
