package com.Teamairlines.flightManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Teamairlines.flightManagementSystem.bean.Flight;
import com.Teamairlines.flightManagementSystem.bean.Passenger;
import com.Teamairlines.flightManagementSystem.bean.Route;
import com.Teamairlines.flightManagementSystem.bean.Ticket;
import com.Teamairlines.flightManagementSystem.bean.TicketPassengerEmbed;
import com.Teamairlines.flightManagementSystem.dao.FlightDao;
import com.Teamairlines.flightManagementSystem.dao.PassengerDao;
import com.Teamairlines.flightManagementSystem.dao.RouteDao;
import com.Teamairlines.flightManagementSystem.dao.TicketDao;
import com.Teamairlines.flightManagementSystem.exception.SeatNotFoundException;
import com.Teamairlines.flightManagementSystem.service.FlightUserService;
import com.Teamairlines.flightManagementSystem.service.TicketService;

@ControllerAdvice
@RestController
public class TicketController {
	@Autowired
	private TicketDao ticketDao;
	
	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private RouteDao routeDao;
	
	@Autowired
	private PassengerDao passengerDao;
	
	@Autowired
	private TicketDao tickteDao;
	
	@Autowired
    private TicketService ticketService;

	
	@GetMapping("/ticket/{id}")
	public ModelAndView showTicketBookingPage(@PathVariable("id") Long id) {
	    Flight flight = flightDao.findFlightById(id);
	    Route route = routeDao.findRouteById(flight.getRouteId());
	    Long newTicketId = ticketDao.findLastTicketNumber();
	    Ticket ticket = new Ticket();
	    ticket.setTicketNumber(newTicketId);
	    ticket.setFlightNumber(flight.getFlightNumber());
	    ticket.setCarrierName(flight.getCarrierName());
	    ticket.setRouteId(flight.getRouteId());
	    ModelAndView mv = new ModelAndView("ticketBookingPage");
	    mv.addObject("ticketRecord", ticket);
	    mv.addObject("flight", flight);
	    mv.addObject("route", route);
	    
	    return mv;
	}

	@PostMapping("/ticket")
		public ModelAndView openShowTicketPage(@ModelAttribute("ticketRecord")Ticket ticket,HttpServletRequest request){
		List<Passenger> passengerList=new ArrayList<>();
		String fromCity=request.getParameter("fromLocation");
		String toCity=request.getParameter("toLocation");
		Double fare=Double.parseDouble(request.getParameter("fare"));
		String pname="";
		String dob="";
		for(int i=1;i<=6;i++){
			pname=request.getParameter("name"+i);
			if(!pname.equals("--")) {
				dob=request.getParameter("dob"+i);
				int age =ticketService.ageCalculation(dob);
				
				TicketPassengerEmbed embed=new TicketPassengerEmbed(ticket.getTicketNumber(),i);
				Passenger passenger=new Passenger(embed,pname,dob,fare);
				Double pfare=ticketService.discountedFareCalculation(passenger); 
				passenger.setFare(pfare); 
				passengerList.add(passenger);
			}
			else {
				break;
			}
	}
		int size=passengerList.size();
		if(ticketService.capacityCalculation(size,ticket.getFlightNumber()))
		{
			ticketDao.save(ticket);
			for(Passenger passenger:passengerList) {
				passengerDao.save(passenger);
			}
		}
		else {
			throw new SeatNotFoundException();
			}
			
		Double totalAmout=ticketService.totalBillCalculation(passengerList);
		ticket.setTotalAmount(totalAmout);
		ticketDao.save(ticket);
		ModelAndView mv=new ModelAndView("aapp");
		mv.addObject("ticket",ticket);
		mv.addObject("fromCity",fromCity);
		mv.addObject("toCity",toCity);
		mv.addObject("passengerList",passengerList);
		return mv;
		
	}
}
