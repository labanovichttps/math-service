package com.labanovich.reactive.math.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class Response {

    private int result;
    private Instant date;
}
