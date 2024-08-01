package com.codeWithProjects.ecom.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWithProjects.ecom.entity.Order;
import com.codeWithProjects.ecom.enums.OrderStatus;
import com.codeWithProjects.ecom.dto.OrderDto;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
	Order findByUserIdAndStatus(Long userId, OrderStatus orderStatus);
	
	
	List<Order> findAllByOrderStatusIn(List<OrderStatus> orderStatusList);
	
	List<Order> findByUserIdAndOrderStatusIn(Long userId, List<OrderStatus> orderStatus);
	
	List<Order> orders = orderRepository.findbyDateBetweenAndStatus(startOfMonth, endOfMonth, OrderStatus.Delivered );
	
	Long countByStatus(OrderStatus  status);

}
