package com.dontwait.shopapp.service;

import com.dontwait.shopapp.dto.request.product.ProductCreationRequest;
import com.dontwait.shopapp.dto.request.product.ProductImageRequest;
import com.dontwait.shopapp.dto.request.product.ProductUpdateRequest;
import com.dontwait.shopapp.dto.response.ProductImageResponse;
import com.dontwait.shopapp.dto.response.ProductResponse;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    ProductResponse findProductById(Long productId);
    List<ProductResponse> findAllProducts(Pageable pageable, String keyword, Long categoryId);
    ProductResponse createProduct(ProductCreationRequest request) throws IOException;
    ProductImageResponse createProductImage(Long productId, ProductImageRequest request);
    void deleteProduct(Long productId);
    ProductResponse updateProduct(Long productId, ProductUpdateRequest request);
}
