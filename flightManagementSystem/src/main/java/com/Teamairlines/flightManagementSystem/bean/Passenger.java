package com.Teamairlines.flightManagementSystem.bean;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Passenger {
	@EmbeddedId
	private TicketPassengerEmbed embeddedId;
	private String passenegerName;
	private Integer passengerAge;
	private Double fare;
	/**
	 * 
	 */
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Passenger(TicketPassengerEmbed embeddedId, String passenegerName, Integer passengerAge, Double fare) {
		super();
		this.embeddedId = embeddedId;
		this.passenegerName = passenegerName;
		this.passengerAge = passengerAge;
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

	public Integer getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
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
				+ passengerAge + ", fare=" + fare + "]";
	}
	
}
