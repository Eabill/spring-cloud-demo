package com.myava.eureka.feign.fallback;

import org.springframework.stereotype.Component;

import com.myava.eureka.feign.DemoFeignClient;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DemoFeignClientFallbackFactory implements FallbackFactory<DemoFeignClient> {

	@Override
	public DemoFeignClient create(Throwable throwable) {
		log.error("fallback error.", throwable.getCause());
		return new DemoFeignClient() {

			@Override
			public String getInfo() {
				return "Get info error, try again later.";
			}
			
		};
	}

}
