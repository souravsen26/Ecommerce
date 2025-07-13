package com.ecommerce.main.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ecommerce.main.Mapeer.UserMainRowMapper;
import com.ecommerce.main.Mapper.CartDetailsRowMapper;
import com.ecommerce.main.Mapper.UserAndCartMainRowMapper;
import com.ecommerce.main.dto.CartDetails;
import com.ecommerce.main.dto.UserMain;
import com.ecommerce.main.dto.UserandCartMain;

@Repository
public class UserandServiceDao {

//	public UserMain getUser() ;
	
	@Autowired
	JdbcTemplate jdbcTemplate ;
	
	public UserMain getUser(String username) {
		
		UserMain userMain = jdbcTemplate.queryForObject("select username,password,enabled,email,phoneNumber from EcommerceUsers", new UserMainRowMapper()) ;
		return userMain ;
		
	}
	
	public UserandCartMain getCartId(String username) {
		
		UserandCartMain userandCartMain = jdbcTemplate.queryForObject("select username,cartId from EcommerceUsersCart where username=?", new UserAndCartMainRowMapper(),username) ;
		return userandCartMain ;
		
	}
	
	public List<CartDetails> getCartItems(String cartId) {
		List<CartDetails> cartDetails = jdbcTemplate.query("select productId as productId,status as status from CARTDETAILS where cartId=?",new CartDetailsRowMapper(),cartId) ;
		List<CartDetails> cartDetails1 = null ;
		
		if(cartDetails!=null) {
			cartDetails1 =cartDetails.stream().map(cartDetail->{
				cartDetail.setCartId(cartId) ;
				return cartDetail ;
			}).collect(Collectors.toList()) ;
		}
		
		return cartDetails1 ;
		
	}
	
	public int addToCart(String cartId, String productId) {
		
		return jdbcTemplate.update("INSERT INTO CARTDETAILS values(?,?,'unpaid')",cartId,productId) ;
		
	}
	
	
	public List<UserandCartMain> getLastCartId() {
		return jdbcTemplate.query("select username,cartId from EcommerceUsersCart",new UserAndCartMainRowMapper()) ;
	}
	
	public int createCart(String username,String cartId) {
		
		return jdbcTemplate.update("INSERT INTO ECOMMERCEUSERSCART values(?,?)",username,cartId) ;
	}
	
	
}
