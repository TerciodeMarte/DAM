/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.pruebamongo;

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
 *
 * @author Albano Díez de Paulino
 */
public class Connection {

    private String usuario="adiezd07";
    private String password="1234";
    private String connectionString;
    private ServerApi serverApi;
    private MongoClientSettings settings;
 
    public Connection(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
 
    public void createConecction() {
        connectionString = "mongodb+srv://"+usuario+":"+password+"@cluster0.v1mcthi.mongodb.net/?retryWrites=true&w=majority";
        serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
    }
    public void startConecction(){
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                MongoDatabase database = mongoClient.getDatabase("admin");
                database.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
}
