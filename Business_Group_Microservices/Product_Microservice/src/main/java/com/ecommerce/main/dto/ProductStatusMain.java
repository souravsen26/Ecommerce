package com.ecommerce.main.dto;

public class ProductStatusMain {
	
	String productId ;
	String productName ;
	String status ;
	
	public ProductStatusMain() {
		super() ;
	}
	
	public ProductStatusMain(String productId,String productName,String status) {
		super() ;
		this.productId=productId ;
		this.productName=productName ;
		this.status=status;
	}
	
	public void setProductId(String productId) {
		this.productId=productId ;
	}
	
	public String getProductId() {
		return this.productId ;
	}
	
	public void setProductName(String productName) {
		this.productName=productName ;
	}

	public String getProductName() {
		return this.productName ;
	}
	
	public void setStatus(String status) {
		this.status = status ;
	}
	
	public String getStatus() {
		return this.status ;
	}
	
}
