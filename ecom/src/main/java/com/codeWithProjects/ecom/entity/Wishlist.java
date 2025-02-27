package com.codeWithProjects.ecom.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Wishlist {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "product_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usere_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;


	public WishlistDto getWishlistDto() {
		WishlistDto wishlistDto = new WishlistDto();
		
		wishlistDto.setId(id);
		wishlistDto.setProductId(product.getId());
		wishlistDto.setReturnedImg(product.getImg());
		wishlistDto.setProductName(product.getName());
		wishlistDto.setProductDescription(product.getDescription());
		wishlistDto.setPrice(product.getPrice());
		wishlistDto.setUserId(User.getId());
		
		return wishlistDto;
	}

}

