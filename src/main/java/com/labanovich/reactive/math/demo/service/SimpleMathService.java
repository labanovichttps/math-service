package com.labanovich.reactive.math.demo.service;

import com.labanovich.reactive.math.demo.dto.Response;
import com.labanovich.reactive.math.demo.util.SleepUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Service
public class SimpleMathService {

    public Response calculateMultiply(Integer input) {
        log.info("calculate for input {}", input);
        var multiplyResult = input * input;
        return new Response(multiplyResult, Instant.now());
    }

    public List<Response> calculateMultiplyTable(Integer input) {
        log.info("calculate for input {}", input);
        return IntStream.rangeClosed(1, 10)
//                .peek(num -> SleepUtil.sleepSeconds(1))
                .peek(System.out::println)
                .map(num -> num * input)
                .mapToObj(multiply -> new Response(multiply, Instant.now()))
                .toList();
    }
}
