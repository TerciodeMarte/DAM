/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.tarea41;

import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Indexes.ascending;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main {

    public static void main(String[] args) {
        MongoCollection<Document> c = ConexionMongoDB.getInstance().getMongoDataBase().getCollection("superficie");

        String provincia = "LEON";
        String producto = "COLZA";

        System.out.println("-------------------------------------------------------------");
        System.out.println("CONSULTA 1");
        allSuperficieProvincia(c, provincia);
        System.out.println("-------------------------------------------------------------");

        System.out.println("-------------------------------------------------------------");
        System.out.println("CONSULTA 2");
        for (String i : listaProvincias(c)) {
            System.out.println(i);
        }
        System.out.println("-------------------------------------------------------------");

        System.out.println("-------------------------------------------------------------");
        System.out.println("CONSULTA 3");
        System.out.println("Superficie cultivable en " + provincia + " de " + producto);
        numberSuperficieProducto(c, provincia, producto);
        System.out.println("-------------------------------------------------------------");

    }

    /**
     * Método que muestre los datos del tipo de cultivo y la superficie de
     * cultivo de una provincia determinada ordenadas ascendentemente por
     * superficie.
     *
     * @param collection MongoCollection
     * @param provincia Nombre de la provincia
     */
    public static void allSuperficieProvincia(MongoCollection collection, String provincia) {

        FindIterable<Document> documents = collection.find(eq("provincia", provincia)).sort(ascending("superficie"));
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }

    }

    /**
     * Método que devuelve la lista con el nombre de las 9 provincias incluidas
     * en la colección.
     *
     * @param collection MongoCollection
     * @return Lista de tipo String con los nombres de las provincias, sin
     * repetir
     */
    public static ArrayList<String> listaProvincias(MongoCollection collection) {

        DistinctIterable<String> documents = collection.distinct("provincia", String.class);
        MongoCursor<String> cursor = documents.iterator();

        ArrayList<String> lista = new ArrayList<>();

        while (cursor.hasNext()) {
            lista.add(cursor.next());
        }

        return lista;
    }

    /**
     * Método que devuelve la superficie de cultivo en una provincia para un
     * producto concreto
     *
     * @param collection MongoCollection
     * @param provincia Nombre de la provincia
     * @param producto Nombre del producto
     * @return int con la superficie
     */
    public static Integer numberSuperficieProducto(MongoCollection collection, String provincia, String producto) {

        FindIterable<Document> documents = collection.find(and(eq("provincia", provincia), eq("producto", producto)));
        MongoCursor<Document> cursor = documents.iterator();
        int aux = 0;
        while (cursor.hasNext()) {
            aux += cursor.next().getInteger("superficie");
        }

        return aux;
    }
}
