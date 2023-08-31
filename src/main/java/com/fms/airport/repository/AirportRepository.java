package com.fms.airport.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.airport.entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer>{

	Optional<Airport> findByAirportId(Integer airportId);
	
	Optional<Airport>  findByAirportName(String airportName);
	

	
	
}
