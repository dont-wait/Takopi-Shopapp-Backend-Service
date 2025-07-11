package com.dontwait.shopapp.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "social_accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SocialAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "social_account_id")
    Long socialAccountId;
    @Column(name = "social_account_provider", length = 20, nullable = false)
    String provider;
    @Column(name = "social_account_provider_id", length = 50, nullable = false)
    String providerId;
    @Column(name = "social_account_email", length = 150)
    String providerEmail;

    @Column(name = "social_account_name", length = 100)
    String socialAccountName;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;
}
