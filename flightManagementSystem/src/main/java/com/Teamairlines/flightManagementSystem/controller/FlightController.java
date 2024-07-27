package com.Teamairlines.flightManagementSystem.controller;

import com.Teamairlines.flightManagementSystem.bean.Flight;
import com.Teamairlines.flightManagementSystem.dao.FlightDao;
import com.Teamairlines.flightManagementSystem.dao.RouteDao;
import com.Teamairlines.flightManagementSystem.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    private FlightDao flightDao;

    @Autowired
    private RouteDao routeDao;

    @Autowired
    private FlightService flightService;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @GetMapping("/flight")
    public ModelAndView showFlightEntryPage() {
        List<Long> routeList = routeDao.findAllRoutesId();
        Flight flight = new Flight();
        ModelAndView mv = new ModelAndView("flightEntryPage");
        mv.addObject("flightRecord", flight);
        mv.addObject("routeList", routeList);
        return mv;
    }

    @PostMapping("/flight")
    public ModelAndView saveFlight(@ModelAttribute("flightRecord") Flight flight,
                                   @RequestParam("dtime") String dtime,
                                   @RequestParam("atime") String atime,
                                   @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                Path filePath = uploadPath.resolve(fileName);

                file.transferTo(filePath.toFile());
                flight.setImageUrl("/imageairline/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        flightDao.save(flight);
        Flight returnFlight = flightService.createReturnFlight(flight, dtime, atime);
        flightDao.save(returnFlight);
        ModelAndView mv = new ModelAndView("redirect:/flights");
        mv.addObject("message", "Flight added successfully!");
        return mv;
    }

    @GetMapping("/flights")
    public ModelAndView showFlightReportPage() {
        List<Flight> flightList = flightDao.findAllFlights();
        ModelAndView mv = new ModelAndView("flightReportPage");
        mv.addObject("flightList", flightList);
        return mv;
    }
   
 
    @GetMapping("/deleteFlight")
    public ModelAndView deleteFlight(@RequestParam("id") Long flightNumber) {
        flightDao.deleteById(flightNumber);
        ModelAndView mv = new ModelAndView("redirect:/flights");
        mv.addObject("message", "Flight deleted successfully!");
        return mv;
    }
}
