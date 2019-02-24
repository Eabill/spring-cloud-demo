package com.myava.eureka.provider.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
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
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@GetMapping(value = "/demo/queryInformation")
	public String queryInformation() {
		return "service invoke success, " + hostname + ": " + port;
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

}
