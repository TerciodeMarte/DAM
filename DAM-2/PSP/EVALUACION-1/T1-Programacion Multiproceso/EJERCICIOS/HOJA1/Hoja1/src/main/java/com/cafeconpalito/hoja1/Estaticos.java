/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.hoja1;

import java.io.IOException;
import java.util.Arrays;
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
                String[] comando = {"calc.exe"};
                Process p = rt.exec(comando);
                ProcessHandle handle = ProcessHandle.current();
                ProcessHandle.Info processInfo = handle.info();

                System.out.println("ID del proceso: " + handle.pid());
                System.out.println("Nombre del comando: " + handle.info().command().orElse("Desconocido"));
                System.out.println("Argumentos usados: " + Arrays.toString(handle.info().arguments().orElse(new String[0])));
                System.out.println("Tiempo de comienzo: " + handle.info().startInstant());
                System.out.println("Tiempo de CPU: " + handle.info().totalCpuDuration().orElse(null));
                System.out.println("Propietario: " + handle.info().user().orElse("Desconocido"));
                System.out.println("Número de hijos: " + p.descendants().count());
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (operatingSystem.contains("nux")) {
            try {
                Runtime rt = Runtime.getRuntime();
                String[] comando = {"firefox"};
                Process p = rt.exec(comando);

            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
