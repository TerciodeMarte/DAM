package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Main {
    public static void main(String[] args) {
        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request= HttpRequest.newBuilder()
                    .uri(new URI("https://postman-echo.com/get"))
                    .version(HttpClient.Version.HTTP_2)
                    .header("key1", "value2")
                    .header("key2", "value2")
                    .timeout(Duration.of(10, SECONDS))
                    .GET()
                    .build();

            HttpResponse<String> response= client.send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();
            int responseStatusCode = response.statusCode();

            System.out.println("httpGetRequest: " + responseBody);
            System.out.println("httpGetRequest status code: " + responseStatusCode);

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}