package Ejercicio5;

/**
 *
 * @author Albano Díez de Paulino
 */
public class main {

    public static void main(String[] args) {
        int array[][]=new int[4][3];
        int suma[]=new int[3];
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j]=(int) (Math.random() * 100);
                System.out.print(array[i][j]+" ");
                suma[j]=suma[j]+array[i][j];
            }
            System.out.println("");
        }
       System.out.println("Suma de columnas");
       for (int i = 0; i < suma.length; i++) {
            System.out.print(suma[i]+" ");
        }
    }

}
