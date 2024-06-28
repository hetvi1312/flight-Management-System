package com.Teamairlines.flightManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Teamairlines.flightManagementSystem.bean.Route;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    @Query("select max(routeId) from Route")
    Long findLastRouteId();

    @Query("SELECT a FROM Route a WHERE sourceAirportCode = ?1 AND destinationAirportCode = ?2")
    Route findRouteBySourceAndDestination(String sourceAirportCode, String destinationAirportCode);

    @Query("SELECT routeId FROM Route")
    List<Long> findAllRoutesId();
}
