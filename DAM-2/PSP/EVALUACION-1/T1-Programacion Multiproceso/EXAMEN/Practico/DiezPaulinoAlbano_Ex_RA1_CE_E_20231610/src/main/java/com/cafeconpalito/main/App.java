/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
/*
1. Muestra un mensaje con el nombre del estudiante, el nombre de la aplicación y la fecha actual.
2. Espera 1 segundo.
3. Imprime “Generando fichero con Generator…”.
4. Ejecuta el programa “Generator.jar” y espera a que termine.
5. Imprime los números aleatorios generados en el main de Java obteniendo la salida estándar del 
proceso Generator.jar.
6. Imprime “Ejecutando la copia con el comando copy…”.
7. Para hacer la copia del fichero no lo haremos nosotros con código,sino que, utilizaremos un comando 
de Windows que ya hace la copia por nosotros. Por tanto, se ejecutará el siguiente comando de 
Windows de la terminal que hace la copia de un fichero (primer parámetro) en otro fichero cuyo 
nombre se establece en el segundo parámetro:

8. Espera a que el programa termine y se obtiene el valor/código de salida del proceso. 
a. En el caso de que el proceso haya terminado correctamente, se imprimirá: 
i. “Copia realizada con éxito”
ii. Imprime: “Procediendo a abrir el fichero copiado…”
iii. Espera 2 segundos.
iv. Se crea el proceso que abre el Notepad de Windows pasándole el fichero de copia 
como argumento para abrirlo: 
1. Windows: notepad.exe /ruta/nombreFicheroCopia.txt
b. En el caso de que el proceso haya terminado con error, se imprimirá: 
i. “Error en la copia”.
 */
public class App {

    public static void main(String[] args) {

        try {
            //Nombre Alumno
            System.out.println(BannerWorld.getBanner1());

            Thread.sleep(1000);

            //Generar fichero banner
            System.out.println(BannerWorld.getBanner2());

            //Lanzar generator
            ProccesCreator pc = new ProccesCreator(args[0], args[1]);
            pc.crearMetodo(true);

            try (InputStream is = pc.getP().getInputStream(); BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

                String linea;
                //Inicio de lectura linea a linea
                linea = br.readLine();

                System.out.println("Los numeros aleatorios son: ");
                while (linea != null) {
                    //mostrando las lineas por consola
                    System.out.println(linea);
                    linea = br.readLine();
                }

            } catch (IOException e) {
                System.err.println("IOException");
            }
            //Imprime “Ejecutando la copia con el comando copy…”
            System.out.println(BannerWorld.getBanner3());
         
            
            ProccesCreator pc2 = new ProccesCreator(args[1],args[2]);
            
            pc2.copy();
            
            if (pc2.valorSalida()==0) {
                //Copia realizada con éxito
                System.out.println(BannerWorld.getBanner4());
                System.out.println(BannerWorld.getBanner5());
                
                Thread.sleep(2000);
                
                 ProccesCreator pc3 = new ProccesCreator(args[2]);
                 
                 pc3.crearMetodo( false);
            }else{
                 System.out.println(BannerWorld.getBanner6());
            }
            
           
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
