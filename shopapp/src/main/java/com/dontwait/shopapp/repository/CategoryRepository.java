package com.dontwait.shopapp.repository;

import com.dontwait.shopapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findById(Integer id);
    List<Category> findAll();
    Boolean existsByName(String name);
    void deleteById(Integer id);
}
