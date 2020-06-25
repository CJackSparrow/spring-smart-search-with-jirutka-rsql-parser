package com.demo.samplerest.exception;

public class JwtTokenException extends RuntimeException {

    public static final String MESSAGE_INVALID = "Jwt Invalid!";
    public static final String MESSAGE_EXPIRED = "Jwt expired!";

    public JwtTokenException(String mgs){super(mgs);}
}
