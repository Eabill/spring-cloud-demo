package com.myava.eureka.consumer.listener;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.myava.eureka.consumer.constant.SystemConstant;

@Component
public class KafkaSingleListener {
	
	@KafkaListener(id = "single-consumer", topics = { SystemConstant.TOPIC_MYAVA_EUREKA_CONSUMER })
	public void receive(ConsumerRecord<String, Object> consumerRecord, Consumer<?, ?> consumer) {
		
		System.out.println("-------------------------single-start-------------------------");
		System.out.println(consumerRecord);
		consumer.commitSync(); // 手动提交位移
		System.out.println("-------------------------single-finish-------------------------");
		
	}

}
