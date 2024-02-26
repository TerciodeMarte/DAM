package com.cafeconpalito.main.simetrico;

import com.cafeconpalito.main.cifrado.HashTool;
import com.cafeconpalito.main.config.LogConfig;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import javax.crypto.spec.SecretKeySpec;

/**
 * Se generará la clave secreta AES a partir de una contraseña introducida por
 * el usuario convertida en un array de bytes. Para hacerlo, mirar la clase
 * SecretKeySpec.
 *
 * @author Albano Díez de Paulino
 */
public class SecretKeyManagerAES {

    private static SecretKeySpec key;
    
    private static Scanner scstring = new Scanner(System.in);

    /**
     * Metodo para generar una clave AES
     *
     * @param pwd
     */
    public static void generateKey(String pwd) {
        
        if (PasswordValidator.validate(pwd)) {
            key = new SecretKeySpec(pwd.getBytes(), "AES");
            System.out.println("KEY");
            System.out.println(HashTool.enHexadecimal(key.getEncoded()));
            
            System.out.println("You want to save?(Y/N)");

            if (scstring.nextLine().equalsIgnoreCase("Y")) {
                System.out.println("File names:");
                saveKey(scstring.nextLine());
                System.out.println("Saved");
            }
            LogConfig.LOG_ALL.log(Level.INFO, "one AES key has been generated");
        } else {
            System.out.println("The password does not meet the security requirements.");
            LogConfig.LOG_ERROR.log(Level.WARNING, "Second or third parameter missing <-rsaencryption>");
        }

    }
    
    /**
     * Metodo para guardar una clave AES
     * @param nameFile nombre para ficheros generados
     */
    private static void saveKey(String nameFile) {
        try (FileOutputStream fos = new FileOutputStream(nameFile + "_aes.agl")) {
            fos.write(key.getEncoded());
            LogConfig.LOG_ALL.log(Level.INFO, "one AES key has been saved");
       
        } catch (FileNotFoundException ex) {
            LogConfig.LOG_ERROR.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            LogConfig.LOG_ERROR.log(Level.SEVERE, null, ex);
        }

    }
}
