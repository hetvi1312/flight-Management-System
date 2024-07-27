package com.Teamairlines.flightManagementSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;

import com.Teamairlines.flightManagementSystem.bean.Ticket;
import java.util.List;
import java.util.Optional;
@Service
@Repository
public class TicketDaoImpl implements TicketDao {

    @Autowired
    private TicketRepository repository;

    @Override
    public void save(Ticket ticket) {
        repository.save(ticket);
    }

    @Override
    public Long findLastTicketNumber() {
        Long val = repository.findLastTicketNumber();
        if (val == null) {
            val = 1000001L;
        } else {
            val = val + 1;
        }
        return val;
    }

    @Override
    public void deleteById(Long ticketNumber) {
        repository.deleteById(ticketNumber);
    }

    @Override
    public List<Ticket> findAllTicketsByUsername(String username) {
        return repository.findAllByUsername(username);
    }

    @Override
    public List<Ticket> findAllTickets() {
        return repository.findAll();
    }
    @Override
    public Optional<Ticket> findById(Long ticketNumber) {
        return repository.findById(ticketNumber);
    }
    @Override
    public Ticket findByTicketNumber(Long ticketNumber) {
        return repository.findByTicketNumber(ticketNumber);
    }
    @Override
    public long countTickets() {
        return repository.count();
    }
    @Override
    public List<Ticket> findTicketsByUsername(String username) {
        return repository.findTicketsByUsername(username);
    }
  
}
