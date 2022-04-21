package com.Task.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Task.model.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> 
{
	@Transactional
	@Modifying
	@Query(value="delete from passenger where t_id=? AND passenger_name=?", nativeQuery=true)
	public void deletePassenger(int tId, String passengerName);
}
