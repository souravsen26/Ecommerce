package com.ecommerce.main.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.dto.GlobalResponseEntity;
import com.ecommerce.main.dto.ProductDetailsMain;
import com.ecommerce.main.services.UserandCartServices;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/user")
public class CartandUserController {
	
	@Autowired
	UserandCartServices userandCartServices ;
	
	private static final Logger log = LogManager.getLogger() ;

	@RequestMapping("/viewCart/{username}")
	public GlobalResponseEntity getAllProducts(@RequestHeader Map<String,String> headers ,@PathVariable String username) throws JsonProcessingException {
		
		log.error("Headers :") ;
		headers.forEach((key,value)->{
			log.error("'" + key + "' : "+value) ;
//			log.error("'" + key + "' : "+value) ;
		}) ;
		
		return userandCartServices.getCartItems(username) ;
	}
	
	@PostMapping("/addToCart/{username}")
	public GlobalResponseEntity addToCart(@PathVariable String username, @RequestBody ProductDetailsMain productDetails) {
		
		GlobalResponseEntity responseEntity = userandCartServices.addToCart(username, productDetails)  ;
	
		
//	     GlobalResponseEntity responseEntity = new GlobalResponseEntity() ;
//	     responseEntity.setObject("Added To Cart") ;
	     
	     return responseEntity ;
		
	}
	
	@PostMapping("createCart/{username}")
	public String createCart(@PathVariable String username) {
		
	      return	userandCartServices.createCart(username) ;
		
	}
	
	
	
}
