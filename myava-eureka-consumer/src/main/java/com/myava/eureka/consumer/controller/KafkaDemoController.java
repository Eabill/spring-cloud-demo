package com.myava.eureka.consumer.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myava.eureka.consumer.constant.SystemConstant;

@RestController
public class KafkaDemoController {
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	@PostMapping(value = "/kafka/send")
	public void send() {
		ListenableFuture<SendResult<String, Object>> result = kafkaTemplate.send(SystemConstant.TOPIC_MYAVA_EUREKA_CONSUMER, UUID.randomUUID().toString());
		result.addCallback(successCallback -> {
			System.out.println("Kafka send message succ.");
		}, errorCallback -> {
			System.out.println("Kafka send message error.");
		});
	}

}
