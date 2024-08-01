package com.codeWithProjects.ecom.services.customer.review;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codeWithProjects.ecom.dto.ProductDto;
import com.codeWithProjects.ecom.entity.CartItems;

import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

	
	private final OrderRepository orderRepository;
	
	private final ReviewRepository reviewRepository;
	
	private final ProductRepository productRepository;
	
	private final UserRepository userRepository;
	
	public OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId) {
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		OrderedProductsResponseDto orderedProductsResponseDto = new OrderedProductsResponseDto();
		if(optionalOrder.isPresent()) {
			orderProductsResponseDto.setOrderAmount(optionalOrder.get().getAmount());
			
			List<ProductDto> productDtoList = new ArrayList<>();
			for (CartItems cartItems: optionalOrder.get()optionalOrder.getCartItems()) {
				ProductDto productDto = new ProductDto();
				
				productDto.setId(cartItems.getProduct().getId());
				productDto.setName(cartItems.getProduct().getName());
				productDto.setPrice(cartItems.getPrice());
				productDto.setQuantity(cartItems.getQuantity());
			}
			
		     orderedProductsResponseDto.setProductDeoList(productDtoList);
			
		}
		
		return orderedProductsResponseDto;
	}
	
	
	public ReviewDto givereview(ReviewDto reviewDto) throws IOException{
		Optional<Product> optionalProduct = productRepository.findByID(reviewDto.getproductID());
		Optional<User> optionalUser = userRepository.findById(reviewDTO.getUserId());
		
		if(optionalProduct.isPresent() && optionalUser.isPresent()) {
			Review review = new Review();
			 
			review.setRating(reviewDto.getRating());
			review.setDescription(reviewDto.getDescription();
			review.setUser(optionalUser.get());
			review.setProduct(optionalProduct.get());
			review.setImg(reviewDto.getImg().getBytes());
			
			return reviewRepository.save(review).getDto();
		}
		return null;
	}
	
}
