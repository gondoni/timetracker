package com.timetracker.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id;
	private String name;
	private String username;
	private String password;

	@OneToMany(mappedBy = "user")
	private Set<Usertask> tasks;

	public User() {
		
	}

	public User(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public User(Long id, String name, String username, String password) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
