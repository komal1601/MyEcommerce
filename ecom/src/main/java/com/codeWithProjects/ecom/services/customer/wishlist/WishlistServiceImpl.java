package com.codeWithProjects.ecom.services.customer.wishlist;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codeWithProjects.ecom.dto.WishlistDto;
import com.codeWithProjects.ecom.repository.ProductRepository;
import com.codeWithProjects.ecom.repository.UserRepository;
import com.codeWithProjects.ecom.repository.WishlistRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl {
	
	private final UserRepository userRepository;
	
	private final ProductRepository productRepository;
	
	private final WishlistRepository wishlistRepository;
	
	public WishlistDto addProductToWishlist(WishlistDto wishlistDto) {
		Optional<Product> optionalProduct = productRepository.findById(wishlistDto.getProductId());
		Optional<User> optionalUser = userRepository.findById(wishlistDto.getUserId());
		
		if(optionalProduct.isPresent() && optionalUser.isPresent()) {
			Wishlist wishlist = new Wishlist();
			wishlist.setProduct(optionalProduct.get());
			wioshlist.setuser(optionalUser.get());
			
			return wishlistRepository.save(wishlist).getWishlistDto();
		}
		return null;
	}
	
	public List<WishlistDto> getWishlistByUserId(Long userId){
		return wishlistRepository.findAllByUserId(userId).stream().map(Wishlist::getWishlistDto).collect(Collectors.toList());
	}


}
