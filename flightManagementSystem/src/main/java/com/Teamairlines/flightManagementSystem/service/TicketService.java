package com.Teamairlines.flightManagementSystem.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Teamairlines.flightManagementSystem.bean.Flight;
import com.Teamairlines.flightManagementSystem.bean.Passenger;
import com.Teamairlines.flightManagementSystem.dao.FlightDao;

@Service
public class TicketService {
    @Autowired
    private FlightDao flightDao;

    public int ageCalculation(String dob) {
        LocalDate today = LocalDate.now();
        String[] dateArr = dob.split("-");
        LocalDate birthDay = LocalDate.of(
            Integer.parseInt(dateArr[2]),
            Integer.parseInt(dateArr[1]),
            Integer.parseInt(dateArr[0])
        );
        Period period = Period.between(birthDay, today);
        int age=period.getYears();
        return age;
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

    public boolean capacityCalculation(int numberOfSeatBooking, Long flightNumber) {
        Flight flight = flightDao.findFlightById(flightNumber);
        int bookedSeat = flight.getSeatBooked() + numberOfSeatBooking;
        int balance = flight.getSeatCapacity() - bookedSeat;
        if (balance < 0) {
            return false;
        } else {
            flight.setSeatBooked(bookedSeat);
            flightDao.save(flight);
            return true;
        }
    }
   public Double totalBillCalculation(List<Passenger>passengerList) {
	   Double totalAmount=0.0;
	   for (Passenger passenger : passengerList) {
           totalAmount += passenger.getFare();
       }
       return totalAmount;
}
}
