package ejercicio5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main5 {

    public static void main(String[] args) {
        
        FileOutputStream fos= null; //Flujo para crear archivos
        ObjectOutputStream oos= null; //Flujo para escribir objetos
        try {
            fos= new FileOutputStream("alumnos.dat");
            oos = new ObjectOutputStream(fos);
            String nombre[]= new String[]{"Albano","Daniel","Carmen","Ramiro"};
            int calificacion[]=new int[]{10,9,4,7};
            
            for (int i = 0; i < nombre.length; i++) {
                Alumno a=new Alumno(nombre[i],calificacion[i]);
                oos.writeObject(a);
            }
            System.out.println("Alumnos Guardados correctamente");
    
        } catch (IOException e) {
            System.err.println("Se a producido un error");
        }finally{
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                System.err.println("Se a producido un error");
            }
            
        }
        
    }

}
