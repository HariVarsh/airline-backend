package com.mindtree.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.airline.entity.Food;
@Repository
public interface FoodRepo extends JpaRepository<Food, Integer> {

}
