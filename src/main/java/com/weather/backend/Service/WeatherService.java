package com.weather.backend.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.weather.backend.Model.WeatherResponse;

import org.json.JSONObject;

@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherResponse getCurrentWeather(String city) {
        String url = UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host("api.openweathermap.org")
                .path("/data/2.5/weather")
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .build()
                .toUriString();

        String response = restTemplate.getForObject(url, String.class);
        JSONObject json = new JSONObject(response);

        String cityName = json.getString("name");
        String weatherMain = json.getJSONArray("weather").getJSONObject(0).getString("main");
        double temp = json.getJSONObject("main").getDouble("temp");
        double windSpeed = json.getJSONObject("wind").getDouble("speed");
        int humidity = json.getJSONObject("main").getInt("humidity");
        long sunrise = json.getJSONObject("sys").getLong("sunrise");
        long sunset = json.getJSONObject("sys").getLong("sunset");
        int timezone = json.getInt("timezone");
        int dt = json.getInt("dt");

        return new WeatherResponse(
                cityName,
                weatherMain,
                temp,
                windSpeed,
                humidity,
                sunrise,
                sunset,
                timezone,
                dt);
    }
}
