package com.cafeconpalito;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.or;
import static com.mongodb.client.model.Indexes.ascending;
import com.sun.source.util.DocSourcePositions;

import org.bson.Document;

/**
 * @author Albano Di­ez de Paulino
 */
public class Main {

    public static void main(String[] args) {
        MongoCollection<Document> c = ConexionMongoDB.getInstance().getMongoDataBase().getCollection("bicis");

        //Metodo 1
        String salida = "BARAKALDO";
        String llegada = "MUSKIZ";
        int km = 12;
        int horas = 1;

        //Metodo 2
        String municipio = "GETXO";
        //Metodo 3
        String dificultad = "BAJA";

        System.out.println("-------------------------------------------------------------");
        System.out.println("INSERT 1");
        //nuevoDocumento(c, salida, llegada, km, horas);
        System.out.println("INSERTADO");
        System.out.println("-------------------------------------------------------------");

        System.out.println("-------------------------------------------------------------");
        System.out.println("CONSULTA 1");
        listaRutasSalida(municipio, c);
        System.out.println("-------------------------------------------------------------");

        System.out.println("-------------------------------------------------------------");
        System.out.println("CONSULTA 2");
        System.out.println(totalRutasDificultad(dificultad, c));
        System.out.println("-------------------------------------------------------------");

        System.out.println("-------------------------------------------------------------");
        System.out.println("CONSULTA 3");
        System.out.println(totalKmRutaLocalidad(c, salida));
        System.out.println("-------------------------------------------------------------");
        
        System.out.println("-------------------------------------------------------------");
        System.out.println("INSERT 2");
        //nuevaColeccionCircular(c, "COPIACIRCULAR");
        System.out.println("-------------------------------------------------------------");

    }

    /**
     * MÃ©todo que inserta un documento con los siguientes datos
     * MUNICIPIO_SALIDA, MUNICIPIO_LLEGADA, LONGITUD_KM, DURACION_H
     *
     * @param collection
     * @param salida MUNICIPIO_SALIDA
     * @param llegada MUNICIPIO_LLEGADA
     * @param km LONGITUD_KM
     * @param horas DURACION_H
     */
    public static void nuevoDocumento(MongoCollection<Document> collection, String salida, String llegada, int km,
            int horas) {

        Document doc = new Document();
        doc.append("MUNICIPIO_SALIDA", salida);
        doc.append("MUNICIPIO_LLEGADA", llegada);
        doc.append("LONGITUD_KM", km);
        doc.append("DURACION_H", horas);

        collection.insertOne(doc);
    }

    /**
     * Muestra por pantalla las rutas ciclables que salen o llegan de un
     * municipio.
     *
     * @param municipio
     * @param collection
     */
    public static void listaRutasSalida(String municipio, MongoCollection collection) {
        FindIterable<Document> documents = collection.find(or(eq("MUNICIPIO_SALIDA", municipio), eq("MUNICIPIO_LLEGADA", municipio)));
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    /**
     * Método que devuelve el total de rutas ciclables que hay con una
     * dificultad determinada
     *
     * @param dificultad
     * @param collection
     * @return el total de rutas
     */
    public static int totalRutasDificultad(String dificultad, MongoCollection collection) {
        FindIterable<Document> documents = collection.find(eq("DIFICULTAD", dificultad));
        MongoCursor<Document> cursor = documents.iterator();
        int aux = 0;
        while (cursor.hasNext()) {
            cursor.next();
            aux += 1;
        }

        return aux;
    }

    /**
     * Método que devuelve el número total de kilómetros de todas las rutas que
     * salen de una determinada localidad
     *
     * @param collection
     * @param salida
     * @return suma km
     */
    public static int totalKmRutaLocalidad(MongoCollection collection, String salida) {
        FindIterable<Document> documents = collection.find(eq("MUNICIPIO_SALIDA", salida));
        MongoCursor<Document> cursor = documents.iterator();
        int aux = 0;
        while (cursor.hasNext()) {
            aux += cursor.next().getInteger("LONGITUD_KM");
        }

        return aux;

    }

    public static void nuevaColeccionCircular(MongoCollection collection, String nombreColeccion) {

        //Creo una nueva conexion con el nombre de la nueva coleccion
        ConexionMongoDB.getInstance().getMongoDataBase().createCollection(nombreColeccion);

        //Genero la conexion a la nueva coleccion
        MongoCollection newcollection = ConexionMongoDB.getInstance().getMongoDataBase().getCollection(nombreColeccion);

        sendaCircular(newcollection, collection);

    }

    private static void sendaCircular(MongoCollection newcollection, MongoCollection oldCollection) {

        FindIterable<Document> documents = oldCollection.find(eq("RECORRIDO", "CIRCULAR"));
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            Document doc = new Document();
            Document d = cursor.next();
            doc.append("MUNICIPIO_SALIDA", d.getString("MUNICIPIO_SALIDA"));
            doc.append("RECORRIDO", d.getString("RECORRIDO"));
            doc.append("LONGITUD_KM", d.getInteger("LONGITUD_KM"));
            newcollection.insertOne(doc);
        }
   
    }

}
