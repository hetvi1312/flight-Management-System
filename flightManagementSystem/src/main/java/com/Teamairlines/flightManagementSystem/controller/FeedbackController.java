package com.Teamairlines.flightManagementSystem.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RestController;
import com.Teamairlines.flightManagementSystem.bean.Feedback;
import com.Teamairlines.flightManagementSystem.dao.FeedbackDao;

@RestController
public class FeedbackController {

    @Autowired
    private FeedbackDao feedbackDao;

    @GetMapping("/feedback-report")
    public ModelAndView showFeedbackReportPage() {
        List<Feedback> feedbackList = feedbackDao.displayAllFeedbacks();
        ModelAndView mv = new ModelAndView("feedbackReportPage");
        mv.addObject("feedbackList", feedbackList);
        return mv;
    }
    
    @GetMapping("/feedback")
    public ModelAndView showFeedbackPage() {
        ModelAndView mv = new ModelAndView("feedbackPage");
        mv.addObject("feedbackRecord", new Feedback());
        return mv;
    }

    @PostMapping("/feedback")
    public ModelAndView saveFeedback(@ModelAttribute("feedbackRecord") Feedback feedback, HttpServletRequest request) {
        String username = request.getUserPrincipal().getName(); // Get the username from the authenticated user
        feedback.setUsername(username);
        feedback.setfId(feedbackDao.generateFeedbackId());
        feedbackDao.saveNewFeedback(feedback);
        ModelAndView mv = new ModelAndView("redirect:/feedback-history");
        mv.addObject("message", "Feedback added successfully!");
        return mv;
    }

    @GetMapping("/feedback-show")
    public ModelAndView showSingleFeedback(@RequestParam("id") Long id) {
        Feedback feedback = feedbackDao.findFeedbackById(id);
        ModelAndView mv = new ModelAndView("feedbackShowPage");
        mv.addObject("feedback", feedback);
        return mv;
    }

  
    @GetMapping("/deleteFeedback")
    public ModelAndView deleteFeedback(@RequestParam("id") Long id) {
        feedbackDao.deleteFeedback(id);
        ModelAndView mv = new ModelAndView("redirect:/feedback-history");
        mv.addObject("message", "Feedback deleted successfully!");
        return mv;
    }

    @GetMapping("/feedback-history")
    public ModelAndView showFeedbackHistory(HttpServletRequest request) {
        String username = request.getUserPrincipal().getName(); // Get the username from the authenticated user
        List<Feedback> feedbackList = feedbackDao.findFeedbackByUsername(username);
        ModelAndView mv = new ModelAndView("feedbackHistoryPage");
        mv.addObject("feedbackList", feedbackList);
        return mv;
    }
}
