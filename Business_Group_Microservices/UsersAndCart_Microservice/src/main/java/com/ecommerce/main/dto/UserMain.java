package com.ecommerce.main.dto;

public class UserMain {
	
	private String username ;
	private String password ;
	private int enabled ;
	private String email ;
	private String phoneNumber ;
	
	public UserMain() {
		super() ;
	}
	
	public UserMain(String username, String password,int enabled,String email,String phoneNumber) {
		super() ;
		this.username=username ;
		this.password=password ;
		this.enabled=enabled ;
		this.email=email ;
		this.phoneNumber=phoneNumber ;
	}
	
	public void setUsername(String username) {
		this.username = username ;
	}
	public String getUsername() {
		return this.username ;
	}
	
	public void setPassword(String password) {
         this.password=password;		
	}
	public String getPassword() {
		return this.password ;
	}
	
	public void setEnable(int enabled) {
		this.enabled= enabled ;
	}
	
	public int getEnabled() {
		return this.enabled ;
	}
	
	public void setEmail(String email) {
		this.email=email ;
	}
	
	public String getEmail(){
		return this.email ;
	}
	
	public void setPhonenumber(String phoneNumber) {
		this.phoneNumber=phoneNumber ;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	

}
