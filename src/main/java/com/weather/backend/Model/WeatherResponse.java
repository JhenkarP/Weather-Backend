package com.weather.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse {
    private String city;
    private String weather;
    private double temperature;
    private double windSpeed;
    private int humidity;
    private long sunrise;
    private long sunset;
    private int timezone;
    private int dt;
}
