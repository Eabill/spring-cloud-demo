package com.myava.eureka.consumer.config;

import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.AbstractMessageListenerContainer.AckMode;

@Configuration
@Import(KafkaAutoConfiguration.class)
public class KafkaConfig {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean("batchContainerFactory")
	@Primary
    public ConcurrentKafkaListenerContainerFactory kafkaListenerContainerFactory(ConsumerFactory kafkaConsumerFactory) {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(kafkaConsumerFactory);
        factory.setConcurrency(5);
        factory.setBatchListener(true);
        factory.getContainerProperties().setAckMode(AckMode.MANUAL_IMMEDIATE);
        return factory;
    }

}
