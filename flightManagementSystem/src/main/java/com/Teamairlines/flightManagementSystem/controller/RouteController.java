package com.Teamairlines.flightManagementSystem.controller;

import com.Teamairlines.flightManagementSystem.bean.Route;
import com.Teamairlines.flightManagementSystem.bean.Flight;
import com.Teamairlines.flightManagementSystem.service.RouteService;
import com.Teamairlines.flightManagementSystem.dao.AirportDao;
import com.Teamairlines.flightManagementSystem.dao.FlightDao;
import com.Teamairlines.flightManagementSystem.dao.RouteDao;
import com.Teamairlines.flightManagementSystem.exception.FlightNotFoundException;
import com.Teamairlines.flightManagementSystem.exception.RouteException;
import com.Teamairlines.flightManagementSystem.exception.RouteNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RouteController {

    @Autowired
    private RouteDao routeDao;
    
    @Autowired
    private FlightDao flightDao;

    @Autowired
    private RouteService routeService;

    @Autowired
    private AirportDao airportDao;

    @GetMapping("/route")
    public ModelAndView showAddRouteForm() {
        Long newRouteId = routeDao.generateRouteId();
        Route route = new Route();
        route.setRouteId(newRouteId);
        ModelAndView mv = new ModelAndView("routeEntryPage");
        mv.addObject("routeRecord", route);
        return mv;
    }

    @PostMapping("/route")
    public ModelAndView saveRoutes(@ModelAttribute("routeRecord") Route route1) {
        String source = route1.getSourceAirportCode().toUpperCase();
        String destination = route1.getDestinationAirportCode().toUpperCase();

        route1.setSourceAirportCode(source);
        route1.setDestinationAirportCode(destination);

        String sourceCode = airportDao.findAirportCodeByLocation(route1.getSourceAirportCode());
        String destinationCode = airportDao.findAirportCodeByLocation(route1.getDestinationAirportCode());

        route1.setSourceAirportCode(sourceCode);
        route1.setDestinationAirportCode(destinationCode);

        Route route2 = routeService.createReturnRoute(route1);
        routeDao.save(route1);
        routeDao.save(route2);
        ModelAndView mv = new ModelAndView("redirect:/routes");
        mv.addObject("message", "Route added successfully!");
        return mv;
    }

    @GetMapping("/route/delete/{id}")
    public ModelAndView deleteRoute(@PathVariable("id") Long routeId) {
        routeDao.delete(routeId);
        ModelAndView mv = new ModelAndView("redirect:/routes");
        mv.addObject("message", "Route deleted successfully!");
        return mv;
    }

    @GetMapping("/routes")
    public ModelAndView showRouteReportPage() {
        List<Route> routeList = routeDao.findAllRoutes();
        ModelAndView mv = new ModelAndView("routeReportPage");
        mv.addObject("routeList", routeList);
        return mv;
    }
   
    
    @GetMapping("/flight-search")
    public ModelAndView showRouteSelectPage() {
        List<String> airportList = airportDao.findAllAirportLocations();
        ModelAndView mv = new ModelAndView("index1");
        mv.addObject("airportList", airportList);
        return mv;
    }
    @PostMapping("/flight-search")
    public ModelAndView showRouteFlightsPage(@RequestParam("flight_city") String fromCity, @RequestParam("to_city") String toCity) {
        String fromAirport = airportDao.findAirportCodeByLocation(fromCity);
        String toAirport = airportDao.findAirportCodeByLocation(toCity);

        if (fromAirport.equalsIgnoreCase(toAirport)) {
            throw new RouteException();
        }

        Route route = routeDao.findRouteBySourceAndDestination(fromAirport, toAirport);
        if (route == null) {
            throw new RouteNotFoundException("Route not found from " + fromCity + " to " + toCity);
        }

        List<Flight> flightList = flightDao.findFlightsByRouteId(route.getRouteId());
        if (flightList.isEmpty()) {
            throw new FlightNotFoundException("No flights available from " + fromCity + " to " + toCity);
        }

        ModelAndView mv = new ModelAndView("flightshowpageuser");
        mv.addObject("flightList", flightList);
        mv.addObject("fromAirport", fromCity);
        mv.addObject("toAirport", toCity);
        mv.addObject("fair", route.getFair());
        return mv;
    }

    @ExceptionHandler(value = RouteException.class)
    public ModelAndView handlingRouteException(RouteException exception) {
        String message = "Form-city & to-city cannot be the same";
        ModelAndView mv = new ModelAndView("routeErrorPage");
        mv.addObject("errorMessage", message);
        return mv;
    }

    @ExceptionHandler(value = RouteNotFoundException.class)
    public ModelAndView handlingRouteNotFoundException(RouteNotFoundException exception) {
        String message = exception.getMessage();
        ModelAndView mv = new ModelAndView("routeErrorPage");
        mv.addObject("errorMessage", message);
        return mv;
    }

    @ExceptionHandler(value = FlightNotFoundException.class)
    public ModelAndView handlingFlightNotFoundException(FlightNotFoundException exception) {
        String message = exception.getMessage();
        ModelAndView mv = new ModelAndView("flightErrorPage");
        mv.addObject("errorMessage", message);
        return mv;
    }
}

