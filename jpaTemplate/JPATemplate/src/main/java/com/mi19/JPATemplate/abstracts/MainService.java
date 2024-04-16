package com.mi19.JPATemplate.abstracts;

import org.springframework.transaction.annotation.Transactional;

public abstract class MainService<E extends MainEntity<ID>,ID> extends BaseService<E,ID> {
    public MainService(BaseRepository<E, ID> repository) {
        super(repository);
    }
    @Transactional
    public void save(E _new){
        ID id= _new.getId();
        if (id!=null)
            if (repository.existsById(id))throw new IllegalStateException(getTClass()+" with id "+id+" exist");
        repository.save(_new);
    }
}
