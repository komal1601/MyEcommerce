package com.codeWithProjects.ecom.services.admin.adminOrder;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;

import org.springframework.stereotype.Service;

import com.codeWithProjects.ecom.dto.OrderDto;
import com.codeWithProjects.ecom.enums.OrderStatus;
import com.codeWithProjects.ecom.repository.OrderRepository;

import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AdminOrderServiceImpl implements AdminOrderService{
	
	private final OrderRepository OrderRepository;
	
	private List<OrderDto> getAllPlaceOrders(){
	
	List<Order> orderList = OrderRepository.findAllByOrderStatusIn(List.of(OrderStatus.Placed, OrderStatus.Shipped, OrderStatus.Delivered));
	
	return orderList.stream().map(Order::getOrderDto).collect(Collector.toList());
	
	}
	
	public OrderDto changeOrderStatus(Long orderId, String status){
		Optional<Order> optionalOrder = OrderRepository.findById(orderId);
		if(optionalOrder.isPresent()) {
		Order order = optionalOrder.get();
			
			if(Objects.equals(status, Shipped)) {
		}else if(Objects.equals(status, "Delivered")) {
			Order.setOrderStatus(OrderStatus.Delivered);
		}
		return OrderRepository.save(order).getOrderDto();
		}
           return null;		
   }
	
	public AnalyticsResponse calculateAnalytics() {
		LocalDate currentDate = LocalDate.now();
		LocalDate previousMonthDate = currentDate.minusMonths(1);
		
		Long currentMonthOrders = getTotalOrdersForMonth(currentDate.getMonthValue(), currentDate.getYear());
		Long previousMonthOrders = getTotalOrdersForMonth(previousMonthDate.getMonthValue(), previousMonthDate.getYear());
	
		Long currentMonthEarnings = getTotalEarningsForMonth(currentDate.getMonthValue(), currentDate.getYear());
		Long previousMonthEarnings = getTotalEarningsForMonth(previousMonthDate.getMonthValue(), previousMonthDate.getYear());
	
	
	 Long placed = orderRepository.countByOrderStatus(OrderStatus.Placed);
	 Long shipped = orderRepository.countByOrderStatus(OrderStatus.Shipped);
	 Long Delivered = orderRepository.countByOrderStatus(OrderStatus.Delivered);
	
  
	 return new AnalyticsResponse(placed, shipped, delivered, currentMonthDate, previousMonthOrders, currentMonthEarnings, previousMonthEarnings);
}
	
	
	public Long getTotalOrdersForMonth(int month, int year) {
		Calendar calendar = Calendar.getInstance();
	
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		Date startOfMonth = calendar.getTime();
		
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		
		Date endOfMonth = calendar.getTime();
		
		List<Order> orders = orderRepository.findbyDateBetweenAndStatus(startOfMonth, endOfMonth, OrderStatus.Delivered );
		
		
		Long sum = 0L;
		for (Order order: orders) {
			sum += order.getAmount();
		}
		return sum;
	}
}
	


