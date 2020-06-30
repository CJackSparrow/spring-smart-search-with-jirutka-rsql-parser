package com.demo.samplerest.controller;

import com.demo.samplerest.exception.EmrException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/exceptionHandler")
    public ResponseEntity test() throws EmrException {
        throw new EmrException("Khong duoc dau");
    }
}
