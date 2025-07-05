package com.dontwait.shopapp.dto.request.order;

import com.dontwait.shopapp.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderCreationRequest {
    Long userId;

    String orderFullName;

    String orderEmail;

    String orderPhoneNumber;

    String address;

    String note;

    BigDecimal totalMoney;

    String shippingMethod;

    String shippingAddress;

    String paymentMethod;

}
