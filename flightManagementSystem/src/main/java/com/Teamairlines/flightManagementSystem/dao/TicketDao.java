package com.Teamairlines.flightManagementSystem.dao;

import com.Teamairlines.flightManagementSystem.bean.Ticket;

public interface TicketDao {
    void save(Ticket ticket);
    Long findLastTicketNumber();
}
