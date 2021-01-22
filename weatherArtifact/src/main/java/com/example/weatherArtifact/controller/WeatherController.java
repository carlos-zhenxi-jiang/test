package com.example.weatherArtifact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.weatherArtifact.dto.Weather;
import com.example.weatherArtifact.service.CityService;
import com.example.weatherArtifact.service.WeatherProviderServiceImp;
import com.example.weatherArtifact.service.WeatherServiceImp;

//@RestController
@Controller
public class WeatherController {

	@Autowired
	private WeatherServiceImp weatherService;
	
	@Autowired
	private WeatherProviderServiceImp weatherProviderServiceImp;
	
	@Autowired
	private CityService cityService;

	@GetMapping("/weather_provider")
	@ResponseBody
	public String hello(@RequestParam(value = "name", defaultValue = "world") String name) {
		
		return weatherProviderServiceImp.providerWeatherByCityName(name);
	}

	@RequestMapping(value="/weather",method=RequestMethod.GET)
	public String weather(@RequestParam(name = "cityName", required = false, defaultValue = "world") String name,
			Model model) {
		Weather weather = weatherService.getWeatherByCityName(name);
		List<String> cities = cityService.getCities();	
		model.addAttribute("cities", cities);
		model.addAttribute("weatherInfo", weather);
		return "weather";
	}
}
