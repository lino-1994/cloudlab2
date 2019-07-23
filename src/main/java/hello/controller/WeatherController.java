package hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import hello.value.weather.OpenWeather;

@RestController
public class WeatherController {
	 
	private static final Logger log = LoggerFactory.getLogger(WeatherController.class);
	
	@GetMapping ("/weather/{cityName}/{countryCode}/{appId}")
	public OpenWeather getWeather(@PathVariable String cityName, @PathVariable String countryCode, @PathVariable String appId) {
		
		RestTemplate restTemplate = new RestTemplate();
		/*
		 * final String appId= blablavla
		 * String cityName= "MIlano";
		 * String countryName="IT";
		 * this without take variable in the Path
		 */
		String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName +"," + countryCode + "&appId=" + appId;
		
		log.info(url);
		return restTemplate.getForObject(url, OpenWeather.class);
	}
	@GetMapping ("/weather")
	public OpenWeather getTwotWeather (@RequestParam String cName1, String cC1, String cName2, String cC2, String appId ) {
		RestTemplate restTemplate = new RestTemplate();
		
		return null;
	}
	
	

}
