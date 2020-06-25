package com.demo.samplerest.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseRepository<E> extends JpaSpecificationExecutor<E>, PagingAndSortingRepository<E, Long> {
}
