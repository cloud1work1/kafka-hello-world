package com.javainuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/{message}")
	public String postMessage(@PathVariable("message") String message) {
		return kafkaProducerService.postMessage(message);
	}
}
