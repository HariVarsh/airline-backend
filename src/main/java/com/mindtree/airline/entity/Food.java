package com.mindtree.airline.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Food {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int food_id;
	@Column(unique = true)
	private String food_name;
	@Column(unique = true)
	private String description;
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany(mappedBy="foodList", cascade = CascadeType.ALL)
	private List<Flight> flightList;

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

//	public List<Flight> getFlightList() {
//		return flightList;
//	}

	

	

	public Food(int food_id, String food_name, String description, List<Flight> flightList) {
		super();
		this.food_id = food_id;
		this.food_name = food_name;
		this.description = description;
		this.flightList = flightList;
	}

	public Food() {
		super();
	}


	
	

}
