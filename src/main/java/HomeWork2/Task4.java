package HomeWork2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 Задание 4
 * @author Artem Denisov
 */
public class Task4 {

    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://httpbin.org/anything";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json") // Для примера в request пусть будет только json в качестве допустимого.
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(response.body());

        JsonNode headers = jsonNode.get("headers");
        JsonNode acceptHeader = headers.get("Accept"); // Сервер наше значение продублирует в качестве допустимых в своём ответе

        if (acceptHeader != null) {
            System.out.println("Accept: " + acceptHeader.asText());
        } else {
            System.out.println("Не найдено");
        }
    }
}
