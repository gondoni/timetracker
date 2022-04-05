package com.timetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timetracker.entity.Fulfillment;
import com.timetracker.service.FulfillmentService;
import com.timetracker.entity.Project;
import com.timetracker.service.ProjectService;
import com.timetracker.entity.Task;
import com.timetracker.service.TaskService;

@RestController
public class ApiController {

	private ProjectService projService;
	private TaskService taskService;
	private FulfillmentService ffService;
	
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

	
//	@RequestMapping("/title/{title}")
//	public Story searchForTitle(@PathVariable(value="title") String title) throws Exception {
//		return storyService.getSpecificStory(title);
//	}

	@RequestMapping("/projects")
	public List<Project> projects() throws Exception {
		return projService.getProjectsByUserId();
//		return projService.getProjects();
	}
	
	@RequestMapping("/tasks")
	public List<Task> tasks() throws Exception {
		return taskService.getTasksByUserId();
//		return taskService.getTasks();
	}

	@RequestMapping("/fulfillments")
	public List<Fulfillment> fulfillments() throws Exception {
		return ffService.getFulfillmentsByUserId();
	}
	
//	@RequestMapping("/stories/{name}")
//	public List<Story> searchStoriesByBloggerName(@PathVariable(value="name") String name) throws Exception {
//		return storyService.getStoriesByBloggerName(name);
//	}
	
}
