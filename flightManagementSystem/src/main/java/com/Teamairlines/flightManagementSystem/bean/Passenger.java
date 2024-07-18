package com.Teamairlines.flightManagementSystem.bean;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Passenger {
	@EmbeddedId
	private TicketPassengerEmbed embeddedId;
	private String passenegerName;
	private String passengerDOB;
	private Double fare;
	/**
	 * 
	 */
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Passenger(TicketPassengerEmbed embeddedId, String passenegerName,String passengerDOB, Double fare) {
		super();
		this.embeddedId = embeddedId;
		this.passenegerName = passenegerName;
		this.passengerDOB = passengerDOB;
		this.fare = fare;
	}

	public TicketPassengerEmbed getEmbeddedId() {
		return embeddedId;
	}

	public void setEmbeddedId(TicketPassengerEmbed embeddedId) {
		this.embeddedId = embeddedId;
	}

	public String getPassenegerName() {
		return passenegerName;
	}

	public void setPassenegerName(String passenegerName) {
		this.passenegerName = passenegerName;
	}

	public String getPassengerDOB() {
		return passengerDOB;
	}

	public void setPassengerDOB(String passengerDOB) {
		this.passengerDOB = passengerDOB;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "Passenger [embeddedId=" + embeddedId + ", passenegerName=" + passenegerName + ", passengerAge="
				+ passengerDOB + ", fare=" + fare + "]";
	}
	
}
