package Ejercicio7;

import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scstring = new Scanner(System.in);
        Coche c1 = new Coche("Rojo", "Seat");
        Coche c2 = new Coche("Azul", "Renault");
        Coche c3 = new Coche("Verde", "Volkswagen");
        Coche c4 = new Coche("Negro", "Scania");

        Almacen a1 = new Almacen();

        /*Una vez creado el almacén deberás rellenarlo con al menos cuatro coches.*/
        a1.add_coche(c1);
        a1.add_coche(1,c2);
        a1.add_coche(c3);
        a1.add_coche(3,c4);
        System.out.println("Almacen con 4 coches");
        a1.visualiza_coches();
        
        System.out.println("");

        /*Comprueba el tamaño del almacén.*/
        System.out.println("Tamano del Almacen: " + a1.tamano_almacen());
        
        System.out.println("");

        /*Elimina dos de los coches. Visualiza la colección de nuevo.*/
        a1.remove_coche(1);
        a1.remove_coche(c3);
        System.out.println("Almacen eliminando dos coches");
        a1.visualiza_coches();
        
        System.out.println("");

        /*Añádelos en la posición final.*/
        a1.add_coche(c2);
        a1.add_coche(c3);

        /*Pregunta por teclado a un usuario qué vehículo desea localizar (pidiendo su 
        matrícula) y da respuesta a tal búsqueda con la información de ese objeto*/
        System.out.println("Dime que posicion del almacen para ver la informacion del coche");
        int x = sc.nextInt();
        a1.buscar(x);
        
        System.out.println("");

        /*Utiliza el constructor copia para comprobar que realizas correctamente la copia 
        de seguridad del Almacén.*/
        Almacen a2 = new Almacen(a1);
        System.out.println("Almacen Copia");
        a2.visualiza_coches();
        System.out.println("");
        
        /*Pregunta por teclado a un usuario qué vehículo desea localizar (necesitas todos 
        sus datos) y da respuesta a tal búsqueda, diciendo si el objeto existe o no en el almacén*/
        
        System.out.println("Dime el color del coche para buscar");
        String color=scstring.nextLine();
        System.out.println("Dime la marca del coche para buscar");
        String marca=scstring.nextLine();
        
        Coche c5 = new Coche(color,marca);
        System.out.println(a2.buscar(c5));
       

        
    }

}
