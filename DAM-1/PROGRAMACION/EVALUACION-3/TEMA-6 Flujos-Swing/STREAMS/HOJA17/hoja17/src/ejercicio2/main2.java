package ejercicio2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Albano Díez de Paulino
 */

/*2. Escritura secuencial en un archivo con la clase FileOutputStream
Crea un programa que guarde en un archivo llamado “datos personales” el nombre, la edad y 
la altura que introduce un único usuario por teclado en una única cadena de caracteres.*/
public class main2 {

    public static void main(String[] args) {
        boolean controledad = false;
        boolean controlaltura = false;
        double altura = 0;
        int edad = 0;
        FileOutputStream fos = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Dime el nombre del ninno");
            String nombre = br.readLine();
            do {
                try {

                    System.out.println("Dime la edad del niño");
                    edad = Integer.parseInt(br.readLine());
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
                    controlaltura = true;
                } catch (Exception e) {
                    controlaltura = true;
                }
            } while (controlaltura);
            String texto = "Nombre: " + nombre + "\nEdad: " + edad + "\nAltura: " + altura;
            fos = new FileOutputStream("datospersonales.txt");
            for (int i = 0; i < texto.length(); i++) {
                fos.write(texto.charAt(i));
            }
            System.out.println("Texto escrito correctamente");

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                br.close();
                fos.close();
            }catch(FileNotFoundException f){
                System.err.println(f.getMessage());
            }catch (IOException e) {
                System.err.println(e.getMessage());
            }

        }
    }

}
