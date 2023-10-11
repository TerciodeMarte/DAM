/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

 /*1. EJERCICIO 1. Realiza un programa en java que muestre 
por pantalla el nombre del Sistema Operativo, 
del usuario y cambie el nombre del usuario por tu nombre y dos apellidos y 
establezca un nuevo directorio de trabajo.*/
package examen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Leer propiedades
        System.out.println("El sistema operativo donde se esta ejecutando este programa es: ");
        System.out.println(System.getProperty("os.name"));
        System.out.println("Y el usuario que este ejecutando el programa es: ");
        System.out.println(System.getProperty("user.name"));

        //Modificar propiedad
        System.out.println("\nEstableciendo nuevo nombre de usuario ");
        System.setProperty("user.name", "Albano Díez de Paulino");
        System.out.println("Nombre nuevo: " + System.getProperty("user.name"));

        //Cambiar directorio
        System.out.println("\nDirectorio Antiguo");
        System.out.println(System.getProperty("user.dir"));
        System.setProperty("user.dir", "C:\\");
        System.out.println("Directorio Nuevo");
        System.out.println(System.getProperty("user.dir"));

        //Escribiendo las propiedas en un archivo de texto plano
        FileWriter fw = null;

        File f = null;
        try {
            f = new File("propiedades.txt");
            if (f.exists()) {
                f.delete();
            }
            fw = new FileWriter(f);
            fw.write("S.O: ");
            fw.write(System.getProperty("os.name")+"\n");
            fw.write("Usuario: ");
            fw.write(System.getProperty("user.name")+ "\n");
             fw.write("Directorio: ");
            fw.write(System.getProperty("user.dir"));
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

}
