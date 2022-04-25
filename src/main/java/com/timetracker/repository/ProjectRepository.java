package com.timetracker.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.timetracker.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
	
	List<Project> findAll();
	
	@Query(value = "SELECT * FROM project p " +
			"where p.id in (select t.project_id from task t inner join usertask ut on ut.task_id = t.id " +
			" inner join user u on ut.user_id = u.id " + 
							"where u.username = :username )", nativeQuery = true)
	Collection <Project> findByUsername(@Param("username") String username);

}
