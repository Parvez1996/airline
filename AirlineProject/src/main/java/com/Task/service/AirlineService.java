package com.Task.service;

import java.util.List;
import com.Task.model.Airline;
import com.Task.model.Passenger;
import com.Task.model.Ticket;

public interface AirlineService {
	public Airline saveDetails(Airline airline);
	List<Airline> getFlightDetails(String flightName);
	List<Passenger> sortByAge(String flightName);
	List<Passenger> searchByTicket(int ticketId);
	public String deleteTicket(int tId);
	public void deletePassenger(int passengerId);
	
	
}
