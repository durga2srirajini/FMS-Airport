package com.fms.airport.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fms.airport.DTO.AirportDTO;
import com.fms.airport.DTO.ScheduleFlightDTO;
import com.fms.airport.entity.Airport;
import com.fms.airport.exception.AirportAlreadyExistsException;
import com.fms.airport.exception.AirportNotFoundException;
import com.fms.airport.repository.AirportRepository;

import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;

@Service
public class AirportServiceImpl implements AirportService{

	@Autowired
	private AirportRepository airportRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private WebClient webclient;
	
	@Override
	public String  addAirport(AirportDTO newAirportDTO){
		
		Airport airport = modelMapper.map(newAirportDTO, Airport.class);
		
		airportRepository.save(airport);
		
		return "new Airport successfully added";
	}
	

	@Override
	public AirportDTO getAirportById(Integer id) throws AirportNotFoundException {
		Optional<Airport> optAirport = this.airportRepository.findByAirportId(id);
		if(optAirport.isEmpty()) {
			throw new AirportNotFoundException("Airport doesn't exist for given id");
		}
		Airport airport = optAirport.get();
		
		return modelMapper.map(airport, AirportDTO.class);
		
	}
	

	@Override
	public List<AirportDTO> getAllAirports() {
		List<Airport> airport = airportRepository.findAll();

		List<AirportDTO> airportDTO = airport.stream()
				.map(list -> modelMapper
				.map(list, AirportDTO.class))
				.collect(Collectors.toList());

		return airportDTO;
		
		
	}




	@Override
	public String removeAirportById(Integer id) throws AirportNotFoundException {
		Optional<Airport> optAirport = this.airportRepository.findByAirportId(id);
		if(optAirport == null) {
			throw new AirportNotFoundException("Airport doesn't exist for given id");
		}
		Airport airport = optAirport.get();
		airportRepository.delete(airport);
		
		
		return "Airport deleted successfully";
	}
	
	
 

	@Override
	public List<ScheduleFlightDTO> getSchedulesByAirportName(String airportName) {
		Mono<ScheduleFlightDTO[]> response = webclient.get().uri("http://localhost:8093/api/scheduleFlight/schedules")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(ScheduleFlightDTO[].class)
				.log();

		ScheduleFlightDTO[] scheduleFlights = response.block();

		return Arrays.stream(scheduleFlights).filter(s -> (s.getSourceAirport()).equals(airportName))
				.collect(Collectors.toList());
		
	}


	@Override
	public String changeAirportDetails(AirportDTO updateAiport, Integer airportId) throws AirportNotFoundException{
		
			Optional<Airport> optAirport = this.airportRepository.findByAirportId(airportId);
			if(optAirport.isEmpty()) {
				throw new AirportNotFoundException("Airport doesn't exist for given id");
			}
			Airport airport = modelMapper.map(updateAiport, Airport.class);
			airport.setAirportId(airportId);
			airport.setAirportName(updateAiport.getAirportName());
			airport.setAirportLocation(updateAiport.getAirportLocation());
	
			airportRepository.save(airport);
			
			return "Airport updated successfully";
			
	
			
		}
	

}
