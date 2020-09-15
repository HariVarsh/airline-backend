package com.mindtree.airline.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.airline.entity.Passenger;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Integer> {
	@Transactional
	@Modifying
	@Query("update Passenger set seat_num=?2 where passenger_id=?1")
	void update(int passenger_id, String seat_num);
	
	
	
	@Transactional
	@Modifying
	@Query("update Passenger set status=?2 where passenger_id=?1")
	void updateStatus(int passenger_id, String status);


	@Transactional
	@Modifying
	@Query("update Passenger set food_id=?2 where passenger_id=?1")
	void updateFood(int passenger_id, int foodId);
	
}
