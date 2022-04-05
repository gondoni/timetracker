package com.timetracker.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.timetracker.entity.Fulfillment;

public interface FulfillmentRepository extends CrudRepository<Fulfillment, Long>{
	
	List<Fulfillment> findAll();
	
	@Query(value = "select * from fulfillment f " +
			"where f.usertask_id in (select ut.id from usertask ut where ut.user_id = 1)", nativeQuery = true)
	Collection <Fulfillment> findByUserId();


}
