package com.spb.skilltracker.cloud.userservice.controller;

import com.spb.skilltracker.cloud.userservice.dto.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return new UserResponse(id, "Test User", "test@mail.com");
    }
}
