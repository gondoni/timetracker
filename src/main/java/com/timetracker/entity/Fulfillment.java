package com.timetracker.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fulfillment {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id;
	
	@ManyToOne
	private Usertask usertask;
	
	private Date fulfillDate;
	private Float hours;
	private String description;
	
	public Fulfillment() {
		
	}
	
	public Fulfillment(Usertask usertask, Date fulfillDate, Float hours, String description) {
		this.usertask = usertask;
		this.fulfillDate = fulfillDate;
		this.hours = hours;
		this.description = description;
	}
	
	
	public Fulfillment(Long id, Usertask usertask, Date fulfillDate, Float hours, String description) {
		this.id = id;
		this.usertask = usertask;
		this.fulfillDate = fulfillDate;
		this.hours = hours;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usertask getUsertask() {
		return usertask;
	}

	public void setUsertask(Usertask usertask) {
		this.usertask = usertask;
	}

	public Date getFulfillDate() {
		return fulfillDate;
	}

	public void setFulfillDate(Date fulfillDate) {
		this.fulfillDate = fulfillDate;
	}

	public Float getHours() {
		return hours;
	}

	public void setHours(Float hours) {
		this.hours = hours;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
