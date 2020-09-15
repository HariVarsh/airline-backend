package com.mindtree.airline.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flight_id;

	private String flight_name;
	@Column( nullable = false)
	private String source;
	@Column( nullable = false)
	private String destination;
	@Column( nullable = false)
	private Date date_of_travel;
	@Column(nullable = false)
	private Time time_of_takeOff;
	@Column( nullable = false)
	private double price;
	
	@ManyToMany
	private List<AncillaryService> serviceList;
	@ManyToMany
	private List<Food> foodList;
	
	
	public List<AncillaryService> getServiceList() {
		return serviceList;
	}
	public void setServiceList(List<AncillaryService> serviceList) {
		this.serviceList = serviceList;
	}
	public List<Food> getFoodList() {
		return foodList;
	}
	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	public String getFlight_name() {
		return flight_name;
	}
	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
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
	public Date getDate_of_travel() {
		return date_of_travel;
	}
	public void setDate_of_travel(Date date_of_travel) {
		this.date_of_travel = date_of_travel;
	}
	public Time getTime_of_takeOff() {
		return time_of_takeOff;
	}
	public void setTime_of_takeOff(Time time_of_takeOff) {
		this.time_of_takeOff = time_of_takeOff;
	}
	

	public Flight() {
		super();
	}
	public Flight(int flight_id, String flight_name, String source, String destination, Date date_of_travel,
			Time time_of_takeOff, double price, List<AncillaryService> serviceList, List<Food> foodList) {
		super();
		this.flight_id = flight_id;
		this.flight_name = flight_name;
		this.source = source;
		this.destination = destination;
		this.date_of_travel = date_of_travel;
		this.time_of_takeOff = time_of_takeOff;
		this.price = price;
		this.serviceList = serviceList;
		this.foodList = foodList;
	}
	@Override
	public String toString() {
		return "Flight [flight_id=" + flight_id + ", flight_name=" + flight_name + ", source=" + source
				+ ", destination=" + destination + ", date_of_travel=" + date_of_travel + ", time_of_takeOff="
				+ time_of_takeOff + ", price=" + price + ", serviceList=" + serviceList + ", foodList=" + foodList
				+ "]";
	}
	
	

}
