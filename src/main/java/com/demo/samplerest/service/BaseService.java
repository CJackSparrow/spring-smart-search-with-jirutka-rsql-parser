package com.demo.samplerest.service;


import com.demo.samplerest.exception.EmrException;
import com.demo.samplerest.exception.SearchReq;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;

public interface BaseService<T> {
    T create(T t) throws EmrException;

    void delete(Long id) throws NotFoundException;

    T getById(Long id) throws NotFoundException;

    Page<T> search(SearchReq req);

    Page<T> getList(Integer page, Integer size);
}
