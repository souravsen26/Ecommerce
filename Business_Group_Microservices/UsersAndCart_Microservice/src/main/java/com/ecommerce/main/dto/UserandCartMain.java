package com.ecommerce.main.dto;

public class UserandCartMain {
	
	private String username ;
	private String cartId ;
	
	public UserandCartMain() {
		super() ;
	}
	
	public UserandCartMain(String username,String cartId) {
		super() ;
		this.username=username ;
		this.cartId=cartId ;
	}
	
	public void setUsername(String username) {
		this.username=username ;
	}
	
	public String getUsername() {
		return this.username ;
	}
	
	public void setCartId(String cartId) {
		this.cartId= cartId ;
	}
	
	public String getCartId() {
		return this.cartId ;
	}
	

}
