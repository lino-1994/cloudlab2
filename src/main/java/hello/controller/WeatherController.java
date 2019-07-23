package hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import hello.value.weather.OpenWeather;
import hello.value.weather.response.OpenWeatherResponse;

@RestController
public class WeatherController {
	  static final String appId= "2f5a929aefa1a0ae9020337a90e7433e";

	private static final Logger log = LoggerFactory.getLogger(WeatherController.class);
	
	@GetMapping ("/weather/{cityName},{countryCode}")
	public OpenWeather getWeather(@PathVariable String cityName, @PathVariable String countryCode) {
		
		RestTemplate restTemplate = new RestTemplate();
		 /* String cityName= "MIlano";
		 * String countryName="IT";
		 * this without take variable in the Path
		 */
		String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName +"," + countryCode + "&appId=" + appId;
		
		log.info(url);
		return restTemplate.getForObject(url, OpenWeather.class);
	}
	@GetMapping ("/weather")
	public OpenWeatherResponse getTwotWeather (@RequestParam ("city1") String city1, @RequestParam ("city2") String city2) {
		RestTemplate restTemplate = new RestTemplate();
		String url1 = "https://api.openweathermap.org/data/2.5/weather?q=" + city1 + "&appId=" + appId;
		String url2 = "https://api.openweathermap.org/data/2.5/weather?q=" + city2+ "&appId=" + appId;
		
		log.info(url1);
		log.info(url2);
		
		OpenWeather weather1 = restTemplate.getForObject(url1, OpenWeather.class);
		OpenWeather weather2 = restTemplate.getForObject(url2, OpenWeather.class);
		
		OpenWeatherResponse response = new OpenWeatherResponse();
		
		response.setFirstCity(weather1.getName());
		response.setSecondCity(weather2.getName());
		response.setFirstTemp(weather1.getMain().getTemp());
		response.setSecondTemp(weather2.getMain().getTemp());

		return response;
	}
	
	

}
