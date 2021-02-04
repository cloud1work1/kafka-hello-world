package com.javainuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.service.KafkaProducerService;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

	@Autowired
	private KafkaProducerService kafkaProducerService;
	
	private final String PROG_TOPIC_NAME = "progTopic";
	@Autowired
	@Qualifier(value="progKafkaTemplate")
	private KafkaTemplate myKafkaTemplate;
	
	
	@GetMapping("/{message}")
	public String postMessage(@PathVariable("message") String message) {
		myKafkaTemplate.send(PROG_TOPIC_NAME, message);
		return kafkaProducerService.postMessage(message);
	}
}
