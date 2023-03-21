package ej4;

import java.io.*;

public class LeerFicherosC {

    public static void main(String[] args) {
        //Lee el fichero datos1.txt caracter por caracter hasta que encuentra un '.'

        FileReader fr = null;        
        String texto = "";
        char c = 0;
        try {
            fr = new FileReader("datos1.txt");
           
            do {                              
                c = (char) fr.read();            
                texto = texto + c;          
            } while (c != '.');
            System.out.println(texto);
        } catch (FileNotFoundException fnfe) {
            System.err.println("Archivo no encontrado");
        } catch (IOException e) {
            System.err.println("Ha ocurrido una IOException");
        } finally {
           
            try {

                if (fr != null) {
                    fr.close();                  
                }                                   
            } catch (IOException e) {
                System.err.println("Ha ocurrido una IOException");
            }

        }

    }
}
