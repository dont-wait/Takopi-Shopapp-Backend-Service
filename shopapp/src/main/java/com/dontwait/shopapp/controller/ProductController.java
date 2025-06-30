package com.dontwait.shopapp.controller;

import com.dontwait.shopapp.dto.response.ApiResponse;
import com.dontwait.shopapp.dto.response.ProductResponse;
import com.dontwait.shopapp.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    @GetMapping("{productId}")
    public ApiResponse<ProductResponse> findProductById(@PathVariable Integer productId) {
        return ApiResponse.<ProductResponse>builder()
                .result(productService.findProductById(productId))
                .message("Get product successfully")
                .build();
    }
    @GetMapping
    public ApiResponse<List<ProductResponse>> findAll(@RequestParam(name = "page") Integer page,
                                                      @RequestParam(name = "limit") Integer limit,
                                                      @RequestParam(name = "sort", defaultValue = "name") String sort,
                                                      @RequestParam(name = "order", defaultValue = "asc") String order) {
        return ApiResponse.<List<ProductResponse>>builder()
                .result(productService.findAllProducts())
                .message("Get all products successfully")
                .build();
    }

    @DeleteMapping("{productId}")
    public ApiResponse<String> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
        return ApiResponse.<String>builder()
                .message("Delete product successfully")
                .build();
    }
}
