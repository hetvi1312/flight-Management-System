package com.Teamairlines.flightManagementSystem.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "daily_seat_bookings")
public class DailySeatBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long flightNumber;
    private LocalDate bookingDate;
    private int seatsBooked;
    private Long ticketNumber; // New field

    // Default constructor
    public DailySeatBooking() {
    }

    // Parameterized constructor
    public DailySeatBooking(Long flightNumber, LocalDate bookingDate, int seatsBooked, Long ticketNumber) {
        this.flightNumber = flightNumber;
        this.bookingDate = bookingDate;
        this.seatsBooked = seatsBooked;
        this.ticketNumber = ticketNumber;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Long flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(int seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public Long getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Long ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public String toString() {
        return "DailySeatBooking{" +
                "id=" + id +
                ", flightNumber=" + flightNumber +
                ", bookingDate=" + bookingDate +
                ", seatsBooked=" + seatsBooked +
                ", ticketNumber=" + ticketNumber +
                '}';
    }
}
