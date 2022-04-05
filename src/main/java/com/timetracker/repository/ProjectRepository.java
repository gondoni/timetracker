package com.timetracker.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.timetracker.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
	
	List<Project> findAll();
	
	@Query(value = "SELECT * FROM project p " +
			"where p.id in (select t.project_id from task t inner join usertask ut on ut.task_id = t.id " +
							"where ut.user_id = 1)", nativeQuery = true)
	Collection <Project> findByUserId();

}
