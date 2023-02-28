package ejercicio05;
/**
 *
 * @author Albano Díez de Paulino
 */
public class Main5 {

    public static void main(String[] args) {
        int array[] = new int[10];
        int aux;
        for (int i = 0; i < 10; i++) {
            array[i]=i;
        }
        
        for (int i = 0; i < 10; i++) {
            aux=array[i];
            array[i]=array[(array.length-1)-i];
            array[(array.length-1)-i]=aux;
            System.out.println(array[i]);
        }
    }

}
