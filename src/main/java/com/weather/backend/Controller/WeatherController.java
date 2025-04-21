package com.weather.backend.Controller;

import org.springframework.web.bind.annotation.*;
import com.weather.backend.Model.WeatherResponse;
import com.weather.backend.Service.WeatherService;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "http://localhost:5173")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/current")
    public WeatherResponse getCurrentWeather(@RequestParam String city) {
        return weatherService.getCurrentWeather(city);
    }
}