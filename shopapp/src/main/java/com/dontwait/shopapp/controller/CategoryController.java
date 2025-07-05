package com.dontwait.shopapp.controller;

import com.dontwait.shopapp.dto.request.category.CategoryCreationRequest;
import com.dontwait.shopapp.dto.request.category.CategoryUpdateRequest;
import com.dontwait.shopapp.dto.response.ApiResponse;
import com.dontwait.shopapp.dto.response.CategoryResponse;
import com.dontwait.shopapp.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CategoryController {

    CategoryService categoryService;

    @GetMapping
    public ApiResponse<List<CategoryResponse>> getAllCategories() {
        return ApiResponse.<List<CategoryResponse>>builder()
                .result(categoryService.findAllCategories())
                .message("Get all categories successfully")
                .build();
    }

    @GetMapping("{categoryId}")
    public ApiResponse<CategoryResponse> findCategoryById(@PathVariable Long categoryId) {
        return ApiResponse.<CategoryResponse>builder()
                .result(categoryService.findCategoryById(categoryId))
                .message("Get category successfully")
                .build();
    }

    @PostMapping
    public ApiResponse<CategoryResponse> createCategory(@RequestBody CategoryCreationRequest request) {
        return ApiResponse.<CategoryResponse>builder()
                .result(categoryService.createCategory(request))
                .message("Create category successfully")
                .build();
    }

    @PutMapping("{categoryId}")
    public ApiResponse<CategoryResponse> updateCategory(@PathVariable Long categoryId, @RequestBody CategoryUpdateRequest request) {
        return ApiResponse.<CategoryResponse>builder()
                .result(categoryService.updateCategory(categoryId, request))
                .message("Create category successfully")
                .build();
    }

    @DeleteMapping("{categoryId}")
    public ApiResponse<String> deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ApiResponse.<String>builder()
                .message("Delete category successfully")
                .build();
    }


}
