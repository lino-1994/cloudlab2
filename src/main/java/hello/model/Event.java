package hello.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javafx.scene.chart.PieChart.Data;

@Entity
@Table(name = "events")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {

    public Event() {}

    public Event(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    private Data date;
    private String location;
    private String venue;
    private double price;
    private int nTicket;

	public Data getDate() {
		return date;
	}

	public void setDate(Data date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getnTicket() {
		return nTicket;
	}

	public void setnTicket(int nTicket) {
		this.nTicket = nTicket;
	}

	

}
