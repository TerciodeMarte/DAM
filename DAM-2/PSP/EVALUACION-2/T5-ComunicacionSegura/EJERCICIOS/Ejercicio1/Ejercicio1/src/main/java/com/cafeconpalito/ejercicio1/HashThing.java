package com.cafeconpalito.ejercicio1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.Buffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class HashThing {

    private static MessageDigest mensajedigest;

    public static String getAlgorithms() {
        return "MD5\n"
                + "SHA-1\n"
                + "SHA-256";
    }

    public String getStringHash(String algorithm, String plaintext) {
        try {
            mensajedigest = MessageDigest.getInstance(algorithm);
            byte datos[] = plaintext.getBytes();
            mensajedigest.update(datos);
            byte hash[] = mensajedigest.digest();
            return enHexadecimal(hash);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(HashThing.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String getFilehash(String algorithm, File f) {
        FileInputStream fis = null;
        BufferedInputStream bis = null;

        try {
            mensajedigest = MessageDigest.getInstance(algorithm);
            fis = new FileInputStream(f);

            bis = new BufferedInputStream(fis);
            byte[] buffer = new byte[1028];
            int bytesRead;

            // Iterar hasta que se alcance el final del fichero
            while ((bytesRead = bis.read(buffer)) != -1) {
             
            }
            
            return null;

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(HashThing.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HashThing.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(HashThing.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    private static String enHexadecimal(byte[] inf) {
        String hexadecimal = "";
        for (int i = 0; i < inf.length; i++) {
            String hx = Integer.toHexString(inf[i] & 0xFF);
            if (hx.length() == 1) {
                hexadecimal += "0";
            }
            hexadecimal += hx;
        }
        return hexadecimal.toUpperCase(); //lo devuelvo en mayus
    }
}
