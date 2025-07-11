package com.dontwait.shopapp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "tokens")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "token", nullable = false, length = 255)
    String token;
    @Column(name = "token_type", nullable = false, length = 50)
    String tokenType;
    @Column(name = "expiration_date", nullable = false)
    LocalDateTime expirationDate;

    @Column(name = "revoked", nullable = false)
    Boolean revoked; //huy
    @Column(name = "expired", nullable = false)
    Boolean expired; //het han

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;
}
