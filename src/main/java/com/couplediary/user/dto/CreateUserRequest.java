package com.couplediary.user.dto;

import com.couplediary.user.domain.User;
import lombok.Getter;

@Getter
public class CreateUserRequest {
    private String email;
    private String password;
    private String nickname;
    private User.Sex sex;
}
