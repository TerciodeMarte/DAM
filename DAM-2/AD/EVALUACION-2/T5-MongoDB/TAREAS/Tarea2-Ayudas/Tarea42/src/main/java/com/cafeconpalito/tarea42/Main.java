/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.tarea42;

import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Indexes.ascending;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main {

    public static void main(String[] args) {
        MongoCollection<Document> c = ConexionMongoDB.getInstance().getMongoDataBase().getCollection("ayudas");

        String provincia = "LEON";
        int solicitudes = 100;

        System.out.println("-------------------------------------------------------------");
        System.out.println("CONSULTA 1");
        seccionesProvincia(c, provincia);
        System.out.println("-------------------------------------------------------------");

        System.out.println("-------------------------------------------------------------");
        System.out.println("CONSULTA 2");
        for (String i : allprovincias(c)) {
            System.out.println(i);
        }
        System.out.println("-------------------------------------------------------------");

        System.out.println("-------------------------------------------------------------");
        System.out.println("CONSULTA 3");
        System.out.println(numerosolucitudes(c, provincia));
        System.out.println("-------------------------------------------------------------");
        

        System.out.println("-------------------------------------------------------------");
        System.out.println("CONSULTA 4");
        allayudasbynumero(c, solicitudes);
        System.out.println("-------------------------------------------------------------");

    }

    /*1. Método que muestre los datos de las secciones agrarias comarcales y el número de solicitudes 
para una provincia determinada, ordenadas ascendentemente por número de solicitudes.*/
    /**
     * @param collection MongoCollection
     * @param provincia Nombre de la provincia
     */
    private static void seccionesProvincia(MongoCollection collection, String provincia) {
        FindIterable<Document> documents = collection.find(eq("provincia", provincia)).sort(ascending("superficie"));
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }

    }

    /*2. Método que devuelve la lista con el nombre de las 9 provincias incluidas en la colección.*/
    /**
     * @param collection MongoCollection
     * @return Lista de tipo String con los nombres de las provincias, sin
     * repetir
     */
    private static ArrayList<String> allprovincias(MongoCollection collection) {
        DistinctIterable<String> documents = collection.distinct("provincia", String.class);
        MongoCursor<String> cursor = documents.iterator();

        ArrayList<String> lista = new ArrayList<>();

        while (cursor.hasNext()) {
            lista.add(cursor.next());
        }

        return lista;
    }

    /*3. Método que devuelve el número total de solicitudes presentadas en una provincia concreta.*/
    /**
     * @param collection MongoCollection
     * @param provincia Nombre de la provincia
     *
     * @return int con el número total de solicitudes
     */
    private static int numerosolucitudes(MongoCollection collection, String provincia) {
        FindIterable<Document> documents = collection.find(eq("provincia", provincia));
        MongoCursor<Document> cursor = documents.iterator();
        int aux = 0;
        while (cursor.hasNext()) {
            aux += cursor.next().getInteger("numero_de_solicitudes_presentadas");
        }

        return aux;
    }

    /*4. Método que muestra la provincia, sección agraria y número de solicitudes cuando el número 
de solicitudes sea menor a un valor especificado como parámetro.*/
    /**
     * @param collection MongoCollection
     * @param int número mínimo de solicitudes para filtrar
     *
     */
    private static void allayudasbynumero(MongoCollection collection, int solicitudes) {
        FindIterable<Document> documents = collection.find(lt("numero_de_solicitudes_presentadas", solicitudes));
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            Document d = cursor.next();
            System.out.println("provincia: " + d.getString("provincia"));
            System.out.println("Seccion agraria: " + d.getString("seccion_agrarica_comarcal"));
            System.out.println("Numero de solicitudes: " + d.getInteger("numero_de_solicitudes_presentadas"));
        }
    }
}
