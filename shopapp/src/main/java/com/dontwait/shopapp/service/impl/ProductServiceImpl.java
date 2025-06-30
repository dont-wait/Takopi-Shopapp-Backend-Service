package com.dontwait.shopapp.service.impl;

import com.dontwait.shopapp.dto.request.product.ProductCreationRequest;
import com.dontwait.shopapp.dto.response.ProductResponse;
import com.dontwait.shopapp.entity.Product;
import com.dontwait.shopapp.enums.ErrorCode;
import com.dontwait.shopapp.exception.AppException;
import com.dontwait.shopapp.mapper.ProductMapper;
import com.dontwait.shopapp.repository.ProductRepository;
import com.dontwait.shopapp.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
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
                    .get("id"), categoryId
                    )
            );
        }

        if(keyword != null && !keyword.isEmpty()) {
            spec = spec.and((root, query, cb)
                    -> cb.like(root.get("name"), "%" + keyword + "%"));
        }

        return productRepository.findAll(spec, pageable).stream()
                .map(productMapper::toProductResponse)
                .toList();
    }

    @Override
    public ProductResponse createProduct(ProductCreationRequest request) {

        Product product = productMapper.toProduct(request);
        return productMapper.toProductResponse(product);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }
}
