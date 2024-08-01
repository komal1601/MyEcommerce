package com.codeWithProjects.ecom.services.customer;

import java.util.List;

import com.codeWithProjects.ecom.dto.ProductDetailDto;
import com.codeWithProjects.ecom.dto.ProductDto;

public interface CustomerProductService {
	
	List<ProductDto> searchProductByTitle(String title);
	
	List<ProductDto> getAllProducts();

	ProductDetailDto getProductDetailById(Long productId);
}
