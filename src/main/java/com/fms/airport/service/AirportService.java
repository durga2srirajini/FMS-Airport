package com.fms.airport.service;

import java.util.List;

import com.fms.airport.DTO.AirportDTO;
import com.fms.airport.DTO.ScheduleFlightDTO;
import com.fms.airport.entity.Airport;
import com.fms.airport.exception.AirportAlreadyExistsException;
import com.fms.airport.exception.AirportNotFoundException;



public interface AirportService {

	String addAirport(AirportDTO newAirportDTO);

	AirportDTO getAirportById(Integer id) throws AirportNotFoundException;

	List<AirportDTO> getAllAirports();

	String removeAirportById(Integer id) throws AirportNotFoundException;
	
	List<ScheduleFlightDTO> getSchedulesByAirportName(String airportName);
	
	String changeAirportDetails(AirportDTO updateAirport, Integer airportId) throws AirportNotFoundException;
	
}
