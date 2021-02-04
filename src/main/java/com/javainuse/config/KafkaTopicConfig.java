package com.javainuse.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServer;
	
	@Bean
	public KafkaAdmin kafkaAdmin() {
		Map<String,Object> configMap = new HashMap<>();
		configMap.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		return new KafkaAdmin(configMap);
	}
	
	@Bean
	public NewTopic newTopic() {
		return new NewTopic("progTopic",1,(short)1);
	}
}
