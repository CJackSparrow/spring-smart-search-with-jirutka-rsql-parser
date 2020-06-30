package com.demo.samplerest.controller;

import com.demo.samplerest.exception.BaseResponse;
import com.demo.samplerest.exception.EmrException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class AdviceController {

    @ExceptionHandler(EmrException.class)
    public ResponseEntity<BaseResponse> handleEmrException(EmrException ex){
        log.info("ahihi: {}", ex.getMessage());
        return ResponseEntity.ok(BaseResponse.builder()
                .message(ex.getMessage())
                .code(401)
                .build());
    }
}
