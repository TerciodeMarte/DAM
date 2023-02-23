package ejercicio7;
/**
 *
 * @author Albano Díez de Paulino
 */
public class Main7 {

    public static void main(String[] args) {
        Clase c1=new Clase();
        System.out.println("Numeros Introducidos");
        System.out.println(c1.mostrar());
        
        c1.porDos();
        System.out.println("Numeros Introducidos por dos");
        System.out.println(c1.mostrar());
        
        System.out.println("Suma de los numeros en posiciones pares");
        System.out.println(c1.sumaPares());
        
    }

}
