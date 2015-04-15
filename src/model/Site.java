package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Site {
	@Id
	private int id;
	private Double latitude;
	private Double longitude;
	private String name;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Site(int id, Double latitude, Double longitude, String name) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
	}
	
	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
