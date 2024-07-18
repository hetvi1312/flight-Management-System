package com.Teamairlines.flightManagementSystem.controller;

import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.Teamairlines.flightManagementSystem.bean.FlightUser;
import com.Teamairlines.flightManagementSystem.service.FlightUserService;

@RestController
public class LoginController {

    @Autowired
    private FlightUserService service;

    @Autowired
    private BCryptPasswordEncoder bCrypt;

    @GetMapping("/register")
    public ModelAndView showUserRegisterPage() {
        FlightUser user = new FlightUser();
        ModelAndView mv = new ModelAndView("newUserEntry");
        mv.addObject("userRecord", user);
        return mv;
    }

    @PostMapping("/register")
    public ModelAndView saveUserRegisterPage(@ModelAttribute("userRecord") FlightUser user) {
        String encodedPassword = bCrypt.encode(user.getPassword());
        FlightUser newUser = new FlightUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(encodedPassword);
        newUser.setType(user.getType());
        service.save(newUser);
        ModelAndView mv = new ModelAndView("loginPage");
        mv.addObject("registrationSuccess", true);
        return mv;
    }

    @GetMapping("/loginpage")
    public ModelAndView showLoginPage() {
        return new ModelAndView("loginPage");
    }

    @GetMapping("/loginsuccess")
    public ModelAndView loginSuccess(HttpServletRequest request) {
        String username = request.getUserPrincipal().getName();
        FlightUser user = service.findByUsername(username);
        ModelAndView mv;
        if (user.getType().equals("admin")) {
            mv = new ModelAndView("welcomePage");
        } else {
            mv = new ModelAndView("UserwelcomePage");
        }
        mv.addObject("username", username);
        return mv;
    }

    @GetMapping("/loginerror")
    public ModelAndView showLoginErrorPage() {
        return new ModelAndView("loginErrorPage");
    }
}
