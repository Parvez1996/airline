package com.Task.service;

import java.util.Comparator;
import com.Task.model.Passenger;

public class ServiceComparator implements Comparator<Passenger>{

	@Override
	public int compare(Passenger o1, Passenger o2) {
		Integer age1=o1.getPassengerAge();
		Integer age2=o2.getPassengerAge();
		return age1.compareTo(age2);
	}

}
