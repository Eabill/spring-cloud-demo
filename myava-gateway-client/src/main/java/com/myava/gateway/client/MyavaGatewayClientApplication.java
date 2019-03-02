package com.myava.gateway.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyavaGatewayClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyavaGatewayClientApplication.class, args);
	}

}

