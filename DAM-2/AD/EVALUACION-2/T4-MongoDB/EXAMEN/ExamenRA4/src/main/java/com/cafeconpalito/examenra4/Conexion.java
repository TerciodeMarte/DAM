package com.cafeconpalito.examenra4;

import static com.cafeconpalito.examenra4.ConexionMongoDB.CLUSTER;
import static com.cafeconpalito.examenra4.ConexionMongoDB.DB;
import static com.cafeconpalito.examenra4.ConexionMongoDB.PASS;
import static com.cafeconpalito.examenra4.ConexionMongoDB.USER;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Conexion {

    final String URL = "mongodb+srv://Albano:01022024@diezpaulinoalbano.1ay46v7.mongodb.net/?retryWrites=true&w=majority";

    //static final String DB = "Tarea2"; // nombre de la base de datos
    private MongoClient mongoClient = null;
    private MongoCollection mongoCollection = null;

    public MongoClient getMongoClient() {
        String connectionString = URL;

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        try {
            mongoClient = MongoClients.create(settings);
            return mongoClient;
        } catch (MongoException e) {
            e.printStackTrace();
            System.out.println("ERROR CONECTION MONGO DB");
            return null;
        }
    }

    public MongoCollection<Document> getCollection(String db, String collection) {
        try {
            mongoCollection = mongoClient.getDatabase(db).getCollection(collection);
            return mongoCollection;
        } catch (MongoException e) {
            e.printStackTrace();
            System.out.println("ERROR CONECTION MONGO DB");
        }

        return null;
    }

    public  void desconecta() {

        mongoClient.close();

    }
}
