package ejercicio2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main2 {

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String cadena = "";
        String letra = "";

        FileWriter fw = null;

        do {
            try {
                letra = bf.readLine();
                if (letra.equals("\\")) {
                    cadena = cadena + "\n";
                } else if (letra.equals("@")) {

                } else {
                    cadena = cadena + letra;
                }

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        } while (!letra.equals("@"));
        //System.out.println(cadena);

        try {
            fw = new FileWriter("ficheroej2.txt");
            fw.write(cadena);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }

    }

}
