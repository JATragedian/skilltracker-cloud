package com.spb.skilltracker.cloud.userservice.service;

import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestSpan {

    @Autowired
    Tracer tracer;

    @PostConstruct
    public void checkOtel() {
        System.out.println("OpenTelemetry: " + io.opentelemetry.api.GlobalOpenTelemetry.get());
    }

    public void test() {
        Span span = tracer.nextSpan().name("manual-test-span").start();
        span.end();
    }
}
