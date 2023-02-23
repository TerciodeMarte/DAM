package ejercicio7;

import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Clase {
    private int array[] = new int[5];

    public Clase() {
        Scanner sc= new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Dime el numero de la posicion: "+i);
            array[i]=sc.nextInt();
        }
    }
    
    public void porDos(){
        for (int i = 0; i < array.length; i++) {
            array[i]=array[i]*2;
        }
    }
    public String mostrar(){
        String aux="";
        for (int i = 0; i < array.length; i++) {
            aux=aux+" "+array[i];
        }
        return aux;
    }
    public int sumaPares(){
        int suma=0;
        for (int i = 0; i < array.length; i++) {
            if (i%2==0) {
                suma=suma+array[i];
            }
        }
        return suma;
    }
     
     

}
