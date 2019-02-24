package com.myava.eureka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = { "com.myava.eureka" })
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
public class MyavaEurekaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyavaEurekaConsumerApplication.class, args);
	}
	
}

