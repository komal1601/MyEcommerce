package com.codeWithProjects.ecom.services.customer.wishlist;

import com.codeWithProjects.ecom.dto.WishlistDto;

public interface WishlistService {

	WishlistDto addProductToWishlist(WishlistDto wishlistDto);
	
	List<WishlistDto> getWishlistByUSerId(Long userId);
	
}
