package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import io.egen.entity.Vehicle;
import io.egen.entity.VehicleReading;
import io.egen.services.VehicleService;

@RestController
@RequestMapping(value = "vehicles")
public class VehicleController {
	

	@Autowired 
	private VehicleService vehicleService;
	
//	@RequestMapping(method = RequestMethod.GET)
//	public List <Vehicle>  find() {
//		System.out.println("I am getting hit");
//		return null;
//		
//	}

	@RequestMapping(method = RequestMethod.PUT)
	public void create(@RequestBody Vehicle[] vehicles) {
//		System.out.println("I am getting hit in put");
		 vehicleService.insertVehicles(vehicles);
		
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public void insertReadings(@RequestBody VehicleReading vehicleReading) {
		
		vehicleService.insertReading(vehicleReading);
	}
}
