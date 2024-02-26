package com.cafeconpalito.main.asimetrico;

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
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Cifrado y descifrado de ficheros utilizando el algoritmo de criptografía
 * asimétrica RSA.
 *
 * @author Albano Díez de Paulino
 */
public class RSAEncryption {

    private static Scanner scstring = new Scanner(System.in);

    /**
     * Metodo para cifrar un fichero con extensión .txt
     * @param pathPublicKey
     * @param pathPrivateKey 
     */
    public static void encryption(String pathPublicKey, String pathPrivateKey) {
        if (KeyPairManagerRSA.loadKeyPair(pathPublicKey, pathPrivateKey)) {
            System.out.println("What do you want to encrypt the file with?(Public|Private)");
            String lectura = scstring.nextLine();

            if (lectura.equalsIgnoreCase("Public")) {
                try {
                    System.out.println("File path to encrypt(Only .txt): ");
                    String path = scstring.nextLine();

                    //Objeto para encriptar
                    Cipher c = Cipher.getInstance("RSA");
                    c.init(Cipher.ENCRYPT_MODE, KeyPairManagerRSA.getPublicKey());

                    try (InputStream in = Files.newInputStream(new File(path).toPath()); OutputStream out = Files.newOutputStream(Path.of(new File(path).getName().split("\\.")[0] + ".encrypted"))) {

                        byte[] buffer = new byte[25];
                        int len;
                        //Bucle para leer los bytes del buffer mediante el metodo update
                        while ((len = in.read(buffer)) != -1) {
                            byte[] encrypted = c.update(buffer, 0, len);
                            out.write(encrypted);
                        }
                        byte[] finalBlock = c.doFinal(); //Lectura del último bloque
                        out.write(finalBlock);
                        LogConfig.LOG_ALL.log(Level.INFO, "A file has been encrypted with RSA");

                        System.out.println("Encrypted");
                    }

                } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
                    LogConfig.LOG_ERROR.log(Level.WARNING, "Error when encrypting a file with RSA");
                    System.out.println("ERROR: "+ex.getMessage());
                }
            } else if (lectura.equalsIgnoreCase("Private")) {
                try {
                    System.out.println("File path to encrypt(Only .txt): ");
                    String path = scstring.nextLine();

                    //Objeto para encriptar
                    Cipher c = Cipher.getInstance("RSA");
                    c.init(Cipher.ENCRYPT_MODE, KeyPairManagerRSA.getPrivateKey());

                    try (InputStream in = Files.newInputStream(new File(path).toPath()); OutputStream out = Files.newOutputStream(Path.of(new File(path).getName().split("\\.")[0] + ".encrypted"))) {

                        byte[] buffer = new byte[1024];
                        int len;
                        //Bucle para leer los bytes del buffer mediante el metodo update
                        while ((len = in.read(buffer)) != -1) {
                            byte[] encrypted = c.update(buffer, 0, len);
                            out.write(encrypted);
                        }
                        byte[] finalBlock = c.doFinal(); //Lectura del último bloque
                        out.write(finalBlock);
                        LogConfig.LOG_ALL.log(Level.INFO, "A file has been encrypted with RSA");

                        System.out.println("Encrypted");
                    }

                } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
                    LogConfig.LOG_ERROR.log(Level.WARNING, "Error when encrypting a file with RSA");
                    System.out.println("ERROR: "+ex.getMessage());
                }
            } else {
                System.out.println("Choose a valid option next time");
                LogConfig.LOG_ERROR.log(Level.WARNING, "Choose a valid option next time <encryptionRSA>");
            }
        }

    }

    /**
     * Metodo para descifrar un fichero .encrypted
     * @param pathPublicKey
     * @param pathPrivateKey 
     */
    public static void decryption(String pathPublicKey, String pathPrivateKey) {
        if (KeyPairManagerRSA.loadKeyPair(pathPublicKey, pathPrivateKey)) {
            System.out.println("What do you want to decrypt the file with?(Public|Private)");
            String lectura = scstring.nextLine();

            if (lectura.equalsIgnoreCase("Public")) {
                try {
                    System.out.println("File path to decrypt(Only .encrypted): ");
                    String path = scstring.nextLine();

                    //Objeto para encriptar
                    Cipher c = Cipher.getInstance("RSA");
                    c.init(Cipher.DECRYPT_MODE, KeyPairManagerRSA.getPublicKey());

                    try (InputStream in = Files.newInputStream(new File(path).toPath()); 
                        OutputStream out = Files.newOutputStream(Path.of(new File(path).getName().split("\\.")[0] + ".txt"))) {

                        byte[] buffer = new byte[1024];
                        int len;
                        //Bucle para leer los bytes del buffer mediante el metodo update
                        while ((len = in.read(buffer)) != -1) {
                            byte[] encrypted = c.update(buffer, 0, len);
                            out.write(encrypted);
                        }
                        byte[] finalBlock = c.doFinal(); //Lectura del último bloque
                        out.write(finalBlock);
                        LogConfig.LOG_ALL.log(Level.INFO, "A file has been decrypted with RSA");

                        System.out.println("Decrypted");
                    }

                } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
                    LogConfig.LOG_ERROR.log(Level.WARNING, "Error when decrypting a file with RSA");
                    System.out.println("ERROR: "+ex.getMessage());
                }
            } else if (lectura.equalsIgnoreCase("Private")) {
                try {
                    System.out.println("File path to decrypt(Only .encrypted): ");
                    String path = scstring.nextLine();

                    //Objeto para encriptar
                    Cipher c = Cipher.getInstance("RSA");
                    c.init(Cipher.DECRYPT_MODE, KeyPairManagerRSA.getPrivateKey());

                    try (InputStream in = Files.newInputStream(new File(path).toPath()); 
                        OutputStream out = Files.newOutputStream(Path.of(new File(path).getName().split("\\.")[0] + ".txt"))) {

                        byte[] buffer = new byte[1024];
                        int len;
                        //Bucle para leer los bytes del buffer mediante el metodo update
                        while ((len = in.read(buffer)) != -1) {
                            byte[] encrypted = c.update(buffer, 0, len);
                            out.write(encrypted);
                        }
                        byte[] finalBlock = c.doFinal(); //Lectura del último bloque
                        out.write(finalBlock);
                        LogConfig.LOG_ALL.log(Level.INFO, "A file has been Decrypted with RSA");

                        System.out.println("Decrypted");
                    }

                } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
                    LogConfig.LOG_ERROR.log(Level.WARNING, "Error when decrypting a file with RSA");
                    System.out.println("ERROR: "+ex.getMessage());
                }
            } else {
                System.out.println("Choose a valid option next time");
                LogConfig.LOG_ERROR.log(Level.WARNING, "Choose a valid option next time <decryptionRSA>");
            }
        }

    }
}
