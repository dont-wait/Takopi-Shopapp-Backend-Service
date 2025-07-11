package com.dontwait.shopapp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "order_id", nullable = false)
    Long orderId;
    @Column(name = "product_id", nullable = false)
    Long productId;
    @Column(name = "price", nullable = false)
    BigDecimal price;
    @Column(name = "number_of_products", nullable = false)
    Integer numberOfProducts;
    @Column(name = "total_money", nullable = false)
    BigDecimal totalMoney;
    String color;
}
