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
    Integer id;

    @Column(name = "name", nullable = false, length = 350)
    String name;

    BigDecimal price;

    String thumbnail;

    @Column(columnDefinition = "LONGTEXT")
    String description;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    Category category;
}
