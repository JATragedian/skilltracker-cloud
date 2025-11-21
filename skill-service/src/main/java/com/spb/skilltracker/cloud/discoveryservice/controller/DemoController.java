package com.spb.skilltracker.cloud.discoveryservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${example.message:NOT_LOADED}")
    private String message;

    @GetMapping("/config-test")
    public String test() {
        return message;
    }
}
