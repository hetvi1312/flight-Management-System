package com.Teamairlines.flightManagementSystem.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Teamairlines.flightManagementSystem.bean.DailySeatBooking;
import com.Teamairlines.flightManagementSystem.bean.Flight;
import com.Teamairlines.flightManagementSystem.bean.Passenger;
import com.Teamairlines.flightManagementSystem.bean.Ticket;
import com.Teamairlines.flightManagementSystem.dao.FlightDao;
import com.Teamairlines.flightManagementSystem.dao.PassengerDao;
import com.Teamairlines.flightManagementSystem.dao.TicketDao;
import com.Teamairlines.flightManagementSystem.dao.DailySeatBookingRepository;
import com.Teamairlines.flightManagementSystem.exception.SeatNotFoundException;

@Service
public class TicketService {
    @Autowired
    private FlightDao flightDao;

    @Autowired
    private PassengerDao passengerDao;

    @Autowired
    private TicketDao ticketDao;

    @Autowired
    private DailySeatBookingRepository dailySeatBookingDao;

    public int ageCalculation(String dob) {
        LocalDate today = LocalDate.now();
        String[] dateArr = dob.split("-");
        LocalDate birthDay = LocalDate.of(
            Integer.parseInt(dateArr[2]),
            Integer.parseInt(dateArr[1]),
            Integer.parseInt(dateArr[0])
        );
        Period period = Period.between(birthDay, today);
        return period.getYears();
    }

    public Double discountedFareCalculation(Passenger passenger) {
        int age = ageCalculation(passenger.getPassengerDOB());
        double finalFare = 0.0;
        if (age <= 14) {
            finalFare = passenger.getFare() / 2;
        } else if (age >= 60) {
            finalFare = passenger.getFare() - passenger.getFare() * 0.30;
        } else {
            finalFare = passenger.getFare();
        }
        return finalFare;
    }

    public boolean capacityCalculation(int numberOfSeatBooking, Long flightNumber, LocalDate bookingDate, Long ticketNumber) {
        Flight flight = flightDao.findFlightById(flightNumber);
        if (flight == null || flight.getSeatCapacity() == null) {
            throw new SeatNotFoundException("Flight data is incomplete for flight " + flightNumber);
        }
        
        int seatCapacity = flight.getSeatCapacity();

        // Check and update daily seat bookings
        DailySeatBooking dailyBooking = dailySeatBookingDao.findBookingByFlightNumberAndDate(flightNumber, bookingDate);
        int seatsBookedToday = (dailyBooking != null) ? dailyBooking.getSeatsBooked() : 0;
        int availableSeats = seatCapacity - seatsBookedToday;

        if (availableSeats < numberOfSeatBooking) {
            throw new SeatNotFoundException("Not enough seats available for flight " + flightNumber + " on " + bookingDate);
        } else {
            if (dailyBooking != null) {
                dailyBooking.setSeatsBooked(seatsBookedToday + numberOfSeatBooking);
                dailySeatBookingDao.save(dailyBooking);
            } else {
                DailySeatBooking newBooking = new DailySeatBooking(flightNumber, bookingDate, numberOfSeatBooking, ticketNumber);
                dailySeatBookingDao.save(newBooking);
            }
            return true;
        }
    }
    public Double totalBillCalculation(List<Passenger> passengerList) {
        Double totalAmount = 0.0;
        for (Passenger passenger : passengerList) {
            totalAmount += passenger.getFare();
        }
        return totalAmount;
    }
    @Transactional
    public void cancelTicket(Long ticketNumber) {
        // Find the ticket
        Ticket ticket = ticketDao.findById(ticketNumber).orElse(null);

        if (ticket == null) {
            throw new IllegalArgumentException("Ticket not found");
        }

        // Find the booking
        DailySeatBooking dailyBooking = dailySeatBookingDao.findBookingByTicketNumber(ticketNumber);

        if (dailyBooking == null) {
            throw new IllegalArgumentException("No booking found for the given ticket number");
        }

        LocalDate bookingDate = dailyBooking.getBookingDate(); // Retrieve booking date from dailyBooking

        // Update seat availability
        Flight flight = flightDao.findFlightById(ticket.getFlightNumber());
        if (flight == null || flight.getSeatCapacity() == null) {
            throw new SeatNotFoundException("Flight data is incomplete for flight " + ticket.getFlightNumber());
        }

        int seatCapacity = flight.getSeatCapacity();
        int seatsBookedToday = dailyBooking.getSeatsBooked();

        // Update or remove the daily seat booking
        if (seatsBookedToday - 1 > 0) {
            dailyBooking.setSeatsBooked(seatsBookedToday - 1);
            dailySeatBookingDao.save(dailyBooking);
        } else {
            dailySeatBookingDao.delete(dailyBooking);
        }
        passengerDao.deleteByTicketNumber(ticketNumber);
        // Delete the ticket
        ticketDao.deleteById(ticketNumber);
    }

    public Optional<Ticket> getTicketById(Long ticketNumber) {
        return ticketDao.findById(ticketNumber);
    }
    public List<Ticket> findTicketsByUsername(String username) {
        // Assume you have a method in TicketDao to find tickets by username
        return ticketDao.findTicketsByUsername(username);
    }
    
}
