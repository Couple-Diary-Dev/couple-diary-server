package com.couplediary.user.dto;

import com.couplediary.user.domain.User;
import lombok.Getter;

@Getter
public class UpdateUserRequest {
    // TODO : 이메일 변경 관련 생각해보기
    private String password;
    private String nickname;
    private User.Sex sex;
}
