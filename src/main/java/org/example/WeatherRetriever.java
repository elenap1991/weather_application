package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.WeatherResponse;

import java.net.URLEncoder;

public class WeatherRetriever {
    private String paramCity = "q";

    public WeatherResponse getWeatherByCityName() throws Exception {
        String userInput = new ConsoleInput().getUserInput();
        String cityParamInUrl = String.format("&%s=%s", paramCity, URLEncoder.encode(userInput));

        WeatherRequest req = new WeatherRequest();
        req.sendRequest(cityParamInUrl);

        ObjectMapper mapper = new ObjectMapper();
        if (req.getResponseBody() != null) {
            return mapper.readValue(req.getResponseBody(), WeatherResponse.class);
        }
        return null;
    }
}
