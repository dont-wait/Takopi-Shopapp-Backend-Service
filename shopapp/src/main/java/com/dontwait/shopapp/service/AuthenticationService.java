package com.dontwait.shopapp.service;

import com.dontwait.shopapp.dto.request.auth.AuthenticationRequest;
import com.dontwait.shopapp.dto.response.UserResponse;
import com.dontwait.shopapp.entity.User;
import com.dontwait.shopapp.enums.ErrorCode;
import com.dontwait.shopapp.exception.AppException;
import com.dontwait.shopapp.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {
    UserRepository userRepository;

    //TODO: Implement JWT token response for login
    public String authenticate(AuthenticationRequest request) {
        User user = userRepository.findByFullName(request.getFullName())
                .orElseThrow(() -> new AppException(ErrorCode.FULLNAME_NOT_FOUND));
        PasswordEncoder passwordEncode = new BCryptPasswordEncoder(10);

        Boolean authenticated = passwordEncode.matches(request.getPassword(), user.getPassword());

        if(!authenticated)
            throw new AppException(ErrorCode.UNAUTHENTICATED);

        return "Login successfully";
    }
}
