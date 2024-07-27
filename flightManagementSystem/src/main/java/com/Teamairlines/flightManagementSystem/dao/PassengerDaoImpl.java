package com.Teamairlines.flightManagementSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Teamairlines.flightManagementSystem.bean.Passenger;
import com.Teamairlines.flightManagementSystem.bean.TicketPassengerEmbed;

import java.util.List;
import java.util.Optional;

@Repository
public class PassengerDaoImpl implements PassengerDao {
    @Autowired
    private PassengerRepository repository;

    @Override
    public void save(Passenger passenger) {
        repository.save(passenger);
    }

    @Override
    public Optional<Passenger> findById(TicketPassengerEmbed id) {
        return repository.findById(id);
    }

    @Override
    public List<Passenger> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteByTicketNumber(Long ticketNumber) {
        repository.deleteByEmbeddedId_TicketNumber(ticketNumber);
    }
}
