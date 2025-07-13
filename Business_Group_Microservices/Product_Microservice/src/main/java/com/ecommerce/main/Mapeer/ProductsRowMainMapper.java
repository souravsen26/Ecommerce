package com.ecommerce.main.Mapeer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.main.dto.ProductsMain ;

public class ProductsRowMainMapper implements RowMapper<ProductsMain> {
	
	@Override
	public ProductsMain mapRow(ResultSet rs,int indxe) throws SQLException {
		
		ProductsMain productMain = new ProductsMain() ;
		
		productMain.setPrice(rs.getInt("price"));
		productMain.setProductCategory(rs.getString("productCategory"));
		productMain.setProductName(rs.getString("productName"));
		productMain.setQuantity(rs.getInt("quantity"));
		
		return productMain ;
		
	}

}
