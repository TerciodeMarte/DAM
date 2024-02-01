/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.examenra4;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lt;
import java.util.ArrayList;
import java.util.Collections;
import org.bson.Document;

/**
 *
 * @author carra
 */
public class ExamenRA4 {

    public static void main(String[] args) {
        Conexion c = new Conexion();
        MongoClient mg = c.getMongoClient();
        MongoCollection<Document> mc = c.getCollection("Diez_Paulino_Albano", "coffe_shop");

        System.out.println("CONSULTA A");
        System.out.println("-------------------------------------------");
        System.out.println(consultaA(mc));
        System.out.println("-------------------------------------------");

        System.out.println("CONSULTA B");
        System.out.println("-------------------------------------------");
        ArrayList<String> listab = consultaB(mc);
        for (String string : listab) {
            System.out.println(string);
        }
        System.out.println("-------------------------------------------");

        System.out.println("CONSULTA E");
        System.out.println("-------------------------------------------");
        ArrayList<String> listae = consultaE(mc);
        for (String string : listae) {
            System.out.println(string);
        }
        System.out.println("-------------------------------------------");

        System.out.println("CONSULTA F");
        System.out.println("-------------------------------------------");
        consultaF(mc);
        System.out.println("-------------------------------------------");
        
        //INSERT ALBANO
        //nuevoDocumento(mc);
        
        //Listar todos los clientes
        System.out.println("LISTAR TODOS LOS CLIENTES");
        System.out.println("-------------------------------------------");
        listarClientes(mc);

    }

    private static int consultaA(MongoCollection collection) {
        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> cursor = documents.iterator();
        int suma = 0;
        int contador = 0;
        while (cursor.hasNext()) {
            Integer n = cursor.next().getInteger("Age");
            if (n != null) {
                suma += n;
                contador++;
            }
        }

        return suma / contador;
    }

    private static ArrayList<String> consultaB(MongoCollection collection) {
        FindIterable<Document> documents = collection.find(and(gte("Level_of_membership", 4), gt("Age", 35)));
        MongoCursor<Document> cursor = documents.iterator();

        ArrayList<String> lista = new ArrayList<>();

        while (cursor.hasNext()) {
            lista.add(cursor.next().getString("Name"));
        }

        return lista;
    }

    private static ArrayList<String> consultaE(MongoCollection collection) {
        FindIterable<Document> documents = collection.find(gt("Time_of_purchase", 15));
        MongoCursor<Document> cursor = documents.iterator();

        ArrayList<String> lista = new ArrayList<>();

        while (cursor.hasNext()) {
            lista.add(cursor.next().getString("Name"));
        }
        Collections.sort(lista);

        return lista;
    }

    private static void consultaF(MongoCollection collection) {
        FindIterable<Document> documents = collection.find(eq("Membership_card", "Black"));
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            Document d = cursor.next();
            System.out.println(d);

        }
    }

    public static void nuevoDocumento(MongoCollection<Document> collection) {

        Document doc = new Document();
        /*{
        "Member_ID": 5,
        "Name": "Hayes, Steven",
        "Membership_card": "White",
        "Age": 50,
        "Time_of_purchase": 44,
        "Level_of_membership": 3,
        "Address": "Cheshire"
    }*/
        doc.append("Member_ID", 13);
        doc.append("Name", "Diez,Albano");
        doc.append("Membership_card", "Black");
        doc.append("Age", 27);

        collection.insertOne(doc);
    }
    
    private static void listarClientes(MongoCollection collection) {
        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            Document d=cursor.next();
            Integer n = d.getInteger("Age");
            if (n != null) {
                System.out.println(d);
            }
        }
 
    }
}
