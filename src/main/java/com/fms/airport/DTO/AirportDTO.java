package com.fms.airport.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AirportDTO {
	
	
	Integer airportId;
	
	@NotBlank(message = "airport name cannot be blank")
	@Pattern(regexp = "^[a-zA-Z '-]*$", message = "Input should not contain special characters or numbers")
	@Size(min = 3, max = 30, message = "Input length should be between 3 and 30 characters")
	String airportName;
	
	@NotBlank(message = "airport name cannot be blank")
	@Pattern(regexp = "^[a-zA-Z '-]*$", message = "Input should not contain special characters or numbers")
	@Size(min = 3, max = 30, message = "Input length should be between 3 and 30 characters")
	String airportLocation;
	
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
	
	
	public AirportDTO() {
		super();
	}
	public AirportDTO(Integer airportId, String airportName, String airportLocation) {
		super();
		this.airportId = airportId;
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}

}
