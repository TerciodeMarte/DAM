package ejercicio01;

/**
 *
 * @author Albano Díez de Paulino
 */
public class main1 {
    public static void main(String[] args) {
        
        int array[]=new int[]{-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};
        
        for (int i = 0; i < array.length; i++) {
            array[i]=-1;
            System.out.println(array[i]);
        }
        
        for (int i = 0; i < array.length; i++) {
            array[i]=i+12;
            System.out.println(array[i]);
        }
    }
    
}
