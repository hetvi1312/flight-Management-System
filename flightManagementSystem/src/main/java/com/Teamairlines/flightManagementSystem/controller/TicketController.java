package com.Teamairlines.flightManagementSystem.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Teamairlines.flightManagementSystem.bean.Airport;
import com.Teamairlines.flightManagementSystem.bean.DailySeatBooking;
import com.Teamairlines.flightManagementSystem.bean.Flight;
import com.Teamairlines.flightManagementSystem.bean.Passenger;
import com.Teamairlines.flightManagementSystem.bean.Route;
import com.Teamairlines.flightManagementSystem.bean.Ticket;
import com.Teamairlines.flightManagementSystem.bean.TicketPassengerEmbed;
import com.Teamairlines.flightManagementSystem.dao.DailySeatBookingRepository;
import com.Teamairlines.flightManagementSystem.dao.FlightDao;
import com.Teamairlines.flightManagementSystem.dao.PassengerDao;
import com.Teamairlines.flightManagementSystem.dao.RouteDao;
import com.Teamairlines.flightManagementSystem.dao.TicketDao;
import com.Teamairlines.flightManagementSystem.exception.SeatNotFoundException;
import com.Teamairlines.flightManagementSystem.service.TicketService;

@Controller
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
    private TicketService ticketService;
    @Autowired
    private DailySeatBookingRepository dailySeatBookingDao;


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
        mv.addObject("today", LocalDate.now());

        return mv;
    }

    @PostMapping("/ticket")
    public ModelAndView openShowTicketPage(@ModelAttribute("ticketRecord") Ticket ticket, HttpServletRequest request) {
        List<Passenger> passengerList = new ArrayList<>();
        String fromCity = request.getParameter("fromLocation");
        String toCity = request.getParameter("toLocation");
        Double fare = Double.parseDouble(request.getParameter("fare"));
        String pname;
        String dob;
        LocalDate bookingDate = LocalDate.parse(request.getParameter("bookingDate"));

        String username = request.getUserPrincipal().getName();

        for (int i = 1; i <= 6; i++) {
            pname = request.getParameter("name" + i);
            if (pname != null && !pname.trim().isEmpty() && !pname.equals("--")) {
                dob = request.getParameter("dob" + i);
                int age = ticketService.ageCalculation(dob);

                TicketPassengerEmbed embed = new TicketPassengerEmbed(ticket.getTicketNumber(), i);
                Passenger passenger = new Passenger(embed, pname, dob, fare);
                Double pfare = ticketService.discountedFareCalculation(passenger);
                passenger.setFare(pfare);
                passengerList.add(passenger);
            } else {
                break;
            }
        }
        int size = passengerList.size();
        boolean isSeatsAvailable;
        try {
            isSeatsAvailable = ticketService.capacityCalculation(size, ticket.getFlightNumber(), bookingDate, ticket.getTicketNumber());
        } catch (SeatNotFoundException e) {
            return new ModelAndView("SeatErrorPage").addObject("errorMessage", e.getMessage());
        }

        ticket.setUsername(username);
        ticketDao.save(ticket);
        for (Passenger passenger : passengerList) {
            passengerDao.save(passenger);
        }

        Double totalAmount = ticketService.totalBillCalculation(passengerList);
        ticket.setTotalAmount(totalAmount);
        ticketDao.save(ticket);

        ModelAndView mv = new ModelAndView("showTicketPage");
        mv.addObject("ticket", ticket);
        mv.addObject("fromCity", fromCity);
        mv.addObject("toCity", toCity);
        mv.addObject("passengerList", passengerList);
        mv.addObject("bookingDate", bookingDate);

        return mv;
    }

    @GetMapping("/ticket-report")
    public ModelAndView showAllTickets() {
        List<Ticket> allTickets = ticketDao.findAllTickets();
        ModelAndView mv = new ModelAndView("allTicketsPage");
        mv.addObject("allTickets", allTickets);
        
        return mv;
    } 
  

    @GetMapping("/ticketshow")
    public ModelAndView showSingleTicketPage(@RequestParam("id") Long ticketNumber) {
        Optional<Ticket> optionalTicket = ticketDao.findById(ticketNumber);
        ModelAndView mv = new ModelAndView("ticketshowpage");

        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            mv.addObject("ticket", ticket);
        } else {
            mv.addObject("errorMessage", "Ticket not found");
        }

        return mv;
    }

    @GetMapping("/passenger-report")
    public ModelAndView showAllPassengers() {
        List<Passenger> allPassengers = passengerDao.findAll();
        ModelAndView mv = new ModelAndView("allPassengersPage");
        mv.addObject("allPassengers", allPassengers);
        return mv;
    }
    @GetMapping("/passenger-report/{ticketNumber}/{serialNumber}")
    public ModelAndView showSinglePassengerPage(@PathVariable Long ticketNumber, @PathVariable Integer serialNumber) {
        TicketPassengerEmbed id = new TicketPassengerEmbed(ticketNumber, serialNumber);
        Optional<Passenger> optionalPassenger = passengerDao.findById(id);
        ModelAndView mv = new ModelAndView("passengershowpage");

        if (optionalPassenger.isPresent()) {
            Passenger passenger = optionalPassenger.get();
            mv.addObject("passenger", passenger);
        } else {
            mv.addObject("errorMessage", "Passenger not found");
        }

        return mv;
    }



    @GetMapping("/cancelTicket")
    public ModelAndView cancelTicket(@RequestParam("ticketNumber") Long ticketNumber) {
        try {
            // Attempt to cancel the ticket
            ticketService.cancelTicket(ticketNumber);
            
            // If no exception is thrown, the cancellation was successful
            return new ModelAndView("cancellationConfirmationPage")
                .addObject("message", "Ticket successfully canceled.");
        } catch (IllegalArgumentException e) {
            // If an IllegalArgumentException is thrown, the ticket was not found
            return new ModelAndView("errorPage")
                .addObject("errorMessage", "Ticket not found.");
        } catch (Exception e) {
            // Handle other potential exceptions
            return new ModelAndView("errorPage")
                .addObject("errorMessage", "An error occurred while canceling the ticket.");
        }
    }

    @GetMapping("/ticketHistory")
    public ModelAndView viewTicketHistory(HttpServletRequest request) {
        String username = request.getUserPrincipal().getName();
        List<Ticket> tickets = ticketDao.findTicketsByUsername(username);

        ModelAndView mv = new ModelAndView("userbookinghistory");
        mv.addObject("tickets", tickets);

        return mv;
    }

    @GetMapping("/ticketDetails")
    public ModelAndView viewTicketDetails(@RequestParam("ticketNumber") Long ticketNumber) {
        Optional<Ticket> optionalTicket = ticketDao.findById(ticketNumber);
        if (!optionalTicket.isPresent()) {
            return new ModelAndView("errorPage")
                .addObject("errorMessage", "Ticket not found.");
        }

        Ticket ticket = optionalTicket.get();
        
        // Use the correct query method for the composite key
        List<Passenger> passengers = passengerDao.findByTicketNumber(ticketNumber); 

        // Fetch booking details from DailySeatBooking
        DailySeatBooking dailySeatBooking = dailySeatBookingDao.findBookingByTicketNumber(ticketNumber);
        LocalDate bookingDate = (dailySeatBooking != null) ? dailySeatBooking.getBookingDate() : null;

        // Fetch route details
        Route route = routeDao.findRouteById(ticket.getRouteId());
        String fromCity = route.getSourceAirportCode();
        String toCity = route.getDestinationAirportCode();

        ModelAndView mv = new ModelAndView("ticketDetailsPage");
        mv.addObject("ticket", ticket);
        mv.addObject("passengerList", passengers);
        mv.addObject("fromCity", fromCity);
        mv.addObject("toCity", toCity);
        mv.addObject("bookingDate", bookingDate);

        return mv;
    }


}
