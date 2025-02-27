package com.codeWithProjects.ecom.utils;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	
	public static  final String SECRET = "";
	
	public String generateToken(String userName) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userName);
	}
	
	private String createToken(Map<String, Object> claims, String userName) {

	return Jwts.builder()
			.setClaims(claims)
			.setSubject(userName)
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() * 10000 * 60 * 30))
			.signWith((Key) getSignKey(), SignatureAlgorithm.HS256).compact();
	}

	private Object getSignKey() {
	   byte[] keybytes = Decoders.BASE64.decode(SECRET);
	   return Keys.hmacShaKeyFor(keybytes);
	   
	
	}
	
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
		
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimResolver.apply(claims);
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
		}
	
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new date());
	}
	
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);  
		
	}
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String  username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
}