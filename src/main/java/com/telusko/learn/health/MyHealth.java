package com.telusko.learn.health;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Endpoint(id = "my-check")
public class MyHealth implements HealthIndicator {
    @ReadOperation
    @Override
    public Health health() {
        return Health.down()
                .withDetails(Map.of(
                        "status", "working boss",
                        "httpStatus", 503 // HTTP 503 Service Unavailable
                ))
                .build();
    }
}
