package com.example.demo.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repositories.EventManagerRepository;
import com.example.demo.model.AwsAlert;

/*import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
*/


@RestController
public class Controller {
	

	@Autowired
    private KafkaTemplate<String, Object> 
        kafkaTemplate; 
  
    private static final String TOPIC 
        = "test"; //3
    
    @Autowired
    private EventManagerRepository repository;
    
	/* MongoClient mongoClient = new MongoClient(); */
    
	@RequestMapping("/")
	public String show()
	{
		return "Hello";
	}
	
  
     
    @PostMapping("/cloudwatch")
    public String post(@RequestBody  String alert) 
    { 
    	System.out.println("\n Cloudwatch collected alert: " + alert);
    	AwsAlert a=new AwsAlert(alert);
        kafkaTemplate.send(TOPIC, alert);
        repository.save(a);
  
        return "Published successfully"; 
    } 


	

}
