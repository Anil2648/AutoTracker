package io.egen.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;

@Entity
//@Component
//@Scope("prototype")
public class Alert {
	
	@Id
	private String alertID;
	private String vin;
	private String alertPriority;
	private String message;
	
	public Alert() {
		this.alertID = UUID.randomUUID().toString();
	}
	public String getAlertID() {
		return alertID;
	}
	public void setAlertID(String alertID) {
		this.alertID = alertID;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getAlertPriority() {
		return alertPriority;
	}
	public void setAlertPriority(String alertPriority) {
		this.alertPriority = alertPriority;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
