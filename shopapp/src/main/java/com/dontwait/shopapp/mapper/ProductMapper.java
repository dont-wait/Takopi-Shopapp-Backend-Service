package com.dontwait.shopapp.mapper;

import com.dontwait.shopapp.dto.request.product.ProductCreationRequest;
import com.dontwait.shopapp.dto.request.product.ProductUpdateRequest;
import com.dontwait.shopapp.dto.response.ProductResponse;
import com.dontwait.shopapp.entity.Category;
import com.dontwait.shopapp.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductCreationRequest request, Category category);

    @Mapping(target = "productCategory", source = "category.categoryName")
    ProductResponse toProductResponse(Product product);

    void updateProduct(ProductUpdateRequest request, @MappingTarget Product product);
}
