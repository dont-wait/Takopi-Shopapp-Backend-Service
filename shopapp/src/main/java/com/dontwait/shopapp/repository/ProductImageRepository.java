package com.dontwait.shopapp.repository;

import com.dontwait.shopapp.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    List<ProductImage> findByProductProductId(Long productId);
}
