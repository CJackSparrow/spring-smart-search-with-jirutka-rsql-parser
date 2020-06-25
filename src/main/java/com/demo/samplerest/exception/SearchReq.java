package com.demo.samplerest.exception;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SearchReq {

  private String filter;

  @NotNull
  private Integer page;

  @NotNull
  private Integer size;

  @NotNull
  private String sort;
}
