package com.example.weatherArtifact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.weatherArtifact.dto.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherServiceImp implements WeatherServiceInterface {
	
	private static final String WEATHER_URI = "http://localhost:8080/weather_provider?";
	 
    @Autowired
    private RestTemplate restTemplate;
	
	@Override
	public Weather getWeatherByCityName(String cityName) {
		
		String uri = WEATHER_URI + "name=" + cityName;
        return this.getWeatherResponse(uri);
        
	}
	
	private Weather getWeatherResponse(String uri) {
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        Weather weather  = null;
        String strBody = null;
        if (respString.getStatusCodeValue() == 200) {
            strBody = respString.getBody();
        }
        try {
        	weather = objectMapper.readValue(strBody, Weather.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weather;
    }

}
