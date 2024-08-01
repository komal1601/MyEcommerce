package com.codeWithProjects.ecom.services.admin.coupon;

import org.springframework.stereotype.Service;

import com.codeWithProjects.ecom.entity.Coupon;
import com.codeWithProjects.ecom.exception.ValidationException;
import com.codeWithProjects.ecom.repository.CouponRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminCouponServiceImpl implements AdminCouponService{
	
private final CouponRepository couponRepository;
	
	public Coupon createCoupon(Coupon coupon) {
		if(couponRepository.existsByCode(coupon.getCode())) {
			throw new ValidationException("Coupon code already exists.");
		}
		return couponRepository.save(coupon);
	}


}
