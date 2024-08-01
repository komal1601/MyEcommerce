package com.codeWithProjects.ecom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithProjects.ecom.dto.OrderDto;
import com.codeWithProjects.ecom.services.customer.cart.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TrackingController {
	
	private final CartService cartService;
	
	public ResponseEntity<OrderDto> searchOrderByTrackingId(@PathVariable UUID trackingId){
		OrderDto orderDto = cartServie.searchOrderByTrackingId(trackingId);
		if(orderDto == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(orderDto);
	}

}
