package com.timetracker.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timetracker.entity.Project;
import com.timetracker.repository.ProjectRepository;

@Service
@Transactional(readOnly = true)
public class ProjectService {
	
	private ProjectRepository projRepo;
	
	@Autowired
	public void setProjectRepo(ProjectRepository projRepo) {
		this.projRepo = projRepo;
	}

	public List<Project> getProjects() {
		return projRepo.findAll();
	}
	
	public List<Project> getProjectsByUserId() {
		Collection coll = projRepo.findByUserId();
		return (coll instanceof List ? (List)coll : new ArrayList(coll));
	}
}
