package io.egen.repository;

//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import io.egen.entity.Alert;
import io.egen.entity.Vehicle;
import io.egen.entity.VehicleReading;

@Repository


public class VehicleRepositoryImpl implements VehicleRepository {

	
	@PersistenceContext
	private EntityManager em;
	@Override
	public  void insertVehicles(Vehicle[] vehicles) {
		// TODO Auto-generated method stub
		
		for (Vehicle vehicle : vehicles){
			

			em.merge(vehicle);
		}
	}


	@Override
	public VehicleReading insertReading(VehicleReading vehicleReading) {
		em.persist(vehicleReading);
		
	
		return vehicleReading;
		
	}


	@Override
	public Vehicle findVehicle(String vin) {
		return em.find(Vehicle.class, vin);
	}


	@Override
	public Alert saveAlert(Alert alert) {
		// TODO Auto-generated method stub
		em.persist(alert);
		
		return alert;
	}


}
