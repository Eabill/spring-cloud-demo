package com.myava.gateway.client.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myava.gateway.client.dto.RespResult;

@RestController
public class FallbackController {

	@GetMapping("/fallback")
	public RespResult fallback() {
		return new RespResult(HttpStatus.SERVICE_UNAVAILABLE.value(), HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase());
	}
	
	
}
