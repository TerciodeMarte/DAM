package com.cafeconpalito.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */

/*• Imprime el sistema operativo donde estamos (ver en enlace del ejercicio 2).
• Esperamos 5 segundos.
• Si estamos en Windows, abre ipconfig e imprime su salida por pantalla y en un fichero.
• Si estamos en Linux o Mac OS abrimos ifconfig e imprimimos su salida por pantalla y en un fichero.
• Esperamos tres segundos.
• Imprimimos “Las redes parecen que van bien”.*/
public class Tarea1 {

    public static void main(String[] args) {
        //Llamada al ejercicio 1
        ejercicio1();
        //Llamada al ejercicio 2
        ejercicio2();
        //Llamada al ejercicio 3
        ejercicio3();

    }

    private static void ejercicio1() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            //• Imprime el sistema operativo donde estamos (ver en enlace del ejercicio 2).
            System.out.println("SISTEMA OPERATIVO");
            System.out.println(os);

            //• Esperamos 5 segundos.
            System.out.println("\nEsperando 5 segundos");
            Thread.sleep(5000);

            //• Si estamos en Windows, abre ipconfig e imprime su salida por pantalla y en un fichero.
            //• Si estamos en Linux o Mac OS abrimos ifconfig e imprimimos su salida por pantalla y en un fichero.
            String cmd = null;
            String param = null;
            String command = null;

            if (os.contains("win")) {
                cmd = "CMD";
                param = "/c";
                command = "ipconfig /all";
            } else if (os.contains("nux") || os.contains("mac")) {
                cmd = "/bin/bash";
                param = "-c";
                command = "ifconfig -a";
            }

            ProcessBuilder pb = new ProcessBuilder(cmd, param, command);

            Process p = pb.start();

            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String linea = null;
            linea = br.readLine();

            File archivo = new File("salida.txt");
            FileWriter fw = null;
            //if (archivo.exists()) {
              //  archivo.delete();
           // }
            try {
                fw = new FileWriter(archivo);
                while (linea != null) {
                    System.out.println(linea);
                    fw.write(linea + "\n");
                    linea = br.readLine();
                }

            } catch (IOException e) {
                System.err.println("IOException");
            } finally {
                try {
                    br.close();
                    if (fw != null) {
                        fw.close();
                    }
                } catch (IOException e) {
                    System.err.println("IOException cierre flujo");
                }
            }

            System.out.println("\nEsperando 3 segundos");
            //Esperamos tres segundos.
            Thread.sleep(3000);

            //• Imprimimos “Las redes parecen que van bien
            System.out.println("\nLas redes parecen que van bien");

        } catch (InterruptedException ex) {
            Logger.getLogger(Tarea1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tarea1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void ejercicio2() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            //• Imprime el sistema operativo donde estamos (ver en enlace del ejercicio 2).
            System.out.println("SISTEMA OPERATIVO");
            System.out.println(os);

            //• Esperamos 5 segundos.
            System.out.println("\nEsperando 5 segundos");
            Thread.sleep(5000);

            //• Si estamos en Windows, abre ipconfig e imprime su salida por pantalla y en un fichero.
            //• Si estamos en Linux o Mac OS abrimos ifconfig e imprimimos su salida por pantalla y en un fichero.
            String cmd = null;
            String param = null;
            String command = null;

            if (os.contains("win")) {
                cmd = "CMD";
                param = "/c";
                command = "ipconfig /all";
            } else if (os.contains("nux") || os.contains("mac")) {
                cmd = "/bin/bash";
                param = "-c";
                command = "ifconfig -a";
            }

            ProcessBuilder pb = new ProcessBuilder(cmd, param, command);

            Process p = pb.start();

            String linea = null;

            File archivo = new File("salida2.txt");

            /*if (archivo.exists()) {
                archivo.delete();
            }*/

            try (FileWriter fw = new FileWriter(archivo); InputStream is = p.getInputStream(); BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

                //Inicio de lectura linea a linea
                linea = br.readLine();

                while (linea != null) {
                    //mostrando las lineas por consola
                    System.out.println(linea+ "\n");
                    fw.write(linea);
                    linea = br.readLine();
                }

            } catch (IOException e) {
                System.err.println("IOException");
            }

            //• Esperamos tres segundos.
            System.out.println("\nEsperando 3 segundos");
            Thread.sleep(3000);

            //• Imprimimos “Las redes parecen que van bien"
            System.out.println("\nLas redes parecen que van bien");
        } catch (InterruptedException ex) {
            Logger.getLogger(Tarea1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tarea1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void ejercicio3() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            //• Imprime el sistema operativo donde estamos (ver en enlace del ejercicio 2).
            System.out.println("SISTEMA OPERATIVO");
            System.out.println(os);

            //• Esperamos 5 segundos.
            System.out.println("\nEsperando 5 segundos");
            Thread.sleep(5000);

            //• Si estamos en Windows, abre ipconfig e imprime su salida por pantalla y en un fichero.
            //• Si estamos en Linux o Mac OS abrimos ifconfig e imprimimos su salida por pantalla y en un fichero.
            String cmd = null;
            String param = null;
            String command = null;

            if (os.contains("win")) {
                cmd = "CMD";
                param = "/c";
                command = "ifconfig /all";
            } else if (os.contains("nux") || os.contains("mac")) {
                cmd = "/bin/bash";
                param = "-c";
                command = "ipconfig -a";
            }

            ProcessBuilder pb = new ProcessBuilder(cmd, param, command);

            Process p = pb.start();

            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            InputStream iser = p.getErrorStream();
            InputStreamReader isrer = new InputStreamReader(iser);
            BufferedReader brer = new BufferedReader(isrer);

            String linea = null;
            linea = br.readLine();

            String lineaer = null;
            lineaer = brer.readLine();

            File archivo = new File("salida3.txt");
            FileWriter fw = null;

            File archivoer = new File("error3.txt");
            FileWriter fwer = null;
            
            /*if (archivo.exists()) {
                archivo.delete();
            }
            
            if (archivoer.exists()) {
                archivoer.delete();
            }*/
            
            try {
                fw = new FileWriter(archivo);
                 fwer = new FileWriter(archivoer);
                while (linea != null) {
                    System.out.println(linea);
                    fw.write(linea + "\n");
                    linea = br.readLine();
                }
                while (lineaer != null) {
                    System.out.println(lineaer);
                    fwer.write(lineaer + "\n");
                    lineaer = br.readLine();
                }

            } catch (IOException e) {
                System.err.println("IOException");
            } finally {
                try {
                    br.close();
                    if (fw != null) {
                        fw.close();
                    }
                    brer.close();
                    if (fwer != null) {
                        fwer.close();
                    }
                } catch (IOException e) {
                    System.err.println("IOException cierre flujo");
                }
            }

            System.out.println("\nEsperando 3 segundos");
            //Esperamos tres segundos.
            Thread.sleep(3000);

            //• Imprimimos “Las redes parecen que van bien
            System.out.println("\nLas redes parecen que van bien");

        } catch (InterruptedException ex) {
            Logger.getLogger(Tarea1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tarea1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
