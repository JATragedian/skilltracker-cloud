package com.spb.skilltracker.cloud.discoveryservice.controller;

import com.spb.skilltracker.cloud.discoveryservice.client.UserClient;
import com.spb.skilltracker.cloud.discoveryservice.dto.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class SkillController {

    private final UserClient userClient;

    @GetMapping("/test-user/{id}")
    public UserResponse test(@PathVariable Long id) {
        return userClient.getUserById(id);
    }
}
