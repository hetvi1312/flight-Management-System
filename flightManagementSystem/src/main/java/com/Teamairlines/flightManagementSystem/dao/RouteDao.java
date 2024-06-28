package com.Teamairlines.flightManagementSystem.dao;

import java.util.List;
import com.Teamairlines.flightManagementSystem.bean.Route;

public interface RouteDao {
	public void save(Route route);
	public List<Route> findAllRoutes();
	public Route findRouteById(Long id);
	public  Route findRouteBySourceAndDestination(String source, String destination);
	public Long generateRouteId(); // Add this line
	public List<Long> findAllRoutesId();
}
