package com.Teamairlines.flightManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Teamairlines.flightManagementSystem.bean.FlightUser;
import com.Teamairlines.flightManagementSystem.dao.FlightUserRepository;

@Service
public class FlightUserService implements UserDetailsService {
	
	@Autowired
	private FlightUserRepository repository;
	private String type;
	
	public void save(FlightUser user) {
		repository.save(user);
	}
	public String getType() {
		return type;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
	FlightUser users= repository.findById(username).get();
	type=users.getType();
	return users;
}

    public FlightUser findByUsername(String username) {
        return repository.findByUsername(username).orElse(null);
    }
}
