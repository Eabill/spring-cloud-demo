package com.myava.gateway.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myava.gateway.client.dto.RespResult;
import com.myava.gateway.client.route.GatewayRouteDefinition;
import com.myava.gateway.client.route.GatewayRouteService;

@RestController
public class GatewayRouteController {
	
	@Autowired
	private GatewayRouteService gatewayRouteService;
	
	@PostMapping(value = "/route/add")
	public RespResult add(@RequestBody GatewayRouteDefinition gatewayRouteDefinition) {
		return gatewayRouteService.save(gatewayRouteDefinition);
	}
	
	@PostMapping(value = "/route/delete")
	public RespResult delete(@RequestParam String routeId) {
		return gatewayRouteService.delete(routeId);
	}
	
	@PostMapping(value = "/route/update")
	public RespResult update(GatewayRouteDefinition gatewayRouteDefinition) {
		return gatewayRouteService.update(gatewayRouteDefinition);
	}
	
	@PostMapping(value = "/route/cleanCache")
	public boolean cleanCache(@RequestParam String key) {
		return gatewayRouteService.cleanCache(key);
	}

}
