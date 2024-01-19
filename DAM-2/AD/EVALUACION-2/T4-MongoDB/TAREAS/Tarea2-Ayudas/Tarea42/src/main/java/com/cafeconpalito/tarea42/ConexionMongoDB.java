/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.tarea42;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Clase para rgestionar la conexion a la BBDDD MongoDB
 *
 * @author CafeConPalito
 */
public class ConexionMongoDB {

    //NECESARIO PARA MONGO DB
    static final String USER = "albano";
    static final String PASS = "1234";
    static final String CLUSTER = "@tarea2.7v58fwu.mongodb.net/?retryWrites=true&w=majority";
    static final String DB = "Tarea2"; // nombre de la base de datos

    private static ConexionMongoDB instance = null;

    private MongoDatabase mongoDatabase = null;
    private MongoClient mongoClient = null;

    /**
     * Constructor que inicia la coneccion
     */
    private ConexionMongoDB() {

        String connectionString = "mongodb+srv://" + USER + ":" + PASS + CLUSTER;

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
                
            
        
        try {
            mongoClient = MongoClients.create(settings);
            mongoDatabase = mongoClient.getDatabase(DB);
            
            mongoDatabase.runCommand(new Document("ping", 1));
            
            System.out.println("Connection OK");
        } catch (MongoException e) {
            e.printStackTrace();
            System.out.println("ERROR CONECTION MONGO DB");
        }
    }

    public static ConexionMongoDB getInstance() {
        if (instance == null) {
            instance = new ConexionMongoDB();
        }
        return instance;
    }

    public MongoDatabase getMongoDataBase() {
        return mongoDatabase;
    }

    /**
     * Metodo para desconectar la DB
     */
    public void desconectar() {

        mongoClient.close();

    }

}
