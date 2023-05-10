package ejemploxml;

import java.io.*;
import java.util.*;

public class EjemploXML {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        FileWriter fw = null;
        String texto1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        System.out.println("Introduce el elemento raíz:");
        String raiz = teclado.nextLine();
        String texto2 = "\n<" + raiz + ">" + "\n</" + raiz + ">";
        try {
            fw = new FileWriter("datos1.xml");
            fw.write(texto1);
            fw.write(texto2);
            System.out.println("Fichero XML generado.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido una IOException.");
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.err.println("Ha ocurrido una IOException.");
            }

        }
    }

}


