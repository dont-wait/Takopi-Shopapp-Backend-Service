package com.dontwait.shopapp.controller;

import com.dontwait.shopapp.dto.request.auth.AuthenticationRequest;
import com.dontwait.shopapp.dto.response.ApiResponse;
import com.dontwait.shopapp.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationController {
    AuthenticationService authenticationService;


    @PostMapping("/login")
    public ApiResponse<String> login(@Valid @RequestBody AuthenticationRequest request) {
        return ApiResponse.<String>builder()
                .message("Success")
                .result(authenticationService.authenticate(request))
                .build();
    }
}
