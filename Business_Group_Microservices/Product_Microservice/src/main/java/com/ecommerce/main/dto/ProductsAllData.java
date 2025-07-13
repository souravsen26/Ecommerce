package com.ecommerce.main.dto;

import java.util.List;

public class ProductsAllData {
	
	private String productName ;
	private String productCategory ;
	private int quantity ;
	private int price ;
	private String image ;
	
	private List<String> reviews ;
	private List<Integer> ratings ;
	
	public ProductsAllData() {
		super() ;
	}
	
	public ProductsAllData(String productName,String productCategory,int quantity,int price,String image) {
		super() ;
		this.productName=productName ;
		this.productCategory=productCategory ;
		this.quantity=quantity ;
		this.price=price ;
		this.image=image ;
	}
	
	
	public ProductsAllData(String productName,String productCategory,int quantity,int price,String image,List<String> review,List<Integer> rating) {
		super() ;
		this.productName=productName ;
		this.productCategory=productCategory ;
		this.quantity=quantity ;
		this.price=price ;
		this.image=image ;
		this.reviews=review ;
		this.ratings=rating ;
	}
	
	public void setProduuctName(String productName) {
		this.productName =productName ;
	}
	
	public String getProductName() {
		return this.productName ;
	}
	
	public void setProductcategory(String productCategory){
		this.productCategory= productCategory ;
	}
	
	public String getProductCategory() {
		return this.productCategory ;
	}
	
	public void setQuantity(int quantity) {
		this.quantity=quantity ;
	}
	
	public int getQuantity() {
		return this.quantity ;
	}
	
	public void setPrice(int price) {
		this.price=price ;
	}
	
	public int getPrice() {
		return this.price ;
	}
	
	public void setImage(String image) {
		this.image=image ;
	}
	
	public String getImage() {
	return this.image ; 
	}
	
	public void setReview(List<String> review) {
		this.reviews=review ;
	}
	public List<String> getReview(){
		return this.reviews ;
	}
	
	public void setRating(List<Integer> rating) {
		this.ratings = rating ;
	}
	
	public List<Integer> getRating(){
		return this.ratings ;
	}
	
	

}
