package com.myava.gateway.client.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.myava.gateway.client.dto.RespResult;

import reactor.core.publisher.Mono;

@Service
public class GatewayRouteService implements ApplicationEventPublisherAware {

	@Autowired
	private RouteDefinitionWriter routeDefinitionWriter;

	private ApplicationEventPublisher publisher;
	@Autowired
	private StringRedisTemplate redisTemplate;

	public RespResult save(GatewayRouteDefinition gatewayRouteDefinition) {
		RouteDefinition routeDefinition = new RouteDefinition();
		routeDefinition.setId(gatewayRouteDefinition.getId());
//		routeDefinition.setUri(UriComponentsBuilder.fromHttpUrl(gatewayRouteDefinition.getUrl()).build().toUri());
		routeDefinition.setUri(UriComponentsBuilder.fromUriString(gatewayRouteDefinition.getUrl()).build().toUri());
		routeDefinition.setPredicates(gatewayRouteDefinition.getPredicates());
		routeDefinition.setFilters(gatewayRouteDefinition.getFilters());
		routeDefinitionWriter.save(Mono.just(routeDefinition)).subscribe();
		this.publisher.publishEvent(new RefreshRoutesEvent(this));
		return new RespResult();
	}

	public RespResult delete(String routeId) {
		routeDefinitionWriter.delete(Mono.just(routeId)).subscribe();
		return new RespResult();
	}

	public RespResult update(GatewayRouteDefinition gatewayRouteDefinition) {
		this.delete(gatewayRouteDefinition.getId());
		return this.save(gatewayRouteDefinition);
	}
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}

	public boolean cleanCache(String key) {
		return redisTemplate.delete(key);
	}

}
