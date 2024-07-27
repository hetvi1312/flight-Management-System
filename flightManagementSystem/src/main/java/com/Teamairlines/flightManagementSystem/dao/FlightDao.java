package com.Teamairlines.flightManagementSystem.dao;

import java.util.List;
import com.Teamairlines.flightManagementSystem.bean.Flight;

public interface FlightDao {
	 void save(Flight flight);
   
    void deleteById(Long flightNumber);
    List<Flight> findAllFlights();
    Flight findFlightById(Long id);
    List<Flight> findFlightsByRouteId(Long routeId);
    long countFlights();
}
