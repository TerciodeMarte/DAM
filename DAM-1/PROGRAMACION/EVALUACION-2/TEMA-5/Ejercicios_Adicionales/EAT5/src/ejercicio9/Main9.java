package ejercicio9;

import java.util.Arrays;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main9 {

    public static void main(String[] args) {
        Invierno i1=new Invierno(3);
        System.out.println("La temperatura media es: "+ i1.temp_media());
        System.out.println("Las temperaturas en Fahrenheit son: "+i1.mostrar(i1.fahrenheit()));
    }

}
