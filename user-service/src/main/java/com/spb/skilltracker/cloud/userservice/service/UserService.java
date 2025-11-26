package com.spb.skilltracker.cloud.userservice.service;

import com.spb.skilltracker.cloud.userservice.dto.UserResponse;
import com.spb.skilltracker.cloud.userservice.dto.event.UserCreatedEvent;
import com.spb.skilltracker.cloud.userservice.service.event.UserCreatedProducer;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserService {

    private final UserCreatedProducer producer;

    public UserService(UserCreatedProducer producer) {
        this.producer = producer;
    }

    public UserResponse createUser(String name, String email) {
        UserResponse user = new UserResponse(1L, name, email);

        UserCreatedEvent event = new UserCreatedEvent(
                user.id(),
                user.email(),
                Instant.now().toString()
        );

        producer.send(event);

        return user;
    }
}
