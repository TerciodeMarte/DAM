package paisesxml;

import java.io.*;
import java.util.*;

public class PaisesXML {

    public static void main(String[] args) {

        boolean isnumero = false;
        int numeropaises = 0;
        String pais, capital;
        Scanner teclado = new Scanner(System.in);
        Scanner tecladoint = new Scanner(System.in);

        FileWriter fw = null;

        try {

            do {
                try {
                    System.out.println("Cuantos paises quieres introducir");
                    numeropaises = tecladoint.nextInt();
                    if (numeropaises < 0) {
                        System.err.println("No se pueden introducir numeros negativos");
                        isnumero = true;
                    } else {
                        fw = new FileWriter("paises.xml");
                        fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
                        fw.write("<paises>");
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Introduce un numero");
                    isnumero = true;
                }
            } while (isnumero);

            for (int i = 0; i < numeropaises; i++) {
                System.out.println("Dime el nombre del pais");
                pais = teclado.nextLine();
                System.out.println("Dime la capital del pais");
                capital = teclado.nextLine();
                 fw.write("\n\t<pais>\n\t\t<nombre> " + pais + "</nombre>\n" + "\t\t<capital>" + capital + "</capìtal>\n\t</pais>");
            }

            fw.write("\n</paises>");
        } catch (IOException e) {
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
