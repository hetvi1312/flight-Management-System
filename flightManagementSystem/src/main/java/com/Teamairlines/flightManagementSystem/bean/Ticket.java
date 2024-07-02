package com.Teamairlines.flightManagementSystem.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ticket {
	@Id
	private Long ticketNumber;
	private Long routeId;
	private Long flightNumber;
	private String carrierName;
	private Double totalAmount;
	
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ticketNumber
	 * @param routeId
	 * @param flightNumber
	 * @param carrierName
	 * @param totalAmount
	 */
	public Ticket(Long ticketNumber, Long routeId, Long flightNumber, String carrierName, Double totalAmount) {
		super();
		this.ticketNumber = ticketNumber;
		this.routeId = routeId;
		this.flightNumber = flightNumber;
		this.carrierName = carrierName;
		this.totalAmount = totalAmount;
	}

	public Long getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(Long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
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

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Ticket [ticketNumber=" + ticketNumber + ", routeId=" + routeId + ", flightNumber=" + flightNumber
				+ ", carrierName=" + carrierName + ", totalAmount=" + totalAmount + "]";
	}

	

}
