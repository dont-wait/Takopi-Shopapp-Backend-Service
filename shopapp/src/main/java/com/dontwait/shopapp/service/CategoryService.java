package com.dontwait.shopapp.service;

import com.dontwait.shopapp.dto.request.category.CategoryCreationRequest;
import com.dontwait.shopapp.dto.request.category.CategoryUpdateRequest;
import com.dontwait.shopapp.dto.response.CategoryResponse;
import com.dontwait.shopapp.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryResponse findCategoryById(Long categoryId);
    List<CategoryResponse> findAllCategories();
    CategoryResponse createCategory(CategoryCreationRequest request);
    CategoryResponse updateCategory(Long categoryId, CategoryUpdateRequest request);
    void deleteCategory(Long categoryId);
}
