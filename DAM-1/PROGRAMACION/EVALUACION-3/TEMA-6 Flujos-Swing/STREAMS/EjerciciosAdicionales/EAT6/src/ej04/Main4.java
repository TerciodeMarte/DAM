package ej04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main4 {

    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        

        try {
            fis = new FileInputStream("hellothere.png");
            fos = new FileOutputStream("copia.png");
            while (fis.available()>0) {
               fos.write(fis.read());
            }
            System.out.println("Copia Realziada");
        } catch (IOException e) {
            System.err.println("Ha ocurrido una IOException");
        } finally {
            try {
                if (fis!=null) {
                   fis.close(); 
                }
                if(fos!=null){
                    fos.close();
                }
                
            } catch (IOException ex) {
                System.err.println("Ha ocurrido una IOException");
            }

        }
    }

}
