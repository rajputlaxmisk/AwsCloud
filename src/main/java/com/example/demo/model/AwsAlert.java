package com.example.demo.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;	

@Document(collection = "AwsAlert")
public class AwsAlert {

	
	@Id
	//private String id;
	private Object alert;

	public AwsAlert(Object alert) {
		super();
		this.alert = alert;
	}

	public Object getAlert() {
		return alert;
	}

	public void setAlert(Object alert) {
		this.alert = alert;
	}
	  
	/*
	 * public String getId() { return id; } public void setId(String id) { this.id =
	 * id; }
	 */
	/*
	 * public Map<String, Object> getAlert() { return alert; } public void
	 * setAlert(Map<String, Object> alert) { this.alert = alert; }
	 */
	  

	
}
