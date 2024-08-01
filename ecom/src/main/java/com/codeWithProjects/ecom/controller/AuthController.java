package com.codeWithProjects.ecom.controller;

import java.util.Optional;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithProjects.ecom.dto.AuthenticationRequest;
import com.codeWithProjects.ecom.dto.SignupRequest;
import com.codeWithProjects.ecom.dto.UserDto;
import com.codeWithProjects.ecom.repository.UserRepository;
import com.codeWithProjects.ecom.utils.JwtUtil;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import com.codeWithProjects.ecom.services.auth.authService;


@RestController
@RequiredArgsConstructor
public class AuthController {

	private final AuthenticationManager authentivationManager ;
	
	private final UserDetailsService userDetailsService;
	
	private final UserRepository userRepository;
	
	private final JwtUtil jwtUtil;
	
	public static final String TOKEN_PREFIX = "Bearer";
	
	public static final String HEADER_STRING = "Authorization";
	
	private final authService authService;
	
	@PostMapping("/authenticate")
	public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws IOException, JSONException {
		
		
		
		
		
		try {
			AuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
	        authenticationRequest.getPassword()));
	        
		
		} catch(BadCrendentialsException e) {
		  
			throw new BadCredentialException("Incorrectusername or password.");
		}
		
		final UserDetails userDetails= userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		Optional<User> optionalUser = userRepository.findFirstByEmail(userDetails.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails.getUsername());
		
		if(optionalUser.isPresent()) {
			response.getWriter().write(new JSONObject()
					.put("userId", optionalUser.get().getId())
					.put("role",optionalUser.get().getRole())
					.toString()
					
					
					);
			
			response.addHeader(HEADER_STRING, TOKEN_PREFIX + jwt);	
			
		}
	}
		@PostMapping("/sign-up")
		public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest){
			
			if(authService.hasUserWithEmail(signupRequest.getEmail()))
			{
				return new ResponseEntity<> ("User already exist ", HttpStatus.NOT_ACCEPTABLE);
				
				}
			
			UserDto userDto = authService.createUser(signupRequest);
			return new ResponseEntity<>(userDto, HttpStatus.OK);
				}
			
		}
	
	
}
