package ej03;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main3 {

    public static void main(String[] args) {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = null;
        String palabra = "";
        try {
            fw = new FileWriter("ej3.txt");

            do {
                System.out.println("Dime la palabra para almacenar");
                palabra = bf.readLine();
                fw.write(palabra + "\n");

            } while (!palabra.equalsIgnoreCase("$"));
        } catch (IOException e) {
            System.err.println("Ha ocurrido una IOexception");
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                    bf.close();
                }
            } catch (IOException ex) {
                System.err.println("Ha ocurrido una IOexception");
            }

        }

    }

}
