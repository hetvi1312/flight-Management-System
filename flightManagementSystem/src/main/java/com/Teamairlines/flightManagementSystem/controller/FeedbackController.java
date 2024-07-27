package com.Teamairlines.flightManagementSystem.controller;

import java.util.List;

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
    public ModelAndView saveFeedback(@ModelAttribute("feedbackRecord") Feedback feedback) {
        feedback.setfId(feedbackDao.generateFeedbackId());
        feedbackDao.saveNewFeedback(feedback);
        ModelAndView mv = new ModelAndView("redirect:/flight-search");
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

    @GetMapping("/editFeedbackForm")
    public ModelAndView showEditFeedbackForm(@RequestParam("id") Long id) {
        Feedback feedback = feedbackDao.findFeedbackById(id);
        ModelAndView mv = new ModelAndView("editFeedbackPage");
        mv.addObject("feedbackRecord", feedback);
        return mv;
    }

    @PostMapping("/updateFeedback")
    public ModelAndView updateFeedback(@ModelAttribute("feedbackRecord") Feedback feedback) {
        feedbackDao.updateFeedback(feedback);
        ModelAndView mv = new ModelAndView("redirect:/feedback-report");
        mv.addObject("message", "Feedback updated successfully!");
        return mv;
    }

    @GetMapping("/deleteFeedback")
    public ModelAndView deleteFeedback(@RequestParam("id") Long id) {
        feedbackDao.deleteFeedback(id);
        ModelAndView mv = new ModelAndView("redirect:/feedback-report");
        mv.addObject("message", "Feedback deleted successfully!");
        return mv;
    }
  
}
