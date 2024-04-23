package com.couplediary.auth.token;

import java.util.Date;

public class AccessTokenProvider extends TokenProvider {
    public AccessTokenProvider(String secret, Date expireAt) {
        super(secret, expireAt);
    }
}
