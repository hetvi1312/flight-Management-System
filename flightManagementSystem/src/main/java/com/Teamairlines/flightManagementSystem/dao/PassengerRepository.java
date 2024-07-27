package com.Teamairlines.flightManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Teamairlines.flightManagementSystem.bean.Passenger;
import com.Teamairlines.flightManagementSystem.bean.TicketPassengerEmbed;

public interface PassengerRepository extends JpaRepository<Passenger, TicketPassengerEmbed> {
    void deleteByEmbeddedId_TicketNumber(Long ticketNumber);
    
    
}
