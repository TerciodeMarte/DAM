package com.cafeconpalito.pokedex;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javafx.scene.image.Image;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Clase para realizar consultas a la API de Pokemon
 * https://pokeapi.co/
 * @author Albano Díez de Paulino
 */
public class ConsultasAPI {

    private static JSONObject json;

    /**
     * Metodo para Obtener la Imagen del pokemon seleccionado
     * @return Image Sprite del Pokemon
     */
    public static Image getSprite() {
        return new Image(json.getJSONObject("sprites").getJSONObject("other").getJSONObject("home").getString("front_default"));
    }

    /**
     * Metodo para Obtener el nombre del pokemon seleccionado
     * @return String Nombre del Pokemon
     */
    public static String getName() {
        return json.getString("name");
    }

    /**
     * Metodo para Obtener las estadisticas del pokemon seleccionado
     * @return Integer[] Array de 6 para las estadisticas
     */
    public static Integer[] getStats() {
        Integer stats[] = new Integer[6];
        for (int i = 0; i < 6; i++) {
            stats[i] = json.getJSONArray("stats").getJSONObject(i).getInt("base_stat");
        }
        return stats;

    }

    /**
     * Metodo para Obtener los tipos del pokemon seleccionado
     * @return String[] Array de 2 para los tipos
     */
    public static String[] getTypes() {
        String types[] = new String[json.getJSONArray("types").length()];
        for (int i = 0; i < json.getJSONArray("types").length(); i++) {
            types[i]= json.getJSONArray("types").getJSONObject(i).getJSONObject("type").getString("name");
        }
        return types;
    }

    /**
     * Metodo para hacer la consulta a la API de Pokemon
     * @param id Id del pokemon a buscar
     */
    public static void consulta(int id) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://pokeapi.co/api/v2/pokemon/" + id))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            json = new JSONObject(response.body());

        } catch (URISyntaxException | IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
