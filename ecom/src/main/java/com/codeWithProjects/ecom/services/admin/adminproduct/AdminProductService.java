package com.codeWithProjects.ecom.services.admin.adminproduct;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codeWithProjects.ecom.dto.ProductDto;
import com.codeWithProjects.ecom.repository.CategoryRepository;
import com.codeWithProjects.ecom.repository.ProductRepository;

import io.jsonwebtoken.io.IOException;

@Service
public interface AdminProductService {
	
   ProductDto addProduct(ProductDto productDto) throws IOException;
   
   List<ProductDto> getAllProducts();
   
   List<ProductDto> getAllProductByName(String name);

   boolean deleteProduct(Long id);
   
   ProductDto getProductById(Long productId);
    
   ProductDto updateProduct(Long productId, ProductDto productDto); 
}


