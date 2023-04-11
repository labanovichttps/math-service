package com.labanovich.reactive.math.demo.service;

import com.labanovich.reactive.math.demo.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Service
public class ReactiveMathService {

    public Mono<Response> calculateMultiply(Integer input) {
        log.info("calculate for input {}", input);
        return Mono.fromSupplier(() -> input * input)
            .map(it -> new Response(it, Instant.now()));
    }

    public Flux<Response> calculateMultiplyTable(Integer input) {
        log.info("calculate for input {}", input);
        return Flux.range(1, 10)
//            .delayElements(Duration.ofSeconds(1))
            .doOnNext(num -> log.info("generated num {}", num))
            .map(it -> new Response(input * it, Instant.now()));
    }
}
