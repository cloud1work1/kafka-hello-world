package com.javainuse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	private final String TOPIC_NAME = "apptopic";
	
	public String postMessage(String message) {
		kafkaTemplate.send(TOPIC_NAME, message);
		return "Message sent successfully to "+ TOPIC_NAME + " topic";
	}
}
