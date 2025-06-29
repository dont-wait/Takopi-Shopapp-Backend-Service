package com.dontwait.shopapp.mapper;
import com.dontwait.shopapp.dto.request.category.CategoryCreationRequest;
import com.dontwait.shopapp.dto.request.category.CategoryUpdateRequest;
import com.dontwait.shopapp.dto.response.CategoryResponse;
import com.dontwait.shopapp.entity.Category;
import org.mapstruct.*;
@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryCreationRequest request);
    CategoryResponse toCategoryResponse(Category category);
    void updateCategory(CategoryUpdateRequest request, @MappingTarget Category category);
}
