package com.Teamairlines.flightManagementSystem.dao;


import com.Teamairlines.flightManagementSystem.bean.Flight;
import com.Teamairlines.flightManagementSystem.dao.FlightDao;
import com.Teamairlines.flightManagementSystem.dao.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightDaoImpl implements FlightDao {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public void save(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public List<Flight> findFlightsByRouteId(Long routeId) {
        return flightRepository.findFlightByRouteId(routeId);
    }
}
