package com.dontwait.shopapp;

import com.dontwait.shopapp.dto.response.ProductResponse;
import com.dontwait.shopapp.entity.Product;
import com.dontwait.shopapp.mapper.ProductMapper;
import com.dontwait.shopapp.repository.ProductRepository;
import com.dontwait.shopapp.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product1;
    private Product product2;
    private ProductResponse productResponse1;
    private ProductResponse productResponse2;

    @BeforeEach
    void setUp() {
        // Initialize test data
        product1 = new Product();
        product1.setId(1);
        product1.setName("Test Product 1");

        product2 = new Product();
        product2.setId(2);
        product2.setName("Test Product 2");

        productResponse1 = new ProductResponse();
        productResponse1.setId(1);
        productResponse1.setName("Test Product 1");

        productResponse2 = new ProductResponse();
        productResponse2.setId(2);
        productResponse2.setName("Test Product 2");
    }

    @Test
    void findAllProducts_WithNoFilters_ShouldReturnAllProducts() {
        // Arrange
        PageRequest pageable = PageRequest.of(0, 10, Sort.by("name"));
        Page<Product> productPage = new PageImpl<>(Arrays.asList(product1, product2));
        
        when(productRepository.findAll(any(Specification.class), any(PageRequest.class)))
                .thenReturn(productPage);
        when(productMapper.toProductResponse(product1)).thenReturn(productResponse1);
        when(productMapper.toProductResponse(product2)).thenReturn(productResponse2);

        // Act
        List<ProductResponse> result = productService.findAllProducts(pageable, null, null);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(productRepository).findAll(any(Specification.class), eq(pageable));
    }

    @Test
    void findAllProducts_WithKeyword_ShouldReturnFilteredProducts() {
        // Arrange
        String keyword = "Test";
        PageRequest pageable = PageRequest.of(0, 10, Sort.by("name"));
        Page<Product> productPage = new PageImpl<>(List.of(product1));
        
        when(productRepository.findAll(any(Specification.class), any(PageRequest.class)))
                .thenReturn(productPage);
        when(productMapper.toProductResponse(product1)).thenReturn(productResponse1);

        // Act
        List<ProductResponse> result = productService.findAllProducts(pageable, keyword, null);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(productRepository).findAll(any(Specification.class), eq(pageable));
    }

    @Test
    void findAllProducts_WithCategoryId_ShouldReturnFilteredProducts() {
        // Arrange
        Integer categoryId = 1;
        PageRequest pageable = PageRequest.of(0, 10, Sort.by("name"));
        Page<Product> productPage = new PageImpl<>(List.of(product1));
        
        when(productRepository.findAll(any(Specification.class), any(PageRequest.class)))
                .thenReturn(productPage);
        when(productMapper.toProductResponse(product1)).thenReturn(productResponse1);

        // Act
        List<ProductResponse> result = productService.findAllProducts(pageable, null, categoryId);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(productRepository).findAll(any(Specification.class), eq(pageable));
    }

    @Test
    void findAllProducts_WithKeywordAndCategoryId_ShouldReturnFilteredProducts() {
        // Arrange
        String keyword = "Test";
        Integer categoryId = 1;
        PageRequest pageable = PageRequest.of(0, 10, Sort.by("name"));
        Page<Product> productPage = new PageImpl<>(List.of(product1));
        
        when(productRepository.findAll(any(Specification.class), any(PageRequest.class)))
                .thenReturn(productPage);
        when(productMapper.toProductResponse(product1)).thenReturn(productResponse1);

        // Act
        List<ProductResponse> result = productService.findAllProducts(pageable, keyword, categoryId);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(productRepository).findAll(any(Specification.class), eq(pageable));
    }

    @Test
    void findAllProducts_WithEmptyResult_ShouldReturnEmptyList() {
        // Arrange
        PageRequest pageable = PageRequest.of(0, 10, Sort.by("name"));
        Page<Product> productPage = new PageImpl<>(List.of());
        
        when(productRepository.findAll(any(Specification.class), any(PageRequest.class)))
                .thenReturn(productPage);

        // Act
        List<ProductResponse> result = productService.findAllProducts(pageable, null, null);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(productRepository).findAll(any(Specification.class), eq(pageable));
    }
}