/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package es.iesaugustogonzalez.jfranco.ejemplo2post;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jfrancoros
 */
public class Ejemplo2Post {

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .uri(new URI("https://postman-echo.com/post"))
                    //.headers("Content-Type", "text/plain;charset=UTF-8")
                    .POST(HttpRequest.BodyPublishers.ofString("Ejemplo de POST con body"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();
            int responseStatusCode = response.statusCode();

            System.out.println("httpGetRequest: " + responseBody);
            System.out.println("httpGetRequest status code: " + responseStatusCode);

        } catch (URISyntaxException ex) {
            Logger.getLogger(Ejemplo2Post.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejemplo2Post.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejemplo2Post.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
