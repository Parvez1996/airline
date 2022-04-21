package com.Task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Task.model.Airline;
import com.Task.model.Passenger;
import com.Task.service.AirlineService;

@RestController
@RequestMapping("/airline")
public class AirlineController {

	@Autowired
	private AirlineService airlineService;

	@PostMapping("/save")
	public Airline saveDetails(@RequestBody Airline airline) {
		return airlineService.saveDetails(airline);
	}
	
	@GetMapping("/flight/{flightName}")
	public List<Airline> getFlight(@PathVariable String flightName) {
		return airlineService.getFlightDetails(flightName);
	}
	
	@GetMapping("/sort")
	public List<Passenger> getFlight() {
		return airlineService.sortByAge();
	}
	@GetMapping("/getById/{tId}")
	public List<Passenger> searchByTicket(@PathVariable int tId) {
		return airlineService.searchByTicket(tId);
	}
	
	@DeleteMapping("/delete/{tId}/{passengerName}")
	public String deletePassenger(@PathVariable int tId,@PathVariable String passengerName)
	{
		airlineService.deletePassenger(tId,passengerName);
		return "Deleted successfully......But you are not eligible for refund";
	}
	
	@DeleteMapping("/deleteById/{tId}")
	public String deleteTicket(@PathVariable int tId)
	{
		return airlineService.deleteTicket(tId);
	}

}
