package com.dontwait.shopapp.service.impl;

import com.dontwait.shopapp.dto.request.product.ProductCreationRequest;
import com.dontwait.shopapp.dto.request.product.ProductUpdateRequest;
import com.dontwait.shopapp.dto.response.ProductResponse;
import com.dontwait.shopapp.entity.Category;
import com.dontwait.shopapp.entity.Product;
import com.dontwait.shopapp.enums.ErrorCode;
import com.dontwait.shopapp.exception.AppException;
import com.dontwait.shopapp.mapper.ProductMapper;
import com.dontwait.shopapp.repository.CategoryRepository;
import com.dontwait.shopapp.repository.ProductRepository;
import com.dontwait.shopapp.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    ProductMapper productMapper;
    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    @Override
    public ProductResponse findProductById(Integer productId) {
        Product product = productRepository.findById(productId).
                orElseThrow(() -> new AppException(ErrorCode.PRODUCT_ID_NOT_FOUND));

        return productMapper.toProductResponse(product);
    }

    @Override
    public List<ProductResponse> findAllProducts(Pageable pageable, String keyword, Integer categoryId) {
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
    public ProductResponse createProduct(ProductCreationRequest request) {

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_ID_NOT_FOUND));

        Product product = productMapper.toProduct(request, category);

        return productMapper.toProductResponse(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public ProductResponse updateProduct(Integer productId, ProductUpdateRequest request) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_ID_NOT_FOUND));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_ID_NOT_FOUND));

        productMapper.updateProduct(request, product);
        return productMapper.toProductResponse(productRepository.save(product));
    }
}
