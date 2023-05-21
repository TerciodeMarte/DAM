package ej6;

import java.io.*;

public class AlmacenarObjetos {

    public static void main(String[] args) {
        //Almacena objetos en forma de bytes en el archivo.dat
        Amigo am1 = new Amigo("Pablo", 987987987);
        Amigo am2 = new Amigo("Laura", 678678678);
        Amigo am3 = new Amigo("Carlos", 876876876);

        FileOutputStream fos = null;
        ObjectOutputStream flujosalidaobjetos = null;
       
        try {
            
            fos = new FileOutputStream("amigos.txt"); //debe de ser amigos.dat
         
            flujosalidaobjetos = new ObjectOutputStream(fos);

            flujosalidaobjetos.writeObject(am1);           
            flujosalidaobjetos.writeObject(am2);           
            flujosalidaobjetos.writeObject(am3);

        } catch (IOException e) {
            System.err.println("Ha ocurrido una IOException");
        } finally {
            try {
                if (flujosalidaobjetos != null) {//La condicion del if deberia de ser con fos
                    flujosalidaobjetos.close();                   
                    fos.close();                             
                }
            } catch (IOException e) {
                System.err.println("Ha ocurrido una IOException");

            }

        }
    }
}
