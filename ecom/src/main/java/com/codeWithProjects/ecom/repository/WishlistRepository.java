package com.codeWithProjects.ecom.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<WishList, Long> {

	List<Wishlist> findAllByUserId(Long userId);
}
