package com.timetracker.service;

import com.timetracker.entity.User;

public interface UserService {
	
	public User findByUsername(String username);

}
