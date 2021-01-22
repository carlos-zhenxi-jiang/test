package com.example.weatherArtifact.service;

import com.example.weatherArtifact.dto.Weather;


public interface WeatherServiceInterface {
	
	Weather  getWeatherByCityName(String CityName);
}
