package com.dontwait.shopapp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "product_images")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_images_id")
    Long productImageId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    Product product;
    @Column(name = "image_url", length = 300)
    String imageURL;
}
