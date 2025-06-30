package com.dontwait.shopapp.repository;

import com.dontwait.shopapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findById(Integer id);
    List<Product> findAll();
    void deleteById(Integer id);
}
