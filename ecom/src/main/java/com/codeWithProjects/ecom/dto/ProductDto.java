package com.codeWithProjects.ecom.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;


@Data
public class ProductDto {
	
private Long id;
	
	private String name;
	
	private Long price;
	

	private String description;
	

	private byte[] byteImg;
	
	
	private Long categoryId;
	
	private String categoryName;
	
	private MultipartFile img;
 	
	

}
