package com.myava.eureka.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyavaEurekaProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyavaEurekaProviderApplication.class, args);
	}

}

