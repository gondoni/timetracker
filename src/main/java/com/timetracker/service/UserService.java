package com.timetracker.service;

import org.springframework.security.core.Authentication;

import com.timetracker.entity.User;

public interface UserService {
	
	public User findByUsername(String username);

}
