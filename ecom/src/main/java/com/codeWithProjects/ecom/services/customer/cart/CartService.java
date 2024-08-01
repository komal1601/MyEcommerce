package com.codeWithProjects.ecom.services.customer.cart;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.codeWithProjects.ecom.dto.AddProductInCartDto;
import com.codeWithProjects.ecom.dto.OrderDto;
import com.codeWithProjects.ecom.dto.PlaceOrderDto;

public interface CartService {
	
	ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto)
	
	OrderDto getCartByUserId(Long userId);
	
    OrderDto applyCoupon(Long userId, String code);
    
    OrderDto increaseProductQuantity(AddProductInCartDto addProductinCartDto);

    OrderDto decreaseProductQuantity(AddProductInCartDto addProductInCartDto);

    OrderDto placeOrder(PlaceOrderDto placeOrderDto);
    
    List<OrderDto> getMyPlacedOrders(Long userId);


}
