package hello.controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import hello.value.weather.OpenWeather;

@RestController
public class WeatherController {
//	static final String appId= "2f5a929aefa1a0ae9020337a90e7433e";
//	 
	private static final Logger log = LoggerFactory.getLogger(WeatherController.class);
	
	@GetMapping ("/weather/{cityName}/{countryCode}/{appId}")
	public OpenWeather getWeather(@PathVariable String cityName, @PathVariable String countryCode, @PathVariable String appId) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName +"," + countryCode + "&appId=" + appId;
		log.info(url);
		return restTemplate.getForObject(url, OpenWeather.class);
	}
	
	

}
