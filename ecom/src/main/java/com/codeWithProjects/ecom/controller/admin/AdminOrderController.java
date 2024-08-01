package com.codeWithProjects.ecom.controller.admin;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithProjects.ecom.dto.AnalyticsResponse;
import com.codeWithProjects.ecom.dto.OrderDto;
import com.codeWithProjects.ecom.services.admin.adminOrder.AdminOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor

public class AdminOrderController {
	
	private final AdminOrderService adminOrderService;
	
	@GetMapping("/placeOrders")
	public ResponseEntity<List<OrderDto>> getAllPlaceOrders(){
		return ResponseEntity.ok(adminOrderService.getAllPlaceOrders());
	}

	@GetMapping("/order/{orderId}/{status}")
	public ResponseEntity<?> changeOrderStatus(@PathVariable Long orderId, @PathVariable String status){
		OrderDto orderDto = adminOrderService.changedOrderStatus(orderId, status);
		if(orderDto == null)
			return new ResponseEntity<>("Something went wrong!", HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.OK).body(orderDto);
	}
	
	@GetMapping("/order/analytics")
	public ResponseEntity<AnalyticsResponse> getAnalytics(){
		return ResponseEntity.ok(adminOrderService.calculateAnalytics());
	}
	
	
}
