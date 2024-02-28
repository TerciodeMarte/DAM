package com.cafeconpalito.main.simetrico;

import com.cafeconpalito.main.asimetrico.KeyPairManagerRSA;
import com.cafeconpalito.main.config.LogConfig;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Cifrado y descifrado de ficheros utilizando el algoritmo de criptografía
 * simétrica AES.
 *
 * @author Albano Díez de Paulino
 */
public class AESEncryption {

    private static Scanner scstring = new Scanner(System.in);

    /**
     * Metodo para encriptar en AES
     * @param pathkey 
     */
    public static void encryption(String pathkey) {
        if (SecretKeyManagerAES.loadKey(pathkey)) {
            System.out.println("File path to encrypt: ");
            String path = scstring.nextLine();

            try (InputStream in = Files.newInputStream(new File(path).toPath()); 
                OutputStream out = Files.newOutputStream(Path.of(new File(path).getName().split("\\.")[0] + ".encrypted"))) {

                //Objeto para encriptar
                Cipher c = Cipher.getInstance("AES");
                c.init(Cipher.ENCRYPT_MODE, SecretKeyManagerAES.getKey());

                byte[] buffer = new byte[25];
                int len;
                //Bucle para leer los bytes del buffer mediante el metodo update
                while ((len = in.read(buffer)) != -1) {
                    byte[] encrypted = c.update(buffer, 0, len);
                    out.write(encrypted);
                }
                byte[] finalBlock = c.doFinal(); //Lectura del último bloque
                out.write(finalBlock);
                LogConfig.LOG_ALL.log(Level.INFO, "A file has been encrypted with AES");

                System.out.println("Encrypted");

            } catch (IOException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException ex) {
                LogConfig.LOG_ERROR.log(Level.WARNING, "Error when encrypting a file with AES");
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

    }

    /**
     * Metodo para desencriptar en AES
     * @param pathkey 
     */
    public static void decryption(String pathkey) {
        if (SecretKeyManagerAES.loadKey(pathkey)) {
            System.out.println("File path to decrypt: ");
            String path = scstring.nextLine();
            System.out.println("Extension of the new file");
            String ext = scstring.nextLine();

            try (InputStream in = Files.newInputStream(new File(path).toPath()); 
                OutputStream out = Files.newOutputStream(Path.of(new File(path).getName().split("\\.")[0] + ext))) {

                //Objeto para desencriptar
                Cipher c = Cipher.getInstance("AES");
                c.init(Cipher.DECRYPT_MODE, SecretKeyManagerAES.getKey());

                byte[] buffer = new byte[25];
                int len;
                //Bucle para leer los bytes del buffer mediante el metodo update
                while ((len = in.read(buffer)) != -1) {
                    byte[] encrypted = c.update(buffer, 0, len);
                    out.write(encrypted);
                }
                byte[] finalBlock = c.doFinal(); //Lectura del último bloque
                out.write(finalBlock);
                LogConfig.LOG_ALL.log(Level.INFO, "A file has been Decrypted with AES");

                System.out.println("Decrypted");

            } catch (IOException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException ex) {
                LogConfig.LOG_ERROR.log(Level.WARNING, "Error when encrypting a file with AES");
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

    }

}
