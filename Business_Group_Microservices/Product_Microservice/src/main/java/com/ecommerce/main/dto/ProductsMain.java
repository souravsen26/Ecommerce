package com.ecommerce.main.dto;

public class ProductsMain {
	
	String productName ;
	String productCategory ;
	int quantity ;
	int price ;
	
	public ProductsMain() {
		super() ;
	}
	
	public ProductsMain(String productName,String productCategory,int quantity,int price) {
		this.productName=productName ;
		this.productCategory=productCategory ;
		this.quantity = quantity ;
		this.price= price ;
	}
	
	public void setProductName(String productName) {
		this.productName=productName ;
	}
	
	public String getProductName() {
		return this.productName ;
	}
	
	public void setProductCategory(String productCategory)
	{
		this.productCategory=productCategory ;
	}	
	
	public String getProductCategory() {
	return this.productCategory ;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity ;
	}
	
	public int getQuantity() {
		return this.quantity ;
	}
	
	public void setPrice(int price) {
		this.price = price ;
	}
	
	public int getPrice() {
		return this.price ;
	}

}
