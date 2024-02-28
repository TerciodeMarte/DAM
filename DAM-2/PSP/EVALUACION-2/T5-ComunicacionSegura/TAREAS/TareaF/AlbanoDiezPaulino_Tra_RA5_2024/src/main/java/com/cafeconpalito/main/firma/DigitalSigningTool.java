package com.cafeconpalito.main.firma;

import com.cafeconpalito.main.cifrado.HashTool;
import com.cafeconpalito.main.config.LogConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Firma de ficheros y verificación.
 *
 * @author Albano Díez de Paulino
 */
public class DigitalSigningTool {

    private static PrivateKey privateKey;
    private static PublicKey publicKey;

    private static Scanner scstring = new Scanner(System.in);

    public static PrivateKey getPrivateKey() {
        return privateKey;
    }

    public static PublicKey getPublicKey() {
        return publicKey;
    }

    /**
     * Metodo para comprobar si una firma es correcta
     * @param opathfile
     * @param fpathfile
     * @param publickey 
     */
    public static void verificarFirma(String opathfile, String fpathfile,String publickey ) {
        try {
            loadKeyPair(publickey);
            Signature sign = Signature.getInstance("SHA1withDSA");
            sign.initVerify(publicKey);
            sign.update(Files.readAllBytes(Paths.get(opathfile)));

            if (sign.verify(Files.readAllBytes(Paths.get(fpathfile)))) {
                System.out.println("Correct signature");
            } else {
                System.out.println("Invalid signature");
            }
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException | IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            Logger.getLogger(DigitalSigningTool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para firmar un fichero
     * @param pathfile 
     */
    public static void firmarFichero(String pathfile) {
        try {
            //Genero las claves
            generateKeyPair();

            Signature firma = Signature.getInstance("SHA1withDSA");

            //MD5withRSA, MD5withDSA, SHA1withRSA
            firma.initSign(privateKey);

            System.out.println("Signing File".toUpperCase());
            firma.update(Files.readAllBytes(Paths.get(pathfile)));

            byte[] firmaMensaje = firma.sign(); //Obtengo la firma digital

            System.out.println("Message signed in Hexadecimal".toUpperCase());

            System.out.println(HashTool.enHexadecimal(firmaMensaje));

            System.out.println("You want to save?(Y/N)");

            if (scstring.nextLine().equalsIgnoreCase("Y")) {
                System.out.println("File name:");
                String name = scstring.nextLine();
                saveFileSigned(name, firmaMensaje);
                System.out.println("Saved");
            }

        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException | IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            LogConfig.LOG_ERROR.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para generar un par de claves DSA
     */
    private static void generateKeyPair() {
        try {

            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
            SecureRandom seed = SecureRandom.getInstance("SHA1PRNG");

            keyGen.initialize(512, seed);
            KeyPair par = keyGen.generateKeyPair();

            privateKey = par.getPrivate();
            publicKey = par.getPublic();

            System.out.println("PRIVATE KEY");
            System.out.println(HashTool.enHexadecimal(privateKey.getEncoded()));
            System.out.println("----------------");
            System.out.println("PUBLIC KEY");
            System.out.println(HashTool.enHexadecimal(publicKey.getEncoded()));

            System.out.println("You want to save?(Y/N)");

            if (scstring.nextLine().equalsIgnoreCase("Y")) {
                System.out.println("File names:");
                String name = scstring.nextLine();
                saveKeyPair(name);
                System.out.println("Saved");
                System.out.println("");
            }

            LogConfig.LOG_ALL.log(Level.INFO, "A DSA key pair has been generated");

        } catch (NoSuchAlgorithmException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            LogConfig.LOG_ERROR.log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Metodo para guardar el par de claves
     * @param nameFile 
     */
    private static void saveKeyPair(String nameFile) {
        try (FileOutputStream fos = new FileOutputStream(nameFile + "_public_dsa.agl"); FileOutputStream fos2 = new FileOutputStream(nameFile + "_private_dsa.agl")) {
            fos.write(publicKey.getEncoded());
            fos2.write(privateKey.getEncoded());

            LogConfig.LOG_ALL.log(Level.INFO, "A DSA key pair has been saved");

        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            LogConfig.LOG_ERROR.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            LogConfig.LOG_ERROR.log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Metodo para guardar el fichero firmado
     * @param nameFile
     * @param filesigned 
     */
    private static void saveFileSigned(String nameFile, byte[] filesigned) {
        try (FileOutputStream fos = new FileOutputStream(nameFile + "_signed.agl")) {
            fos.write(filesigned);

            LogConfig.LOG_ALL.log(Level.INFO, "A signed file has been saved");

        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            LogConfig.LOG_ERROR.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            LogConfig.LOG_ERROR.log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Metodo para cargar las claves DSA en memoria
     * @param pathPublicKey
     * @return 
     */
    private static boolean loadKeyPair(String pathPublicKey) {
        try {
            //CLAVE PUBLICA
            File publicKeyFile = new File(pathPublicKey);
            if (publicKeyFile.exists()) {
                byte[] publicKeyBytes = Files.readAllBytes(publicKeyFile.toPath());

                // Crear una instancia de X509EncodedKeySpec utilizando el array de bytes
                X509EncodedKeySpec keySpecPublic = new X509EncodedKeySpec(publicKeyBytes);

                // Obtener una instancia de KeyFactory para el algoritmo de clave deseado (por ejemplo, DSA)
                KeyFactory keyFactory = KeyFactory.getInstance("DSA");

                // Generar la PublicKey utilizando la especificación de clave
                publicKey = keyFactory.generatePublic(keySpecPublic);

            } else {
                System.out.println("Third parameter not valid");
                LogConfig.LOG_ERROR.log(Level.WARNING, "Error when loading rsa public key");
                return false;

            }

            LogConfig.LOG_ALL.log(Level.INFO, "A RSA key pair has been loaded");
            return true;

        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            LogConfig.LOG_ERROR.log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
