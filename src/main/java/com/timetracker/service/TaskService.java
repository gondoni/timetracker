package com.timetracker.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timetracker.entity.Task;
import com.timetracker.repository.TaskRepository;

@Service
@Transactional(readOnly = true)
public class TaskService {
	
private TaskRepository taskRepo;
	
	@Autowired
	public void setTaskRepo(TaskRepository taskRepo) {
		this.taskRepo = taskRepo;
	}

	public List<Task> getTasks() {
		return taskRepo.findAll();
	}

	public List<Task> getTasksByUsername(String username) {
		Collection coll = taskRepo.findByUsername(username);
		return (coll instanceof List ? (List)coll : new ArrayList(coll));
	}

}
