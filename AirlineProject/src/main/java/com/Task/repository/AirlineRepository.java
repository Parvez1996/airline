package com.Task.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Task.model.Airline;
import com.Task.model.Passenger;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> {
	
	public List<Airline> findByFlightName(String flightName);

	
	
}
