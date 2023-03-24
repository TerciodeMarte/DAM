package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Albano Díez de Paulino
 */

/*1. Utilizando las clases de flujo para la lectura de teclado
Crea un programa que pida por teclado nombre, edad y altura en metros de un niño menor de 
10 años, y devuelva los datos de la persona dentro de 10 años, suponiendo que ha crecido 70 
centímetros.*/
public class main1 {

    public static void main(String[] args) {
        boolean controledad = false;
        boolean controlaltura = false;
        double altura=0;
        int edad=0;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            System.out.println("Dime el nombre del ninno");
            String nombre = br.readLine();
            do {
                try {

                    System.out.println("Dime la edad del niño");
                    edad= Integer.parseInt(br.readLine());
                    if (edad > 10 || edad < 0) {
                        System.out.println("Dime una edad comprendida entre 0 y 10");
                        throw new Exception("Error");
                    } else {
                        controledad = false;
                    }

                } catch (NumberFormatException e) {
                    System.err.println("Debes introducir un numero entero");
                    controledad = true;
                } catch (Exception e) {
                    controledad = true;
                }
            } while (controledad);

            do {
                try {
                    System.out.println("Dime la altura en metros");
                    altura = Double.parseDouble(br.readLine());
                    if (altura < 0.3 || altura > 1.5) {
                        System.out.println("Dime una altura logica");
                        throw new Exception("Error");
                    } else {
                        controlaltura = false;
                    }

                } catch (NumberFormatException e) {
                    System.err.println("Debes introducir un numero");
                    controlaltura=true;
                } catch (Exception e) {
                    controlaltura = true;
                }
            } while (controlaltura);

            System.out.println("El ninno " + nombre + " dentro de 10 años medira " + (altura+0.7) + " m");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }finally{
            try {
                 br.close();
            } catch (IOException e) {
                 System.err.println(e.getMessage());
            }
           
        }
    }

}
