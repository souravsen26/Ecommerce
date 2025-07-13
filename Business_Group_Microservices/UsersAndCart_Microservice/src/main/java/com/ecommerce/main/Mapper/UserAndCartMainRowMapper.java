package com.ecommerce.main.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.main.dto.UserandCartMain;

public class UserAndCartMainRowMapper implements RowMapper<UserandCartMain> {
	
	@Override
	public UserandCartMain mapRow(ResultSet rs, int index) throws SQLException {
		UserandCartMain userandCartMain = new UserandCartMain() ;
		
		userandCartMain.setCartId(rs.getString("cartId"));
		userandCartMain.setUsername(rs.getString("username"));
		
		
		return userandCartMain ;
		
	}

}
