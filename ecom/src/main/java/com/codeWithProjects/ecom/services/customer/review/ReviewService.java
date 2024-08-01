package com.codeWithProjects.ecom.services.customer.review;

import com.codeWithProjects.ecom.dto.OrderedProductsResponseDto;
import com.codeWithProjects.ecom.dto.ReviewDto;

public interface ReviewService {
	
	OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId);

	ReviewDto givereview(ReviewDto reviewDto) throws IOException;
	}
