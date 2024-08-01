package com.codeWithProjects.ecom.services.admin.adminOrder;

import java.util.List;

import com.codeWithProjects.ecom.dto.AnalyticsResponse;
import com.codeWithProjects.ecom.dto.OrderDto;

public interface AdminOrderService {

	 List<OrderDto> getAllPlaceOrders();
	 
	 OrderDto changedOrderStatus(Long orderId, String status);
	 
	 AnalyticsResponse calculateAnalytics();
	 
}
