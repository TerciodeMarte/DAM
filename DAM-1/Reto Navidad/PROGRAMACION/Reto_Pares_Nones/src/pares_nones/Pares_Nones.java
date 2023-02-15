/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pares_nones;

import java.util.Scanner;

/**
 *
 * @author damt104
 */
public class Pares_Nones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        //Me doy a elegir entre pares o nones
        System.out.println("Elige pares o nones");
        String eleccion = sc.nextLine();
        //Meto un bucle while para que solo se pueda contestar pares o nones, sino se repetira
        while (!(eleccion.equals("pares") || eleccion.equals("nones"))) {
            System.out.println("pares o nones, no vale truquito");
            eleccion = sc.nextLine();
        }
        if (eleccion.equals("pares")) {
            System.out.println("Pues yo nones");
        }
        if (eleccion.equals("nones")) {
            System.out.println("Pues yo pares");
        }

        System.out.println("A la de 3 sacamos un numero");
        System.out.println("1  2  3");
        int num1, num2, resultado;
 
        do{
            System.out.println("Tiene que ser un numero de dedo validos entre el  0 y el 5");
             num1 = sc.nextInt(); 
        } while(num1<=-1|num1>=6);
      //En esta parte tienes que introducir un numero del 1 al 5, se repetira el mensaje hasta que se introduzca un numero valido 
        //Meto un random pero al tener decimales, le tengo que transformar a entero con la formula
        num2 = (int)Math.floor(Math.random()*5);
        System.out.println("Pues yo elijo: "+num2);
        resultado = num1 + num2;
        System.out.println(num1+" + "+num2+" = "+resultado);
        //Hago la operacion del resto para saber si son pares o nones
         if  (resultado%2 == 0) {
             System.out.println ("Ganan los pares");
         } else {
             System.out.println ("Ganan los nones");
         }
    }
}

