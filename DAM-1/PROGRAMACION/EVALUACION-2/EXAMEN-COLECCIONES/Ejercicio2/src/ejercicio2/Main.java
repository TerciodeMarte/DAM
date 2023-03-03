package ejercicio2;
/**
 *
 * @author Albano Díez de Paulino
 */
public class Main {

    public static void main(String[] args) {
        String array[][] =new String[4][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j%2==0) {
                    array[i][j]="+";
                    System.out.print(array[i][j]+"  ");
                }else{
                    array[i][j]="-";
                    System.out.print(array[i][j]+"  ");
                }
            }
            System.out.println("");
        }
        
    }

}
