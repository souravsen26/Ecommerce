package com.ecommerce.main.dto;

public class RatingModel {
	
	private String productName ;
	private String ratingId ;
	private int rating;
	
	public RatingModel(String productName, String ratingId, int rating){
		super() ;
		this.productName=productName ;
		this.ratingId=ratingId ;
		this.rating=rating ;
	}
	
	public void setProductName(String productName) {
		this.productName=productName;
	}
	
	public String getProductName() {
		return this.productName ;
	}

	public void setRating(int rating) {
		this.rating= rating ;
	}
	
	public int getRating() {
		return this.rating ;
	}
	
}
