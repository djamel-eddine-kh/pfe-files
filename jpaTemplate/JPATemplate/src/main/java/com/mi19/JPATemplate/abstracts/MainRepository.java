package com.mi19.JPATemplate.abstracts;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MainRepository<E extends MainEntity<ID>,ID> extends BaseRepository<E,ID> {
}
