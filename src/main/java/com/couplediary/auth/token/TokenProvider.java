package com.couplediary.auth.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public abstract class TokenProvider {

    private String secret;
    private Date expireAt;

    public TokenProvider(String secret, Date expireAt) {
        this.secret = secret;
        this.expireAt = expireAt;
    }

    public String generateToken(Long userId) {
        Algorithm algorithm = Algorithm.HMAC512(secret);
        String token = JWT.create()
                .withExpiresAt(expireAt)
                .withIssuer("couple-diary")
                .withClaim("id", userId)
                .sign(algorithm);
        return token;
    }
}
