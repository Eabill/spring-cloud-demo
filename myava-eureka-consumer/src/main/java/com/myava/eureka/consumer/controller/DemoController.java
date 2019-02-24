package com.myava.eureka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.myava.eureka.consumer.dto.Demo;
import com.myava.eureka.consumer.dto.RespResult;
import com.myava.eureka.consumer.feign.DemoFeignClient;

import io.swagger.annotations.ApiOperation;

@RestController
public class DemoController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String URL = "http://myava-eureka-provider/service/demo/queryInformation";
	
	@Autowired
	private DemoFeignClient demoFeignClient;
	
	@GetMapping("/demo/queryInformation")
	public String queryInformation() {
		// 通过restTemplate访问
		String restResp = restTemplate.getForObject(URL, String.class);
		System.out.println("restResp: " + restTemplate.getForObject(URL, String.class));
		// 通过feign client访问
		System.out.println("feignResp: " + demoFeignClient.getInformation());
		return restResp;
	}
	
	@ApiOperation(value = "获取信息")
	@GetMapping("/demo/swaggerApiDoc")
	public RespResult<Demo> swaggerApiDoc() {
		// Swagger返回泛型测试
		return RespResult.success(new Demo("ABC", "This is abc."));
	}
	
}