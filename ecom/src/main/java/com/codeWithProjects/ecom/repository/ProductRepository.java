package com.codeWithProjects.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWithProjects.ecom.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
 
	List<Product> findAllByNameContaining(String title);
	
}
