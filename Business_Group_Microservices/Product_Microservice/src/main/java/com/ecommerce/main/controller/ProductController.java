package com.ecommerce.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.dto.GlobalResponseEntity;
import com.ecommerce.main.services.ProductsSevices;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductsSevices productServices ;
	
	@RequestMapping("/getAll")
	public GlobalResponseEntity getAllProducts() {
		return productServices.getAllProducts() ;
	}

}
