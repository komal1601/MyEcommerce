package com.codeWithProjects.ecom.dto;


@Data
public class CartItemsDto {

	private Long id;
	
	private Long price;
	
	private Long quality;
	
	private Long productId;
	
	private String productName;
	
	private byte[] returnedImg;
	
	private Long userId;
}
