package com.Task.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	private Date boardingDateTime;
	private Date departureDateTime;
	private int totalCost;
	private String source;
	private String destination;
	private String journeyTime;
	private String flightClass;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "tId",referencedColumnName="ticketId",nullable = false)
	private List<Passenger> passenger;

	public Ticket() {
		super();

	}

	public Ticket(int ticketId, Date boardingDateTime, Date departureDateTime, int totalCost, String source,
			String destination, String journeyTime, String flightClass, List<Passenger> passenger) {
		super();
		this.ticketId = ticketId;
		this.boardingDateTime = boardingDateTime;
		this.departureDateTime = departureDateTime;
		this.totalCost = totalCost;
		this.source = source;
		this.destination = destination;
		this.journeyTime = journeyTime;
		this.flightClass = flightClass;
		this.passenger = passenger;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public Date getBoardingDateTime() {
		return boardingDateTime;
	}

	public void setBoardingDateTime(Date boardingDateTime) {
		this.boardingDateTime = boardingDateTime;
	}

	public Date getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(Date departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getJourneyTime() {
		return journeyTime;
	}

	public void setJourneyTime(String journeyTime) {
		this.journeyTime = journeyTime;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", boardingDateTime=" + boardingDateTime + ", departureDateTime="
				+ departureDateTime + ", totalCost=" + totalCost + ", source=" + source + ", destination=" + destination
				+ ", journeyTime=" + journeyTime + ", flightClass=" + flightClass + ", passenger=" + passenger + "]";
	}
	

	
	
}
