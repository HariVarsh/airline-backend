package com.mindtree.airline.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mindtree.airline.entity.AncillaryService;
import com.mindtree.airline.entity.Flight;
import com.mindtree.airline.entity.Food;
import com.mindtree.airline.entity.Passenger;
import com.mindtree.airline.exception.InvalidDataException;
import com.mindtree.airline.exception.MyApplicationException;
import com.mindtree.airline.exception.RecordAlreadyExistsException;
import com.mindtree.airline.exception.RecordNotFoundException;
import com.mindtree.airline.repository.AncillaryServiceRepo;
import com.mindtree.airline.repository.FlightRepo;
import com.mindtree.airline.repository.FoodRepo;
import com.mindtree.airline.repository.PassengerRepo;

@Service
public class AirlineService {
	@Autowired
	FlightRepo flightRepo;
	@Autowired
	AncillaryServiceRepo serviceRepo;
	@Autowired
	FoodRepo foodRepo;
	@Autowired
	PassengerRepo passengerRepo;

	public String addFlight(Flight flight) {

		Flight result = flightRepo.save(flight);
		System.out.println(result.toString());
		if (result != null) {
			return "A new flight is Added successfully";
		} else
			return "Couldnot add new Flight";

	}

	public String addService(AncillaryService service) throws MyApplicationException {
		if (serviceRepo.findAll().stream().anyMatch(i -> i.getService_name().equals(service.getService_name()))) {
			try {
				throw new RecordAlreadyExistsException("already exits");
			} catch (RecordAlreadyExistsException e) {
				throw new MyApplicationException("This service already exists");
			}
		} else {
			AncillaryService result = serviceRepo.save(service);
			if (result != null)
				return "New Service added Successfully";
			else
				return "couldn't add this Service";
		}

	}

	public String addFood(Food food) throws MyApplicationException {
		if (foodRepo.findAll().stream().anyMatch(i -> i.getFood_name().equals(food.getFood_name()))) {
			try {
				throw new RecordAlreadyExistsException("already exits");
			} catch (RecordAlreadyExistsException e) {
				throw new MyApplicationException("This food already exists");
			}
		} else {
			Food result = foodRepo.save(food);
			if (result != null)
				return "New food added Successfully";
			else
				return "couldn't add this food";
		}
	}

	public String addPassenger(Passenger passenger) {
//		Calendar london =  Calendar.getInstance(TimeZone.getTimeZone("Indian"));
		Passenger result = passengerRepo.save(passenger);
		if (result != null)
			return "New passenger added Successfully";
		else
			return "couldn't add this passenger";
	}

	public void updateService(AncillaryService service) throws MyApplicationException {
		try {
			List<AncillaryService> serviceList;
			serviceList = serviceRepo.findAll();
			List<AncillaryService> serviceId = serviceList.stream()
					.filter(i -> i.getService_id() == service.getService_id()).collect(Collectors.toList());
			System.out.println(serviceId);
			for (AncillaryService s : serviceId) {

				s.setPrice(service.getPrice());
				s.setService_id(service.getService_id());
				s.setService_name(service.getService_name());
				s.setDescription(service.getDescription());
				serviceRepo.save(s);
			}
		} catch (DataAccessException e) {
			throw new MyApplicationException("Error in updating service", e);
		}
	}

	public void updateFood(Food food) throws MyApplicationException {
		try {
			List<Food> foodList;
			foodList = foodRepo.findAll();
			List<Food> foodId = foodList.stream().filter(i -> i.getFood_id() == food.getFood_id())
					.collect(Collectors.toList());

			for (Food s : foodId) {
				s.setDescription(food.getDescription());

				s.setFood_id(food.getFood_id());
				s.setFood_name(food.getFood_name());
				foodRepo.save(s);
			}
		} catch (DataAccessException e) {
			throw new MyApplicationException("Error in updating food", e);
		}
	}

	public void updatePassenger(Passenger passenger) throws MyApplicationException {
		try {
			System.out.println("haritha" + passenger);
			List<Passenger> passList;
			passList = passengerRepo.findAll();
			List<Passenger> passId = passList.stream().filter(i -> i.getPassenger_id() == passenger.getPassenger_id())
					.collect(Collectors.toList());

			for (Passenger s : passId) {
				s.setDate_of_travel(passenger.getDate_of_travel());
				s.setDestination(passenger.getDestination());
				s.setEmail(passenger.getEmail());
				s.setExpiry_date(passenger.getExpiry_date());
				s.setFirst_name(passenger.getFirst_name());
				s.setFlight(passenger.getFlight());
				s.setFood(passenger.getFood());
				s.setGender(passenger.getGender());

				s.setLast_name(passenger.getLast_name());
				s.setMobile(passenger.getMobile());
				s.setNationality(passenger.getNationality());
				s.setPassport_number(passenger.getPassport_number());
				s.setSeat_num(passenger.getSeat_num());
				s.setServiceList(passenger.getServiceList());
				s.setSource(passenger.getSource());
				s.setStatus(passenger.getStatus());

				passengerRepo.save(s);
			}
		} catch (DataAccessException e) {
			throw new MyApplicationException("Error in updating passenger", e);
		}

	}

	public void updateFlight(Flight flight) throws MyApplicationException {
		try {

			List<Flight> flightList;
			flightList = flightRepo.findAll();
			List<Flight> flightId = flightList.stream().filter(i -> i.getFlight_id() == flight.getFlight_id())
					.collect(Collectors.toList());

			for (Flight s : flightId) {
				s.setDate_of_travel(flight.getDate_of_travel());
				s.setDestination(flight.getDestination());
				s.setFlight_name(flight.getFlight_name());
				s.setFoodList(flight.getFoodList());
				s.setPrice(flight.getPrice());
				s.setServiceList(flight.getServiceList());
				s.setSource(flight.getSource());
				s.setTime_of_takeOff(flight.getTime_of_takeOff());

				System.out.println(s);
				flightRepo.save(s);
			}
		} catch (DataAccessException e) {
			throw new MyApplicationException("Error in updating food", e);
		}

	}

	public List<Flight> getFlights(Time curr_time, Date dot) throws MyApplicationException {

		if (flightRepo.findAll().stream()
				.anyMatch(i -> i.getTime_of_takeOff().equals(curr_time) && i.getDate_of_travel().equals(dot))) {
			return flightRepo.findAll().stream()
					.filter(i -> i.getTime_of_takeOff().equals(curr_time) && i.getDate_of_travel().equals(dot))
					.collect(Collectors.toList());

		} else {
			try {
				throw new RecordNotFoundException("record not found");
			} catch (RecordNotFoundException e) {
				throw new MyApplicationException("There are no flights taking off at this schedule");
			}
		}

	}

	public List<AncillaryService> getAllAncillaryServices() {
		if (serviceRepo.findAll().size() != 0)
			return serviceRepo.findAll();
		else
			return null;
	}

	public List<Passenger> getPassByFlightId(int flight_id) throws MyApplicationException {
		System.out.println(flight_id);
		if (passengerRepo.findAll().stream().anyMatch(i -> i.getFlight().getFlight_id() == flight_id))
			return passengerRepo.findAll().stream().filter(i -> i.getFlight().getFlight_id() == flight_id)
					.collect(Collectors.toList());
		else {
			try {
				throw new RecordNotFoundException("record not found");
			} catch (RecordNotFoundException e) {
				throw new MyApplicationException("No Passengers have booked ticket in this Flight");
			}
		}
	}

	public List<Passenger> getPassByPassId(int pass_id) throws MyApplicationException {
		if (passengerRepo.findAll().stream().anyMatch(i -> i.getPassenger_id() == pass_id))
			return passengerRepo.findAll().stream().filter(i -> i.getPassenger_id() == pass_id)
					.collect(Collectors.toList());
		else {
			try {
				throw new RecordNotFoundException("record not found");
			} catch (RecordNotFoundException e) {
				throw new MyApplicationException("There no passengers with this id");
			}
		}
	}

	public List<Passenger> getPassByStatus(int flight_id) throws MyApplicationException {
		List<Passenger> passInFlight = new ArrayList<>();
		List<Passenger> passCheckedIn = new ArrayList<>();
		if (passengerRepo.findAll().stream().anyMatch(i -> i.getFlight().getFlight_id() == flight_id)) {
			passInFlight = passengerRepo.findAll().stream().filter(i -> i.getFlight().getFlight_id() == flight_id)
					.collect(Collectors.toList());
			if (passInFlight.stream().anyMatch(i -> i.getStatus().equals("checked-in")))
				passCheckedIn = passInFlight.stream().filter(i -> i.getStatus().equals("checked-in"))
						.collect(Collectors.toList());
		}
		if (passCheckedIn.size() != 0)
			return passCheckedIn;
		else {
			try {
				throw new RecordNotFoundException("record not found");
			} catch (RecordNotFoundException e) {
				throw new MyApplicationException(" no passengers are checked-in");

			}
		}
	}

	public List<Passenger> getPassByService(int flight_id, String service_name) throws MyApplicationException {
		List<Passenger> passInFlight = null;
		List<Passenger> passWithService = new ArrayList<>();
		List<AncillaryService> serviceList = null;
		List<Passenger> pList;
		if (passengerRepo.findAll().stream().anyMatch(i -> i.getFlight().getFlight_id() == flight_id)) {
			passInFlight = passengerRepo.findAll().stream().filter(i -> i.getFlight().getFlight_id() == flight_id)
					.collect(Collectors.toList());
			for (int i = 0; i < passInFlight.size(); i++) {
				serviceList = passInFlight.get(i).getServiceList();
				for (int j = 0; j < serviceList.size(); j++) {
					System.out.println(j);
					if (serviceList.get(j).getService_name().equalsIgnoreCase(service_name)) {
						System.out.println("kiii");
						passWithService.add(passInFlight.get(i));
					}

				}
			}

		} else {
			try {
				throw new RecordNotFoundException("record not found");
			} catch (

			RecordNotFoundException e) {
				throw new MyApplicationException("There is not flight with this id");

			}
		}
		if (passWithService.size() != 0)
			return passWithService;
		else {
			try {
				throw new RecordNotFoundException("record not found");
			} catch (RecordNotFoundException e) {
				throw new MyApplicationException("There no passengers in this flight with this service");

			}
		}

	}

	public List<Passenger> getPassBySeatNum(int flight_id, String seat_num) throws MyApplicationException {
		List<Passenger> passInFlight = null;
		List<Passenger> passDetails = null;
		if (passengerRepo.findAll().stream().anyMatch(i -> i.getFlight().getFlight_id() == flight_id)) {
			passInFlight = passengerRepo.findAll().stream().filter(i -> i.getFlight().getFlight_id() == flight_id)
					.collect(Collectors.toList());

			if (passInFlight.stream().anyMatch(i -> i.getSeat_num().equalsIgnoreCase(seat_num)))
				passDetails = passInFlight.stream().filter(i -> i.getSeat_num().equalsIgnoreCase(seat_num))
						.collect(Collectors.toList());

		}
		if (passDetails != null)
			return passDetails;
		else {
			try {
				throw new RecordNotFoundException("record not found");
			} catch (RecordNotFoundException e) {
				throw new MyApplicationException("This seat is not booked yet");

			}
		}
	}

	public List<AncillaryService> getServicesOfFlight(int flight_id) throws MyApplicationException {
		List<Flight> flightList;
		List<AncillaryService> serviceList;
		List<AncillaryService> sList = new ArrayList<>();
		flightList = flightRepo.findAll();

		for (int i = 0; i < flightList.size(); i++) {

			if (flightList.get(i).getFlight_id() == flight_id) {
				sList = flightList.get(i).getServiceList();
			}
		}

		if (sList.size() != 0)
			return sList;
		else {
			try {
				throw new RecordNotFoundException("record not found");
			} catch (RecordNotFoundException e) {
				throw new MyApplicationException(" this flight has no ancillary services");

			}
		}

	}

	public List<Food> getMenuOfFlight(int flight_id) throws MyApplicationException {
		List<Flight> flightList;
		List<Food> foodList;
		List<Food> fList = new ArrayList<>();
		flightList = flightRepo.findAll();

		for (int i = 0; i < flightList.size(); i++) {

			if (flightList.get(i).getFlight_id() == flight_id) {
				fList = flightList.get(i).getFoodList();
			}

		}
		if (fList.size() != 0)
			return fList;
		else {
			try {
				throw new RecordNotFoundException("record not found");
			} catch (RecordNotFoundException e) {
				throw new MyApplicationException("This flight has no food services");

			}
		}
	}

	public List<AncillaryService> getAncillaryServicesOfOnePassenger(int passId) throws MyApplicationException {
		List<AncillaryService> serviceList, sList = new ArrayList<>();
		List<Passenger> pList;
		List<Passenger> passList;

		passList = passengerRepo.findAll();
		for (int i = 0; i < passList.size(); i++) {

			if (passList.get(i).getPassenger_id() == (passId)) {
				sList = passList.get(i).getServiceList();
			}
		}

		if (sList.size() == 0)
			try {
				throw new RecordNotFoundException();
			} catch (RecordNotFoundException e) {
				throw new MyApplicationException("This passenger has no ancillary services");
			}
		else {
			return sList;

		}

	}

	public void deleteFood(int food_id) {
		foodRepo.deleteById(food_id);
	}

	public void deleteService(int service_id) {
		serviceRepo.deleteById(service_id);

	}

	public void updateSeatNum(int passenger_id, String seat_num, int flightId) throws MyApplicationException {
		if (passengerRepo.findAll().stream().anyMatch(i -> i.getPassenger_id() == (passenger_id)))
			passengerRepo.update(passenger_id, seat_num);
		else {
			try {
				throw new RecordNotFoundException("record not found");
			} catch (RecordNotFoundException e) {
				throw new MyApplicationException("This seat is not booked yet");

			}
		}
	}

	public void updateStatus(int flightId, int passenger_id, String status) throws MyApplicationException {
		if (passengerRepo.findAll().stream().anyMatch(i -> i.getPassenger_id() == (passenger_id)))
			passengerRepo.updateStatus(passenger_id, status);
		else {
			try {
				throw new RecordNotFoundException("record not found");
			} catch (RecordNotFoundException e) {
				throw new MyApplicationException("This seat is not booked yet");

			}
		}

	}

	public void updateFood(int flightId, int passenger_id, int foodId) throws MyApplicationException {
		System.out.println(passenger_id + " food" + foodId + "floght " + flightId);
		if (passengerRepo.findAll().stream().anyMatch(i -> i.getPassenger_id() == (passenger_id)))
			passengerRepo.updateFood(passenger_id, foodId);
		else {
			try {
				throw new RecordNotFoundException("record not found");
			} catch (RecordNotFoundException e) {
				throw new MyApplicationException("This seat is not booked yet");

			}
		}
		// TODO Auto-generated method stub

	}

	public List<Flight> getFlightBysrc(String src, String dest, Date dot) throws MyApplicationException {
		
		if (flightRepo.findAll().stream().anyMatch(i -> (i.getSource().equalsIgnoreCase(src))
				&& (i.getDestination().equalsIgnoreCase(dest)) && (i.getDate_of_travel().equals( dot)))) {
			return flightRepo
					.findAll().stream().filter(i -> (i.getSource().equalsIgnoreCase(src))
							&& (i.getDestination().equalsIgnoreCase(dest)) && (i.getDate_of_travel().equals(dot)))
					.collect(Collectors.toList());
		} else {
			try {
				throw new RecordNotFoundException("record not found");
			} catch (RecordNotFoundException e) {
				throw new MyApplicationException("no flights are available");

			}
		}

	}

	public List<Flight> getAllFlight() {

		if (flightRepo.findAll().size() != 0)
			return flightRepo.findAll();
		else
			return null;
	}

	public List<Food> getAllFood() {

		if (foodRepo.findAll().size() != 0)
			return foodRepo.findAll();
		else
			return null;
	}

	public List<Flight> getFlightById(int id) {
		if (flightRepo.findAll().size() != 0) {
			return flightRepo.findAll().stream().filter(i -> i.getFlight_id() == id).collect(Collectors.toList());
		} else
			return null;
	}

}