package com.codeWithProjects.ecom.dto;

import org.springframework.web.multipart.MultipartFile;

import com.codeWithProjects.ecom.entity.Product;
import com.codeWithProjects.ecom.entity.User;

import lombok.Data;

@Data
public class ReviewDto {

private Long id;
	
	private Long rating;
	
	
	private String description;
	
	private MultipartFile img;
	
	private byte[] returnImg;
	
	
	private User userId;
	
	
	private Product productId;
}
