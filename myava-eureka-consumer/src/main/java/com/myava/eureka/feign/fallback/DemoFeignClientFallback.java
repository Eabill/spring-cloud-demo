package com.myava.eureka.feign.fallback;

import org.springframework.stereotype.Component;

import com.myava.eureka.feign.DemoFeignClient;

@Component
public class DemoFeignClientFallback implements DemoFeignClient {

	@Override
	public String getInfo() {
		return "Get info error, try again later.";
	}

}
