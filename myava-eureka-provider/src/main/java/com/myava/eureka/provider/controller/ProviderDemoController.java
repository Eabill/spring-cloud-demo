package com.myava.eureka.provider.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderDemoController {
	
	@Value("${server.port}")
	private String port;
	
	@Value("${spring.redis.host}")
	private String redisHost;
	@Value("${spring.redis.port}")
	private String redisPort;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@GetMapping(value = "/demo/queryInformation")
	public String queryInformation() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "service invoke success, port: " + port;
	}
	
	@GetMapping(value = "/demo/redisConfig")
	public String redisConfig() {
		return redisHost + ":" + redisPort;
	}
	
	@GetMapping(value = "/demo/getValueFromRedis")
	public String getValueFromRedis(String key) {
		redisTemplate.opsForValue().set(key, key + ":" + UUID.randomUUID());
		return (String) redisTemplate.opsForValue().get(key);
	}
	
	@GetMapping(value = "/microservice/provider")
	public String route() {
		return "Myava-eureka-provider: " + UUID.randomUUID();
	}

}
