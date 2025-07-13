package com.ecommerce.main.Mapper;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.main.dto.ProductImagesMain;

public class ProductImagesMainMapper implements RowMapper<ProductImagesMain> {
	
	@Override
	public ProductImagesMain mapRow(ResultSet rs, int index) throws SQLException {
		
		ProductImagesMain productImages = new ProductImagesMain() ;
		Blob blob = rs.getBlob("productImages") ;
		productImages.setProductImages(blob.getBytes(1, (int)blob.length()));
		productImages.setProductName(rs.getString("productName"));
		
		return productImages ;
		
	}

}
