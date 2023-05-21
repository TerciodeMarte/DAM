package ejercicio04;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main4 {

    public static void main(String[] args) {
        int array[] = new int[10];
        int array2[] =new int[10];
        
        for (int i = 0; i < 10; i++) {
            array[i]=i;
        }
        for (int i = 0; i < array.length; i++) {
            array2[i]=array[(array.length-1)-i];
            System.out.println(array2[i]);
        }
    }

}
