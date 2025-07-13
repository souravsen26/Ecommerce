package com.ecommerce.main.services;

//import java.lang.System.Logger;
import java.util.ArrayList;
//import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;
//import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
//import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.main.dao.ItemsDao;
import com.ecommerce.main.dto.GlobalResponseEntity;
import com.ecommerce.main.dto.ProductStatusMain;
import com.ecommerce.main.dto.ProductsAllData;
import com.ecommerce.main.dto.ProductsMain;
import com.ecommerce.main.dto.ReviewModel;
import com.ecommerce.main.ratingandreview.RatingandReviewConsumer;

@Service
public class ProductsSevices {
	
	@Autowired
	ItemsDao itemDaoImpl ;
	
	@Autowired
	RestTemplate restTemplate ;
	
	private Logger log= LoggerFactory.getLogger(ProductsSevices.class) ;
	
	public GlobalResponseEntity getAllProducts() {
		
		GlobalResponseEntity globalResponse = new GlobalResponseEntity() ;
		
       List<ProductsMain> productMain =// new ArrayList<ProductsMain>() ;
    	/**
    	 * this db call is hidden	 
    	 */
      itemDaoImpl.getProductsMain() ;
		
		/*ProductsMain product1 = new ProductsMain("Polo Tshirts","Tshirts",5,1000) ;
		ProductsMain product2 = new ProductsMain("V Neck Tshirts","Tshirts",5,1000) ;
		ProductsMain product3 = new ProductsMain("Round Tshirts","Tshirts",5,1000) ;
		
		productMain.add(product1);
		productMain.add(product2) ;
		productMain.add(product3) ; */
		
//		globalResponse.setObject(productMain);
		
		List<ProductStatusMain> productStatus = itemDaoImpl.getProductsStatusMain() ;
		
	 /*   ProductStatusMain productStatus1 = new ProductStatusMain("POLO0001","Polo Tshirts","A") ;
	    ProductStatusMain productStatus2 = new ProductStatusMain("POLO0002","Polo Tshirts","A") ;
	    ProductStatusMain productStatus3 = new ProductStatusMain("POLO0003","Polo Tshirts","A") ;
	    ProductStatusMain productStatus4 = new ProductStatusMain("POLO0004","Polo Tshirts","A") ;
	    ProductStatusMain productStatus5 = new ProductStatusMain("POLO0005","Polo Tshirts","A") ;
	    
	    ProductStatusMain productStatus6 = new ProductStatusMain("POLO0005","Polo Tshirts","A") ;
	    ProductStatusMain productStatus7 = new ProductStatusMain("POLO0005","Polo Tshirts","A") ;
	    ProductStatusMain productStatus8 = new ProductStatusMain("POLO0005","Polo Tshirts","A") ;
	    ProductStatusMain productStatus9 = new ProductStatusMain("POLO0005","Polo Tshirts","A") ;
	    ProductStatusMain productStatus10 = new ProductStatusMain("POLO0005","Polo Tshirts","A") ; */
	    
		
		for (ProductsMain productsMain : productMain) {
			int count=0 ;
			for(ProductStatusMain productsStatusMain: productStatus) {
				
				if(productsMain.getProductName().equalsIgnoreCase(productsStatusMain.getProductName()))
						{
					         if(productsStatusMain.getStatus().equalsIgnoreCase("A")) {
					        	 count++ ;
					         }
						}
			}
			productsMain.setQuantity(count);
		}
		
//		log.info("ProductService request ")
		
		List<ProductsAllData> productData = new ArrayList<ProductsAllData>() ;
		
		
		
		productData = productMain.stream().map(productssMain->{
		 return	new ProductsAllData(productssMain.getProductName(),productssMain.getProductCategory(),productssMain.getQuantity(),productssMain.getPrice(),itemDaoImpl.getImage().substring(itemDaoImpl.getImage().length()-30)) ; 
		}).collect(Collectors.toList()) ;
		
	/*	String authStr="John:Johhnn" ;
		String baseCreds = Base64.getEncoder().encodeToString(authStr.getBytes()) ; */
		
		HttpHeaders headers = new HttpHeaders() ;
//		headers.setBasicAuth("John","Johhnn");
		
		HttpEntity request = new HttpEntity(headers) ;
		
	/*	Map<String,String> map = new HashMap<String,String>() ;
		map.put("Authorization", baseCreds) ; */
		
		RatingandReviewConsumer ratingandreviewconsumer= new RatingandReviewConsumer() ;
	
/*	List<ProductsAllData> productDataa = productData.stream().map(productDatas->{
			ResponseEntity<GlobalResponseEntity> responseEntity = ratingandreviewconsumer.getRatingandReviewUrl(productDatas.getProductName()) ;
			Object obj = responseEntity.getBody().getObject() ;
	      List<LinkedHashMap> list = (List<LinkedHashMap>) obj ;
	      
	    //  String reviewModel=(String) list.get(0).get("reviewComment") ;
	    // log.info(reviewModel) ;
	    
		
//		productDataa.addAll()
		List<String> reviewComment = new ArrayList<String>() ;
		int i ;
		for(i=0;i<list.size();i++) {
			reviewComment.add((String)list.get(i).get("reviewComment")) ;
		}
		productDatas.setReview(reviewComment) ;
			return productDatas ;
		}).collect(Collectors.toList()) ; */
		
		System.out.println(productData.get(0).getProductName()) ;
	
	  GlobalResponseEntity resEntity = restTemplate.getForObject("http://RATINGANDREVIEWSERVICE/reviewandrating/getReviews/"+productData.get(0).getProductName(),GlobalResponseEntity.class) ;
	  List<LinkedHashMap>  reviewModel = (List<LinkedHashMap>) resEntity.getObject() ;
	  
	  System.out.println(reviewModel.get(0).get("reviewComment")) ;
	  
	  productData.stream().map(product->{
		  int i=0 ;
		  List<String> reviewList = new ArrayList<String>() ;
		  for(i=0;i<reviewModel.size();i++) {
			  if(product.getProductName().equalsIgnoreCase((String)reviewModel.get(i).get("productName"))) {
				  reviewList.add((String)reviewModel.get(i).get("reviewComment")) ;
			  }
		  }
		  product.setReview(reviewList) ;
		  return product ;
	  }).collect(Collectors.toList()) ; 
	  
		System.out.println(resEntity) ;
		
		globalResponse.setObject(productData) ;
		
		return globalResponse ;
		
	}

}
