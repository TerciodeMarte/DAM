package ej1;

import java.io.*;


public class EscribirFicherosC {

    public static void main(String[] args) {
        //Escribe el string "hola." entero en el fichero datos1.txt
        FileWriter fw = null;      
        String texto = "hola.";
        try {
            fw = new FileWriter("datos1.txt");
            fw.write(texto); 
            System.out.println("Texto escrito");  
        } catch (IOException e) {
            System.err.println("Ha ocurrido una IOException");
        } finally {
            try {
                fw.close();   
            } catch (IOException e) {    
                System.err.println("Ha ocurrido una IOException");
            }
           
        }
    }
}
