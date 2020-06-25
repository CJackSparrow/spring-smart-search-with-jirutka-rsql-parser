package com.demo.samplerest.service.impl;

import com.demo.samplerest.repository.BaseRepository;
import com.demo.samplerest.repository.FunctionRepository;
import com.demo.samplerest.repository.entity.FunctionEntity;
import com.demo.samplerest.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FunctionServiceImpl extends BaseServiceImpl<FunctionEntity> implements FunctionService {

    private final FunctionRepository functionRepository;

    @Autowired
    public FunctionServiceImpl(FunctionRepository functionRepository) {
        this.functionRepository = functionRepository;
    }

    @Override
    protected BaseRepository<FunctionEntity> getBaseRepository() {
        return functionRepository;
    }
}
