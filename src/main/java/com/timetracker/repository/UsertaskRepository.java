package com.timetracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.timetracker.entity.Usertask;

public interface UsertaskRepository extends CrudRepository<Usertask, Long>{

	List<Usertask> findAll();
	
	Optional<Usertask> findById(Long id);

}
