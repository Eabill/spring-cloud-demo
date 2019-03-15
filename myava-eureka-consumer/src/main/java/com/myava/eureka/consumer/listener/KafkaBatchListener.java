package com.myava.eureka.consumer.listener;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.myava.eureka.consumer.constant.SystemConstant;

@Component
public class KafkaBatchListener {
	
	@KafkaListener(id = "batch-consumer", topics = { SystemConstant.TOPIC_MYAVA_EUREKA_CONSUMER }, containerFactory = "batchContainerFactory")
	public void receive(List<ConsumerRecord<String, Object>> records, Acknowledgment ack) {
		
		System.out.println("-------------------------batch-start-------------------------");
		System.out.println("size: " + records.size());
		for (ConsumerRecord<String, Object> record : records) {
			System.out.println(record);
		}
		ack.acknowledge(); // 手动提交位移
		System.out.println("-------------------------batch-finish-------------------------");
		
	}

}
