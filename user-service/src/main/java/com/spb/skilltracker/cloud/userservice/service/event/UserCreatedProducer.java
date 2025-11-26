package com.spb.skilltracker.cloud.userservice.service.event;

import com.spb.skilltracker.cloud.userservice.dto.event.UserCreatedEvent;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedProducer {

    private final StreamBridge streamBridge;

    public UserCreatedProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void send(UserCreatedEvent event) {
        streamBridge.send("userCreated-out-0", event);
    }
}
