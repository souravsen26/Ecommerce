package com.ecommerce.main.dto;

public class ProductImageTemp {
	
	private String productName ;
	private String productImage;
	
	public ProductImageTemp() {
		super() ;
	}
	
	public ProductImageTemp(String productName, String productImage) {
		super() ;
		this.productName= productName ;
		this.productImage=productImage ;
		
	}
	
	public void setProductName(String productName) {
		this.productName =productName ;
	}
	
	public String getProductName() {
		return this.productName ;
	}
	
	public void setProductImage(String productImage) {
		this.productImage=productImage ;
	}
	
	public String getProductImage() {
		return this.productImage ;
	}
	

}
