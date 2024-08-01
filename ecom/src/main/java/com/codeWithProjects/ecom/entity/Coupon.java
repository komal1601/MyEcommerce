package com.codeWithProjects.ecom.entity;

import jakarta.persistence.GenerationType;

@Entity
@Data
@Table(name = "coupons")
public class Coupon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String code;
	
	private Long discount;
	
	private Date expirationDate;

}
