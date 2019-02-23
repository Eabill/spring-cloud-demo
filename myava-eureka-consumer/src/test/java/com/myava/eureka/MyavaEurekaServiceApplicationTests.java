package com.myava.eureka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myava.eureka.feign.DemoFeignClient;
import com.myava.eureka.feign.FeignService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyavaEurekaServiceApplicationTests {
	
	@Autowired
	private FeignService feignService;
	@Autowired
	private DemoFeignClient demoFeignClient;

	@Test
	public void contextLoads() {
		// 动态的服务名或url方式
		DemoFeignClient client = feignService.newInstanceByName(DemoFeignClient.class, "myava-eureka-provider");
		System.out.println(client.getInfo());
		
		// 固定服务名和url方式
		System.out.println(demoFeignClient.getInfo());
	}

}

