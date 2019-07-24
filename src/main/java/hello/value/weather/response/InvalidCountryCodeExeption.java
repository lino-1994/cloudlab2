package hello.value.weather.response;

public class InvalidCountryCodeExeption extends Exception {
	
	public InvalidCountryCodeExeption () {
		super ("country not found");
	}

}
