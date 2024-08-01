package com.codeWithProjects.ecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWithProjects.ecom.entity.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {


Optional<Coupon> findByCode(String code);
}
