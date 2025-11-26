package com.spb.skilltracker.cloud.skillservice.controller;

import com.spb.skilltracker.cloud.skillservice.client.UserClient;
import com.spb.skilltracker.cloud.skillservice.dto.UserResponse;
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

    @GetMapping("/skills")
    public String getSkills() {
        return "Here's your skills";
    }
}
