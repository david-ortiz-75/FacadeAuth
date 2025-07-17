package com.task.takehome.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;

@Service
public class DownstreamAuthService {

    private final Map<Integer, Boolean> mockUserStore = Map.of(
            123, true,
            789, false
    );
    @CircuitBreaker(name = "downstreamAuthService", fallbackMethod = "fallbackAuth")
    public Mono<Boolean> forwardRequest(Integer userId) {
        return Mono.delay(Duration.ofMillis(200))
                .map(delay -> mockUserStore.getOrDefault(userId, false));
    }

    public Mono<Boolean> fallbackAuth(String userId, Throwable ex) {
        return Mono.just(false);
    }

}
