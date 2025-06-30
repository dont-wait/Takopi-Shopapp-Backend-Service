package com.dontwait.shopapp.dto.request.product;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductUpdateRequest {
    @Size(min = 3, message = "PRODUCT_NAME_MUST_BE_GREATER_THAN_3")
    String name;
    @DecimalMin(value = "0.01", message = "PRODUCT_PRICE_MUST_BE_GREATER_THAN_0")
    String price;
    String thumbnail;
    String description;
    Integer categoryId;
}
