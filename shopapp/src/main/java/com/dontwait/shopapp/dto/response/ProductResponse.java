package com.dontwait.shopapp.dto.response;

import com.dontwait.shopapp.entity.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    Integer id;
    String name;
    BigDecimal price;
    String thumbnail;
    String description;
    String productCategory;
}
