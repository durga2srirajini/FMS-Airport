package com.fms.airport.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Airport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer airportId;
	
	@NotBlank(message = "airport name cannot be blank")
	@Pattern(regexp = "^[a-zA-Z '-]*$", message = "Input should not contain special characters or numbers")
	@Size(min = 8, max = 45, message = "Input length should be between 8 and 45 characters")
	String airportName;
	
	@NotBlank(message = "airport name cannot be blank")
	@Pattern(regexp = "^[a-zA-Z '-]*$", message = "Input should not contain special characters or numbers")
	@Size(min = 3, max = 30, message = "Input length should be between 3 and 30 characters")
	String airportLocation;
	
	
	
	public Airport() {
		super();
	}
	public Integer getAirportId() {
		return airportId;
	}
	public void setAirportId(Integer airportId) {
		this.airportId = airportId;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	public Airport(Integer airportId, String airportName, String airportLocation) {
		super();
		this.airportId = airportId;
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}
	
	
	

}
