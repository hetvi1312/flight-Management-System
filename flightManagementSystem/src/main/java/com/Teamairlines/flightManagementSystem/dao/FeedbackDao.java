package com.Teamairlines.flightManagementSystem.dao;

import java.util.List;
import com.Teamairlines.flightManagementSystem.bean.Feedback;

public interface FeedbackDao {
    void saveNewFeedback(Feedback feedback);
    List<Feedback> displayAllFeedbacks(); 
    Long generateFeedbackId();
    Feedback findFeedbackById(Long id); // Optional: Method to find feedback by ID
    void updateFeedback(Feedback feedback); // Optional: Method to update feedback
    void deleteFeedback(Long id); // Optional: Method to delete feedback
    long countFeedbacks();
}
