package com.mindtree.airline.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.airline.entity.AncillaryService;
import com.mindtree.airline.entity.Flight;
import com.mindtree.airline.entity.Food;
import com.mindtree.airline.entity.Passenger;
import com.mindtree.airline.exception.MyApplicationException;
import com.mindtree.airline.service.AirlineService;

@RestController
@CrossOrigin("*")
@RequestMapping("/airline")
public class HomeController {
	@Autowired
	AirlineService airlineService;
@GetMapping("")
public String get() {
	return "Hi";
}
	
	// adding flight
	@PostMapping("/addFlight")
	public ResponseEntity<?> addNewFlight(@RequestBody Flight flight) {

		HashMap<String, Object> result = new HashMap<>();
		result.put("status", HttpStatus.OK);
		result.put("body", "success");
		result.put("output", airlineService.addFlight(flight));
		return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);

	}

	// adding ancillary service
	@PostMapping("/addService")
	public ResponseEntity<?> addNewService(@RequestBody AncillaryService service) {
		HashMap<String, Object> result = new HashMap<>();
		try {

			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			result.put("output", airlineService.addService(service));
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}
	}

	// add food
	@PostMapping("/addFood")
	public ResponseEntity<?> addNewFood(@RequestBody Food food) {
		HashMap<String, Object> result = new HashMap<>();
		try {

			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			result.put("output", airlineService.addFood(food));
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}
	}

	// add passanger
	@PostMapping("/addPassenger")
	public ResponseEntity<?> addNewpassenger(@RequestBody Passenger passenger) {
		HashMap<String, Object> result = new HashMap<>();
		result.put("status", HttpStatus.OK);
		result.put("body", "success");
		result.put("output", airlineService.addPassenger(passenger));
		return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);

	}

	// get flights by time and date
	@GetMapping("/getCurrentFlights/{curr_time}/{dot}")
	public ResponseEntity<?> getCurrentFlights(@PathVariable("curr_time") Time curr_time,@PathVariable("dot") Date dot) {
		HashMap<String, Object> result = new HashMap<>();
		try {
			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			result.put("output", airlineService.getFlights(curr_time,dot));
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}
	}

	// get all ancillary services
	@GetMapping("/getAllAncillaryServices")
	public ResponseEntity<?> getAllAncillaryServices() {
		HashMap<String, Object> result = new HashMap<>();
		result.put("status", HttpStatus.OK);
		result.put("body", "success");
		result.put("output", airlineService.getAllAncillaryServices());
		return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);

	}
	
	//get all food
	@GetMapping("/getAllFood")
	public ResponseEntity<?> getAllFood() {
		HashMap<String, Object> result = new HashMap<>();
		result.put("status", HttpStatus.OK);
		result.put("body", "success");
		result.put("output", airlineService.getAllFood());
		return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);

	}
	

	// get ancillary details of a particular passenger
	@GetMapping("/getServicesOfOnePassenger/{passId}")
	public ResponseEntity<?> getAncillaryServicesOfOnePassenger(@PathVariable("passId") int passId) {
		HashMap<String, Object> result = new HashMap<>();
		try {
			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			result.put("output", airlineService.getAncillaryServicesOfOnePassenger(passId));
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}
	}

	// get ancillary services of a flight
	@GetMapping("/getServicesOfFlight/{flight_id}")
	public ResponseEntity<?> getServicesOfFlight(@PathVariable("flight_id") int flight_id) {
		HashMap<String, Object> result = new HashMap<>();
		try {
			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			result.put("output", airlineService.getServicesOfFlight(flight_id));
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}
	}

	// get passengers by flight_id
	@GetMapping("/getPassByFlightId/{flight_id}")
	public ResponseEntity<?> getPassByFlightId(@PathVariable("flight_id") int flight_id) {
		HashMap<String, Object> result = new HashMap<>();
		try {
			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			result.put("output", airlineService.getPassByFlightId(flight_id));
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}
	}

	// get passenger by id
	@GetMapping("/getPassByPassId/{pass_id}")
	public ResponseEntity<?> getPassByPassId(@PathVariable("pass_id") int pass_id) {
		HashMap<String, Object> result = new HashMap<>();
		try {
			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			result.put("output", airlineService.getPassByPassId(pass_id));
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}
	}

	// get passenger by check-in status
	@GetMapping("/getChecked-inPassengers/{flight_id}")
	public ResponseEntity<?> getPassByStatus(@PathVariable("flight_id") int flight_id) {
		HashMap<String, Object> result = new HashMap<>();
		try {
			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			result.put("output", airlineService.getPassByStatus(flight_id));
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}
	}

	// get passenger by ancillary service
	@GetMapping("/getPassByService/{flight_id}/{service_name}")
	public ResponseEntity<?> getPassByService(@PathVariable("flight_id") int flight_id,
			@PathVariable("service_name") String service_name) {
		HashMap<String, Object> result = new HashMap<>();
		try {
			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			result.put("output", airlineService.getPassByService(flight_id, service_name));
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}
	}

	// get passenger by seat num
	@GetMapping("/getPassBySeatNum/{flight_id}/{seat_num}")
	public ResponseEntity<?> getPassBySeatNum(@PathVariable("flight_id") int flight_id,
			@PathVariable("seat_num") String seat_num) {
		HashMap<String, Object> result = new HashMap<>();
		try {
			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			result.put("output", airlineService.getPassBySeatNum(flight_id, seat_num));
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}
	}

	// get food of the flight
	@GetMapping("/getMenuOfFlight/{flight_id}")
	public ResponseEntity<?> getMenuOfFlight(@PathVariable("flight_id") int flight_id) {
		HashMap<String, Object> result = new HashMap<>();
		try {
			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			result.put("output", airlineService.getMenuOfFlight(flight_id));
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}
	}

	// delete a food
	@DeleteMapping("/deleteFood/{food_id}")
	public ResponseEntity<?> deleteFood(@PathVariable("food_id") int food_id) {
		airlineService.deleteFood(food_id);
		HashMap<String, Object> result = new HashMap<>();
		result.put("status", HttpStatus.OK);
		result.put("body", "success");
		return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
	}

	// delete a ancillary service
	@DeleteMapping("/deleteService/{service_id}")
	public ResponseEntity<?> deleteService(@PathVariable("service_id") int service_id) {
		airlineService.deleteService(service_id);
		HashMap<String, Object> result = new HashMap<>();
		result.put("status", HttpStatus.OK);
		result.put("body", "success");
		return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
	}

	// update seat numb of a passenger
	@PutMapping("/updateSeatNum/{flightId}/{passenger_id}/{seat_num}")
	public ResponseEntity<?> updateSeatNum(@PathVariable("passenger_id") int passenger_id,
			@PathVariable("seat_num") String seat_num, @PathVariable("flightId") int flightId) {
		HashMap<String, Object> result = new HashMap<>();
		try {
			airlineService.updateSeatNum(passenger_id, seat_num,flightId);
			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}
	}

	// update status
	@PutMapping("/updateStatus/{flightId}/{passenger_id}/{status}")
	public ResponseEntity<?> updateStatus(@PathVariable("passenger_id") int passenger_id,
			@PathVariable("status") String status, @PathVariable("flightId") int flightId) {
		HashMap<String, Object> result = new HashMap<>();
		try {
			airlineService.updateStatus(flightId,passenger_id,status);
			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}
	}

	// food for a passenger
	@PutMapping("/updateFood/{flightId}/{passenger_id}/{foodId}")
	public ResponseEntity<?> updateFood(@PathVariable("passenger_id") int passenger_id, @PathVariable("foodId") int foodId,
			@PathVariable("flightId") int flightId) {
		HashMap<String, Object> result = new HashMap<>();
		try {
			airlineService.updateFood(flightId,passenger_id,foodId);
			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}
	}

	// put ancillary service
	@PutMapping("/updateService")
	public ResponseEntity<?> updateService(@RequestBody AncillaryService service) {
		HashMap<String, Object> result = new HashMap<>();
		try {
			airlineService.updateService(service);
			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}

	}

	// put food
	@PutMapping("/updateFood")
	public ResponseEntity<?> updateFood(@RequestBody Food food) {
		HashMap<String, Object> result = new HashMap<>();
		try {
			airlineService.updateFood(food);
			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}

	}

	// get flight by source dest date of travel
	@GetMapping("/getFlightsBySrcDest/{src}/{dest}/{dot}")
	public ResponseEntity<?> getFlightBysrc(@PathVariable("src") String src, @PathVariable("dest") String dest,
			@PathVariable("dot") Date dot) {
		HashMap<String, Object> result = new HashMap<>();
		try {
			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			result.put("output", airlineService.getFlightBysrc(src,dest,dot));
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}
	}

	// put passenger details
	@PutMapping("/updatePasseneger")
	public ResponseEntity<?> updatePassenger(@RequestBody Passenger passenger) {
		HashMap<String, Object> result = new HashMap<>();
		try {
			airlineService.updatePassenger(passenger);
			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}

	}

	// put flight details
	@PutMapping("/updateFlight")
	public ResponseEntity<?> updateFlight(@RequestBody Flight flight) {
		HashMap<String, Object> result = new HashMap<>();
		try {
			airlineService.updateFlight(flight);
			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		} catch (MyApplicationException e) {
			result.put("status", HttpStatus.OK);
			result.put("exception", e.getMessage());
			result.put("cause", e.getCause());// doubt
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
		}

	}
//	// get all flights
		@GetMapping("/getAllFlights")
		public ResponseEntity<?> getAllFlights() {
			HashMap<String, Object> result = new HashMap<>();
			result.put("status", HttpStatus.OK);
			result.put("body", "success");
			result.put("output", airlineService.getAllFlight());
			return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);

		}
		
		//get flight by flight id
		@GetMapping("/getFlightByFlightId/{id}")
		public ResponseEntity<?> getFlightById(@PathVariable("id") int id) {
			HashMap<String, Object> result = new HashMap<>();
			
				result.put("status", HttpStatus.OK);
				result.put("body", "success");
				result.put("output", airlineService.getFlightById(id));
				return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK)).body(result);
			
		}


}
