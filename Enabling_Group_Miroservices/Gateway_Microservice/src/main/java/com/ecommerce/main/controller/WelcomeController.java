package com.ecommerce.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.dto.GlobalResponseEntity;

import reactor.core.publisher.Mono;

@RestController
public class WelcomeController {
	
	@RequestMapping(value="/productsFailed",method=RequestMethod.GET)
	public Mono<String> productServiceFailed(){
		/*GlobalResponseEntity responseEntity = new GlobalResponseEntity("","Failure") ;
		return responseEntity ; */
		
		return Mono.just("Failure") ;
	}
	
	@RequestMapping(value="/cartandUserService",method=RequestMethod.GET)
	public Mono<String> cartAndUserFailed(){
	/*	GlobalResponseEntity responseEntity = new GlobalResponseEntity("","Failuree") ;
		return responseEntity ; */
		
		return Mono.just("Failuree") ;
	}
	
	@RequestMapping(value="/reviewandratingService",method=RequestMethod.GET)
	public Mono<String> reviewAndRatingService(){
		
		return Mono.just("Failuree") ;
	}
	
	@RequestMapping(value="/ratingandreviewauthenticationService",method=RequestMethod.GET)
	public Mono<String> reviewAndRatingAuthenticationService(){
		return Mono.just("--Failure--") ;
	}
	

}
