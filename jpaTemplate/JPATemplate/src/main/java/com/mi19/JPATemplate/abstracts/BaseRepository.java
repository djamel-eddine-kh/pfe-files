package com.mi19.JPATemplate.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity<ID>,ID> extends JpaRepository<E,ID> {

}
