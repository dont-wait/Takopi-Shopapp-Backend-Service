package com.dontwait.shopapp.mapper;

import com.dontwait.shopapp.dto.request.product.ProductImageRequest;
import com.dontwait.shopapp.dto.response.ProductImageResponse;
import com.dontwait.shopapp.entity.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductImageMapper {
    ProductImage toProductImage(ProductImageRequest request);

    @Mapping(source = "product.productId", target = "productImageId")
    ProductImageResponse toProductImageResponse(ProductImage productImage);
}
