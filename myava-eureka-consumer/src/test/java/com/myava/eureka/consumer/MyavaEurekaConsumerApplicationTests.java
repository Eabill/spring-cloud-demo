package com.myava.eureka.consumer;

import java.util.concurrent.CountDownLatch;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.myava.eureka.consumer.feign.DemoFeignClient;
import com.myava.eureka.consumer.feign.FeignService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyavaEurekaConsumerApplicationTests {
	
	@Autowired
	private FeignService feignService;
	@Autowired
	private DemoFeignClient demoFeignClient;

	@Test
	@Ignore
	public void contextLoads() {
		// 动态的服务名或url方式
		DemoFeignClient client = feignService.newInstanceByName(DemoFeignClient.class, "myava-eureka-provider");
		System.out.println(client.getInformation());
		
		// 固定服务名和url方式
		System.out.println(demoFeignClient.getInformation());
	}
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String URL = "http://myava-gateway-client/demo/queryInformation";
	
	@Test
	public void testRateLimiter() {
		CountDownLatch latch = new CountDownLatch(10);
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						String resp = restTemplate.getForObject(URL, String.class);
						System.out.println("+++++++++++++++++++resp: " + resp);
					} finally {
						latch.countDown();
					}
				}
			}).start();
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("----------------Invoke finish-----------------------------------------------------");
	}

}

