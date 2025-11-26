package com.spb.skilltracker.cloud.skillservice.dto.event;

public record UserCreatedEvent(
        Long userId,
        String email,
        String createdAt
) {}
