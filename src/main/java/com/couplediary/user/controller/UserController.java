package com.couplediary.user.controller;

import com.couplediary.user.dto.CreateUserRequest;
import com.couplediary.user.dto.CreateUserResponse;
import com.couplediary.user.dto.GetUserResponse;
import com.couplediary.user.dto.UpdateUserRequest;
import com.couplediary.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
        return userService.createUser(createUserRequest);
    }

    @GetMapping("/{id}")
    public GetUserResponse getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody UpdateUserRequest updateUserRequest) {
        userService.updateUser(id, updateUserRequest);
    }
}
