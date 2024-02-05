/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.iesaugustogonzalez.jfranco.ejemplo1_hashmaven;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

/**
 *
 * @author jfrancoros
 */
public class Ejemplo1_HashMaven {

    public static void main(String[] args) {
          try {
            MessageDigest mensajedigest;
            mensajedigest = MessageDigest.getInstance("SHA");
            String txt= "Mensaje de texto plano";
            byte datos[] = txt.getBytes(); //paso texto a bytes
            //actualizo los bytes a resumir 
            mensajedigest.update(datos);
            //calculo el resumen con digest y lo meto en array de bytes
            byte resumen[] = mensajedigest.digest();
            //mostramos información por pantalla
            System.out.println ("Mensaje texto= " + txt);
            System.out.println ("\tNum bytes= " +
                    mensajedigest.getDigestLength());
            System.out.println ("\tAlgoritmo= " + 
                    mensajedigest.getAlgorithm());
            System.out.println ("\tMensaje resumen en bytes = " 
                    + enHexadecimal(resumen));
            //informacion sobre el proveedor
            Provider proveedor = mensajedigest.getProvider();
             System.out.println ("Proveedor= " + proveedor);
        } catch (NoSuchAlgorithmException ex) {
            System.err.println ("Error no encuentra algoritmo. " + ex.toString());
        }
    }
    
    
    
       static String enHexadecimal (byte[] inf){
        String hexadecimal ="";
        for (int i=0; i<inf.length; i++){
            String hx = Integer.toHexString(inf[i] & 0xFF);
            if (hx.length()==1){
                hexadecimal+="0";
            }
             hexadecimal+=hx;
        }
        return hexadecimal.toUpperCase(); //lo devuelvo en mayus
    }
}
