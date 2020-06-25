package com.demo.samplerest.controller;

import com.demo.samplerest.exception.EmrException;
import com.demo.samplerest.exception.SearchReq;
import com.demo.samplerest.service.BaseService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
public abstract class BaseController<D> {
    protected abstract BaseService<D> getBaseService();

    @PostMapping("/create")
    public ResponseEntity<D> create(@Valid @RequestBody D dto) throws EmrException {
        dto = getBaseService().create(dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) throws NotFoundException {
        getBaseService().delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<D> getById(@PathVariable(value = "id") Long id) throws NotFoundException {
        D dto = getBaseService().getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<D>> search(@Valid SearchReq req) {
        Page<D> pageD = this.getBaseService().search(req);
        return ResponseEntity.ok(pageD);
    }
}
