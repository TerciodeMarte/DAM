/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.iesaugustogonzalez.jfranco.ejemplo3_cifradorsamaven;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author jfrancoros
 */
public class Ejemplo3_cifradoRSAMaven {

    public static void main(String[] args) {
              try {
            // TODO code application logic here
            
            KeyPairGenerator keyGen=KeyPairGenerator.getInstance("RSA");
            //SecureRandom secure= SecureRandom.getInstance("SHA1PRNG");
            
            SecureRandom secure= SecureRandom.getInstance("SHA1PRNG");
            secure.setSeed("cadena".getBytes());
            keyGen.initialize(512, secure);
            KeyPair clavesRSA=keyGen.generateKeyPair();
            
            PrivateKey clavePrivada=clavesRSA.getPrivate();
            PublicKey clavePublica=clavesRSA.getPublic();
            
            System.out.println(clavePrivada.toString());
            
            
            String mensaje="Este es el mensaje secreto";
            
            //Crear el cifrador
            Cipher cifrador=Cipher.getInstance("RSA");
            
            //Poner el cifrador en modo ENCRIPTACIÓN 
            cifrador.init(Cipher.ENCRYPT_MODE, clavePrivada);
            
            byte[] bufferCifrado=cifrador.doFinal(mensaje.getBytes());
            
            String textoCifrado=Base64.getEncoder().encodeToString(bufferCifrado);
            
            System.out.println(textoCifrado);
            
            cifrador.init(Cipher.DECRYPT_MODE, clavePublica);
            
            byte[] arrayCifrado=Base64.getDecoder().decode(textoCifrado);
            
            byte[] bufferClaro=cifrador.doFinal(arrayCifrado);
            
            System.out.println(new String (bufferClaro));
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Ejemplo3_cifradoRSAMaven.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Ejemplo3_cifradoRSAMaven.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Ejemplo3_cifradoRSAMaven.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Ejemplo3_cifradoRSAMaven.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Ejemplo3_cifradoRSAMaven.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
