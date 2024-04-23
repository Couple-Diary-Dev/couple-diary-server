package com.couplediary.auth.controller;

import com.couplediary.auth.dto.LoginRequest;
import com.couplediary.auth.dto.LoginResponse;
import com.couplediary.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping()
    public LoginResponse Login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
