package com.mindtree.airline.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int passenger_id;
	@Column(nullable = false)
	private String first_name;
	@Column(nullable = false)
	private String last_name;
	@Column( nullable = false)
	private String email;
	@Column( nullable = false, length = 10)
	private long mobile;
	@Column(nullable = false)
	private String gender;

	@Column( nullable = false, length = 15)
	private String passport_number;
	@Column(nullable = false)
	private String nationality;
	@Column(nullable = false)
	private Date expiry_date;

	@Column(nullable = false)
	private String status;
	@Column(nullable = false)
	private String seat_num;
	@Column(nullable = false)
	private String source;
	@Column(nullable = false)
	private String destination;
	@Column(nullable = false)
	private Date date_of_travel;
	
	@ManyToMany
	private List<AncillaryService> serviceList;
	
	@OneToOne
	@JoinColumn(name="food_id")
	Food food;

	@OneToOne
	@JoinColumn(name="flight_id")
	Flight flight;

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassport_number() {
		return passport_number;
	}

	public void setPassport_number(String passport_number) {
		this.passport_number = passport_number;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeat_num() {
		return seat_num;
	}

	public void setSeat_num(String seat_num) {
		this.seat_num = seat_num;
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

	public List<AncillaryService> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<AncillaryService> serviceList) {
		this.serviceList = serviceList;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	

	

	public Passenger(int passenger_id, String first_name, String last_name, String email, long mobile, String gender,
			String passport_number, String nationality, Date expiry_date, String status, String seat_num, String source,
			String destination, Date date_of_travel, List<AncillaryService> serviceList, Food food, Flight flight) {
		super();
		this.passenger_id = passenger_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.passport_number = passport_number;
		this.nationality = nationality;
		this.expiry_date = expiry_date;
		this.status = status;
		this.seat_num = seat_num;
		this.source = source;
		this.destination = destination;
		this.date_of_travel = date_of_travel;
		this.serviceList = serviceList;
		this.food = food;
		this.flight = flight;
	}

	



	@Override
	public String toString() {
		return "Passenger [passenger_id=" + passenger_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", mobile=" + mobile + ", gender=" + gender + ", passport_number="
				+ passport_number + ", nationality=" + nationality + ", expiry_date=" + expiry_date + ", status="
				+ status + ", seat_num=" + seat_num + ", source=" + source + ", destination=" + destination
				+ ", date_of_travel=" + date_of_travel + ", serviceList=" + serviceList + ", food=" + food + ", flight="
				+ flight + "]";
	}

	public Passenger() {
		super();
	}


	
	
	
	

}
