package com.ecommerce.main.dto;

public class ProductImagesMain {
	
	private String productName ;
	private byte[] productImages ;
	
	public ProductImagesMain(String productName,byte[] productImages) {
		super() ;
		this.productName=productName ;
		this.productImages=productImages ;
	}
	
	public ProductImagesMain() {
		super() ;
	}
	
	public void setProductName(String productName) {
		
		this.productName=productName ;
		
	}
	
	public String getProductName() {
		return this.productName ;
	}
	
	public void setProductImages(byte[] productImages) {
		this.productImages=productImages ;
	}
	
	public byte[] getProductImages() {
		return this.productImages ;
	}
	
	 

}
