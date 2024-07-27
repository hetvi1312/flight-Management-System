package com.Teamairlines.flightManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.Teamairlines.flightManagementSystem.bean.Ticket;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("select max(ticketNumber) from Ticket")
    Long findLastTicketNumber();

    List<Ticket> findAllByUsername(String username); //
    Ticket findByTicketNumber(Long ticketNumber);//
    List<Ticket> findTicketsByUsername(String username);}
