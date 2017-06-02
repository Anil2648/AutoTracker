package io.egen.services;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.entity.Alert;
import io.egen.entity.Vehicle;
import io.egen.entity.VehicleReading;
import io.egen.exception.BadRequestException;
import io.egen.exception.NotFoundException;
import io.egen.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	private Alert alert;

	@Override
	@Transactional
	public void insertVehicles(Vehicle[] vehicles) {
		// TODO Auto-generated method stub
		vehicleRepository.insertVehicles(vehicles);
	}

	@Override
	@Transactional
	public VehicleReading insertReading(VehicleReading vehicleReading) {

		VehicleReading reading = new VehicleReading();
		reading = vehicleRepository.insertReading(vehicleReading);
		if (vehicleRepository.findVehicle(vehicleReading.getVin()) == null) {
			throw new NotFoundException("Vehicle with id=" + vehicleReading.getVin() + "is not found");
		}

//		 if (reading.getTimestamp() ) {
//	            throw new BadRequestException("Employee with email=" + emp.getEmail() + " already exists.");
//	        }
		 DateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		 Date date = new Date();
		 
		 
		 String date1 = dateFormat.format(date);
		 String date2 = dateFormat.format(reading.getTimestamp());
		 
		 System.out.println(date1.substring(0, 10) == date2.substring(0, 10));
		 
		 System.out.println(date1.substring(0, 10));
		 System.out.println(date2.substring(0, 10));
		Vehicle vehicle = vehicleRepository.findVehicle(reading.getVin());
		
		if (reading.getEngineRpm() > vehicle.getRedlineRpm()) {

			// alert.setAlertID(UUID.randomUUID().toString());
			alert = new Alert();
			alert.setAlertPriority("HIGH");
			alert.setMessage("Engine RPM is > Red line RPM");
			alert.setVin(reading.getVin());
			vehicleRepository.saveAlert(alert);

		}

		if (reading.getFuelVolume() < (vehicle.getMaxFuelVolume() * 0.1)) {
			alert = new Alert();
			// alert.setAlertID(UUID.randomUUID().toString());
			alert.setAlertPriority("MEDIUM");
			alert.setMessage("Fuel volume is low");
			alert.setVin(reading.getVin());
			vehicleRepository.saveAlert(alert);

		}
		if (reading.isEngineCoolantLow() || reading.isCheckEngineLightOn()) {
			alert = new Alert();
			// alert.setAlertID(UUID.randomUUID().toString());
			alert.setAlertPriority("LOW");
			alert.setMessage("Engine collant is low or engine loght is on");
			alert.setVin(reading.getVin());
			vehicleRepository.saveAlert(alert);
		}

		if (reading.getTires().getFrontLeft() < 32 || (reading.getTires().getFrontLeft() > 36)) {
			alert = new Alert();
			// alert.setAlertID(UUID.randomUUID().toString());
			alert.setAlertPriority("LOW");
			if (reading.getTires().getFrontLeft() < 32) {
				alert.setMessage("Tire pressure is < 32 PSI");
			} else {
				alert.setMessage("Tire pressure is > 36 PSI");
			}

			alert.setVin(reading.getVin());
			vehicleRepository.saveAlert(alert);

		}
		if (reading.getTires().getFrontRight() < 32 || (reading.getTires().getFrontRight() > 36)) {
			alert = new Alert();
			
			alert.setAlertPriority("LOW");
			if (reading.getTires().getFrontLeft() < 32) {
				alert.setMessage("Tire pressure is < 32 PSI");
			} else {
				alert.setMessage("Tire pressure is > 36 PSI");
			}
			alert.setVin(reading.getVin());
			vehicleRepository.saveAlert(alert);

		}
		if (reading.getTires().getRearLeft() < 32 || (reading.getTires().getRearLeft() > 36)) {
			alert = new Alert();
			// alert.setAlertID(UUID.randomUUID().toString());
			alert.setAlertPriority("LOW");
			if (reading.getTires().getFrontLeft() < 32) {
				alert.setMessage("Tire pressure is < 32 PSI");
			} else {
				alert.setMessage("Tire pressure is > 36 PSI");
			}
			alert.setVin(reading.getVin());
			vehicleRepository.saveAlert(alert);
		}
		if (reading.getTires().getRearRight() < 32 || (reading.getTires().getRearRight() > 36)) {
			alert = new Alert();
			// alert.setAlertID(UUID.randomUUID().toString());
			alert.setAlertPriority("LOW");
			if (reading.getTires().getFrontLeft() < 32) {
				alert.setMessage("Tire pressure is < 32 PSI");
			} else {
				alert.setMessage("Tire pressure is > 36 PSI");
			}
			alert.setVin(reading.getVin());
			vehicleRepository.saveAlert(alert);
		}

		return reading;

	}

	

}
