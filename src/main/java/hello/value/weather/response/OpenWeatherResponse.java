package hello.value.weather.response;

public class OpenWeatherResponse {
	private String firstCity;
	private String secondCity;
	private double firstTemp;
	private double secondTemp;
	
	public OpenWeatherResponse() {
		super();
	}
	public String getFirstCity() {
		return firstCity;
	}
	public void setFirstCity(String firstCity) {
		this.firstCity = firstCity;
	}
	public String getSecondCity() {
		return secondCity;
	}
	public void setSecondCity(String secondCity) {
		this.secondCity = secondCity;
	}
	public double getFirstTemp() {
		return firstTemp;
	}
	public void setFirstTemp(double firstTemp) {
		this.firstTemp = firstTemp;
	}
	public double getSecondTemp() {
		return secondTemp;
	}
	public void setSecondTemp(double secondTemp) {
		this.secondTemp = secondTemp;
	}
	
}
