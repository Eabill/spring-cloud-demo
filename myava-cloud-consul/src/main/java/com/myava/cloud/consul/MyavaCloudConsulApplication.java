package com.myava.cloud.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication(scanBasePackages = { "com.myava.cloud" })
@EnableDiscoveryClient
public class MyavaCloudConsulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyavaCloudConsulApplication.class, args);
	}
	
}

