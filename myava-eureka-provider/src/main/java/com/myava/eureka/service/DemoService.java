package com.myava.eureka.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoService {
	
	@Value("${eureka.instance.hostname}")
	private String hostname;
	@Value("${server.port}")
	private String port;
	
	@Value("${spring.redis.host}")
	private String redisHost;
	@Value("${spring.redis.port}")
	private String redisPort;
	
	@GetMapping(value = "/demo/queryInformation")
	public String queryInformation() {
		return "service invoke success, " + hostname + ": " + port;
	}
	
	@GetMapping(value = "/demo/redisConfig")
	public String redisConfig() {
		return redisHost + ":" + redisPort;
	}

}
