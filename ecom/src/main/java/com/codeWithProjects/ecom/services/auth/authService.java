package com.codeWithProjects.ecom.services.auth;

import com.codeWithProjects.ecom.dto.SignupRequest;
import com.codeWithProjects.ecom.dto.UserDto;

public interface authService {
	
	UserDto createUser(SignupRequest signupRequest);
	
	Boolean hasUserWithEmail(String email); 

}
