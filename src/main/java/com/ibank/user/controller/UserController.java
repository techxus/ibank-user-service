package com.ibank.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.MDC;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping
@Slf4j
public class UserController {

    private static final AtomicInteger counter = new AtomicInteger();

    @GetMapping("/server")
    public Map<String, Object> getServerDetails() {

        int counterValue = counter.incrementAndGet();
        MDC.put("correlationId", UUID.randomUUID().toString());
        log.info("Processing GET:/api/v1/user/server...");

        return Map.of(
                "message", "Brick @ Postgres | Redis | Vault Setup Milestone Reached !!!",
                "timestamp", Instant.now().toString(),
                "counter", counterValue
        );
    }
}