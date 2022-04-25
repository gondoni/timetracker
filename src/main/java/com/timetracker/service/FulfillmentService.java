package com.timetracker.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timetracker.entity.Fulfillment;
import com.timetracker.repository.FulfillmentRepository;

@Service
public class FulfillmentService {

	private FulfillmentRepository ffRepo;
	
	@Autowired
	public void setFulfillmentRepo(FulfillmentRepository ffRepo) {
		this.ffRepo = ffRepo;
	}

	public List<Fulfillment> getFulfillments() {
		return ffRepo.findAll();
	}
	
	public List<Fulfillment> getFulfillmentsByUsername(String username) {
		Collection coll = ffRepo.findByUsername(username);
		return (coll instanceof List ? (List)coll : new ArrayList(coll));
	}

}
