package com.codeWithProjects.ecom.dto;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.codeWithProjects.ecom.entity.CartItems;
import com.codeWithProjects.ecom.entity.User;
import com.codeWithProjects.ecom.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class OrderDto {

	private Long id;
	
	private String orderDescription;
	
	private Date date;
	
	private Long amount;
	
	private String address;
	
	private OrderStatus orderStatus;
	
	private Long totalAmount;
	
	private Long discount;
	
	private UUID trackingId;
	

	private String userName;
	
	
	private List<CartItems> cartItems;
	
	private String couponName;
}
