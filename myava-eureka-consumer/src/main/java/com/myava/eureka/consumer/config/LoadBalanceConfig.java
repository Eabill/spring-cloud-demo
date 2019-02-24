package com.myava.eureka.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;

/**
 * @description Ribbon负载均衡配置
 */
@SuppressWarnings("all")
@Configuration
public class LoadBalanceConfig {
	
	/**
	 * 客户端使用Ribbon实现负载均衡，默认使用轮询策略
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	/**
	 * 轮询策略
	 * @return
	 */
	@Bean
	public IRule roundRobinRule() {
		return new RoundRobinRule();
	}
	
//	/**
//	 * 随机策略
//	 * @return
//	 */
//	@Bean
//	public IRule randomRule() {
//		return new RandomRule();
//	}
	
//	/**
//	 * 最小并发量策略
//	 * @return
//	 */
//	@Bean(name = "bestAvailableRule")
//	public IRule bestAvailableRule() {
//		return new BestAvailableRule();
//	}
//	
//	/**
//	 * 重试策略
//	 * @return
//	 */
//	@Bean(name = "retryRule")
//	public IRule retryRule() {
//		return new RetryRule();
//	}
//	
//	/**
//	 * 可用过滤链策略
//	 * @return
//	 */
//	@Bean(name = "availabilityFilteringRule")
//	public IRule availabilityFilteringRule() {
//		return new AvailabilityFilteringRule();
//	}
//	
//	/**
//	 * Zone区域策略
//	 * @return
//	 */
//	@Bean(name = "zoneAvoidanceRule")
//	public IRule zoneAvoidanceRule() {
//		return new ZoneAvoidanceRule();
//	}
//	
//	/**
//	 * 加权-响应时间策略
//	 * @return
//	 */
//	@Bean(name = "weightedResponseTimeRule")
//	public IRule weightedResponseTimeRule() {
//		return new WeightedResponseTimeRule();
//	}

}
