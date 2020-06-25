package com.demo.samplerest.controller;

import com.demo.samplerest.repository.entity.FunctionEntity;
import com.demo.samplerest.service.BaseService;
import com.demo.samplerest.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/function")
public class FunctionController extends BaseController<FunctionEntity> {

    private final FunctionService functionService;

    @Autowired
    public FunctionController(FunctionService functionService) {
        this.functionService = functionService;
    }

    @Override
    protected BaseService<FunctionEntity> getBaseService() {
        return functionService;
    }
}
