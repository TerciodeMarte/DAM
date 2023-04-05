package ejercicio3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        String lectura=sc.nextLine();
        String cadena="";
        FileWriter fw = null;
        
        HashMap<Character,Integer>hm= new HashMap();
        
        hm.put('A', 11);
        hm.put('B', 12);
        hm.put('C',13 );
        hm.put('D', 14);
        hm.put('E', 15);
        hm.put('F', 21);
        hm.put('G', 22);
        hm.put('H', 23);
        hm.put('I', 24);
        hm.put('J', 24);
        hm.put('K', 25);
        hm.put('L', 31);
        hm.put('M', 32);
        hm.put('N', 33);
        hm.put('O', 34);
        hm.put('P', 35);
        hm.put('Q', 41);
        hm.put('R', 42);
        hm.put('S', 43);
        hm.put('T', 44);
        hm.put('U', 45);
        hm.put('V', 51);
        hm.put('W', 52);
        hm.put('X', 53);
        hm.put('Y', 54);
        hm.put('Z', 55);
        
        lectura=lectura.toUpperCase();
        for (int i = 0; i < lectura.length(); i++) {
            char letra=lectura.charAt(i);
            for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
                if (entry.getKey()==letra) {
                    cadena=cadena+" "+entry.getValue();
                }
                
            }
        }
        cadena=cadena.trim();
        System.out.println(cadena);
        
        try {
            fw = new FileWriter("ficheroej3.txt");
            fw.write(cadena);
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
