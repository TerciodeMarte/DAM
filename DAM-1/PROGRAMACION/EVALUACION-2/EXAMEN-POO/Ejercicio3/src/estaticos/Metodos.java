package estaticos;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Metodos {
    /**
     * Metodo que calcula cual es el numero mayor de entre tres
     * @param a numero 1
     * @param b numero 2
     * @param c numero 3
     * @return Numero mayor
     */
    public static int numeroMayor(int a, int b, int c) {
        if ((a > b) && (a > c)) {
            return a;
        } else if ((b > a) && (b > c)) {
            return b;
        } else {
            return c;
        }
    }
    /**
     * Metodo que calcula el porcentaje de Descuento sabiendo el precio original y el rebajado
     * @param precioRebajado Precio con rebaja
     * @param precio Precio sin reabaja
     * @return Porcentaje de Descuento
     */

    public static double porcentajeDescuento(double precioRebajado, double precio) {
        return 100-(precio/precioRebajado*100);
    }
    /**
     * Metodo que te da el equivalente en numeros romanos
     * @param numero Numero Decimal
     * @return Numero en romano
     */

    public static String numerosRomanos(byte numero) {
        switch (numero) {
            case 1:
                return "I";
               
            case 5:
                return "V";
                
            case 10:
                return "X";
                
            case 50:
                return "L";
                
            case 100:
                return "C";
            default:
                return "Ese numero no existe";
        }
    }
    /**
     * Metodo que calcula el volumen de una esfera
     * @param radio Radio de la esfera
     * @return Volumen de la esfera
     */
    public static double volumenEsfera(double radio){
        return (4/3)*Math.PI*Math.pow(radio, 3);
    }
}
