package com.dontwait.shopapp.service;

import com.dontwait.shopapp.dto.request.product.ProductCreationRequest;
import com.dontwait.shopapp.dto.request.product.ProductImageRequest;
import com.dontwait.shopapp.dto.request.product.ProductUpdateRequest;
import com.dontwait.shopapp.dto.response.ProductImageResponse;
import com.dontwait.shopapp.dto.response.ProductResponse;
import com.dontwait.shopapp.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    ProductResponse findProductById(Long productId);
    List<ProductResponse> findAllProducts(Pageable pageable, String keyword, Long categoryId);
    ProductResponse createProduct(ProductCreationRequest request) throws IOException;
    List<ProductImageResponse> uploadImages(Long productId, List<MultipartFile> files) throws IOException;
    Product getProductById(Long productId);
    ProductImageResponse createProductImage(Long productId, ProductImageRequest request);
    void deleteProduct(Long productId);
    ProductResponse updateProduct(Long productId, ProductUpdateRequest request);
}
