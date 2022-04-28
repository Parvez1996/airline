package com.Task.model;

import java.io.Serializable;
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
public class Airline implements Serializable {
	@Id
	private int flightId;
	private String flightName;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fid", referencedColumnName = "flightId", nullable = false)
	private List<Ticket> ticket;

	public Airline() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Airline(int flightId, String flightName, List<Ticket> ticket) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.ticket = ticket;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public List<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Airline [flightId=" + flightId + ", flightName=" + flightName + ", ticket=" + ticket + "]";
	}
	

}
