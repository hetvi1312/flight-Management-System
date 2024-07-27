package com.Teamairlines.flightManagementSystem.dao;

import com.Teamairlines.flightManagementSystem.bean.Ticket;
import java.util.List;
import java.util.Optional;

public interface TicketDao {
    void save(Ticket ticket);
    Long findLastTicketNumber();
    void deleteById(Long ticketNumber);
    List<Ticket> findAllTicketsByUsername(String username);
    List<Ticket> findAllTickets();
    Optional<Ticket> findById(Long ticketNumber);
    Ticket findByTicketNumber(Long ticketNumber); 
    long countTickets(); 
    List<Ticket> findTicketsByUsername(String username);
}
