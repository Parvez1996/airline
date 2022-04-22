package com.Task.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Task.model.Airline;
import com.Task.model.Passenger;
import com.Task.model.Ticket;
import com.Task.repository.AirlineRepository;
import com.Task.repository.PassengerRepository;
import com.Task.repository.TicketRepository;

@Service
public class AirlineServiceImpl implements AirlineService {
	@Autowired
	private AirlineRepository repo;

	@Autowired
	private PassengerRepository passenger;

	@Autowired
	private TicketRepository ticket;

	List<Ticket> tick = new ArrayList<>();

	// 1. Passengers should be able to book tickets – show the ticket cost once
	// booking is done.
	@Override
	public Airline saveDetails(Airline airline) {
		return repo.save(airline);
	}

	// 2. Get all the details of INDI34E
	// 3. Get all the details of INDI67G
	@Override
	public List<Airline> getFlightDetails(String flightName) {
		List<Airline> list = repo.findAll();
		List<Airline> list2 = list.stream().filter(i -> i.getFlightName().contains(flightName))
				.collect(Collectors.toList());

		for (Airline a : list2) {
			tick.addAll(a.getTicket());
		}
		// changes .

		return list2;
	}

	// 4. Get all passenger details of INDI67G sorted by name or age.
	@Override
	public List<Passenger> sortByAge(String flightName) 
	{

		List<Airline> a=repo.findByFlightName(flightName);
		List<Ticket> ticket =new ArrayList<>();
		
		for(Airline air:a)
		{
			ticket.addAll(air.getTicket());
		}
		List<Passenger> p=new ArrayList<>();
		for(Ticket tic:ticket)
		{
			p.addAll(tic.getPassenger());
		}
		Collections.sort(p, new ServiceComparator());
		
		return p;
	}

	// 5. Get all passengers in a particular ticket (search with ticket id) sorted
	// by age
	@Override
	public List<Passenger> searchByTicket(int ticketId) {
		List<Ticket> t = new ArrayList<>();
		Ticket tick = ticket.getById(ticketId);
		List<Passenger> p1 = tick.getPassenger();
		Collections.sort(p1, new ServiceComparator());
		return p1;
	}

	//6. cancel an entire journey – if ticket is cancelled within 1 hour of journey, no refund is given. If cancelled within 5 hours, 50% is refunded.
	@Override
	public String deleteTicket(int ticketId) {
		Ticket t = ticket.getById(ticketId);
		Date date1 = t.getBoardingDateTime();
		Date date2 = new Date();
		//System.out.println(date1.getHours());
		long diffInMillies = date1.getTime() - date2.getTime();
		long days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		int hours = (int) ((diffInMillies / (1000 * 60 * 60)) % 24);
		//Cost printing code
		List<Ticket> t1=new ArrayList<>();
		Ticket tick=ticket.getById(ticketId);
		List<Passenger> p2=tick.getPassenger();
		int totalPassenger=p2.size();
		int refund=tick.getTotalCost()*totalPassenger;
		System.out.println("totalpass"+ totalPassenger);

		//ticket.deleteById(ticketId);
		
		if (days >= 0 && hours>=0) {

			if (hours <1 && days == 0) {
				return "Ticket Cancelled...";
			} else if (hours < 5 && hours >= 1 && days <= 0) {
				return "Ticket Cancelled...You will get 50% refund of Rs."+refund/2;
			} else {
				return "Ticket Cancelled...Your will get full refund of Rs."+refund;
			}
		} else {
			return "Ticket Expired....You cannot cancel the tickets";
		}
	}
	
	// 7. cancel partial ticket – no refund allowed.
	@Override
	public void deletePassenger(int passengerId) {
		passenger.deletePassenger(passengerId);

	}


}






















