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

	// 1. Passengers should be able to book tickets – show the ticket cost once
	// booking is done.
	@PostMapping("/save")
	public Airline saveDetails(@RequestBody Airline airline) {
		return airlineService.saveDetails(airline);
		
	}
	// 2. Get all the details of INDI34E
	// 3. Get all the details of INDI67G
	@GetMapping("/flight/{flightName}")
	public List<Airline> getFlight(@PathVariable String flightName) {
		return airlineService.getFlightDetails(flightName);
	}
	
	// 4. Get all passenger details of INDI67G sorted by name or age.
	@GetMapping("/sort/{flightName}")
	public List<Passenger> sortByAge(@PathVariable String flightName) {
		return airlineService.sortByAge(flightName);
	}
	
	// 5. Get all passengers in a particular ticket (search with ticket id) sorted
	// by age
	@GetMapping("/getById/{ticketId}")
	public List<Passenger> searchByTicket(@PathVariable int ticketId) {
		return airlineService.searchByTicket(ticketId);
	}
	
	//6. cancel an entire journey – if ticket is cancelled within 1 hour of journey, no refund is given. If cancelled within 5 hours, 50% is refunded.
	@DeleteMapping("/deleteById/{ticketId}")
	public String deleteTicket(@PathVariable int ticketId)
	{
		return airlineService.deleteTicket(ticketId);
	}
	
	// 7. cancel partial ticket – no refund allowed.
	@DeleteMapping("/partialdelete/{passengerId}")
	public String deletePassenger(@PathVariable int passengerId)
	{
		airlineService.deletePassenger(passengerId);
		return "Successful......Sorry you are not eligible for refund";
	}
	
}
