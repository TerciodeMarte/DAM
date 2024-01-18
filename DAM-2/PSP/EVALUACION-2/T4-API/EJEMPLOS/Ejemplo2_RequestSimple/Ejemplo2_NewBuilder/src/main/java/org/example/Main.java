package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request= HttpRequest.newBuilder()
                    .uri(new URI("https://www.google.es"))
                    .GET()
                    .build();

            HttpResponse<String> response= client.send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();
            int responseStatusCode = response.statusCode();

            System.out.println("httpGetRequest: " + responseBody);
            System.out.println("httpGetRequest status code: " + responseStatusCode);


        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}