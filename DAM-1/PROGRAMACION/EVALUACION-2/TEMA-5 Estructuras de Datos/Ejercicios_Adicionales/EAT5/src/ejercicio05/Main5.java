package ejercicio05;
/**
 *
 * @author Albano Díez de Paulino
 */
public class Main5 {

    public static void main(String[] args) {
        int array[] = new int[10];
        int aux;
        for (int i = 0; i < array.length; i++) {
            array[i]=i;
        }
        
        for (int i = 0; i < array.length/2; i++) {
            aux=array[i];
            array[i]=array[(array.length-1)-i];
            array[(array.length-1)-i]=aux;
            
        }
        for (int i : array) {
            System.out.println(i);
        }
    }

}
