package com.cafeconpalito.main.cifrado;

import com.cafeconpalito.main.config.LogConfig;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 * Calcular la función resumen (hash) de un fichero. Calcular la función resumen
 * de una cadena de texto.
 *
 * @author Albano Díez de Paulino
 */
public class HashTool {

    private static MessageDigest mensajedigest;

    /**
     * Obtener una lista de todos los algoritmos disponibles
     *
     * @return lista con todos los algoritmos
     */
    public static ArrayList<String> getAlgorithms() {
        ArrayList<String> list = new ArrayList<>();
        for (Provider e : Security.getProviders()) {
            for (Provider.Service s : e.getServices()) {
                if (s.getType().contains("MessageDigest")) {
                    list.add(s.getAlgorithm());
                }
            }
        }

        LogConfig.LOG_ALL.log(Level.INFO,"The algorithm list for hashing has been obtained");
        return list;
    }

    /**
     * Obtener hash de un texto plano
     *
     * @param algorithm
     * @param plaintext
     * @return hash
     */
    public static String getStringHash(String algorithm, String plaintext) {
        try {
            if (plaintext.length() != 0 && getAlgorithms().contains(algorithm)) {
                mensajedigest = MessageDigest.getInstance(algorithm);
                byte datos[] = plaintext.getBytes();
                mensajedigest.update(datos);
                byte hash[] = mensajedigest.digest();
                LogConfig.LOG_ALL.log(Level.INFO,"The hash of a plain text has been obtained");
                return enHexadecimal(hash);
            } else {
                System.out.println("Second or third parameter not valid");
                LogConfig.LOG_ERROR.log(Level.WARNING, "Error when generating a hash of a plain text");
                return null;
            }

        } catch (NoSuchAlgorithmException ex) {
            LogConfig.LOG_ERROR.log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Obtener hash de un fichero
     *
     * @param algorithm
     * @param f
     * @return hash
     */
    public static String getFilehash(String algorithm, File f) {
        String textHexa = null;
        BufferedInputStream bis = null;

        try {

            if (f.exists() && getAlgorithms().contains(algorithm)) {
                MessageDigest mensajedigest;
                mensajedigest = MessageDigest.getInstance(algorithm);

                //Creo el Bufer para leer el File
                bis = new BufferedInputStream(new FileInputStream(f));

                //Creo una Buffer para leer el archivo con un tamaño de 1024 bytes            
                byte[] bufferSalida = new byte[1024];

                //Leo el archivo a enviar y almaceno el valor de Bytes leidos
                int numBytesLeidos = 0;
                numBytesLeidos = bis.read(bufferSalida);

                //Mientras el numero de Bytes sea distito de -1 continua la lectura.
                while (numBytesLeidos != -1) {
                    mensajedigest.update(bufferSalida);
                    //Leo el archivo y lo almaceno en el buffer
                    numBytesLeidos = bis.read(bufferSalida);
                }
                byte resumen[] = mensajedigest.digest();

                textHexa = enHexadecimal(resumen);
                LogConfig.LOG_ALL.log(Level.INFO,"The hash of a file has been obtained");
                return textHexa;

            } else {
                System.out.println("Second or third parameter not valid");
                LogConfig.LOG_ERROR.log(Level.WARNING, "Error when generating a hash of a file");
                return null;
            }

        } catch (NoSuchAlgorithmException ex) {
            LogConfig.LOG_ERROR.log(Level.SEVERE, null, ex);
            return null;

        } catch (FileNotFoundException ex) {
            LogConfig.LOG_ERROR.log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            LogConfig.LOG_ERROR.log(Level.SEVERE, null, ex);
            return null;
        } finally {
            //Cierro las conexiones
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException ex) {
               LogConfig.LOG_ERROR.log(Level.SEVERE, null, ex);
               return null;
            }
        }

    }

    public static String enHexadecimal(byte[] inf) {
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
