package com.dontwait.shopapp;

import com.dontwait.shopapp.controller.CategoryController;
import com.dontwait.shopapp.dto.request.category.CategoryCreationRequest;
import com.dontwait.shopapp.dto.request.category.CategoryUpdateRequest;
import com.dontwait.shopapp.dto.response.ApiResponse;
import com.dontwait.shopapp.dto.response.CategoryResponse;
import com.dontwait.shopapp.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    private CategoryResponse mockCategoryResponse;
    private CategoryCreationRequest creationRequest;
    private CategoryUpdateRequest updateRequest;

    @BeforeEach
    void setUp() {
        // Setup mock data
        mockCategoryResponse = new CategoryResponse();
        mockCategoryResponse.setId(1);
        mockCategoryResponse.setName("Electronics");
        mockCategoryResponse.setDescription("Electronic devices and accessories");

        creationRequest = new CategoryCreationRequest();
        creationRequest.setName("Electronics");
        creationRequest.setDescription("Electronic devices and accessories");

        updateRequest = new CategoryUpdateRequest();
        updateRequest.setName("Updated Electronics");
        updateRequest.setDescription("Updated description");
    }

    @Test
    void getAllCategories_ShouldReturnListOfCategories() {
        // Arrange
        List<CategoryResponse> mockCategories = Arrays.asList(mockCategoryResponse);
        when(categoryService.findAllCategories()).thenReturn(mockCategories);

        // Act
        ApiResponse<List<CategoryResponse>> response = categoryController.getAllCategories();

        // Assert
        assertNotNull(response);
        assertEquals("Get all categories successfully", response.getMessage());
        assertEquals(mockCategories, response.getResult());
        verify(categoryService, times(1)).findAllCategories();
    }

    @Test
    void findCategoryById_ShouldReturnCategory() {
        // Arrange
        Integer categoryId = 1;
        when(categoryService.findCategoryById(categoryId)).thenReturn(mockCategoryResponse);

        // Act
        ApiResponse<CategoryResponse> response = categoryController.findCategoryById(categoryId);

        // Assert
        assertNotNull(response);
        assertEquals("Get category successfully", response.getMessage());
        assertEquals(mockCategoryResponse, response.getResult());
        verify(categoryService, times(1)).findCategoryById(categoryId);
    }

    @Test
    void createCategory_ShouldReturnCreatedCategory() {
        // Arrange
        when(categoryService.createCategory(any(CategoryCreationRequest.class)))
                .thenReturn(mockCategoryResponse);

        // Act
        ApiResponse<CategoryResponse> response = categoryController.createCategory(creationRequest);

        // Assert
        assertNotNull(response);
        assertEquals("Create category successfully", response.getMessage());
        assertEquals(mockCategoryResponse, response.getResult());
        verify(categoryService, times(1)).createCategory(creationRequest);
    }

    @Test
    void updateCategory_ShouldReturnUpdatedCategory() {
        // Arrange
        Integer categoryId = 1;
        when(categoryService.updateCategory(eq(categoryId), any(CategoryUpdateRequest.class)))
                .thenReturn(mockCategoryResponse);

        // Act
        ApiResponse<CategoryResponse> response = categoryController.updateCategory(categoryId, updateRequest);

        // Assert
        assertNotNull(response);
        assertEquals("Create category successfully", response.getMessage());
        assertEquals(mockCategoryResponse, response.getResult());
        verify(categoryService, times(1)).updateCategory(categoryId, updateRequest);
    }

    @Test
    void deleteCategory_ShouldReturnSuccessMessage() {
        // Arrange
        Integer categoryId = 1;
        doNothing().when(categoryService).deleteCategory(categoryId);

        // Act
        ApiResponse<String> response = categoryController.deleteCategory(categoryId);

        // Assert
        assertNotNull(response);
        assertEquals("Delete category successfully", response.getMessage());
        verify(categoryService, times(1)).deleteCategory(categoryId);
    }
}