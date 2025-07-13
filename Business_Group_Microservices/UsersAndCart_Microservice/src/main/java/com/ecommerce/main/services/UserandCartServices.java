package com.ecommerce.main.services;

import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.dao.UserandServiceDao;
import com.ecommerce.main.dto.CartDetails;
import com.ecommerce.main.dto.GlobalResponseEntity;
import com.ecommerce.main.dto.ProductDetailsMain;
import com.ecommerce.main.dto.UserMain;
import com.ecommerce.main.dto.UserandCartMain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserandCartServices {
	
	@Autowired
	UserandServiceDao userAndServiceDao ;
	
	private Logger log= LoggerFactory.getLogger(UserandCartServices.class) ;
	

	public GlobalResponseEntity getCartItems(String username) throws JsonProcessingException {
		
		GlobalResponseEntity responseEntity = new GlobalResponseEntity() ;
		
	//	UserMain userMain = userAndServiceDao.getUser(username) ;
		
		UserandCartMain userandCartMain =userAndServiceDao.getCartId(username) ;

		List<CartDetails> cartDetails=userAndServiceDao.getCartItems(userandCartMain.getCartId()) ;
		
	    responseEntity.setObject(cartDetails);
	    
	    log.info("User and Cart Services()", new ObjectMapper().writeValueAsString(username));
	    
	    log.info("User and Cart Service() :" + cartDetails);
	    
	    return responseEntity ;
		
		
	}
	
	public GlobalResponseEntity addToCart(String username, ProductDetailsMain productMain) {
		
		UserandCartMain userandCartMain = new UserandCartMain() ;
		userandCartMain=userAndServiceDao.getCartId(username) ;
		userAndServiceDao.addToCart(userandCartMain.getCartId(),productMain.getProductId()) ;
		
		GlobalResponseEntity responseEntity = new GlobalResponseEntity() ;
		
		responseEntity.setObject("Added To");
		
		return responseEntity ;
		
	}
	
	public String createCart(String username) {
		
		String cart="CART" ;
		String zeroes="" ;
		
		List<UserandCartMain> userAndCartList = userAndServiceDao.getLastCartId() ;
		List<String> list = new ArrayList<String>() ;
		for(UserandCartMain userandCartMain: userAndCartList) {
			list.add(userandCartMain.getCartId()) ;
		}
		
		int max=0 ;
		for(String cartId: list) {
			
			int lastCartVal= Integer.parseInt(cartId.substring(4)) ;
			if(lastCartVal>max) {
				max=lastCartVal ;
			}
		
			max=max+1 ;
			
			
			if(max/10>=10000)
			{
			    zeroes="" ;
			}
			else if(max/10>=1000) {
				zeroes="0" ;
				
			}
			else if(max/10>=100) {
				zeroes="00" ;
			}
			else if(max/10>=10) {
				zeroes="000" ;
			}
			
			else if(max/10>=1) {
				zeroes="0000" ;
			}
			else {
				zeroes="00000" ;
			}
		}
		String cartId=cart+zeroes+max ;


		 int value = userAndServiceDao.createCart(username,cartId) ;
		 
		 if(value>=1) {
			 return "cart created" ;
		 }
		 else {
			 return "some issue" ;
		 }
		
	}
	
}
