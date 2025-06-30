package com.dontwait.shopapp.service;

import com.dontwait.shopapp.dto.request.product.ProductCreationRequest;
import com.dontwait.shopapp.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse findProductById(Integer productId);
    List<ProductResponse> findAllProducts();
    ProductResponse createProduct(ProductCreationRequest request);
    void deleteProduct(Integer productId);
}
