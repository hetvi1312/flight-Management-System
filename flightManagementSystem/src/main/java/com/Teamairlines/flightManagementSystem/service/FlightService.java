package com.Teamairlines.flightManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Teamairlines.flightManagementSystem.bean.Flight;
import com.Teamairlines.flightManagementSystem.dao.RouteDao;
import com.Teamairlines.flightManagementSystem.bean.Route;

@Service
public class FlightService {

    @Autowired
    private RouteDao routeDao;

    public Flight createReturnFlight(Flight flight, String dtime, String atime) {
        Long newId = flight.getFlightNumber() + 1;
        Route route = routeDao.findRouteById(flight.getRouteId());
        String sourceCode = route.getDestinationAirportCode();
        String destinationCode = route.getSourceAirportCode();
        Route returnRoute = routeDao.findRouteBySourceAndDestination(sourceCode, destinationCode);
        return new Flight(newId, flight.getCarrierName(), returnRoute.getRouteId(), flight.getSeatCapacity(), dtime, atime, flight.getImageUrl());
    }
}
