package ejercicio9;

import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Invierno {

    private double array[];

    public Invierno(int dimension) {
        array = new double[dimension];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Dime la temperatura de la posicion: " + i);
            array[i] = sc.nextDouble();
        }
    }

    public double temp_media() {
        double suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma = suma + array[i];
        }
        return suma / array.length;
    }
    
    public double[]fahrenheit(){
        double array2[]=new double[array.length];
        for (int i = 0; i < array.length; i++) {
            array2[i]=array[i]*1.8+32;
        }
        return array2;
    }
    
     public String mostrar(double arrayp[]){
        String aux="";
        for (int i = 0; i < arrayp.length; i++) {
            aux=aux+" "+arrayp[i];
        }
        return aux;
    }
    

}
