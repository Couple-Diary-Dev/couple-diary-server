package com.couplediary.auth.service;

import com.couplediary.auth.dto.LoginRequest;
import com.couplediary.auth.dto.LoginResponse;
import com.couplediary.auth.token.AccessTokenProvider;
import com.couplediary.auth.token.RefreshTokenProvider;
import com.couplediary.exception.CustomException;
import com.couplediary.user.domain.User;
import com.couplediary.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final AccessTokenProvider accessTokenProvider;

    private final RefreshTokenProvider refreshTokenProvider;

    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> CustomException.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("유저가 존재하지 않습니다.")
                .build());
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPasswordHash())) {
            throw CustomException.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message("회원 정보와 일치하지 않습니다.")
                    .build();
        }
        return new LoginResponse(accessTokenProvider.generateToken(user.getId()), refreshTokenProvider.generateToken(user.getId()));
    }
}
