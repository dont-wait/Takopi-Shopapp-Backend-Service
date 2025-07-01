package com.dontwait.shopapp.service;

import com.dontwait.shopapp.dto.request.product.ProductCreationRequest;
import com.dontwait.shopapp.dto.request.product.ProductUpdateRequest;
import com.dontwait.shopapp.dto.response.ProductResponse;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    ProductResponse findProductById(Integer productId);
    List<ProductResponse> findAllProducts(Pageable pageable, String keyword, Integer categoryId);
    ProductResponse createProduct(ProductCreationRequest request) throws IOException;
    void deleteProduct(Integer productId);
    ProductResponse updateProduct(Integer productId, ProductUpdateRequest request);
}
