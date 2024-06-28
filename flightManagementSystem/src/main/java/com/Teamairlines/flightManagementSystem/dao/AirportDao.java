package com.Teamairlines.flightManagementSystem.dao;

import java.util.List;
import com.Teamairlines.flightManagementSystem.bean.Airport;

public interface AirportDao {
    void addAirport(Airport airport);
    List<Airport> findAllAirports();
    Airport findAirportById(String id);
    List<String> findAllAirportCodes();
    List<String> findAllAirportLocations();
    
    String findAirportCodeByLocation(String location);
    void updateAirport(Airport airport);
    void deleteAirport(String id);
}
