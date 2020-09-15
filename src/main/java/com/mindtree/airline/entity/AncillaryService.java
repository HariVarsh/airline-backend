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
public class AncillaryService {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int service_id;
	@Column(unique = true)
	private String service_name;
	@Column(unique = true)
	private String description;
	private double price;
	
	@ManyToMany(mappedBy="serviceList",cascade = CascadeType.ALL )
	private List<Flight> flightList;
	
	
	@ManyToMany(mappedBy="serviceList",cascade = CascadeType.ALL)
	private List<Passenger> passengerList;


	public int getService_id() {
		return service_id;
	}


	public void setService_id(int service_id) {
		this.service_id = service_id;
	}


	public String getService_name() {
		return service_name;
	}


	public void setService_name(String service_name) {
		this.service_name = service_name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


//	public List<Flight> getFlightList() {
//		return flightList;
//	}
//
//
//	public void setFlightList(List<Flight> flightList) {
//		this.flightList = flightList;
//	}
//
//
//	public List<Passenger> getPassengerList() {
//		return passengerList;
//	}
//
//
//	public void setPassengerList(List<Passenger> passengerList) {
//		this.passengerList = passengerList;
//	}


	public AncillaryService() {
		super();
	}


	public AncillaryService(int service_id, String service_name, String description, double price,
			List<Flight> flightList, List<Passenger> passengerList) {
		super();
		this.service_id = service_id;
		this.service_name = service_name;
		this.description = description;
		this.price = price;
		this.flightList = flightList;
		this.passengerList = passengerList;
	}


	@Override
	public String toString() {
		return "AncillaryService [service_name=" + service_name + "]";
	}



	
	
}
