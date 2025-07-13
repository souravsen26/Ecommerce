package com.ecommerce.main.Mapeer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
//import org.springframework.security.core.userdetails.User;

import com.ecommerce.main.dto.UserMain;

public class UserMainRowMapper implements RowMapper<UserMain> {
	
	@Override
	public UserMain mapRow(ResultSet rs, int index) throws SQLException {
		
		UserMain userMain = new UserMain() ;
		
		userMain.setEmail(rs.getString("email"));
		userMain.setPassword(rs.getString("password"));
		userMain.setPhonenumber(rs.getString("phonenumber"));
		userMain.setUsername(rs.getString("username"));
		userMain.setEnable(rs.getInt("enabled"));
		
		return userMain ;
		
	}

}
