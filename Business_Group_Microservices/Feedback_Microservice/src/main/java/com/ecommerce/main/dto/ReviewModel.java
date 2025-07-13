package com.ecommerce.main.dto;

public class ReviewModel {
	
	private String productName ;
	private String reviewId ;
	private String reviewComment ;
	
	public ReviewModel() {
		super() ;
	}
	
	public ReviewModel(String productName,String reviewId,String reviewComment) {
		super() ;
		this.productName= productName ;
		this.reviewId= reviewId ;
		this.reviewComment=reviewComment ;
	}
	
	public void setProductName(String productName) {
		this.productName=productName ;
	}
	public String getProductName() {
		return this.productName ;
	}
	
	public void setReviewId(String reviewId) {
		this.reviewId=reviewId ;
	}
	
	public String getReviewId() {
		return this.reviewId ;
	}
	
	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment ;
	}
	
	public String getReviewComment()  {
	return this.reviewComment ;
	}
	

}
