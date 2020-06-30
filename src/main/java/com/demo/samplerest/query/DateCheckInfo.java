package com.demo.samplerest.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class DateCheckInfo {
    private Boolean isDateFormat;
    private Date date;
}
