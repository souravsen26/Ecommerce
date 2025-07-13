package com.ecommerce.main.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.main.dto.ProductImagesMain;
import com.ecommerce.main.dto.ProductStatusMain;
import com.ecommerce.main.dto.ProductsMain;

@Repository
public interface ItemsDao {
	
	public List<ProductsMain> getProductsMain() ;
//	public List<ProductImagesMain> getProductImages() ;
	public List<ProductStatusMain> getProductsStatusMain() ;
	public String getImage() ;

}
