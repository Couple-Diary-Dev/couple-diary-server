package com.couplediary.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private String message;
    private HttpStatus status;
}