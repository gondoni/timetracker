package com.timetracker.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.timetracker.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{
	
	List<Task> findAll();
	
	@Query(value = "select * from task t " +
					"where t.id in (select ut.task_id from usertask ut where ut.user_id = 1)", nativeQuery = true)
	Collection<Task> findByUserId();

}
