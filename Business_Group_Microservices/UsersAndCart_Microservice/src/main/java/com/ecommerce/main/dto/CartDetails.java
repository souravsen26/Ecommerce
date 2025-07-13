package com.ecommerce.main.dto;

public class CartDetails {
	
	private String cartId ;
	private String productId ;
	private String Status ;
	
	public CartDetails() {
		super() ;
	}
	
	public CartDetails(String cartId, String productId,String status) {
		super() ;
		this.cartId=cartId;
		this.productId=productId ;
		this.Status=status ;
	}
	
	public void setCartId(String cartId) {
		this.cartId=cartId ;
	}
	
	public String getCartId() {
		return this.cartId ;
	}
	
	public void setProductId(String productId) {
		this.productId=productId ;
	}
	
	public String getProductId() {
		return this.productId ;
	}
	
	public void setStatus(String status) {
		this.Status=status ;
	}

	public String getStatus() {
		return this.Status ;
	} 
}
