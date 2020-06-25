package com.demo.samplerest.service.impl;

import com.demo.samplerest.exception.EmrException;
import com.demo.samplerest.exception.SearchReq;
import com.demo.samplerest.query.CustomRsqlVisitor;
import com.demo.samplerest.repository.BaseRepository;
import com.demo.samplerest.service.BaseService;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

@Slf4j
public abstract class BaseServiceImpl<E> implements BaseService<E> {

    protected abstract BaseRepository<E> getBaseRepository();

    @Override
    public E create(E entity) throws EmrException {
        return getBaseRepository().save(entity);
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        E e = this.getById(id);
        getBaseRepository().delete(e);
    }

    @Override
    public E getById(Long id) throws NotFoundException {
        return getBaseRepository().findById(id).orElseThrow(() -> new NotFoundException("MessageErr.NOT_FOUND"));
    }

    @Override
    public Page<E> search(SearchReq req) {
        Node rootNode = new RSQLParser().parse(req.getFilter());
        Specification<E> spec = rootNode.accept(new CustomRsqlVisitor<E>());

        String[] sortList = req.getSort().split(",");
        Sort.Direction direction = sortList[1].equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        log.info("search: {}, {}, {}", req.getSort(), direction, sortList[0]);
        Pageable pageable = PageRequest.of(req.getPage(), req.getSize(), direction, sortList[0]);
        return this.getBaseRepository().findAll(Specification.where(spec), pageable);
    }

    @Override
    public Page<E> getList(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.getBaseRepository().findAll(pageable);
    }
}
