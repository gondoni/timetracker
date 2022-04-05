package com.timetracker.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Usertask {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "task_id")
	private Task task;
	
	@JsonBackReference
	@OneToMany(mappedBy = "usertask")
	private List<Fulfillment> fulfillment;
	
	public Usertask() {
		
	}

	public Usertask(User user, Task task) {
		this.user = user;
		this.task = task;
	}
	
	public Usertask(Long id, User user, Task task) {
		this.id = id;
		this.user = user;
		this.task = task;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
}
