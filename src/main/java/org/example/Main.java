package org.example;

import org.example.dto.WeatherResponse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        WeatherResponse weatherInfo = new WeatherRetriever().getWeatherByCityName();
        if (weatherInfo == null) {
            System.exit(0);
        }
        System.out.println(String.format("Погода в %s: %s",
                weatherInfo.getLocation().getCityName(),
                weatherInfo.getCurrent().getTemperatureCelsius()));
    }
}