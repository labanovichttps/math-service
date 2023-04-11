package com.labanovich.reactive.math.demo.controller;

import com.labanovich.reactive.math.demo.dto.Response;
import com.labanovich.reactive.math.demo.service.ReactiveMathService;
import com.labanovich.reactive.math.demo.service.SimpleMathService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/math")
@RequiredArgsConstructor
public class RestMathController {

    private final SimpleMathService mathService;

    @GetMapping("/rest/{value}")
    public ResponseEntity<Response> calculateSingleResult(@PathVariable Integer value) {
        return ResponseEntity.ok(mathService.calculateMultiply(value));
    }

    @GetMapping(value = "/rest/table/{value}")
    public ResponseEntity<List<Response>> calculateTable(@PathVariable Integer value) {
        return ResponseEntity.ok(mathService.calculateMultiplyTable(value));
    }
}
