package io.egen.repository;



import org.springframework.stereotype.Repository;

import io.egen.entity.Alert;
import io.egen.entity.Vehicle;
import io.egen.entity.VehicleReading;

@Repository
public interface VehicleRepository {

	void insertVehicles(Vehicle [] vehicles);
	//void insertVehicles(Vehicle  vehicles);
	  VehicleReading insertReading(VehicleReading vehicleReading);
	  Vehicle findVehicle(String vin);
	  Alert saveAlert(Alert alert);
}
