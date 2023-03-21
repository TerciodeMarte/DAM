package ej5;

import java.io.*;

public class LeerFicherosB {

    public static void main(String[] args) {
        ////Lee el fichero datos1.txt caracter por caracter
        FileInputStream fis = null;
        String texto = "";
        char c = 0;
        try {
            fis = new FileInputStream("datos1.txt");
            int longitud = fis.available();
            for (int i = 0; i < longitud; i++) {
                c = (char) fis.read();
                texto = texto + c;
            }
            System.out.println(texto);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Ha ocurrido una IOException");
        } finally {
            try {

                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                System.out.println("Ha ocurrido una IOException");
            }

        }

    }
}
