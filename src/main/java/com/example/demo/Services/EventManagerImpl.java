package com.example.demo.Services;

import java.util.Map;

import org.springframework.stereotype.Service;
import com.example.demo.Interfaces.EventManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;


@Service
public class EventManagerImpl {

	/*	@Override
	public void prometheusAlerts(Map<String, Object> alert) {
		// TODO Auto-generated method stub
		System.out.println("Prometheus WebHook collected JSON: " + alert);

	}
	
*/
	
	
	@Autowired
    private KafkaTemplate<String, Object>   //Object->Map<String, Object>
        kafkaTemplate; 
  
    private static final String TOPIC 
        = "test"; //3
        


	public String AwsAlerts(String alert)
    {
		kafkaTemplate.send(TOPIC, alert);
		System.out.println("CloudWatch collected JSON: " + alert);
		return alert;
	}

	public void otherOpenSourceAlerts(Map<String, Object> alert) {
		System.out.println("Not yet implemented");
		

	}

	
	
}
