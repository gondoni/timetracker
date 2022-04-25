package com.timetracker.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.timetracker.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{
	
	List<Task> findAll();
	
	@Query(value = "select * from task t " +
					"where t.id in (select ut.task_id from usertask ut " +
						" inner join user u on ut.user_id = u.id " +
						" where u.username = :username)", nativeQuery = true)
	Collection<Task> findByUsername(@Param("username") String username);

}
