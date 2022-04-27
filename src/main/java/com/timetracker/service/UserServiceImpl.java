package com.timetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.timetracker.entity.User;
import com.timetracker.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	private UserRepository userRepository;
	private final String USER_ROLE = "USER";
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		System.out.println("User keresés");
		User user = findByUsername(username);
		if( user == null ){
			throw new UsernameNotFoundException(username);
		}
		
		return new UserDetailsImpl(user);
	}
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
}
