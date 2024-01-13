package com.couplediary.user.dto;

import lombok.Getter;

@Getter
public class CreateUserResponse {
    private String nickname;

    public CreateUserResponse(String nickname) {
        this.nickname = nickname;
    }
}
