package com.Teamairlines.flightManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Teamairlines.flightManagementSystem.bean.Airport;
import com.Teamairlines.flightManagementSystem.dao.AirportDao;

@RestController
public class AirportController {

    @Autowired
    private AirportDao airportDao;

    @GetMapping("/index")
    public ModelAndView showIndexPage() {
        return new ModelAndView("index");
    }

    @GetMapping("/airport")
    public ModelAndView showNewAirportPage() {
        Airport airport = new Airport();
        ModelAndView mv = new ModelAndView("airportEntryPage");
        mv.addObject("airportRecord", airport);
        return mv;
    }

    @PostMapping("/airport")
    public ModelAndView saveAirport(@ModelAttribute("airportRecord") Airport airport) {
    	String str = airport.getAirportCode().toUpperCase();
    	airport.setAirportCode(str);
    	String stg = airport.getAirportLocation().toUpperCase();
    	airport.setAirportLocation(stg);
        airportDao.addAirport(airport);
        ModelAndView mv = new ModelAndView("redirect:/airport-report");
        mv.addObject("message", "Airport added successfully!");
        return mv;
    }
    
    
    @GetMapping("/airportshow")
    public ModelAndView showSingleAirportPage(@RequestParam("id") String id) {
    	Airport airport = airportDao.findAirportById(id);
        ModelAndView mv = new ModelAndView("airportShowPage");
        mv.addObject("airport", airport);
        return mv;
    }
    
   @GetMapping("/airport-select")
    public ModelAndView showAirportSelectPage() {
        List<String> codeList = airportDao.findAllAirportCodes();
        ModelAndView mv = new ModelAndView("airportSelectPage");
        mv.addObject("codeList", codeList);
        return mv;
    }

    @PostMapping("/airport-select")
    public ModelAndView showSingleAirportPages(@RequestParam("airport-code") String id) {
        Airport airport = airportDao.findAirportById(id);
        ModelAndView mv = new ModelAndView("airportShowPage");
        mv.addObject("airport", airport);
        return mv;
    }

    @GetMapping("/airport-report")
    public ModelAndView showAirportReportPage(@RequestParam(value = "message", required = false) String message) {
        List<Airport> airportList = airportDao.findAllAirports();
        ModelAndView mv = new ModelAndView("airportReportPage");
        mv.addObject("airportList", airportList);
        if (message != null) {
            mv.addObject("message", message);
        }
        return mv;
    }

    @GetMapping("/editAirportForm")
    public ModelAndView showEditForm(@RequestParam("id") String id) {
        Airport airport = airportDao.findAirportById(id);
        ModelAndView mv = new ModelAndView("editAirportPage");
        mv.addObject("airportRecord", airport);
        return mv;
    }

    @PostMapping("/updateAirport")
    public ModelAndView updateAirport(@ModelAttribute("airportRecord") Airport airport) {
        airportDao.updateAirport(airport);
        ModelAndView mv = new ModelAndView("redirect:/airport-report");
        mv.addObject("message", "Airport updated successfully!");
        return mv;
    }

    @GetMapping("/deleteAirport")
    public ModelAndView deleteAirport(@RequestParam("id") String id) {
        airportDao.deleteAirport(id);
        ModelAndView mv = new ModelAndView("redirect:/airport-report");
        mv.addObject("message", "Airport deleted successfully!");
        return mv;
    }
}
