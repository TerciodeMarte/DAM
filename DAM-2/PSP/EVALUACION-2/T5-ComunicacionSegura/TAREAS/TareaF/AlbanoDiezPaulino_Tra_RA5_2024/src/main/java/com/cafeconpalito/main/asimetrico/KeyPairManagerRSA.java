package com.cafeconpalito.main.asimetrico;

import com.cafeconpalito.main.cifrado.HashTool;
import com.cafeconpalito.main.config.LogConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Scanner;
import java.util.logging.Level;

/**
 * Creación de pares de claves utilizando el algoritmo RSA. Gestión de paresBde
 * claves RSA. Salvar una clave pública o privada en un fichero. Cargar una
 * clave pública o privada de un fichero.
 *
 * @author Albano Díez de Paulino
 */
public class KeyPairManagerRSA {

    private static PrivateKey privateKey;
    private static PublicKey publicKey;

    public static PrivateKey getPrivateKey() {
        return privateKey;
    }

    public static PublicKey getPublicKey() {
        return publicKey;
    }

    private static Scanner scstring = new Scanner(System.in);

    /**
     * Metodo para generar claves RSA
     *
     * @param seed semilla para generar las claves
     */
    public static void generateKeyPair(String seed) {

        try {

            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");

            SecureRandom secure = SecureRandom.getInstance("SHA1PRNG");
            secure.setSeed(seed.getBytes());
            keyGen.initialize(2048, secure);
            KeyPair clavesRSA = keyGen.generateKeyPair();

            privateKey = clavesRSA.getPrivate();
            publicKey = clavesRSA.getPublic();

            System.out.println("PRIVATE KEY");
            System.out.println(HashTool.enHexadecimal(privateKey.getEncoded()));
            System.out.println("----------------");
            System.out.println("PUBLIC KEY");
            System.out.println(HashTool.enHexadecimal(publicKey.getEncoded()));

            System.out.println("You want to save?(Y/N)");

            if (scstring.nextLine().equalsIgnoreCase("Y")) {
                System.out.println("File names:");
                seed = scstring.nextLine();
                saveKeyPair(seed);
                System.out.println("Saved");
            }

            LogConfig.LOG_ALL.log(Level.INFO, "one RSA key pair has been generated");

        } catch (NoSuchAlgorithmException ex) {
            System.out.println("ERROR: "+ex.getMessage());
            LogConfig.LOG_ERROR.log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Metodo para guardar el par de claves RSA
     * @param nameFile nombre para ficheros generados
     */
    private static void saveKeyPair(String nameFile) {
        try (FileOutputStream fos = new FileOutputStream(nameFile + "_public_rsa.agl"); FileOutputStream fos2 = new FileOutputStream(nameFile + "_private_rsa.agl")) {
            fos.write(publicKey.getEncoded());
            fos2.write(privateKey.getEncoded());
            
            LogConfig.LOG_ALL.log(Level.INFO, "one RSA key pair has been saved");
       
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: "+ex.getMessage());
            LogConfig.LOG_ERROR.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("ERROR: "+ex.getMessage());
            LogConfig.LOG_ERROR.log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Metodo para cargar un par de claves RSA
     * Bibliografia https://ryctabo.wordpress.com/2018/02/25/load-pair-keys-from-java/
     * @param pathPublicKey
     * @param pathPrivateKey 
     * 
     */
    public static boolean loadKeyPair(String pathPublicKey, String pathPrivateKey) {
        try {
            //CLAVE PUBLICA
            File publicKeyFile = new File(pathPublicKey);
            if (publicKeyFile.exists()) {
                byte[] publicKeyBytes = Files.readAllBytes(publicKeyFile.toPath());

                // Crear una instancia de X509EncodedKeySpec utilizando el array de bytes
                X509EncodedKeySpec keySpecPublic = new X509EncodedKeySpec(publicKeyBytes);

                // Obtener una instancia de KeyFactory para el algoritmo de clave deseado (por ejemplo, RSA)
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");

                // Generar la PublicKey utilizando la especificación de clave
                publicKey = keyFactory.generatePublic(keySpecPublic);

                //CLAVE PRIVADA
                File privateKeyFile = new File(pathPrivateKey);

                if (privateKeyFile.exists()) {
                    byte[] privateKeyBytes = Files.readAllBytes(privateKeyFile.toPath());

                    // Crear una instancia de PKCS8EncodedKeySpec utilizando el array de bytes
                    PKCS8EncodedKeySpec keySpecPrivate = new PKCS8EncodedKeySpec(privateKeyBytes);

                    // Generar la PrivateKey utilizando la especificación de clave
                    privateKey = keyFactory.generatePrivate(keySpecPrivate);

                } else {
                    System.out.println("Third parameter not valid");
                    LogConfig.LOG_ERROR.log(Level.WARNING, "Error when loading rsa private key");
                    return false;
                }
            } else {
                System.out.println("Second parameter not valid");
                LogConfig.LOG_ERROR.log(Level.WARNING, "Error when loading rsa public key");
                return false;

            }
            
            LogConfig.LOG_ALL.log(Level.INFO, "one RSA key pair has been loaded");
            return true;


        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.out.println("ERROR: "+ex.getMessage());
            LogConfig.LOG_ERROR.log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
