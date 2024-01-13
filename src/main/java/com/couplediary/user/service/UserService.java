package com.couplediary.user.service;

import com.couplediary.user.domain.User;
import com.couplediary.user.dto.CreateUserRequest;
import com.couplediary.user.dto.CreateUserResponse;
import com.couplediary.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public CreateUserResponse createUser(CreateUserRequest request) {
        // TODO: findByEmail해서 같은 이메일을 쓰거나 닉네임을 쓰는경우 예외던지기
        // TODO : Password를 그냥 저장하지 않고, passwordHash로 저장하도록 변경
        User user = User.builder()
                .nickname(request.getNickname())
                .email(request.getEmail())
                .sex(request.getSex())
                .passwordHash(request.getPassword()).build();

        return new CreateUserResponse(userRepository.save(user).getNickname());
    }
}
