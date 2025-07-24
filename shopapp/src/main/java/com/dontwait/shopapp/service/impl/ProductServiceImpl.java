package com.dontwait.shopapp.service.impl;

import com.dontwait.shopapp.dto.request.product.ProductCreationRequest;
import com.dontwait.shopapp.dto.request.product.ProductImageRequest;
import com.dontwait.shopapp.dto.request.product.ProductUpdateRequest;
import com.dontwait.shopapp.dto.response.ProductImageResponse;
import com.dontwait.shopapp.dto.response.ProductResponse;
import com.dontwait.shopapp.entity.Category;
import com.dontwait.shopapp.entity.Product;
import com.dontwait.shopapp.entity.ProductImage;
import com.dontwait.shopapp.enums.ErrorCode;
import com.dontwait.shopapp.exception.AppException;
import com.dontwait.shopapp.mapper.ProductImageMapper;
import com.dontwait.shopapp.mapper.ProductMapper;
import com.dontwait.shopapp.repository.CategoryRepository;
import com.dontwait.shopapp.repository.ProductImageRepository;
import com.dontwait.shopapp.repository.ProductRepository;
import com.dontwait.shopapp.service.ProductService;
import com.dontwait.shopapp.util.FileUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    ProductMapper productMapper;
    ProductImageMapper productImageMapper;
    ProductRepository productRepository;
    ProductImageRepository productImageRepository;
    CategoryRepository categoryRepository;

    @Override
    public ProductResponse findProductById(Long productId) {
        Product existingProduct = productRepository.findById(productId).
                orElseThrow(() -> new AppException(ErrorCode.PRODUCT_ID_NOT_FOUND));

        return productMapper.toProductResponse(existingProduct);
    }

    @Override
    public List<ProductResponse> findAllProducts(Pageable pageable, String keyword, Long categoryId) {
        Specification<Product> spec = Specification.where(null);

        if(categoryId != null) {
            spec = spec.and((root, query, cb)
                    -> cb.equal(root.get("category")
                    .get("categoryId"), categoryId
                    )
            );
        }

        if(keyword != null && !keyword.isEmpty()) {
            spec = spec.and((root, query, cb)
                    -> cb.like(root.get("productName"), "%" + keyword + "%"));
        }

        return productRepository.findAll(spec, pageable).stream()
                .map(productMapper::toProductResponse)
                .toList();
    }

    @Override
    public ProductResponse createProduct(ProductCreationRequest request) throws IOException {
        Category existingCategory = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_ID_NOT_FOUND));
        Product product = productMapper.toProduct(request, existingCategory);

        return productMapper.toProductResponse(productRepository.save(product));
    }

    @Override
    public ProductImageResponse createProductImage(Long productId, ProductImageRequest request) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_ID_NOT_FOUND));

        //If size >= 5, cancel process
        int size = productImageRepository.findByProductProductId(productId).size();
        if(size >= 5)
            throw new AppException(ErrorCode.SIZE_OF_PRODUCT_IMAGES_CANNOT_GREATER_THAN_5);
        ProductImage newProductImage = productImageMapper.toProductImage(request);

        return productImageMapper.toProductImageResponse(productImageRepository.save(newProductImage));
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public ProductResponse updateProduct(Long productId, ProductUpdateRequest request) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_ID_NOT_FOUND));

        Category existingCategory = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_ID_NOT_FOUND));

        productMapper.updateProduct(request, existingProduct, existingCategory);
        return productMapper.toProductResponse(productRepository.save(existingProduct));
    }
}
