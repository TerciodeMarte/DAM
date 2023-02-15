package minijuego2;

public class Script {
    //DECLARACIÓN DE VARIABLES Y OBJETOS A USAR
    private static String palabras[] = new String[]{"DINOSAURIOS", "MEDICO", "ORNITORRINCO", "FUTBOL", "PANTALLA", "ARBOL"};
    private static String palabra;
    private static char palabraacertada[];
    private static byte contadoraciertos = 0, contador = 0, contador2 = 0;

    //ELECCION DE PALABRA (5 DIFERENTES,FORMA ALEATORIA)
    public static void eleccion(int x) {
        palabra = palabras[x];
        palabraacertada = new char[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            palabraacertada[i] = '-';

        }
        System.out.println(palabraacertada);

    }
    //METODO PARA COMPROBAR SI LA LETRA QUE HA INTRODUCIDO EL USUARIO ESTA EN LA PALABRA
    public static byte comprobacionLetras(char a) {
        contadoraciertos = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == a && palabraacertada[i] == '-') {
                palabraacertada[i] = a;
                contadoraciertos++;
            }
        }
        if (contadoraciertos == 0) {
            contador++;
            System.out.println("FALLASTES");
            return contador;

        } else {
            System.out.println("ACERTASTE");
            return contador;
        }
    }
    //METODO PARA MOSTRAR LA PALABRA CON LAS QUE HA ACERTADO EL USUARIO
    public static void mostrarPalabra() {
        for (int i = 0; i < palabra.length(); i++) {
            System.out.print(palabraacertada[i]);
            System.out.print("|");
        }
        System.out.println();
    }
    //METODO PARA MATAR EL PROGRAMA SI EL USUARIO HA ACERTADO TODAS
    public static void Final() {
        contador2 = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabraacertada[i] == '-') {
                contador2++;
            }
        }
        if (contador2 == 0) {
            for (int i = 0; i < palabra.length(); i++) {
                System.out.print(palabraacertada[i]);
                System.out.print("|");
            }
            System.exit(0);
        }
    }

}
