package com.example.demo.Repositories;


import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.AwsAlert;

public interface EventManagerRepository extends MongoRepository<AwsAlert, Object>{

	/*
	 * List<Tutorial> findByTitleContaining(String title); List<Tutorial>
	 * findByPublished(boolean published);
	 */
	
	
}
