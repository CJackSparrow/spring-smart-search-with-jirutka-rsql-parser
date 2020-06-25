package com.demo.samplerest.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class EmrException extends Exception {
    private final HttpStatus httpStatus;

    private final String messageCode;

    private final String errCode;

    public EmrException(HttpStatus httpStatus, String messageCode, String errCode) {
        super(messageCode);
        this.httpStatus = httpStatus;
        this.messageCode = messageCode;
        this.errCode = errCode;
    }

    public EmrException(HttpStatus httpStatus, String messageCode) {
        super(messageCode);
        this.httpStatus = httpStatus;
        this.messageCode = messageCode;
        this.errCode = "";
    }

    public EmrException(String messageCode) {
        super(messageCode);
        this.httpStatus = HttpStatus.BAD_REQUEST;
        this.messageCode = messageCode;
        this.errCode = "";
    }
}
