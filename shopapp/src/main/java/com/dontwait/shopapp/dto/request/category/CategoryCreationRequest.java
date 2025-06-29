package com.dontwait.shopapp.dto.request.category;

import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryCreationRequest {

    @NotNull(message = "CATEGORY_NAME_CANT_NULL")
    @Min(value = 3, message = "CATEGORY_NAME_MUST_BE_GREATER_THAN_3")
    String name;
    String description;
}
