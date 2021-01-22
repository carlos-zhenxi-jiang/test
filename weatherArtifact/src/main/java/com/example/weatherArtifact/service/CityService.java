package com.example.weatherArtifact.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CityService {

	public List<String> getCities(){
		List<String> cities = new ArrayList<String>();
		cities.add("Sydney");
		cities.add("Melbourne");
		cities.add("Wollongong");
		
		return cities;
	}
}
