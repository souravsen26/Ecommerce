package com.ecommerce.main.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config>{

	public AuthenticationFilter() {
		super(Config.class) ;
	}
	
	@Autowired
	private Validator validator ;
	
	@Autowired
	private RestTemplate restTemplate ;
	
	public static final Logger log = LogManager.getLogger() ; 
	
	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange,chain)->{
			if(validator.isSecured.test(exchange.getRequest()))
			{
				if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION))
				{
					throw new RuntimeException("missing authorization Header") ;
				}
				
				String authHead = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0) ;
				if(authHead!=null && authHead.startsWith("Bearer ")) {
					authHead= authHead.substring(7) ;
				}
				try {
					String response = restTemplate.getForObject("http://localhost:8363/ratingandreviewauthenticationservice/validate?token="+authHead, String.class);
					/*headers.set("Authorization", "Bearer your_token_here");
					log.info("Response is : + "+ response) ;*/
					exchange.getRequest().mutate().header("authorization", "Basic Z2F0ZXdheTphYiVyZiFANjc4OTkzQEAqKioqNTY0NTY3ITI0MzY3OCpod2VydHkhIUAjMzQ=").build() ;
					/*exchange.getRequest().mutate().header("UserName","gateway").build() ;
					exchange.getRequest().mutate().header("Password","ab%rf!@678993@@****564567!243678*hwerty!!@#34").build() ; */
					
				}
				catch(Exception e) {
					 throw new RuntimeException("Un authorized error") ;
				}
				
			}
			return chain.filter(exchange) ;
		}) ;
	}
	
	public static class Config{
		
	}
}
