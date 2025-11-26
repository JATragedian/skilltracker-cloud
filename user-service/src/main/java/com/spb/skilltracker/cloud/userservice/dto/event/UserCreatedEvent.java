package com.spb.skilltracker.cloud.userservice.dto.event;

public record UserCreatedEvent(
        Long userId,
        String email,
        String createdAt
) {}
