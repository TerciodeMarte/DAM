package ej3;

import java.io.*;

public class LeerConBufferedReader {

    public static void main(String[] args) {
        //Le por consola un numero entero(como String) y lo muestra
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader bufferTeclado = new BufferedReader(isr);
            System.out.println("Introduzca un entero");
            String cadena = bufferTeclado.readLine();
            Integer.parseInt(cadena); //Linea innecesaria no se usa la conversion y tampoco se trata la excepcion para evitar errores
            System.out.println("Gracias por introducir " + cadena);
        } catch (IOException e) {
            System.err.println("Ha ocurrido una IOException");
        }

    }
}
