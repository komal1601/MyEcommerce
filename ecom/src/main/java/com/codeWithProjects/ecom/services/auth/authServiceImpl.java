package com.codeWithProjects.ecom.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codeWithProjects.ecom.dto.Order;
import com.codeWithProjects.ecom.dto.SignupRequest;
import com.codeWithProjects.ecom.dto.UserDto;
import com.codeWithProjects.ecom.enums.OrderStatus;
import com.codeWithProjects.ecom.enums.UserRole;
import com.codeWithProjects.ecom.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class authServiceImpl implements AuthService {
	 
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserDto createUser(SignupRequest signupRequest) {
		
		User user = new User();
		
		user.setEmail(signupRequest.getEmail());
		user.setName(signupRequest.getName());
		user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
		user.setRole(UserRole.CUSTOMER);
		User createUser = userRepository.save(user);
		
		
		Order order = new Order();
		order.setAmount(0L);
		order.setTotalAmount(0L);
		order.setDiscount(0L);
		order.setUser(createdUser);
		order.setOrderStatus(OrderStatus.Pending);
		orderRepository.save(order);
		
		
		
		UserDto userDto = new UserDto();
		userDto.setId(createdUser.getId());
	
	 return userDto;
	}
	
	
	public Boolean hasUserEmail(String email) {
		return userRepository.findFirstByEmail(email).isPresent();
	}
	
	@PostConstruct
	public void createAdminAccount() {
		User adminAccount = userRepository.findByRole(UserRole.ADMIN);
		if(null==adminAccount) {
			User user = new User();
		    user.setEmail("Admin@test.com");
		    user.setName("admin");
		    user.setRole(UserRole.ADMIN);
		    user.setPassword(new BCryptPasswordEncoder().encode("admin"));
		    userRepository.save(user);
			
		}
	}
}
