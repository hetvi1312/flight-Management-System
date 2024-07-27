package com.Teamairlines.flightManagementSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Teamairlines.flightManagementSystem.bean.Airport;

@Service
public class AirportDaoImpl implements AirportDao {

    @Autowired
    private AirportRepository repository;

    @Override
    public void addAirport(Airport airport) {
        repository.save(airport);
    }

    @Override
    public List<Airport> findAllAirports() {
        return repository.findAll();
    }

    @Override
    public Airport findAirportById(String id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    public long countAirports() {
        return repository.count();
    }

    @Override
    public List<String> findAllAirportCodes() {
        return repository.findAllAirportCodes();
    }

    @Override
    public List<String> findAllAirportLocations() {
        return repository.findAllAirportLocations();
    }

    
    @Override
    public String findAirportCodeByLocation(String location) {
        return repository.findAirportCodeByLocation(location);
    }

    @Override
    public void updateAirport(Airport airport) {
        if (repository.existsById(airport.getAirportCode())) {
            repository.save(airport);
        }
    }

    @Override
    public void deleteAirport(String id) {
        repository.deleteById(id);
    }
    
    }
