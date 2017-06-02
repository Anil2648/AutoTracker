package io.egen.services;

import java.util.List;

import io.egen.entity.Vehicle;
import io.egen.entity.VehicleReading;

public interface VehicleService {
	
	  void insertVehicles(Vehicle [] vehicles);
	 // void insertVehicles(Vehicle  vehicles);
	  VehicleReading insertReading(VehicleReading vehicleReading);

}
