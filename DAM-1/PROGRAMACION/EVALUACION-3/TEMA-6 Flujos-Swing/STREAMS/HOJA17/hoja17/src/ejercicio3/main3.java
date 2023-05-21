package ejercicio3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Albano Díez de Paulino
 */

/*3. Lectura secuencial de un archivo con la clase FileInputStream
Lee los datos almacenados en el archivo “datos personales”.*/

public class main3 {

    public static void main(String[] args) {
        FileInputStream fis=null;
        String texto="";
        char c=0;
        
        try {
            fis=new FileInputStream("datospersonales.txt");
            int longitud=fis.available();
            for (int i = 0; i < longitud; i++) {
                c=(char)fis.read();
                texto=texto+c;
            }
            System.out.println(texto);
            
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }finally{
            try {
                fis.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        
    }

}
