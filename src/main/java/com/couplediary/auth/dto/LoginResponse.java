package com.couplediary.auth.dto;

import lombok.Getter;

@Getter
public class LoginResponse {
    private String accesstoken;
    private String RefreshToken;

    public LoginResponse(String accesstoken, String refreshToken) {
        this.accesstoken = accesstoken;
        RefreshToken = refreshToken;
    }
}
