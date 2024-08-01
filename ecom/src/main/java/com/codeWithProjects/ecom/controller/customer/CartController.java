package com.codeWithProjects.ecom.controller.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithProjects.ecom.dto.OrderDto;
import com.codeWithProjects.ecom.dto.PlaceOrderDto;
import com.codeWithProjects.ecom.exception.ValidationException;
import com.codeWithProjects.ecom.services.customer.cart.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor

public class CartController {

	
	@PostMapping("/cart")
	public ResponseEntity<?> addProductToCart(@RequestBody AddProductInCartDto addProductInCartDto) {
		return CartService.addProductToCart(addProductInCartDto);
	}
	
	
	@GetMapping("/cart/{userId}")
	public ResponseEntity<?> getCartByUSerId(@PathVariable Long userId){
		OrderDto orderDto = CartService.getCartByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(orderDto);
			
	}
	
	@GetMapping("/coupon/{userId}/{code}")
	public ResponseEntity<?> applyCoupon(@PathVariable Long UserId, @PathVariable String code){
		try {
			OrderDto orderDto = CartService.applyCoupon(userId, code);
			return ResponseEntity.ok(orderDto);
		}
		catch(ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
			
			
		}
	}
		
		@PostMapping("/addition")
		public ResponseEntity<OrderDto> increaseProductQuantity(@RequestBody AddProductInCartDto addProductInCartDto){
			return ResponseEntity.status(HttpStatus.CREATED).body(cartService.increaseaddProductQuantity(addProductInCartDto));
		}
		
		@PostMapping("/deduction")
		public ResponseEntity<OrderDto> increaseProductQuantity(@RequestBody AddProductInCartDto addProductInCartDto){
			return ResponseEntity.status(HttpStatus.CREATED).body(cartService.increaseaddProductQuantity(addProductInCartDto));
		}
		
		@PostMapping("/placeOrder")
		public ResponseEntity<OrderDto> placeOrder(@RequestBody PlaceOrderDto placeOrderDto){
			return ResponseEntity.status(HttpStatus.CREATED).body(cartService.placeOrder(placeOrderDto));
		}
		
		@GetMapping("/myOrders/{userId}")
		public ResponseEntity<List<OrderDto>> getMyPlaceOrders(@PathVariable Long userId){
			return ResponseEntity.ok(cartService.getPlacedOrders(userId));
		}
	}
	
	

