package com.ecommerce.main.config;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class Validator {
	
	public static final List<String> openApiEndpoints = List.of("/ratingandreviewauthenticationservice/register", "ratingandreviewauthenticationservice/token","/eureka","/v3/api-docs","/swagger-resources/**","swagger-ui/**","webjar/**") ;
	
	public Predicate<ServerHttpRequest> isSecured = request-> openApiEndpoints.stream().noneMatch(uri -> request.getURI().getPath().contains(uri)) ;

}
