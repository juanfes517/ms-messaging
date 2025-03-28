package com.pragma.messaging.infrastructure.exceptionhandler;

import com.pragma.messaging.application.dto.response.ExceptionResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class ControllerAdvisor {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionResponseDto handleException(Exception e) {
        log.error(e.getMessage());
        return ExceptionResponseDto.builder()
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
