/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clasefile;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author carra
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //ARCHIVO
        File archivo = new File("ARCHIVOSEJ2/hola.txt");
        if (archivo.exists()) {
            System.out.println("existe");
            System.out.println(archivo.getName());
            System.out.println(archivo.length());
            System.out.println(archivo.getAbsolutePath());
            archivo.delete();
        } else {
            System.out.println("no existe");
            try {
                archivo.createNewFile();
                System.out.println(archivo.getName());
                System.out.println(archivo.length());
                System.out.println(archivo.getAbsolutePath());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        // CARPETA
        File carpeta = new File("ARCHIVOSEJ2");
        if (carpeta.exists()) {
            System.out.println("existen");
            System.out.println(carpeta.getName());
            System.out.println(carpeta.length());
            System.out.println(carpeta.getAbsolutePath());
        } else {
            System.out.println("no existe");
            carpeta.mkdir();
            System.out.println(carpeta.getName());
            System.out.println(carpeta.length());
            System.out.println(carpeta.getAbsolutePath());

        }
        //LISTAR ARCHIVOS Y DIRECTORIOS
        System.out.println("CARPETAS EN C:/");
        File raiz = new File("C:/");

        String[] lista = raiz.list();
        if (lista != null) {
            for (String i : lista) {
                System.out.println(i);
            }

        }
        
        //LISTANDO ARCHIVOS DENTRO DE LA CARPETA UTILIZANDO EL METODO .listFiles

        System.out.println("\nLISTANDO ARCHIVOS DENTRO DE LA CARPETA UTILIZANDO EL METODO .listFiles");

        System.out.println("ARCHIVOS EN C:/");
        File raiz2 = new File("C:/");
        File[] lista2 = raiz2.listFiles();
        if (lista2 != null) {
            for (File i : lista2) {
                if (i.isFile()) {
                    System.out.println("Nombre: " + i.getName() + " bytes: " + i.length());
                }

            }

        } else {
            System.out.println("la ruta esta vacia o no es una carpeta");

        }

    }

}
