//Visualizar por pantalla las tablas de multiplicar del 1 al 10
package practica.pkg8;


public class Practica89 {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("LA TABLA DE MULTIPLICAR DEL " + i);
            for (int j = 1; j <= 10; j++) {
                System.out.println(i+"x"+j+"="+(i*j));
            }
        }
        
    }
    
}
