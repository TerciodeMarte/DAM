//Obtener todos los números primos entre 2 y 100.

package practica.pkg8;


public class Practica88 {
    public static void main(String[] args) {
        
        boolean estado;
        
        for (int i = 2; i <= 100; i++) {
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

