/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.iesaugustogonzalez.jfranco.ejemplo2_generarclavesrsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author jfrancoros
 */
public class Ejemplo2_GenerarClavesRSA {

    public static void main(String[] args) {
         //Asigna al objeto claves de tipo keyPair el par de claves generadas
      //por el método GeneraParejaClave()
      KeyPair claves=GeneraParejaClave();
     //Imprime el valor de las claves generadas en diferentes formatos
      System.out.println("Algoritmo Kprivada: "
              +claves.getPrivate().getAlgorithm());
      System.out.println("Codificación Kprivada: "
              +claves.getPrivate().getFormat());
      System.out.println("Bytes Kprivada: "
              +claves.getPrivate().toString());
      System.out.println("Algoritmo Kpública: "
              +claves.getPublic().getAlgorithm());
      System.out.println("Codificación Kpública: "
              +claves.getPublic().getFormat());
      System.out.println("Bytes Kpública: "
              +claves.getPublic().toString());
    }
    //Método que genera una clave tipo KeyPair (uan pareja de claves)
     public static KeyPair GeneraParejaClave() {
       KeyPair claves = null;
       try{
         //Crea el objeto para generar un par de claves mediante RSA
         KeyPairGenerator genera=KeyPairGenerator.getInstance("RSA");
         genera.initialize(512); //asigna tamaño de la clave
         claves=genera.generateKeyPair(); //genera la pareja de claves
       }catch(NoSuchAlgorithmException e){
           System.out.println("No existe el algoritmo de criptografía asimétrica");
       }
       return claves;
    }
    
}
