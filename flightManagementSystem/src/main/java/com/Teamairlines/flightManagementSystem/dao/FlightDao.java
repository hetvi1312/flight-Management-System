package com.Teamairlines.flightManagementSystem.dao;

import com.Teamairlines.flightManagementSystem.bean.Flight;
import java.util.List;

public interface FlightDao {
    void save(Flight flight);
    List<Flight> findAllFlights();
    Flight findFlightById(Long id);
    List<Flight> findFlightsByRouteId(Long routeId);
}
