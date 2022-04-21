package com.Task.service;

import java.util.List;
import com.Task.model.Airline;
import com.Task.model.Passenger;
import com.Task.model.Ticket;

public interface AirlineService {
	public Airline saveDetails(Airline airline);
	List<Airline> getFlightDetails(String flightName);
	List<Passenger> sortByAge();
	List<Passenger> searchByTicket(int tId);
	public void deletePassenger(int tId, String passengerName);
	public String deleteTicket(int tId);
}
