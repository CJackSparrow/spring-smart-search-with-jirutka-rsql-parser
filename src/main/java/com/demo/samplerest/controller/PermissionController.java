package com.demo.samplerest.controller;

import com.demo.samplerest.repository.entity.PermissionEntity;
import com.demo.samplerest.service.BaseService;
import com.demo.samplerest.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permission")
public class PermissionController extends BaseController<PermissionEntity> {
    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @Override
    protected BaseService<PermissionEntity> getBaseService() {
        return permissionService;
    }
}
