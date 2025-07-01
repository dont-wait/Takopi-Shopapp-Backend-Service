package com.dontwait.shopapp.repository;

import com.dontwait.shopapp.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUserId(Integer userId);
    Boolean existsByPhoneNumber(String phoneNumber);
    Page<User> findAll(Pageable pageable, String keyword, Integer roleId);
    void deleteByUserId(Integer userId);
}
