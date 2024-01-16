package com.couplediary.user.service;

import com.couplediary.user.domain.User;
import com.couplediary.user.dto.CreateUserRequest;
import com.couplediary.user.dto.CreateUserResponse;
import com.couplediary.user.dto.GetUserResponse;
import com.couplediary.user.dto.UpdateUserRequest;
import com.couplediary.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public CreateUserResponse createUser(CreateUserRequest request) {
        // TODO : 이 이메일이 진짜 이 사람의 이메일인지 체크
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {

            // TODO : 추후 예외처리 공통적으로 해야함 (ControllerAdvice)
            throw new IllegalArgumentException("이메일 중복");
        }

        // TODO : Password를 그냥 저장하지 않고, passwordHash로 저장하도록 변경
        User user = User.builder()
                .nickname(request.getNickname())
                .email(request.getEmail())
                .sex(request.getSex())
                .passwordHash(request.getPassword()).build();

        return new CreateUserResponse(userRepository.save(user).getNickname());
    }

    public GetUserResponse getUser(Long id) {
        // TODO : 추후 예외처리 공통적으로 해야함 (ControllerAdvice)
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        return new GetUserResponse(user.getEmail(), user.getNickname());
    }

    public void updateUser(Long id, UpdateUserRequest updateUserRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        String nickname = updateUserRequest.getNickname();
        if (nickname != null) {
            user.updateNickname(nickname);
        }
        
        String password = updateUserRequest.getPassword();
        if (password != null) {
            user.updatePassword(updateUserRequest.getPassword());
        }
        User.Sex sex = updateUserRequest.getSex();
        if (sex != null) {
            user.updateSex(sex);
        }
    }
}
