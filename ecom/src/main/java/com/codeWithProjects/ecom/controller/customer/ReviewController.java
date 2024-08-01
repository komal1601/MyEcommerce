package com.codeWithProjects.ecom.controller.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.codeWithProjects.ecom.dto.ReviewDto;
import com.codeWithProjects.ecom.services.customer.review.ReviewService;

import io.jsonwebtoken.io.IOException;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")

public class ReviewController {
 
	private final ReviewService reviewService;
	
	
	@GetMapping("/ordered-product/{orderId")
	public ResponseEntity<OrderedProductResponseDto> getOrderedProductsDetailsByOrderId(@PathVariable Long orderId){
		return ResponseEntity.ok(reviewService.getOrderedProductsDetailsByOrderId(orderId));
	}
	
	@PostMapping("/review")
	public ResponseEntity<?> giveReview(@ModelAttribute ReviewDto reviewDto) throws IOException {
		ReviewDto reviewDto1 = reviewService.giveReview(reviewDto);
		if(reviewDto1 == null ) return ResponseEntity.status(HttpStatusCode.BAD_REQUEST).body("Something went wrong");
	       return ResponseEntity.status(HttpStatus.CREATED).body(reviewDto);
	}
}
