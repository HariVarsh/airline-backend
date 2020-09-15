package com.mindtree.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.airline.entity.Flight;
@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer> {

}
