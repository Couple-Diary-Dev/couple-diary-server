package com.couplediary.config;

import com.couplediary.auth.token.AccessTokenProvider;
import com.couplediary.auth.token.RefreshTokenProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Date;

@Configuration
public class TokenProviderConfig {

    @Value("${app.token.secret}")
    private String secret;
    Date accessTokenExpireAt = new Date(System.currentTimeMillis() + Duration.ofMinutes(30).toMillis());
    Date refreshTokenExpireAt = new Date(System.currentTimeMillis() + Duration.ofDays(14).toMillis());

    @Bean
    public AccessTokenProvider accessTokenProvider() {
        return new AccessTokenProvider(secret, accessTokenExpireAt);
    }

    @Bean
    public RefreshTokenProvider refreshTokenProvider() {
        return new RefreshTokenProvider(secret, refreshTokenExpireAt);
    }
}
