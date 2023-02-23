package ejercicio9;

import java.util.Arrays;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main9 {

    public static void main(String[] args) {
        Invierno i1=new Invierno(3);
        double i2[]=new double[]{1,2,3,4,5,6};
        System.out.println("La temperatura media es: "+ i1.temp_media());
        System.out.println("Las temperaturas en Fahrenheit son: " + Arrays.toString(i1.fahrenheit()));
        System.out.println("El array que me has pasado es: "+i1.mostrar(i2));
    }

}
