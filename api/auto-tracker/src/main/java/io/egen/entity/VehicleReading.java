package io.egen.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;




@Entity
public class VehicleReading {
	
	@Id
	private String readingId;
	private String vin;
	private double latitude;
	private double longitude;
	private Date timestamp;
	private double fuelVolume;
	private int speed;
	private int engineHp;
	private boolean checkEngineLightOn;
	private boolean engineCoolantLow;
	private boolean cruiseControlOn;
	private int engineRpm;
	

	@OneToOne(cascade = { CascadeType.ALL })
	private Tires tires;
	
	
    public VehicleReading() {
    	
    	DateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		 Date date = new Date();
		 
		 
		 String date1 = dateFormat.format(date);
		 this.readingId = UUID.randomUUID().toString().concat(date1);
    }
	public String getReadingId() {
		return readingId;
	}
	public void setReadingId(String readingId) {
		this.readingId = readingId;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		
		this.vin = vin;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

		try {
			this.timestamp = date.parse(timestamp);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	public double getFuelVolume() {
		return fuelVolume;
	}
	public void setFuelVolume(double fuelVolume) {
		this.fuelVolume = fuelVolume;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getEngineHp() {
		return engineHp;
	}
	public void setEngineHp(int engineHp) {
		this.engineHp = engineHp;
	}
	public boolean isCheckEngineLightOn() {
		return checkEngineLightOn;
	}
	public void setCheckEngineLightOn(boolean checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}
	public boolean isEngineCoolantLow() {
		return engineCoolantLow;
	}
	public void setEngineCoolantLow(boolean engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}
	public boolean isCruiseControlOn() {
		return cruiseControlOn;
	}
	public void setCruiseControlOn(boolean cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}
	public int getEngineRpm() {
		return engineRpm;
	}
	public void setEngineRpm(int engineRpm) {
		
		this.engineRpm = engineRpm;
	}
	public Tires getTires() {
		return tires;
	}
	public void setTires(Tires tires) {
		this.tires = tires;
	}
}
