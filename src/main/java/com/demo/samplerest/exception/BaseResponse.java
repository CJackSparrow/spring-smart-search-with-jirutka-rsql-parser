package com.demo.samplerest.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse {
    private Integer code;
    private String message;
}
