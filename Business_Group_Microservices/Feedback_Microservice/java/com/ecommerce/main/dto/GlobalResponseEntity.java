package com.ecommerce.main.dto;

public class GlobalResponseEntity {
	
	private String message ;
	private Object object ;
	
	public GlobalResponseEntity() {
		super() ;
	}
	
	public GlobalResponseEntity(String message, Object object) {
		super() ;
		this.message = message ;
		this.object=object ;
	}
	
	public void setMessage(String message) 
	{
		this.message=message ;
	}
	public String getMessage() {
		return this.message ;
	}
	
	public void setObject(Object object) {
		this.object=object ;
	}
	public Object getObject() {
		return this.object ;
	}

}
