package com.dontwait.shopapp.controller;

import com.dontwait.shopapp.dto.response.ApiResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CategoryController {

    @GetMapping
    ApiResponse<String> getAllCategories(@RequestParam("page") int page,
                                         @RequestParam("limit") int limit) {
        return ApiResponse.<String>builder()
                .result("This is a test response")
                .build();
    }
}
