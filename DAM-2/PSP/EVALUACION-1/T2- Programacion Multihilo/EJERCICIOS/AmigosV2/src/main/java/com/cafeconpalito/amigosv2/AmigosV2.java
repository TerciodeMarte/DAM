package com.cafeconpalito.amigosv2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author TerciodeMarte
 */
public class AmigosV2 {

    public static void main(String[] args) {
        HashMap<Integer, Integer> p = new HashMap();
        TreeMap<Integer, Integer> mapaB = new TreeMap();

        Hilos[] array = new Hilos[20];
        int tramo = 20000000 / 20;
        int aux = 0;
        int aux2 = tramo;
        for (int i = 0; i < 20; i++) {

            array[i] = new Hilos(aux, aux2);
            aux += tramo;
            aux2+=tramo;

            array[i].start();
            System.out.println("Hilo:"+ i +" iniciado");
        }

        for (Hilos hilos : array) {
            while (hilos.isAlive()) {
                Thread.currentThread().interrupt();
               
            }
        }

        for (Hilos hilos : array) {
            p.putAll(hilos.getP());
            
        }

        //Buscar amigos
        for (Map.Entry<Integer, Integer> entry : p.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            //System.out.println("key " + key + " valor: " + val);

            int val2;

            if (p.containsKey(val)) {
                val2 = (Integer) p.get(val);
                if (p.containsKey(val2)) {
                    if (val2 == (Integer) key && !mapaB.containsValue(val2)) {
                        mapaB.put((Integer) key, (Integer) val);
                    }
                }
            }
        }

        //Escribir Fichero
        FileWriter fw = null;
        try {
            fw = new FileWriter("tablaamigos.txt");
            fw.write("Numero A  || Numero B" + "\n");

            for (Map.Entry<Integer, Integer> entry : mapaB.entrySet()) {
                Object key = entry.getKey();
                Object val = entry.getValue();

                fw.write(key + " || " + val + "\n");
            }

        } catch (IOException e) {
            System.err.println("IOException");
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.err.println("IOException cierre flujo");
            }
        }
    }
}
