package com.telusko.learn.health;

import org.jspecify.annotations.Nullable;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "my-check") // Available at /actuator/my-check
public class MyHealth implements HealthIndicator {
    @ReadOperation
    @Override
    public @Nullable Health health() {
        return Health.up()
                .status("Its in good condition")
                .build();
    }
}
