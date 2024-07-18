package com.Teamairlines.flightManagementSystem.controller;

import com.Teamairlines.flightManagementSystem.bean.Flight;
import com.Teamairlines.flightManagementSystem.bean.Route;
import com.Teamairlines.flightManagementSystem.dao.AirportDao;
import com.Teamairlines.flightManagementSystem.dao.FlightDao;
import com.Teamairlines.flightManagementSystem.dao.RouteDao;
import com.Teamairlines.flightManagementSystem.exception.RouteException;
import com.Teamairlines.flightManagementSystem.service.FlightService;
import com.Teamairlines.flightManagementSystem.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@ControllerAdvice
@RestController
public class RouteFlightController {

    
    @Autowired
    private AirportDao airportDao;

    @Autowired
    private RouteService routeService;

    @Autowired
    private RouteDao routeDao;
    
    @Autowired
    private FlightDao flightDao;
    

    
    @Autowired
    private FlightService flightService;

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
        String destinationCode = airportDao.findAirportCodeByLocation( route1.getDestinationAirportCode());

        route1.setSourceAirportCode(sourceCode);
        route1.setDestinationAirportCode(destinationCode);

        Route route2 = routeService.createReturnRoute(route1);
        routeDao.save(route1);
        routeDao.save(route2);

        return new ModelAndView("redirect:/routes");
    }

    @GetMapping("/routes")
    public ModelAndView showRouteReportPage() {
    	List<Route> routeList=routeDao.findAllRoutes();
        ModelAndView mv = new ModelAndView("routeReportPage");
        mv.addObject("routeList",routeList);
        return mv;
    }

    @GetMapping("/flight")
    public ModelAndView showFlightEntryPage() {
        List<Long> routeList = routeDao.findAllRoutesId();
        Flight flight = new Flight();
        ModelAndView mv = new ModelAndView("flightEntryPage");
        mv.addObject("flightRecord",flight);
        mv.addObject("routeList",routeList);
        return mv;
    }

    @PostMapping("/flight")
    public ModelAndView saveFlights(@ModelAttribute("flightRecord") Flight flight1, @RequestParam("dtime") String dtime, @RequestParam("atime") String atime) {
        Flight flight2 = flightService.createReturnFlight(flight1, dtime, atime);
        flightDao.save(flight1);
        flightDao.save(flight2);
        return new ModelAndView("redirect:/flights");
    }

    @GetMapping("/flights")
    public ModelAndView showFlightReportPage() {
        List<Flight> flightList = flightDao.findAllFlights();
        ModelAndView mv = new ModelAndView("flightReportPage");
        mv.addObject("flightList", flightList);
        return mv;
    }
    
    @GetMapping("/flight-search")
    public ModelAndView showRouteSelectPage() {
    	List<String> airportList=airportDao.findAllAirportLocations();
        ModelAndView mv = new ModelAndView("routeSelectPage");
        mv.addObject("airportList",airportList);
        return mv;
    }
    
    @PostMapping("/flight-search")
    public ModelAndView showRouteFlightsPage(@RequestParam("flight_city") String fromCity, @RequestParam("to_city") String toCity) {
        String fromAirport=airportDao.findAirportCodeByLocation(fromCity);
        String toAirport=airportDao.findAirportCodeByLocation(toCity);
        if(fromAirport.equalsIgnoreCase(toAirport))
        	throw new RouteException();
        Route route=routeDao.findRouteBySourceAndDestination(fromAirport,toAirport);
        List<Flight> flightList = flightDao.findFlightsByRouteId(route.getRouteId());
        ModelAndView mv = new ModelAndView("routeFlightShowPage");
        mv.addObject("flightList",flightList);
        mv.addObject("fromAirport",fromCity);
        mv.addObject("toAirport",toCity);
        mv.addObject("fair",route.getFair());
        return mv;     
   
    }

    
    @ExceptionHandler(value= RouteException.class)
    public ModelAndView handlingRouteException(RouteException exception) {
    	String message = "form-city & to-city cannot be same";
    	ModelAndView mv =new ModelAndView("routeErrorPage");
    	mv.addObject("errorMessage",message);
    	return mv;
    	
    	
    }
}
