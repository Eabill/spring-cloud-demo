package com.myava.eureka.consumer.feign.fallback;

import org.springframework.stereotype.Component;

import com.myava.eureka.consumer.feign.DemoFeignClient;

@Component
public class DemoFeignClientFallback implements DemoFeignClient {

	@Override
	public String getInformation() {
		return "Get info error, try again later.";
	}

}
