package com.dontwait.shopapp.controller;

import com.dontwait.shopapp.dto.request.order_detail.OrderDetailCreationRequest;
import com.dontwait.shopapp.dto.request.order_detail.OrderDetailUpdateRequest;
import com.dontwait.shopapp.dto.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-details")
public class OrderDetailController {
    @PostMapping
    public ApiResponse<String> createOrderDetail(@Valid @RequestBody OrderDetailCreationRequest request) {
        return ApiResponse.<String>builder()
                .message("Create order detail successfully")
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<String> getOrderDetails(@PathVariable Long id) {
        return ApiResponse.<String>builder()
                .message("Get order detail successfully")
                .build();
    }

    @GetMapping("/order/{orderId}")
    public ApiResponse<List<String>> getOrderDetailsWithOrderId(@PathVariable Long orderId) {
        return ApiResponse.<List<String>>builder()
                .message("Get order detail with orderId")
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<String> updateOrderDetail(@PathVariable Long id, @Valid @RequestBody OrderDetailUpdateRequest request) {
        return ApiResponse.<String>builder()
                .message("update order detail successfully")
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteOrderDetail(@PathVariable Long id) {
        return ApiResponse.<String>builder()
                .message("delete order detail successfully")
                .build();
    }

}
