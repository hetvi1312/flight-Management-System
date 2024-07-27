package com.Teamairlines.flightManagementSystem.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {

    @Id
    private Long flightNumber;
    private String carrierName;
    private Long routeId;
    private Integer seatCapacity;
    private String departure;
    private String arrival;
    
    private String imageUrl; // URL for the flight image or airline's logo

    public Flight() {
        super(); // Default constructor
    }

    // Constructor with imageUrl field
    
    public Flight(Long flightNumber, String carrierName, Long routeId, Integer seatCapacity, String departure,
			String arrival,  String imageUrl) {
		super();
		this.flightNumber = flightNumber;
		this.carrierName = carrierName;
		this.routeId = routeId;
		this.seatCapacity = seatCapacity;
		this.departure = departure;
		this.arrival = arrival;
		
		this.imageUrl = imageUrl;
	}

	

    public Long getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Long flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Integer getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(Integer seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

  

	public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
