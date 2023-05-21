// Obtener los números primos entre 3 y 9999.
package practica.pkg8;

public class Practica815 {

    public static void main(String[] args) {
         boolean estado;
        
        for (int i = 3; i <= 9999; i++) {
            estado=true;
            for (int j = 2; j < i; j++) {
                if (i%j==0) {
                    estado=false;
                }
            }
            if (estado==true) {
                System.out.println(i);
            }
            }
    }
    
}
