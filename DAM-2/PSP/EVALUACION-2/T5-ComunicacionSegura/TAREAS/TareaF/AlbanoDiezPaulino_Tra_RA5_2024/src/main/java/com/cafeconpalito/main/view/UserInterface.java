package com.cafeconpalito.main.view;

import com.cafeconpalito.main.asimetrico.KeyPairManagerRSA;
import com.cafeconpalito.main.asimetrico.RSAEncryption;
import com.cafeconpalito.main.cifrado.HashTool;
import com.cafeconpalito.main.config.LogConfig;
import java.io.File;
import java.util.logging.Level;

/**
 * Implementación de los mensajes que se muestran al usuario en función de sus
 * entradas.
 *
 * @author Albano Díez de Paulino
 */
public class UserInterface {

    public static void sw(String[] args) {
        if (args.length < 1) {
            help();
        } else {
            switch (args[0]) {
                case "-h":
                case "-help":
                    help();
                    break;
                case "-hlog":
                    for (String a : HashTool.getAlgorithms()) {
                        System.out.println("*"+a);
                    }
                    break;
                case "-htext":
                    if (args.length==3) {
                        System.out.println("HASH: "+ HashTool.getStringHash(args[1], args[2]));
                        
                    }else{
                        System.out.println("Second or third parameter missing");
                        LogConfig.LOG_ERROR.log(Level.WARNING, "Second or third parameter missing <-htext>");
                    }
                    break;
                case "-hfile":
                    if (args.length==3) {
                        System.out.println("HASH: "+ HashTool.getFilehash(args[1], new File(args[2])));
                    }else{
                        System.out.println("Second or third parameter missing");
                        LogConfig.LOG_ERROR.log(Level.WARNING, "Second or third parameter missing <-hfile>");
                    }
                    break;
                case "-rsagenerate":
                    if (args.length==2) {
                         KeyPairManagerRSA.generateKeyPair(args[1]);
                    }else{
                        System.out.println("Second parameter missing");
                        LogConfig.LOG_ERROR.log(Level.WARNING, "Second parameter missing <-rsagenerate>");
                    }
                    break;
                case "-rsae":
                    if (args.length==3) {
                         RSAEncryption.encryption(args[1], args[2]);
                    }else{
                        System.out.println("Second or third parameter missing");
                        LogConfig.LOG_ERROR.log(Level.WARNING, "Second or third parameter missing <-rsaencryption>");
                    }
                    break;
                case "-rsad":
                    if (args.length==3) {
                         RSAEncryption.decryption(args[1], args[2]);
                    }else{
                        System.out.println("Second or third parameter missing");
                        LogConfig.LOG_ERROR.log(Level.WARNING, "Second or third parameter missing <-rsaencryption>");
                    }
                    break;
                
                default:
                    System.out.println("First param no valid");
                    System.out.println("");
                    help();
                    LogConfig.LOG_ERROR.log(Level.WARNING, "First param not valid");
            }
        }

    }

    private static void help() {
        System.out.println("To use this program you must enter a parameter \n"
                + "to determine what you want to do from the following list.");
        System.out.println("");
        System.out.println("\t -hlog  | Get list of available algorithms to generate a hash");
        System.out.println("\t -htext <algorithm> <plaintext>| Generate a hash from plaintext");
        System.out.println("\t -hfile <algorithm> <path>| Generate a hash from file");
        System.out.println("\t ---------------------------------------------------------------");
        System.out.println("\t -rsagenerate <seed>  | Generate RSA key pair");
        System.out.println("\t -rsae <pathPublicKey> <pathPrivateKey> | Encrypt file with RSA key pair");
        System.out.println("\t -rsad <pathPublicKey> <pathPrivateKey> | Encrypt file with RSA key pair");
        System.out.println("\t ---------------------------------------------------------------");
        System.out.println("");
        System.out.println("To see this message again you can use -h or -help");
    }
}
