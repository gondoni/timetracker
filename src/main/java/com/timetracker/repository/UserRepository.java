package com.timetracker.repository;

import org.springframework.data.repository.CrudRepository;

import com.timetracker.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);

}
