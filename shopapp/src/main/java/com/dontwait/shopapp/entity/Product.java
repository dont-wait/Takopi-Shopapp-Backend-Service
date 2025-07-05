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
@Table(name = "products")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    Long productId;

    @Column(name = "product_name", nullable = false, length = 350)
    String productName;

    BigDecimal price;

    @Column(name = "product_thumbnail", nullable = false, length = 350)
    String thumbnail;

    @Column(name = "product_description", columnDefinition = "LONGTEXT")
    String productDescription;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    Category category;
}
