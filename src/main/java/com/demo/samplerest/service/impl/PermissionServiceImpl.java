package com.demo.samplerest.service.impl;

import com.demo.samplerest.exception.SearchReq;
import com.demo.samplerest.query.CustomRsqlVisitor;
import com.demo.samplerest.repository.BaseRepository;
import com.demo.samplerest.repository.PermissionRepository;
import com.demo.samplerest.repository.entity.PermissionEntity;
import com.demo.samplerest.service.PermissionService;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PermissionServiceImpl extends BaseServiceImpl<PermissionEntity> implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Autowired
    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    protected BaseRepository<PermissionEntity> getBaseRepository() {
        return permissionRepository;
    }

    @Override
    public Page<PermissionEntity> search(SearchReq req) {
        Node rootNode = new RSQLParser().parse(req.getFilter());
        Specification<PermissionEntity> spec = rootNode.accept(new CustomRsqlVisitor<PermissionEntity>());

        String[] sortList = req.getSort().split(",");
        Sort.Direction direction = sortList[1].equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        log.info("search: {}, {}, {}", req.getSort(), direction, sortList[0]);
        Pageable pageable = PageRequest.of(req.getPage(), req.getSize(), direction, sortList[0]);
        return this.getBaseRepository().findAll(Specification.where(spec), pageable);
    }
}
