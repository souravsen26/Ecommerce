package com.ecommerce.main.dto;

public class ProductDetailsMain {
	
	private String productId;
	
	public ProductDetailsMain() {
		super() ;
	}
	
	public ProductDetailsMain(String productId) {
		super() ;
		this.productId=productId ;
	}
	
	public void setProductId(String productId) {
		this.productId=productId ;
	}
	
	public String getProductId() {
		return this.productId ;
	}
	
}
