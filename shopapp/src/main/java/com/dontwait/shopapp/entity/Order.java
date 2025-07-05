package com.dontwait.shopapp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

    @Column(name = "order_fullname")
    String orderFullName;

    @Column(name = "order_email")
    String orderEmail;

    @Column(name = "order_phone_number")
    String orderPhoneNumber;

    @Column(name = "order_address")
    String address;

    @Column(name = "note")
    String note;

    @Column(name = "total_money")
    BigDecimal totalMoney;

    @Column(name = "shipping_method")
    String shippingMethod;

    @Column(name = "shipping_address")
    String shippingAddress;

    @Column(name = "payment_method")
    String paymentMethod;
}
