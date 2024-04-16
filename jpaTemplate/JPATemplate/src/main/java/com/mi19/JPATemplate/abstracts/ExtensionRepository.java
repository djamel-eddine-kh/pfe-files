package com.mi19.JPATemplate.abstracts;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ExtensionRepository<E extends ExtensionEntity<ID,P>,ID,P extends BaseEntity<PID>,PID> extends BaseRepository<E,ID> {
     List<E> findByParentId(PID parentId);
     void deleteByParentId(PID parentId);
}
