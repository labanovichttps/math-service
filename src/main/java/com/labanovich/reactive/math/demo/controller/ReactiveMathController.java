package com.labanovich.reactive.math.demo.controller;

import com.labanovich.reactive.math.demo.dto.Response;
import com.labanovich.reactive.math.demo.service.ReactiveMathService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/math")
@RequiredArgsConstructor
public class ReactiveMathController {

    private final ReactiveMathService reactiveMathService;


    @GetMapping("/reactive/{value}")
    public ResponseEntity<Mono<Response>> calculateSingleResult(@PathVariable Integer value) {
        return ResponseEntity.ok(reactiveMathService.calculateMultiply(value));
    }

    @GetMapping(value = "/reactive/table/{value}")
    public ResponseEntity<Flux<Response>> calculateTable(@PathVariable Integer value) {
        return ResponseEntity.ok(reactiveMathService.calculateMultiplyTable(value));
    }
}
