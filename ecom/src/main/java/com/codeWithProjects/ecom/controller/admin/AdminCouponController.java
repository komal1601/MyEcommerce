package com.codeWithProjects.ecom.controller.admin;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.codeWithProjects.ecom.exception.ValidationException;

@RestController
@RequestMapping("/api/admin/coupons")
@RequiredArgsConstructor

public class AdminCouponController {
	
	private final AdminCouponService adminCouponService;
	
	public ResponseEntity<?> createCoupon(@RequestBody Coupon coupon){
		try { 
			Coupon createdCoupon = adminCouponService.createCoupon(coupon);
			return ResponseEntity.ok(createdCoupon);
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
			
		}
		
		return couponRepository.save(coupon);
	}
	
	public ResponseEntity<List<Coupon>> getAllCoupon(){
		return ResponseEntity.ok(adminCouponService.getAllCoupons());
	}

}
