package com.spb.skilltracker.cloud.userservice.controller;

import com.spb.skilltracker.cloud.userservice.dto.UserResponse;
import com.spb.skilltracker.cloud.userservice.service.TestSpan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final TestSpan testSpan;

    public UserController(TestSpan testSpan) {
        this.testSpan = testSpan;
    }

    @GetMapping("/users/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        testSpan.test();

        return new UserResponse(id, "Test User", "test@mail.com");
    }
}
