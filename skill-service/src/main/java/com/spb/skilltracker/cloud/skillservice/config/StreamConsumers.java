package com.spb.skilltracker.cloud.skillservice.config;

import com.spb.skilltracker.cloud.skillservice.dto.event.UserCreatedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class StreamConsumers {

    @Bean
    public Consumer<UserCreatedEvent> userCreatedEvent() {
        return event -> System.out.println("Event received: " + event);
    }
}