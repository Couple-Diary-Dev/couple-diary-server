package com.couplediary.auth.token;

import java.util.Date;

public class RefreshTokenProvider extends TokenProvider {

    public RefreshTokenProvider(String secret, Date expireAt) {
        super(secret, expireAt);
    }
}