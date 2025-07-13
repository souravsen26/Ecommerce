package com.ecommerce.main.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.main.dto.ProductStatusMain;

public class ProductStatusMainMapper implements RowMapper<ProductStatusMain> {
	
	@Override
	public ProductStatusMain mapRow(ResultSet rs,int index) throws SQLException {
		
		ProductStatusMain productStatusMain = new ProductStatusMain() ;
		productStatusMain.setProductId(rs.getString("ProductsId"));
		productStatusMain.setProductName(rs.getString("ProductsName")) ;
		productStatusMain.setStatus(rs.getString("status")); 
		
		return productStatusMain ;
	}

}
