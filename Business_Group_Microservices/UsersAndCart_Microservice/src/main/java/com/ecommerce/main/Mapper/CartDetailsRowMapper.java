package com.ecommerce.main.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.main.dto.CartDetails ;

public class CartDetailsRowMapper implements RowMapper<CartDetails>{
	
	@Override
	public CartDetails mapRow(ResultSet rs, int index) throws SQLException {
		
		CartDetails cartDetails = new CartDetails() ;
		//cartDetails.setCartId(rs.getString("productId"));
		cartDetails.setProductId(rs.getString("productId"));
		cartDetails.setStatus(rs.getString("status"));
		
		return cartDetails ;
		
	}

}
