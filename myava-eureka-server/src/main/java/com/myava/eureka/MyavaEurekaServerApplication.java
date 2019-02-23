package com.myava.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MyavaEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyavaEurekaServerApplication.class, args);
	}

}

