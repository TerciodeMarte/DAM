/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.hoja1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Estaticos {

    /*
1. Utilizando la clase Runtime, realiza un programa que lance un proceso hijo que ejecute el
notepad de Windows pasándole como argumento un fichero de texto para que lo abra (crea un 
fichero de ejemplo en la raíz del proyecto para probarlo). Los argumentos se pasan a través de 
la línea de comandos (String[] args).
     */
    public static void ej1(String argumento) {
        try {
            Runtime rt = Runtime.getRuntime();
            String[] comando = {"notepad.exe", argumento};
            Process p = rt.exec(comando);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    2. En este ejercicio el estudiante ha de crear un programa en java que:
• Dependiendo del sistema operativo:
o Abre la calculadora de Windows.
o Abre el navegador Firefox en Ubuntu Linux.
• Usa ProcessHandle para obtener:
1. El nombre del comando 
2. Los argumentos usados 
3. Tiempo de comienzo. 
4. Tiempo de CPU. 
5. Propietario. 
6. Número de hijos. 
     */
    public static void ej2() {
        String operatingSystem = System.getProperty("os.name").toLowerCase();
        if (operatingSystem.contains("win")) {
            try {
                Runtime rt = Runtime.getRuntime();
                String[] comando = {"notepad.exe", "fichero.txt"};
                Process p = rt.exec(comando);

                //¿Porque que hay que usar un manejador de procesos?
                ProcessHandle handle = p.toHandle();

                //Tambien se puede capturar el proceso asi
                //ProcessHandle handle=ProcessHandle.current()
                System.out.println("ID del proceso: " + handle.pid());
                //Si hemos cojido al hijo porque el nombre del comando es C:\Program Files\Java\jdk-20\bin\java.exe?
                System.out.println("Nombre del comando: " + handle.info().command().get());
                //Porque si le paso argumentos, no hay argumentos en esta lista
                System.out.println("Argumentos usados: " + Arrays.toString(handle.info().arguments().orElse(new String[0])));
                System.out.println("Tiempo de comienzo: " + handle.info().startInstant().get());
                System.out.println("Tiempo de CPU: " + handle.info().totalCpuDuration().get());
                System.out.println("Propietario: " + handle.info().user().get());

                //Para obtener el padre
                //System.out.println("Padre"+ handle.parent().get().info().command().get());
                //Numero de hijos 0? Porque la calculadora no es hijo de java
                //Porque estamos cogiendo la info del proceso de la calculadora no de java
                //Ahora magicamente tiene 2 hijos despues de 10 min de probar
                System.out.println("Número de hijos: " + handle.descendants().count());
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (operatingSystem.contains("nux")) {
            try {
                Runtime rt = Runtime.getRuntime();
                String[] comando = {"firefox"};
                Process p = rt.exec(comando);

                ProcessHandle handle = p.toHandle();

                System.out.println("ID del proceso: " + handle.pid());

                System.out.println("Nombre del comando: " + handle.info().command().get());
                System.out.println("Argumentos usados: " + Arrays.toString(handle.info().arguments().orElse(new String[0])));
                System.out.println("Tiempo de comienzo: " + handle.info().startInstant().get());
                System.out.println("Tiempo de CPU: " + handle.info().totalCpuDuration().get());
                System.out.println("Propietario: " + handle.info().user().get());

                System.out.println("Número de hijos: " + handle.descendants().count());

            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /*3. Modifica el programa del ejercicio 1 que lanzaba el Notepad de Windows. Ahora, el padre, 
mientras el hijo se está́ejecutando, debe realizar una tarea sencilla que consiste en generar 10 
números aleatorios entre el 0 y el 9. ¿qué ocurre y por qué?*/
    public static void ej3() {
        try {
            //Realiza los dos procesos en simultaneo porque son dos procesos independientes y mi ordenador tiene mas de un core
            //Porque al abortar el proceso padre mata a todos sus hijos, son son idependientes?
            Runtime rt = Runtime.getRuntime();
            String[] comando = {"notepad.exe"};
            Process p = rt.exec(comando);
            for (int i = 0; i < 10; i++) {
                System.out.println(Math.random() * 9);
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*4. Utilizando la clase ProcessBuilder, se debe crear un programa en Java que: 
1. Pregunte una app con interfaz gráfica en el Sistema Operativo actual. 
2. Abra la app. 
3. Obtener la información del entorno del proceso.*/
    //TODO
    public static void ej4() {

    }

    /*5. Utilizando la clase ProcessBuilder ejecuta el comando “CMD /c ver” y redirige la salida 
estándar a un fichero llamado “salida.txt” y la salida de error a un fichero llamado “error.txt”. 
Para ello, utiliza los métodos redirectOutput y redirectError de ProcessBuilder. Ejecuta después 
un comando que no exista como por ejemplo “CMD /c verr”*/
    public static void ej5() {
        ProcessBuilder processBuilder = new ProcessBuilder("CMD", "/c", "ver");

        processBuilder.redirectOutput(new File("salidaok.txt"));
        processBuilder.redirectError(new File("errorok.txt"));
        try {
            Process process = processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        processBuilder = new ProcessBuilder("CMD", "/c", "verr");
        processBuilder.redirectOutput(new File("salidamal.txt"));
        processBuilder.redirectError(new File("errormal.txt"));
        try {
            Process process = processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*6. Crea un programa en Java que imprima ¿qué pasa?, 10 veces esperando un segundo cada 
vez.*/
    public static void ej6() {
        for (int i = 0; i < 10; i++) {
            System.out.println("¿qué pasa?");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Estaticos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /*7. Crea un programa igual el ejercicio 3, pero justo después de crear el proceso hijo el padre 
espera a que termine antes de generar los números aleatorios. ¿Qué ocurre? Por último, obtén
el valor de salida. */
    //Ocurre que hasta que no matas(cerrar notepad) el proceso hijo, java no continua
    public static void ej7() {
        try {
            Runtime rt = Runtime.getRuntime();
            String[] comando = {"notepad.exe"};
            Process p = rt.exec(comando);
            int salida = p.waitFor();
            for (int i = 0; i < 10; i++) {
                System.out.println(Math.random() * 9);
            }
            System.out.println("VALOR DE SALIDA");
            //System.out.println(p.exitValue());
            System.out.println(salida);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Estaticos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*8. En este ejercicio el estudiante debe crear un programa que:
• Abra una aplicación introducida por argumento (String[] args), por ejemplo “Notepad”
en Windows o “gedit” en Linux.
• 10 segundos después se cerrará el proceso (con código no a mano)
• Después de que la app se cierre, el programa espera 5 segundo y se imprimirá “Buenas 
noches amigo!”*/
    public static void ej8(String parametro) {
        String operatingSystem = System.getProperty("os.name").toLowerCase();
        if (operatingSystem.contains("win")) {
            try {
                Runtime rt = Runtime.getRuntime();
                Process p = rt.exec(parametro);
                if (!p.waitFor(1, TimeUnit.SECONDS)) {
                    //No mata nada
                    p.destroy();
                }
                Thread.sleep(5000);
                System.out.println("Buenas noches amigo!");

            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Estaticos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (operatingSystem.contains("nux")) {
            try {
                Runtime rt = Runtime.getRuntime();
                Process p = rt.exec(parametro);
                if (!p.waitFor(10, TimeUnit.SECONDS)) {
                    p.destroy();
                }
                Thread.sleep(5000);
                System.out.println("Buenas noches amigo!");

            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Estaticos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /*10. Obtener la salida estándar de un .jar.
Crea dos programas en Java:
- El primero imprime por su salida estándar 10 números aleatorios. A continuación, genera un 
.jar del programa.
- El segundo tiene que ejecutar el .jar del primer programa y leer su salida estándar para 
calcular la suma de los 10 números aleatorios.*/
    public static void ej101() {
        for (int i = 0; i < 10; i++) {
            System.out.println((int) (Math.random() * 9));
        }
    }

    public static void ej102() {

        try {
            int suma = 0;
            ProcessBuilder pb = new ProcessBuilder("CMD", "/c", "java -jar ej10.jar");

            Process p = pb.start();

            String linea = null;

            try (InputStream is = p.getInputStream(); BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

                //Inicio de lectura linea a linea
                linea = br.readLine();

                System.out.println("LOS 10 NUMEROS ALEATORIOS SON: ");
                while (linea != null) {
                    //mostrando las lineas por consola
                    System.out.println(linea);
                    suma += Integer.parseInt(linea);
                    linea = br.readLine();
                }
                System.out.println("LA SUMA ES:");
                System.out.println(suma);

            } catch (IOException e) {
                System.err.println("IOException");
            }

        } catch (IOException ex) {
            Logger.getLogger(Estaticos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Crea dos programas en Java:
- El primero lee dos cadenas de texto desde la entrada estándar. Para hacerlo utiliza la 
clase BufferedReader y su método readLine(). Para redirigir la entrada estándar 
(System.in) a BufferedReader hay que hacer el código siguiente:
Pídelas al usuario con los mensajes: “Introduce la primera cadena” e “introduce la 
segunda cadena”.
Cada cadena leída la tienes que imprimir por pantalla (salida estándar).
Por último, crea un .jar de la aplicación.
- El segundo programa debe lanzar un proceso con el .jar anterior y debe pasarle por su 
entrada estándar las dos cadenas para que las lea. A continuación, comprobar que 
funciona deberás obtener la salida estándar del proceso para imprimirla por pantalla.*/
    public static void ej111() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Introduce la primera cadena");
            System.out.println(br.readLine());
            System.out.println("Introduce la segunda cadena");
            System.out.println(br.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Estaticos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void ej112() {
        try {

            ProcessBuilder pb = new ProcessBuilder("CMD", "/c", "java -jar ej11.jar");

            Process p = pb.start();

            String linea = null;

            try (InputStream is = p.getInputStream(); BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

               
                //Inicio de lectura linea a linea
                linea = br.readLine();
                 
                while (linea != null) {
                    //mostrando las lineas por consola
                    System.out.println(linea);
           
                    linea = br.readLine();
                }

            } catch (IOException e) {
                System.err.println("IOException");
            }

        } catch (IOException ex) {
            Logger.getLogger(Estaticos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
