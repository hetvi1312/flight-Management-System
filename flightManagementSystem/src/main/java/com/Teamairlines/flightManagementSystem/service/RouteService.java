package com.Teamairlines.flightManagementSystem.service;

import org.springframework.stereotype.Service;

import com.Teamairlines.flightManagementSystem.bean.Route;

@Service
public class RouteService {
    
    public Route createReturnRoute(Route route) {
        Long newId = route.getRouteId()+1;
        String sourceCode = route.getDestinationAirportCode();
        String destinationCode = route.getSourceAirportCode();
        return new Route(newId, sourceCode, destinationCode, route.getFair());
    }
}
