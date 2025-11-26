package com.spb.skilltracker.cloud.userservice.controller;

import com.spb.skilltracker.cloud.userservice.dto.UserRequest;
import com.spb.skilltracker.cloud.userservice.dto.UserResponse;
import com.spb.skilltracker.cloud.userservice.service.TestSpan;
import com.spb.skilltracker.cloud.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final TestSpan testSpan;
    private final UserService userService;

    public UserController(TestSpan testSpan, UserService userService) {
        this.testSpan = testSpan;
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        testSpan.test();

        return new UserResponse(id, "Test User", "test@mail.com");
    }

    @PostMapping("/users")
    public UserResponse create(@RequestBody UserRequest request) {
        return userService.createUser(request.name(), request.email());
    }
}
