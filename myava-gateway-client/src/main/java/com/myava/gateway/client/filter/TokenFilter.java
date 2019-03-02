package com.myava.gateway.client.filter;

import java.nio.charset.StandardCharsets;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson.JSON;
import com.myava.gateway.client.dto.RespResult;

import reactor.core.publisher.Mono;

@Component
public class TokenFilter implements GlobalFilter {
	
	private static final String MYAVE_GATEWAY_CLIENT_TOKEN = "123456789";
	private static final String KEY_TOKEN = "token";
	private static final String LOCALHOST = "localhost|127.0.0.1";

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		String token = exchange.getRequest().getHeaders().getFirst(KEY_TOKEN);
		String host = exchange.getRequest().getURI().getHost();
        if (MYAVE_GATEWAY_CLIENT_TOKEN.equals(token) || LOCALHOST.contains(host)) {
            return chain.filter(exchange);
        }
        ServerHttpResponse response = exchange.getResponse();
        RespResult respResult = new RespResult(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
        byte[] datas = JSON.toJSONString(respResult).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(datas);
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
	}
	
}
