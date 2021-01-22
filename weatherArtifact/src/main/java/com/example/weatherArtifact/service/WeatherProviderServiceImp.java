package com.example.weatherArtifact.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.weatherArtifact.dto.Weather;
import com.example.weatherArtifact.utils.JsonUtil;

@Service
public class WeatherProviderServiceImp implements WeatherProviderServiceInterface {

	@Override
	public String providerWeatherByCityName(String name) {
		Weather weather = new Weather();
		weather.setCity(name);
		weather.setUpdatedTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

		switch (name) {
		case "Sydney":
			weather.setTemperature("20℃");
			weather.setWeather("Mostly Cloudy");
			weather.setWind("32km/h");
			break;
		case "Melbourne":
			weather.setTemperature("30℃");
			weather.setWeather("Mostly Sunny");
			weather.setWind("12km/h");
			break;
		case "Wollongong":
			weather.setTemperature("350℃");
			weather.setWeather("Mostly snowy");
			weather.setWind("0km/h");
			break;
		default:break;
			
		}

		String weatherres = JsonUtil.toJson(weather);
		return weatherres;
	}

}
