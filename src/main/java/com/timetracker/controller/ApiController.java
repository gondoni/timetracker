package com.timetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.timetracker.entity.Fulfillment;
import com.timetracker.service.FulfillmentService;
import com.timetracker.entity.Project;
import com.timetracker.service.ProjectService;
import com.timetracker.entity.Task;
import com.timetracker.repository.FulfillmentRepository;
import com.timetracker.service.TaskService;
import com.timetracker.service.UserService;

@RestController
public class ApiController {

	private ProjectService projService;
	private TaskService taskService;
	private FulfillmentService ffService;
	private UserService userService;
	private Authentication authentication;
	private FulfillmentRepository ffRepo;
	
	ApiController(FulfillmentRepository ffRepo) {
		this.ffRepo = ffRepo;
	}
	
	@Autowired	
	public void setProjectService(ProjectService projService) {
		this.projService = projService;
	}
	
	@Autowired	
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	@Autowired	
	public void setFulfillmentService(FulfillmentService ffService) {
		this.ffService = ffService;
	}

	@RequestMapping("/")
	public String index() throws Exception {
		authentication = SecurityContextHolder.getContext().getAuthentication();
		return "Bejeletkezve: " + authentication.getName();
	}
	
	@RequestMapping("/projects")
	public List<Project> projects() throws Exception {
		authentication = SecurityContextHolder.getContext().getAuthentication();
		return projService.getProjectsByUsername(authentication.getName());
	}
	
	@RequestMapping("/tasks")
	public List<Task> tasks() throws Exception {
		authentication = SecurityContextHolder.getContext().getAuthentication();
		return taskService.getTasksByUsername(authentication.getName());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fulfillments")
	public List<Fulfillment> fulfillments() throws Exception {
		authentication = SecurityContextHolder.getContext().getAuthentication();
		return ffService.getFulfillmentsByUsername(authentication.getName());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/fulfillments")
	List<Fulfillment> newFulfillment(@RequestBody Fulfillment newFulfillment) {
		ffRepo.save(newFulfillment);
	    return ffService.getFulfillmentsByUsername("nferi");
	  }
}
