package com.couplediary.user.dto;

import lombok.Getter;

@Getter
public class GetUserResponse {
    private String email;
    private String nickname;

    public GetUserResponse(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }
}
