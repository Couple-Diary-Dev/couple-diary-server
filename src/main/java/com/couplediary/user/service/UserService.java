package com.couplediary.user.service;

import com.couplediary.exception.CustomException;
import com.couplediary.user.domain.User;
import com.couplediary.user.dto.CreateUserRequest;
import com.couplediary.user.dto.CreateUserResponse;
import com.couplediary.user.dto.GetUserResponse;
import com.couplediary.user.dto.UpdateUserRequest;
import com.couplediary.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateUserResponse createUser(CreateUserRequest request) {
        // TODO : 이 이메일이 진짜 이 사람의 이메일인지 체크
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {

            // TODO : 추후 예외처리 공통적으로 해야함 (ControllerAdvice)
            throw CustomException.builder()
                    .message("이미 존재하는 유저입니다.")
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }

        User user = User.builder()
                .nickname(request.getNickname())
                .email(request.getEmail())
                .sex(request.getSex())
                .passwordHash(passwordEncoder.encode(request.getPassword())).build();

        return new CreateUserResponse(userRepository.save(user).getNickname());
    }

    public GetUserResponse getUser(Long id) {
        // TODO : 추후 예외처리 공통적으로 해야함 (ControllerAdvice)
        User user = userRepository.findById(id).orElseThrow(() ->
                CustomException.builder()
                        .message("해당 회원이 존재하지 않습니다.")
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
        return new GetUserResponse(user.getEmail(), user.getNickname());
    }

    public void updateUser(Long id, UpdateUserRequest updateUserRequest) {
        User user = userRepository.findById(id).orElseThrow(() ->
                CustomException.builder()
                        .message("해당 회원이 존재하지 않습니다.")
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
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

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                CustomException.builder()
                        .message("해당 회원이 존재하지 않습니다.")
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
        userRepository.delete(user);
    }
}
