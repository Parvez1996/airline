package com.Task.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String passengerName;
	private int passengerAge;
	private String passengerQualification;
	private String passengerGender;

	public Passenger() {

	}

	public Passenger(int id, String passengerName, int passengerAge, String passengerQualification,
			String passengerGender) {
		super();
		this.id = id;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerQualification = passengerQualification;
		this.passengerGender = passengerGender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}

	public String getPassengerQualification() {
		return passengerQualification;
	}

	public void setPassengerQualification(String passengerQualification) {
		this.passengerQualification = passengerQualification;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

}
