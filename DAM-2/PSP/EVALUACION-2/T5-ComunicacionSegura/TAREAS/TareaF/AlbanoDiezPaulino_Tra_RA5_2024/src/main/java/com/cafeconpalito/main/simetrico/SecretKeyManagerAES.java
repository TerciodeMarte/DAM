package com.cafeconpalito.main.simetrico;

import com.cafeconpalito.main.cifrado.HashTool;
import com.cafeconpalito.main.config.LogConfig;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Se generará la clave secreta AES a partir de una contraseña introducida por
 * el usuario convertida en un array de bytes. Para hacerlo, mirar la clase
 * SecretKeySpec.
 *
 * @author Albano Díez de Paulino
 */
public class SecretKeyManagerAES {

    private static SecretKey key;

    private static Scanner scstring = new Scanner(System.in);

    public static SecretKey getKey() {
        return key;
    }

    /**
     * Metodo para generar una clave AES
     *
     * @param pwd
     */
    public static void generateKey(String pwd) {

        if (PasswordValidator.validate(pwd)) {
            try {
                
                SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
                secureRandom.setSeed(pwd.getBytes());
                KeyGenerator keyGen = KeyGenerator.getInstance("AES");
                keyGen.init(256, secureRandom);
                key = keyGen.generateKey();
                
                System.out.println("KEY");
                System.out.println(HashTool.enHexadecimal(key.getEncoded()));
                
                System.out.println("You want to save?(Y/N)");
                
                if (scstring.nextLine().equalsIgnoreCase("Y")) {
                    System.out.println("File names:");
                    saveKey(scstring.nextLine());
                    System.out.println("Saved");
                }
                LogConfig.LOG_ALL.log(Level.INFO, "one AES key has been generated");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(SecretKeyManagerAES.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("The password does not meet the security requirements.");
            LogConfig.LOG_ERROR.log(Level.WARNING, "Second or third parameter missing <-rsaencryption>");
        }

    }

    /**
     * Metodo para guardar una clave AES
     *
     * @param nameFile nombre para ficheros generados
     */
    private static void saveKey(String nameFile) {
        try (FileOutputStream fos = new FileOutputStream(nameFile + "_aes.agl"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(key);
            LogConfig.LOG_ALL.log(Level.INFO, "one AES key has been saved");

        } catch (FileNotFoundException ex) {
            LogConfig.LOG_ERROR.log(Level.WARNING, "an error occurred while saving the key aes");
        } catch (IOException ex) {
            LogConfig.LOG_ERROR.log(Level.WARNING, "an error occurred while saving the key aes");
        }

    }

    /**
     * Metodo para cargar desde un fichero la clave
     * @param pathkey
     * @return boolean True si ha conseguido hacerlo correctamente
     */
    public static boolean loadKey(String pathkey) {
        try (FileInputStream fis = new FileInputStream(pathkey); ObjectInputStream ois = new ObjectInputStream(fis)) {
            // Leer el objeto SecretKeySpec del archivo
            key = (SecretKey) ois.readObject();
            LogConfig.LOG_ALL.log(Level.INFO, "one AES key has been load");
            return true;
        } catch (Exception e) {
            LogConfig.LOG_ERROR.log(Level.WARNING, "Second parameter have a error <-aese>");
            System.out.println("Second parameter have a error <-aese> " + e.getMessage());
            return false;

        }
    }

}
