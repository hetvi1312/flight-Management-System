package com.Teamairlines.flightManagementSystem.dao;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Teamairlines.flightManagementSystem.bean.FlightUser;

public interface FlightUserRepository extends JpaRepository<FlightUser, String> {

    // Find a user by username
    Optional<FlightUser> findByUsername(String username);

    // Count users by type (e.g., admin, user)
    long countByType(String type);

    // New method to find all users by type
    List<FlightUser> findByType(String type);

    // New method to delete a user by username
    void deleteByUsername(String username);
}
