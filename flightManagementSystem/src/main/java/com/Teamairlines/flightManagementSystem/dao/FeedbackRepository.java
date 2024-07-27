package com.Teamairlines.flightManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.Teamairlines.flightManagementSystem.bean.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    @Query("select max(fId) from Feedback")
    Long findLastFeedbackId();
}
