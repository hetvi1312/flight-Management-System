package com.Teamairlines.flightManagementSystem.dao;

import com.Teamairlines.flightManagementSystem.bean.Passenger;
import com.Teamairlines.flightManagementSystem.bean.TicketPassengerEmbed;

import java.util.List;
import java.util.Optional;

public interface PassengerDao {
    void save(Passenger passenger);
    Optional<Passenger> findById(TicketPassengerEmbed id);
    List<Passenger> findAll();
    void deleteByTicketNumber(Long ticketNumber);
    List<Passenger> findByTicketNumber(Long ticketNumber);

}
