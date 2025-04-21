
# 🌤️ Weather Dashboard Backend

Backend for the **Weather Dashboard** project built with **Spring Boot**. It exposes an API to fetch weather data from the **OpenWeatherMap API**.

## Features

- Fetch current weather (temperature, wind speed, humidity) for any city.
- Built with Spring Boot's structured architecture.

## Technologies Used

- Java 17+
- Spring Boot
- OpenWeatherMap API
- Maven

## API Endpoint

### `GET /api/weather/current?city={city}`

Fetches current weather data for a given city.

**Query Parameter:**
- `city` – City name (required).

**Sample Response:**
```json
{
  "city": "Berlin",
  "weather": "Clear",
  "temperature": 18.5,
  "windSpeed": 3.4,
  "humidity": 60,
  "sunrise": 1682270000,
  "sunset": 1682323400
}
```

## Setup & Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/weather-dashboard-backend.git
   cd weather-dashboard-backend
   ```

2. **Configure API key** in `src/main/resources/application.properties`:
   ```properties
   openweathermap.api.key=your-api-key-here
   ```

3. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the API:**
   ```
   http://localhost:8080/api/weather/current?city=Berlin
   ```

## License

MIT License.
