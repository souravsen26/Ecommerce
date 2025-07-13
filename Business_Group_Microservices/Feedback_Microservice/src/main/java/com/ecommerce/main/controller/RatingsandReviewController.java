package com.ecommerce.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.dto.GlobalResponseEntity;
import com.ecommerce.main.services.RatingandReviewServices;

@RestController
@RequestMapping("/reviewandrating")
public class RatingsandReviewController {
	
	@Autowired
	RatingandReviewServices ratingAndReviewService ;
	
	@RequestMapping("/getReviews/{productName}")
	public GlobalResponseEntity getReview(@PathVariable String productName) {
//		GlobalResponseEntity responseEntity = new GlobalResponseEntity() ;
	    	return ratingAndReviewService.getReview(productName) ;
	}

	@RequestMapping("/getRatings/{productName}")
	public GlobalResponseEntity getRating(@PathVariable String productName) {
//		GlobalResponseEntity responseEntity = new GlobalResponseEntity() ;
	    	return ratingAndReviewService.getRating(productName) ;
	}

}
