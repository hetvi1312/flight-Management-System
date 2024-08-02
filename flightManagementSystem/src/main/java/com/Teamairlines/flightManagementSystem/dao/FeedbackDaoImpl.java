package com.Teamairlines.flightManagementSystem.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.Teamairlines.flightManagementSystem.bean.Feedback;

@Repository
@Service
public class FeedbackDaoImpl implements FeedbackDao {

    @Autowired
    private FeedbackRepository repository;
    
    @Override
    public void saveNewFeedback(Feedback feedback) {
        repository.save(feedback); 
    }
    
    @Override
    public List<Feedback> displayAllFeedbacks() {
        return repository.findAll();
    }

    @Override
    public Long generateFeedbackId() {
        Long val = repository.findLastFeedbackId();
        return (val == null) ? 1L : val + 1;
    }
    
    @Override
    public Feedback findFeedbackById(Long id) {
        return repository.findById(id).orElse(null); // Optional: Implement find by ID
    }

   
    @Override
    public void deleteFeedback(Long id) {
        repository.deleteById(id); // Optional: Implement delete
    }
    @Override
    public long countFeedbacks() {
        return repository.count();
    }
    @Override
    public List<Feedback> findFeedbackByUsername(String username) {
        return repository.findByUsername(username);
    }
}
