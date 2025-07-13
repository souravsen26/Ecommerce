package com.ecommerce.main.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.main.dto.GlobalResponseEntity;
import com.ecommerce.main.dto.RatingModel;
import com.ecommerce.main.dto.ReviewModel; 

@Service
public class RatingandReviewServices {
	
	public GlobalResponseEntity getReview(String productName) {
		
		GlobalResponseEntity responseEntity = new GlobalResponseEntity() ;
	    List<ReviewModel> reviewList = new ArrayList<ReviewModel>() ;
	    reviewList.add(new ReviewModel("Polo Tshirts","R00001","Nice")) ;
	    reviewList.add(new ReviewModel("Polo Tshirts","R0002","Good")) ;
	    
	    responseEntity.setObject(reviewList);
	    
	    return responseEntity ;
		
	}
	
	public GlobalResponseEntity getRating(String ProductName) {
		
		GlobalResponseEntity responseEntity = new GlobalResponseEntity() ;
		
		List<RatingModel> ratingModel = new ArrayList<RatingModel>() ;
		
		ratingModel.add(new RatingModel("Polo Tshirts","RE0001",5)) ;
		ratingModel.add(new RatingModel("Polo Tsshirts","RE0002",5)) ;
		
		int sum=0 ;
		
		for(RatingModel ratingMode: ratingModel) {
			sum +=ratingMode.getRating() ;
		}
		
		sum=(int) sum/ratingModel.size();
		
		responseEntity.setObject(sum) ;
		
		return responseEntity ;
		
		}

}
