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
	
	@GetMapping(value = "/demo/getInfo")
	public String getInfo() {
		return "service invoke success, " + hostname + ": " + port;
	}

}
