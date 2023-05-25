package ejemplo5;

import com.db4o.*;
import com.db4o.query.Query;
import ejemplo1.Estudiante;
import java.io.File;
import java.util.Scanner;


public class Ejemplo5 {

    public static void main(String[] args) {

        ObjectContainer bd = Db4oEmbedded.openFile("Ejemplo");
        
        //Declaración de objetos 
        Estudiante e;
        String nombre;
        int pos;
        Query consulta;
        ObjectSet res;
        Scanner teclado = new Scanner(System.in);
       
        System.out.println("Introduce el nombre del estudiante para modificar su nota.");
        nombre=teclado.next();
        res=bd.queryByExample(new Estudiante (nombre, 0));
        
        if (res.size()==0){
            System.out.println("No hay ningún estudiante con ese nombre.");
        } else{
            while(res.hasNext()){
                e=(Estudiante) res.next();
                System.out.println("Introduce la nueva nota de "+nombre);
                e.setNota(teclado.nextInt());
                bd.store(e);
            }
        }
        
        pos=0;
        System.out.println("Así ha quedado la base de datos con los cambios introducidos:");
        consulta=bd.query();
        consulta.constrain(Estudiante.class);
        res=consulta.execute();
        while (res.hasNext()){
            System.out.println("Los datos del alumno nº "+(pos+1)+" son:");
            e=(Estudiante) res.next();
            e.info();
            pos++;
        }
        
        //Cerramos la base de datos
        bd.close();
    }

}
