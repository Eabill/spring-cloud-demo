package com.myava.eureka.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.myava.eureka.consumer.feign.fallback.DemoFeignClientFallback;
import com.myava.eureka.consumer.feign.fallback.DemoFeignClientFallbackFactory;

@SuppressWarnings("all")
@FeignClient(name = "myava-eureka-provider", 
	/*fallback = DemoFeignClientFallback.class,*/
	fallbackFactory = DemoFeignClientFallbackFactory.class)
public interface DemoFeignClient {
	
	@GetMapping("/service/demo/getInformation")
	String getInformation(); 

}
