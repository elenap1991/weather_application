package org.example;

import org.example.config.AppConfig;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class WeatherRequest {
    private static final String BASE_URL = "http://api.weatherapi.com/v1/current.json";
    private String paramKey = "key";
    private String paramKeyValue = AppConfig.getKey();
    private int StatusCode;
    private String responseBody;


    public void sendRequest(String params) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String url = String.format("%s?%s=%s%s", BASE_URL, paramKey, paramKeyValue, params);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.of(20, SECONDS))
                .GET()
                .build();
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
////                .thenApply(objectMapper::readValue)
//                .thenAccept(System.out::println)
//
//                .thenAccept(System.out::println)
//                .join();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        StatusCode = response.statusCode();
        if (checkStatusCode()) {
            responseBody = response.body();
        } else {
            responseBody = null;
        }

//        System.out.println(response.body());
//        System.out.println(response.statusCode());
//        ObjectMapper mapper = new ObjectMapper();
//        WeatherResponse weatherResponse = mapper.readValue(response.body(), WeatherResponse.class);
//        System.out.println("city name:" + weatherResponse.getLocation().getCityName());
//        System.out.println("city кантри:" + weatherResponse.getLocation().getCountryName());
//        System.out.println("city кантри:" + weatherResponse.getCurrent().getLast_updated());
//        return response;
//        catch (HttpTimeoutException e) {
//            e.printStackTrace();
//        }

    }

    public int getStatusCode() {
        return StatusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    private boolean checkStatusCode() {
        if (StatusCode == 200) {
            return true;
        } else if (StatusCode == 400) {
            System.out.println("Not found");
        } else if (StatusCode == 401) {
            System.out.println("Unauthorized");
        } else if (StatusCode == 404) {
            System.out.println("Not found");
        } else if (StatusCode >= 500 && StatusCode < 600) {
            System.out.println("Internal Server Error");
        } else {
            System.out.println("Error");
        }
        return false;
    }
}

